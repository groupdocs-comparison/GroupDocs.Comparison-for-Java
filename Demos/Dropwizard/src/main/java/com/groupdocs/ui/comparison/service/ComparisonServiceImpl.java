package com.groupdocs.ui.comparison.service;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.ui.common.config.DefaultDirectories;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.util.CachedPageStream;
import com.groupdocs.ui.common.util.SessionCache;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.groupdocs.ui.common.util.Utils.*;

public class ComparisonServiceImpl implements ComparisonService {

    private static final Logger logger = LoggerFactory.getLogger(ComparisonServiceImpl.class);

    private ComparisonConfiguration comparisonConfiguration;
    private GlobalConfiguration globalConfiguration;

    public ComparisonServiceImpl(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
        this.comparisonConfiguration = globalConfiguration.getComparison();
        init();
    }

    /**
     * Initializing fields after creating configuration objects
     */
    public void init() {
        // check files directories
        String filesDirectory = comparisonConfiguration.getFilesDirectory();
        String resultDirectory = comparisonConfiguration.getResultDirectory();
        if (StringUtils.isEmpty(resultDirectory)) {
            resultDirectory = filesDirectory + File.separator + "Temp";
            comparisonConfiguration.setResultDirectory(resultDirectory);
        }
        DefaultDirectories.makeDirs(Paths.get(resultDirectory));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComparisonConfiguration getComparisonConfiguration() {
        return comparisonConfiguration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest) {
        List<FileDescriptionEntity> fileList;
        {
            Path currentPath = Paths.get(comparisonConfiguration.getFilesDirectory());
            if (fileTreeRequest.isNotEmpty()) {
                currentPath = currentPath.resolve(fileTreeRequest.getPath());
            }
            logger.debug("Current path is " + currentPath);

            try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentPath)) {
                List<FileDescriptionEntity> unsortedDirectoryItems = new ArrayList<>();
                for (Path path : directoryStream) {
                    FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                    // set path to file
                    fileDescription.setGuid(path.toAbsolutePath().normalize().toString());
                    // set file name
                    fileDescription.setName(path.getFileName().toString());
                    // set is directory true/false
                    fileDescription.setDirectory(Files.isDirectory(path));
                    // set file size
                    fileDescription.setSize(Files.size(path));
                    unsortedDirectoryItems.add(fileDescription);
                }
                fileList = orderByTypeAndName(unsortedDirectoryItems);
            } catch (IOException e) {
                logger.error("Exception occurred while load file tree", e);
                throw new TotalGroupDocsException("Exception occurred while load file tree", e);
            }
        }
        return fileList;
    }

    @Override
    public LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest, SessionCache sessionCache) {
        LoadDocumentEntity loadDocumentEntity = new LoadDocumentEntity();
        {
            final String guid = loadDocumentRequest.getGuid();
            final String password = loadDocumentRequest.getPassword();
            final int pageHeight = 1056, pageWidth = 816;
            try {
                List<PageDescriptionEntity> pageDescriptionEntities;
                final CachedPageStream cachedPageStream = new CachedPageStream(sessionCache, guid);

                if (!cachedPageStream.isCached()) {
                    final Document document = new Document(guid, password);
                    document.generatePreview(new PreviewOptions.Builder(cachedPageStream)
                            .setHeight(pageHeight)
                            .setWidth(pageWidth)
                            .build());
                }

                pageDescriptionEntities = cachedPageStream.stream().map(item -> {
                    try (InputStream inputStream = item.pageStream) {
                        final PageDescriptionEntity pageDescription = new PageDescriptionEntity();
                        pageDescription.setNumber(item.pageIndex);
                        pageDescription.setHeight(pageHeight);
                        pageDescription.setWidth(pageWidth);
                        pageDescription.setData(getStringFromStream(inputStream));
                        return pageDescription;
                    } catch (Exception e) {
                        logger.error("Exception occurred while getting page description", e);
                        throw new TotalGroupDocsException("Exception occurred while getting page description", e);
                    }
                }).collect(Collectors.toList());
                loadDocumentEntity.setGuid(guid);
                loadDocumentEntity.setPages(pageDescriptionEntities);
            } catch (Exception e) {
                logger.error("Exception occurred while load file description", e);
                throw new TotalGroupDocsException("Exception occurred while load file description", e);
            }
        }
        return loadDocumentEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest, SessionCache sessionCache) {
        PageDescriptionEntity pageDescription = new PageDescriptionEntity();
        {
            final String guid = loadDocumentPageRequest.getGuid();
            final String password = loadDocumentPageRequest.getPassword();
            final int pageNumber = loadDocumentPageRequest.getPage();
            final int pageHeight = 1056, pageWidth = 816, pageIndex = pageNumber - 1;
            try {
                final CachedPageStream cachedPageStream = new CachedPageStream(sessionCache, guid);

                if (!cachedPageStream.isCached()) {
                    final Document document = new Document(guid, password);
                    document.generatePreview(new PreviewOptions.Builder(cachedPageStream)
                            .setHeight(pageHeight)
                            .setWidth(pageWidth)
                            .build());
                }

                try (InputStream inputStream = cachedPageStream.createPageStream(pageIndex)) {
                    pageDescription.setNumber(pageIndex);
                    pageDescription.setHeight(pageHeight);
                    pageDescription.setWidth(pageWidth);
                    pageDescription.setData(getStringFromStream(inputStream));
                } catch (Exception e) {
                    logger.error("Exception occurred while getting page description", e);
                    throw new TotalGroupDocsException("Exception occurred while getting page description", e);
                }

            } catch (Exception e) {
                logger.error("Exception occurred while load file page", e);
                throw new TotalGroupDocsException("Exception occurred while load file page", e);
            }
        }
        return pageDescription;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompareResultResponse compare(CompareRequest compareRequest, SessionCache sessionCache) {
        CompareResultResponse compareResultResponse = new CompareResultResponse();
        {

            final LoadDocumentRequest sourceDocumentRequest = compareRequest.getSourceDocumentRequest();
            final LoadDocumentRequest targetDocumentRequest = compareRequest.getTargetDocumentRequest();

            final String sourceGuid = sourceDocumentRequest.getGuid();
            final String sourcePassword = sourceDocumentRequest.getPassword();
            final String targetGuid = targetDocumentRequest.getGuid();
            final String targetPassword = targetDocumentRequest.getPassword();
            final int pageHeight = 1056, pageWidth = 816;

            try {
                final String extension = parseFileExtension(sourceGuid);
                final String outputFileName = "gd_" + sourceGuid.hashCode() + "_" + targetGuid.hashCode() + ".cache";
                // Delete old result file if existed. Can't reuse because changes are not cached
                sessionCache.deleteCacheEntry(outputFileName);
                // Saving to cache because it should be deleted when session expires
                final Path outputFile = sessionCache.createCacheEntry(outputFileName);

                final ChangeInfo[] changes;
                try (final Comparer comparer = new Comparer(sourceGuid, new LoadOptions(sourcePassword))) {
                    comparer.add(targetGuid, new LoadOptions(targetPassword));
                    comparer.compare(outputFile, new CompareOptions.Builder().setShowDeletedContent(true).setDetectStyleChanges(true).setCalculateCoordinates(true).build());
                    changes = comparer.getChanges();
                }

                List<PageDescriptionEntity> pageDescriptionEntities;
                final CachedPageStream cachedPageStream = new CachedPageStream(sessionCache, outputFileName);

                if (!cachedPageStream.isCached()) {
                    final Document document = new Document(outputFile);
                    document.generatePreview(new PreviewOptions.Builder(cachedPageStream)
                            .setHeight(pageHeight)
                            .setWidth(pageWidth)
                            .build());
                }

                    pageDescriptionEntities = cachedPageStream.stream().map(item -> {
                        try (InputStream inputStream = item.pageStream) {
                            final PageDescriptionEntity pageDescription = new PageDescriptionEntity();
                            pageDescription.setNumber(item.pageIndex);
                            pageDescription.setHeight(pageHeight);
                            pageDescription.setWidth(pageWidth);
                            pageDescription.setData(getStringFromStream(inputStream));
                            return pageDescription;
                        } catch (Exception e) {
                            logger.error("Exception occurred while getting page description", e);
                            throw new TotalGroupDocsException("Exception occurred while getting page description", e);
                        }
                    }).collect(Collectors.toList());

                compareResultResponse.setChanges(changes);
                compareResultResponse.setPages(pageDescriptionEntities);
                compareResultResponse.setGuid(outputFile.toString());
                compareResultResponse.setExtension(extension);

            } catch (Exception e) {
                logger.error("Exception occurred while comparing files", e);
                throw new TotalGroupDocsException("Exception occurred while comparing files", e);
            }
        }
        return compareResultResponse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkFiles(CompareRequest compareRequest) {
        final LoadDocumentRequest sourceDocumentRequest = compareRequest.getSourceDocumentRequest();
        final LoadDocumentRequest targetDocumentRequest = compareRequest.getTargetDocumentRequest();

        final String sourceExtension = parseFileExtension(sourceDocumentRequest.getGuid());
        final String targetExtension = parseFileExtension(targetDocumentRequest.getGuid());
        // check if files extensions are the same and support format file
        return StringUtils.equals(sourceExtension, targetExtension) && checkSupportedFiles(sourceExtension);
    }
}
