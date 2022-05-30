package com.groupdocs.ui.comparison.service;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.comparison.result.ChangeInfo;
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
import com.groupdocs.ui.common.util.TempFilesManager;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import com.groupdocs.ui.comparison.provider.FilesProvider;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.groupdocs.ui.common.util.Utils.*;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    private static final Logger logger = LoggerFactory.getLogger(ComparisonServiceImpl.class);
    @Autowired
    private GlobalConfiguration globalConfiguration;
    private java.nio.file.Path tempDirectoryAbsolutePath = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public ComparisonConfiguration getComparisonConfiguration() {
        return globalConfiguration.getComparison();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest) throws IOException {
        List<FileDescriptionEntity> fileList;
        {
            String currentPath = fileTreeRequest.getPath();
            logger.debug("Current path is " + currentPath);

            List<FileDescriptionEntity> unsortedDirectoryItems = new ArrayList<>();
            FilesProvider.getInstance().visitDirectoryContent(currentPath, (guid, name, isDirectory, size) -> {
                FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                // set path to file
                fileDescription.setGuid(guid);
                // set file name
                fileDescription.setName(name);
                // set is directory true/false
                fileDescription.setDirectory(isDirectory);
                // set file size
                fileDescription.setSize(size);
                unsortedDirectoryItems.add(fileDescription);
            });
            fileList = orderByTypeAndName(unsortedDirectoryItems);
        }
        return fileList;
    }

    @Override
    public LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest, SessionCache sessionCache) throws Exception {
        LoadDocumentEntity loadDocumentEntity = new LoadDocumentEntity();
        {
            final String guid = loadDocumentRequest.getGuid();
            final String password = loadDocumentRequest.getPassword();
            final ComparisonConfiguration comparisonConfiguration = getComparisonConfiguration();
            final int pageWidth = comparisonConfiguration.getPreviewPageWidth();
            final float pageRatio = comparisonConfiguration.getPreviewPageRatio();
            final int pageHeight = (int) (pageWidth * pageRatio);
            try {
                List<PageDescriptionEntity> pageDescriptionEntities;
                final CachedPageStream cachedPageStream = new CachedPageStream(sessionCache, guid);

                if (!cachedPageStream.isCached()) {
                    FilesProvider.getInstance().receiveFilesInputStream(guid, inputStream -> {
                        try (final Document document = new Document(inputStream, password)) {
                            document.generatePreview(new PreviewOptions.Builder(cachedPageStream)
                                    .setHeight(pageHeight).setWidth(pageWidth).build());
                        }
                    });
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
                        throw new TotalGroupDocsException("Exception occurred while getting page description", e);
                    }
                }).collect(Collectors.toList());
                loadDocumentEntity.setGuid(guid);
                loadDocumentEntity.setPages(pageDescriptionEntities);
            } catch (Exception e) {
                final String message = e.getMessage();
                if (message != null && message.contains("At most 4 elements")) {
                    throw new TotalGroupDocsException("Unlicensed version's limitation exception", e);
                }
                throw e;
            }
        }
        return loadDocumentEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest, SessionCache sessionCache) throws Exception {
        PageDescriptionEntity pageDescription = new PageDescriptionEntity();
        {
            final String guid = loadDocumentPageRequest.getGuid();
            final String password = loadDocumentPageRequest.getPassword();
            final int pageNumber = loadDocumentPageRequest.getPage();
            final ComparisonConfiguration comparisonConfiguration = getComparisonConfiguration();
            final int pageWidth = comparisonConfiguration.getPreviewPageWidth();
            final float pageRatio = comparisonConfiguration.getPreviewPageRatio();
            final int pageHeight = (int) (pageWidth * pageRatio);
            final int pageIndex = pageNumber - 1;

            final CachedPageStream cachedPageStream = new CachedPageStream(sessionCache, guid);

            if (!cachedPageStream.isCached()) {
                FilesProvider.getInstance().receiveFilesInputStream(guid, inputStream -> {
                    try (final Document document = new Document(inputStream, password)) {
                        document.generatePreview(new PreviewOptions.Builder(cachedPageStream).setHeight(pageHeight).setWidth(pageWidth).build());
                    }

                });
            }
            try (InputStream inputStream = cachedPageStream.createPageStream(pageIndex)) {
                pageDescription.setNumber(pageIndex);
                pageDescription.setHeight(pageHeight);
                pageDescription.setWidth(pageWidth);
                pageDescription.setData(getStringFromStream(inputStream));
            }
        }
        return pageDescription;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompareResultResponse compare(CompareRequest compareRequest, SessionCache sessionCache) throws Exception {
        CompareResultResponse compareResultResponse = new CompareResultResponse();
        {
            final LoadDocumentRequest sourceDocumentRequest = compareRequest.getSourceDocumentRequest();
            final LoadDocumentRequest targetDocumentRequest = compareRequest.getTargetDocumentRequest();

            final String sourceGuid = sourceDocumentRequest.getGuid();
            final String sourcePassword = sourceDocumentRequest.getPassword();
            final String targetGuid = targetDocumentRequest.getGuid();
            final String targetPassword = targetDocumentRequest.getPassword();
            final ComparisonConfiguration comparisonConfiguration = getComparisonConfiguration();
            final int pageWidth = comparisonConfiguration.getPreviewPageWidth();
            final float pageRatio = comparisonConfiguration.getPreviewPageRatio();
            final int pageHeight = (int) (pageWidth * pageRatio);

            final String extension = parseFileExtension(sourceGuid);
            final String tempFileName = "gd_comparison_result_" + sourceGuid.hashCode() + "_" + targetGuid.hashCode() + "." + extension;
            final String outputFileName;
            Path outputFilePath = null;
            final TempFilesManager tempFilesManager = TempFilesManager.getInstance();
            final Path sourceTempPath = tempFilesManager.createTempPath("gd_" + UUID.randomUUID() + ".tmp");
            final Path targetTempPath = tempFilesManager.createTempPath("gd_" + UUID.randomUUID() + ".tmp");
            final Path resultTempPath = tempFilesManager.createTempPath(tempFileName);

            try {
                final FilesProvider filesProvider = FilesProvider.getInstance();
                {
                    filesProvider.receiveFilesInputStream(sourceGuid, inputStream -> {
                        try {
                            Files.copy(inputStream, sourceTempPath);
                        } catch (IOException e) {
                            throw new TotalGroupDocsException("Can't retrieve source file", e);
                        }
                    });
                    filesProvider.receiveFilesInputStream(targetGuid, inputStream -> {
                        try {
                            Files.copy(inputStream, targetTempPath);
                        } catch (IOException e) {
                            throw new TotalGroupDocsException("Can't retrieve target file", e);
                        }
                    });
                }
                final ChangeInfo[] changes;
                try (InputStream sourceStream = Files.newInputStream(sourceTempPath);
                     InputStream targetStream = Files.newInputStream(targetTempPath);
                     final Comparer comparer = new Comparer(sourceStream, new LoadOptions(sourcePassword))) {
                    comparer.add(targetStream, new LoadOptions(targetPassword));
                    final Path changedFilePath = comparer.compare(resultTempPath, new CompareOptions.Builder()
                            .setShowDeletedContent(true)
                            .setDetectStyleChanges(true)
                            .setCalculateCoordinates(true)
                            .build());
                    final Path pathToUpload;
                    if (changedFilePath == null) {
                        pathToUpload = resultTempPath;
                    } else {
                        pathToUpload = changedFilePath;
                    }
                    outputFilePath = pathToUpload;
                    outputFileName = pathToUpload.getFileName().toString();
                    logger.debug("outputFileName is '" + outputFileName + "'");
                    filesProvider.receiveResultOutputStream(outputFileName, outputStream -> {
                        try {
                            Files.copy(pathToUpload, outputStream);
                        } catch (IOException e) {
                            throw new TotalGroupDocsException("Can't upload result file", e);
                        }
                    });
                    changes = comparer.getChanges();
                }

                List<PageDescriptionEntity> pageDescriptionEntities;
                final CachedPageStream cachedPageStream = new CachedPageStream(sessionCache, outputFileName);

                if (!cachedPageStream.isCached()) {
                    try (final Document document = new Document(outputFilePath)) {
                        document.generatePreview(new PreviewOptions.Builder(cachedPageStream).setHeight(pageHeight).setWidth(pageWidth).build());
                    }
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
                        throw new TotalGroupDocsException("Exception occurred while getting page description", e);
                    }
                }).collect(Collectors.toList());

                compareResultResponse.setChanges(changes);
                compareResultResponse.setPages(pageDescriptionEntities);
                compareResultResponse.setExtension(extension);
                compareResultResponse.setGuid(outputFileName);

            } finally {
                Files.deleteIfExists(sourceTempPath);
                Files.deleteIfExists(targetTempPath);
                if (outputFilePath != null) {
                    Files.deleteIfExists(outputFilePath);
                }
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

    /**
     * Internal upload file into server
     *
     * @param inputStream file stream
     * @param fileName    file name
     * @param isRewrite   flag for rewriting file
     * @return path to file in storage
     */
    @Override
    public String uploadFile(InputStream inputStream, String fileName, boolean isRewrite) {
        final FilesProvider filesProvider = FilesProvider.getInstance();
        final boolean isFileExists = filesProvider.isFileExists(fileName);
        if (!isFileExists || isRewrite) {
            if (isFileExists) {
                filesProvider.deleteFile(fileName);
            }
            filesProvider.receiveFilesOutputStream(fileName, outputStream -> {
                try {
                    IOUtils.copy(inputStream, outputStream);
                } catch (IOException e) {
                    throw new TotalGroupDocsException("Can't upload file", e);
                }
            });
        } else {
            throw new TotalGroupDocsException("File with the name is already exist and rewrite option in configuration is false");
        }
        return fileName;
    }

    @Override
    public void downloadFile(String fileName, DownloadFileCallback callback) throws IOException {
        final FilesProvider filesProvider = FilesProvider.getInstance();
        final Path tempPath = createTempPath(fileName);
        filesProvider.receiveResultInputStream(fileName, inputStream -> {
            try {
                Files.copy(inputStream, tempPath);
            } catch (IOException e) {
                throw new TotalGroupDocsException("Can't download file", e);
            }
        });
        // Using temp file to get file's size before sending data
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(tempPath))) {
            final long fileSize = Files.size(tempPath);
            callback.call(fileSize, inputStream);
        } finally {
            Files.deleteIfExists(tempPath);
        }
    }

    private Path createTempPath(String fileName) throws IOException {
        if (tempDirectoryAbsolutePath == null) {

            final String tempDirectory = getComparisonConfiguration().getTempDirectory();
            Path tempDirectoryPath = Paths.get(tempDirectory);
            final boolean isRelative = !tempDirectoryPath.isAbsolute();
            if (isRelative) {
                tempDirectoryPath = FileSystems.getDefault().getPath(tempDirectoryPath.toString()).toAbsolutePath();
            }
            logger.debug("Temp directory is going to be '" + tempDirectoryPath + "', creating it...");
            tempDirectoryAbsolutePath = Files.createDirectories(tempDirectoryPath);
        }
        return tempDirectoryAbsolutePath.resolve(fileName);
    }
}