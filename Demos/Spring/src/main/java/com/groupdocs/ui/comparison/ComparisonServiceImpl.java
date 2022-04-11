package com.groupdocs.ui.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.common.delegates.Delegates;
import com.groupdocs.comparison.interfaces.IDocumentInfo;
import com.groupdocs.comparison.license.License;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.comparison.options.style.DetalisationLevel;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.PageInfo;
import com.groupdocs.comparison.utils.common.Path;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.ChangeInfoEntity;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import com.groupdocs.ui.config.DefaultDirectories;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.model.response.LoadDocumentEntity;
import com.groupdocs.ui.model.response.PageDescriptionEntity;
import com.groupdocs.ui.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import static com.groupdocs.ui.util.Utils.parseFileExtension;

@Service
public class ComparisonServiceImpl implements ComparisonService {

    private static final Logger logger = LoggerFactory.getLogger(ComparisonServiceImpl.class);
    public static final String TEMP_DIRECTORY_NAME = "temp";

    @Autowired
    private ComparisonConfiguration comparisonConfiguration;
    @Autowired
    private GlobalConfiguration globalConfiguration;

    /**
     * Initializing fields after creating configuration objects
     */
    @PostConstruct
    public void init() {
        // check files directories
        String filesDirectory = comparisonConfiguration.getFilesDirectory();
        String resultDirectory = comparisonConfiguration.getResultDirectory();
        if (StringUtils.isEmpty(resultDirectory)) {
            resultDirectory = filesDirectory + File.separator + TEMP_DIRECTORY_NAME;
            comparisonConfiguration.setResultDirectory(resultDirectory);
        }
        DefaultDirectories.makeDirs(Paths.get(resultDirectory));
        // set GroupDocs license
        try {
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Comparison license!");
        }
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
    public List<FileDescriptionEntity> loadFiles(FileTreeRequest fileTreeRequest) {
        final String path = fileTreeRequest.getPath();
        final File filesDirectory = new File(Path.combine(comparisonConfiguration.getFilesDirectory(), path));

        List<FileDescriptionEntity> filesList = new ArrayList<>();
        try {
            final File[] files = filesDirectory.listFiles();
            if (files == null) {
                throw new TotalGroupDocsException("Can't list files");
            }

            for (File file : files) {
                // check if current file/folder is hidden
                if (!(file.getName().equals(comparisonConfiguration.getFilesDirectory())) && !(file.getName().equals(comparisonConfiguration.getResultDirectory())) && !file.getName().startsWith(".") && !file.isHidden() && !TEMP_DIRECTORY_NAME.equals(file.getName())) {
                    FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                    fileDescription.setGuid(file.getCanonicalFile().getAbsolutePath());
                    fileDescription.setName(file.getName());
                    // set is directory true/false
                    fileDescription.setIsDirectory(file.isDirectory());

                    // set file size
                    if (!fileDescription.isIsDirectory()) {
                        fileDescription.setSize(file.length());
                    }

                    // add object to array list
                    filesList.add(fileDescription);
                }
            }

            // Sort by name and to make directories to be before files
            Collections.sort(filesList, new Comparator<FileDescriptionEntity>() {
                @Override
                public int compare(FileDescriptionEntity o1, FileDescriptionEntity o2) {
                    if (o1.isIsDirectory() && !o2.isIsDirectory()) {
                        return -1;
                    }
                    if (!o1.isIsDirectory() && o2.isIsDirectory()) {
                        return 1;
                    }
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } catch (IOException e) {
            logger.error("Exception in getting file list", e);
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
        return filesList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompareResultResponse compare(CompareRequest compareRequest) {
        CompareResultResponse compareResultResponse = null;
        try {
            compareResultResponse = compareTwoDocuments(compareRequest);
        } catch (FileNotFoundException e) {
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
        return compareResultResponse;
    }

    @Override
    public LoadDocumentEntity loadDocumentDescription(LoadDocumentPageRequest loadDocumentPageRequest) {
        final String documentGuid = loadDocumentPageRequest.getGuid();
        final String password = loadDocumentPageRequest.getPassword();
        return loadDocumentPages(documentGuid, password, 0);
    }

    private CompareResultResponse compareTwoDocuments(CompareRequest compareRequest) throws FileNotFoundException {
        // to get correct coordinates we will compare document twice
        // this is a first comparing to get correct coordinates of the insertions and style changes
        final String fileExt = parseFileExtension(compareRequest.getGuids().get(0).getGuid());
        String extension = "." + fileExt;
        String guid = UUID.randomUUID().toString();
        //save all results in file
        String[] resultGuid = new String[]{Path.combine(comparisonConfiguration.getResultDirectory(), guid + extension)};

        Comparer compareResult = compareFiles(compareRequest, resultGuid);
        ChangeInfo[] changes = compareResult.getChanges();
        List<ChangeInfoEntity> changeInfoEntities = new ArrayList<>();
        for (ChangeInfo changeInfo : changes) {
            changeInfoEntities.add(new ChangeInfoEntity(changeInfo));
        }

        CompareResultResponse compareResultResponse = getCompareResultResponse(changeInfoEntities.toArray(new ChangeInfoEntity[0]), resultGuid[0]);
        compareResultResponse.setExtension(fileExt);
        return compareResultResponse;
    }

    private CompareResultResponse getCompareResultResponse(ChangeInfoEntity[] changes, String resultGuid) {
        CompareResultResponse compareResultResponse = new CompareResultResponse();
        compareResultResponse.setChanges(changes);

        List<PageDescriptionEntity> pages = loadDocumentPages(resultGuid, "",
                /* Uncomment (and delete 0) to support preloadResultPageCount, does not work in front-end at the moment */
                /*comparisonConfiguration.getPreloadResultPageCount()*/0).getPages();

        compareResultResponse.setPages(pages);
        compareResultResponse.setGuid(resultGuid);
        return compareResultResponse;
    }

    public static LoadDocumentEntity loadDocumentPages(String documentGuid, String password, int loadPagesCount) {
        LoadDocumentEntity loadDocumentEntity = new LoadDocumentEntity();

        try (Document document = new Document(documentGuid, password)) {
            IDocumentInfo documentInfo = document.getDocumentInfo();

            final List<PageInfo> pagesInfo = documentInfo.getPagesInfo();
            for (int i = 0; i < pagesInfo.size(); i++) {
                PageDescriptionEntity pageData = new PageDescriptionEntity();
                final PageInfo pageInfo = pagesInfo.get(i);
                pageData.setHeight(pageInfo.getHeight());
                pageData.setWidth(pageInfo.getWidth());
                pageData.setNumber(i);

                if (loadPagesCount == 0 || loadPagesCount > i) {
                    String encodedImage = getPageData(i, documentGuid, password);
                    pageData.setData(encodedImage);
                }

                loadDocumentEntity.getPages().add(pageData);
            }
            loadDocumentEntity.setGuid(documentGuid);

            return loadDocumentEntity;
        }
    }

    private static LoadOptions getLoadOptions(String password) {
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);

        return loadOptions;
    }

    private static String getPageData(int pageNumber, String documentGuid, String password) {
        String encodedImage = "";

        try (Comparer comparer = new Comparer(documentGuid, getLoadOptions(password))) {
            byte[] bytes = renderPageToMemoryStream(comparer, pageNumber);
            encodedImage = new String(Base64.getEncoder().encode(bytes)).replace("\n", "");
        }

        return encodedImage;
    }

    static byte[] renderPageToMemoryStream(Comparer comparer, int pageNumberToRender) {

        try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            IDocumentInfo documentInfo = comparer.getSource().getDocumentInfo();

            PreviewOptions previewOptions = new PreviewOptions(new Delegates.CreatePageStream() {
                @Override
                public OutputStream invoke(int i) {
                    return result;
                }
            });

            previewOptions.setPreviewFormat(PreviewFormats.PNG);
            previewOptions.setPageNumbers(new int[]{pageNumberToRender + 1});
            final PageInfo pageInfo = documentInfo.getPagesInfo().get(pageNumberToRender);
            previewOptions.setHeight(pageInfo.getHeight());
            previewOptions.setWidth(pageInfo.getWidth());
            comparer.getSource().generatePreview(previewOptions);
            return result.toByteArray();
        } catch (IOException e) {
            throw new TotalGroupDocsException(e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        final String documentGuid = loadDocumentPageRequest.getGuid();
        final String password = loadDocumentPageRequest.getPassword();
        final Integer pageNumber = loadDocumentPageRequest.getPage();

        PageDescriptionEntity loadedPage = new PageDescriptionEntity();

        Comparer comparer = new Comparer(documentGuid, getLoadOptions(password));
        try {
            IDocumentInfo documentInfo = comparer.getSource().getDocumentInfo();

            String encodedImage = getPageData(pageNumber - 1, documentGuid, password);
            loadedPage.setData(encodedImage);

            final PageInfo pageInfo = documentInfo.getPagesInfo().get(pageNumber - 1);
            loadedPage.setHeight(pageInfo.getHeight());
            loadedPage.setWidth(pageInfo.getWidth());
            loadedPage.setNumber(pageNumber - 1);
        } catch (Exception ex) {
            throw new TotalGroupDocsException("Exception occurred while loading result page", ex);
        } finally {
            comparer.dispose();
        }

        return loadedPage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkFiles(CompareRequest request) {
        List<LoadDocumentRequest> guids = request.getGuids();
        LoadDocumentRequest loadDocumentRequestFirst = guids.get(0);
        LoadDocumentRequest loadDocumentRequestSecond = guids.get(1);
        String sourceExtension = parseFileExtension(loadDocumentRequestFirst.getGuid());
        String targetExtension = parseFileExtension(loadDocumentRequestSecond.getGuid());
        assert sourceExtension != null : "sourceExtension is null";
        assert targetExtension != null : "targetExtension is null";
        // check if files extensions are the same and support format file
        return Objects.equals(sourceExtension, targetExtension) && checkSupportedFiles(sourceExtension.toLowerCase());
    }

    /**
     * Check support formats for comparing
     *
     * @param extension file extension
     * @return true - format is supported, false - format is not supported
     */
    private boolean checkSupportedFiles(String extension) {
        switch (extension) {
            case "doc":
            case "docx":
            case "xls":
            case "xlsx":
            case "ppt":
            case "pptx":
            case "pdf":
            case "txt":
            case "html":
            case "htm":
            case "jpg":
            case "jpeg":
                return true;
            default:
                return false;
        }
    }

    private static Comparer compareFiles(CompareRequest compareRequest, String[] resultGuid) throws FileNotFoundException {
        String firstPath = compareRequest.getGuids().get(0).getGuid();
        String secondPath = compareRequest.getGuids().get(1).getGuid();

        // create new comparer
        Comparer comparer = new Comparer(firstPath, getLoadOptions(compareRequest.getGuids().get(0).getPassword()));

        comparer.add(secondPath, getLoadOptions(compareRequest.getGuids().get(1).getPassword()));
        CompareOptions compareOptions = new CompareOptions();
        compareOptions.setCalculateCoordinates(true);

        if ("pdf".equals(Utils.parseFileExtension(resultGuid[0]))) {
            compareOptions.setDetalisationLevel(DetalisationLevel.High);
        }
        OutputStream outputStream = new FileOutputStream(resultGuid[0]);
        try {
            final java.nio.file.Path result = comparer.compare(outputStream, compareOptions);
            if (result != null) {
                resultGuid[0] = result.toString();
            }
        } finally {
            com.groupdocs.comparison.common.Utils.closeStreams(outputStream);
        }

        return comparer;
    }
}
