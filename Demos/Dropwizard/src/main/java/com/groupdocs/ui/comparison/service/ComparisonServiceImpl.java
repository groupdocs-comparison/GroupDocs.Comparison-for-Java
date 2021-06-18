package com.groupdocs.ui.comparison.service;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.PageImage;
import com.groupdocs.comparison.common.changes.ChangeInfo;
import com.groupdocs.comparison.common.compareresult.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;
import com.groupdocs.comparison.common.exceptions.cellexceptions.InvalidCellPasswordException;
import com.groupdocs.comparison.common.exceptions.noteexceptions.InvalidNotePasswordException;
import com.groupdocs.comparison.common.exceptions.pdfexceptions.InvalidPdfPasswordException;
import com.groupdocs.comparison.common.exceptions.slidesexceptions.InvalidSlidesPasswordException;
import com.groupdocs.comparison.common.exceptions.wordsexceptions.InvalidWordsPasswordException;
import com.groupdocs.comparison.common.license.License;
import com.groupdocs.comparison.internal.c.a.s.InvalidPasswordException;
import com.groupdocs.ui.common.config.DefaultDirectories;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.groupdocs.ui.common.util.Utils.*;

public class ComparisonServiceImpl implements ComparisonService {

    private static final Logger logger = LoggerFactory.getLogger(ComparisonServiceImpl.class);
    public static final String COMPARE_RESULT = "compareResult";
    public static final String JPG = "jpg";
    public static final String DOCX = "docx";
    public static final String DOC = "doc";
    public static final String XLS = "xls";
    public static final String XLSX = "xlsx";
    public static final String PPT = "ppt";
    public static final String PPTX = "pptx";
    public static final String PDF = "pdf";
    public static final String TXT = "txt";
    public static final String HTM = "htm";
    public static final String HTML = "html";
    public static final String TEMP_HTML = "temp.html";

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
        String currentPath = fileTreeRequest.getPath();
        if (StringUtils.isEmpty(currentPath)) {
            currentPath = comparisonConfiguration.getFilesDirectory();
        } else {
            currentPath = String.format("%s%s%s", comparisonConfiguration.getFilesDirectory(), File.separator, currentPath);
        }
        File directory = new File(currentPath);
        List<FileDescriptionEntity> fileList = new ArrayList<>();
        List<File> files = orderByTypeAndName(Arrays.asList(directory.listFiles()));
        try {
            for (File file : files) {
                if (!file.isHidden()) {
                    fileList.add(getFileDescriptionEntity(file));
                }
            }
            return fileList;
        } catch (Exception ex) {
            logger.error("Exception occurred while load file tree");
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Create file description
     *
     * @param file file
     * @return file description
     */
    private FileDescriptionEntity getFileDescriptionEntity(File file) {
        FileDescriptionEntity fileDescription = new FileDescriptionEntity();
        // set path to file
        fileDescription.setGuid(file.getAbsolutePath());
        // set file name
        fileDescription.setName(file.getName());
        // set is directory true/false
        fileDescription.setDirectory(file.isDirectory());
        // set file size
        fileDescription.setSize(file.length());
        return fileDescription;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompareResultResponse compare(CompareRequest compareRequest) {
        List<LoadDocumentRequest> guids = compareRequest.getGuids();
        LoadDocumentRequest loadDocumentRequestFirst = guids.get(0);
        LoadDocumentRequest loadDocumentRequestSecond = guids.get(1);
        String firstPath = loadDocumentRequestFirst.getGuid();

        ICompareResult compareResult;

        //TODO: remove this synchronization when the bug COMPARISONJAVA-436 is fixed
        synchronized (this) {
            compareResult = compareFiles(loadDocumentRequestFirst, loadDocumentRequestSecond);
        }

        String extension = parseFileExtension(firstPath);
        try {
            return getCompareResultResponse(extension, compareResult);
        } catch (Exception e) {
            throw new TotalGroupDocsException(e.getMessage());
        }
    }

    protected CompareResultResponse getCompareResultResponse(String fileExt, ICompareResult compareResult) throws Exception {
        if (compareResult == null) {
            throw new TotalGroupDocsException("Something went wrong. We've got null result.");
        }

        CompareResultResponse compareResultResponse = createCompareResultResponse(compareResult, fileExt);

        String guid = UUID.randomUUID().toString();
        String savedFile = saveFile(guid, compareResult.getStream(), fileExt);
        compareResultResponse.setGuid(savedFile);
        compareResultResponse.setExtension(fileExt);

        compareResultResponse.setPages(loadPages(savedFile, null));

        return compareResultResponse;
    }

    /**
     * Convert results of comparing and save result files
     *
     * @param compareResult results
     * @param fileExt
     * @return results response
     */
    private CompareResultResponse createCompareResultResponse(ICompareResult compareResult, String fileExt) throws Exception {
        CompareResultResponse compareResultResponse = new CompareResultResponse();

        // FIXME: temporary fix
        ChangeInfo[] changes = getChangeInfos(compareResult, fileExt);

        compareResultResponse.setChanges(changes);

        boolean isHtml = HTML.equals(fileExt) || HTM.equals(fileExt);
        if (isHtml) {
            String resultDirectory = getResultDirectory();
            compareResult.saveDocument(resultDirectory + File.separator + TEMP_HTML);
        }

        return compareResultResponse;
    }

    private ChangeInfo[] getChangeInfos(ICompareResult compareResult, String fileExt) {
        ChangeInfo[] changes = compareResult.getChanges();
        for (int i = 0; i < changes.length; i++) {
            ChangeInfo change = changes[i];
            if (DOC.equals(fileExt) || DOCX.equals(fileExt)) {
                change.getBox().setY(change.getPageInfo().getHeight() - change.getBox().getY());
            }
            int id = change.getPageInfo().getId();
            change.getPageInfo().setId(id > 0 ? id - 1 : id);
        }
        return changes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageDescriptionEntity loadResultPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        String password = loadDocumentPageRequest.getPassword();
        try {
            Comparer comparer = new Comparer();
            List<PageImage> pageImages = comparer.convertToImages(loadDocumentPageRequest.getGuid(), password);
            try {
                PageImage pageImage = pageImages.get(loadDocumentPageRequest.getPage() - 1);
                return getPageDescriptionEntity(pageImage);
            } catch (Exception ex) {
                logger.error("Exception occurred while loading result page", ex);
                throw new TotalGroupDocsException("Exception occurred while loading result page", ex);
            }
        } catch (InvalidPasswordException
                | InvalidWordsPasswordException
                | InvalidCellPasswordException
                | InvalidPdfPasswordException
                | InvalidSlidesPasswordException
                | InvalidNotePasswordException ex) {
            throw new TotalGroupDocsException(getExceptionMessage(password), ex);
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkFiles(CompareRequest request) {
        List<LoadDocumentRequest> guids = request.getGuids();
        LoadDocumentRequest loadDocumentRequestFirst = guids.get(0);
        LoadDocumentRequest loadDocumentRequestSecond = guids.get(1);
        String extension = parseFileExtension(loadDocumentRequestFirst.getGuid());
        // check if files extensions are the same and support format file
        return extension.equals(parseFileExtension(loadDocumentRequestSecond.getGuid())) && checkSupportedFiles(extension.toLowerCase());
    }

    @Override
    public LoadDocumentEntity loadDocument(LoadDocumentRequest loadDocumentRequest) {
        String password = loadDocumentRequest.getPassword();
        try {
            LoadDocumentEntity loadDocumentEntity = new LoadDocumentEntity();
            loadDocumentEntity.setGuid(loadDocumentRequest.getGuid());
            List<PageDescriptionEntity> pageDescriptionEntities = loadPages(loadDocumentRequest.getGuid(), password);
            loadDocumentEntity.setPages(pageDescriptionEntities);
            return loadDocumentEntity;
        } catch (InvalidPasswordException
                | InvalidWordsPasswordException
                | InvalidCellPasswordException
                | InvalidPdfPasswordException
                | InvalidSlidesPasswordException
                | InvalidNotePasswordException ex) {
            throw new TotalGroupDocsException(getExceptionMessage(password), ex);
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private List<PageDescriptionEntity> loadPages(String guid, String password) {
        Comparer comparer = new Comparer();
        List<PageImage> pageImages = comparer.convertToImages(guid, password);
        try {
            List<PageDescriptionEntity> pageDescriptionEntities = getPageDescriptionEntities(pageImages);
            return pageDescriptionEntities;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new TotalGroupDocsException(e.getMessage());
        }
    }

    private List<PageDescriptionEntity> getPageDescriptionEntities(List<PageImage> containerPages) throws IOException {
        List<PageDescriptionEntity> pages = new ArrayList<>();
        for (int i = 0; i < containerPages.size(); i++) {
            PageImage page = containerPages.get(i);
            PageDescriptionEntity pageDescriptionEntity = getPageDescriptionEntity(page);
            pages.add(pageDescriptionEntity);
        }
        return pages;
    }

    private PageDescriptionEntity getPageDescriptionEntity(PageImage page) throws IOException {
        PageDescriptionEntity pageDescriptionEntity = new PageDescriptionEntity();
        pageDescriptionEntity.setNumber(page.getPageNumber());
        pageDescriptionEntity.setHeight(page.getHeight());
        pageDescriptionEntity.setWidth(page.getWidth());
        pageDescriptionEntity.setData(getStringFromStream(page.getPageStream()));
        return pageDescriptionEntity;
    }

    /**
     * Replace empty string with null
     *
     * @param password
     * @return password or null if password is empty
     */
    private String convertEmptyPasswordToNull(String password) {
        return StringUtils.isEmpty(password) ? null : password;
    }

    /**
     * Check support formats for comparing
     *
     * @param extension file extension
     * @return true - format is supported, false - format is not supported
     */
    private boolean checkSupportedFiles(String extension) {
        switch (extension) {
            case DOC:
            case DOCX:
            case XLS:
            case XLSX:
            case PPT:
            case PPTX:
            case PDF:
            case TXT:
            case HTML:
            case HTM:
                return true;
            default:
                return false;
        }
    }

    private ICompareResult compareFiles(LoadDocumentRequest loadDocumentRequestFirst, LoadDocumentRequest loadDocumentRequestSecond) {
        Comparer comparer = new Comparer();
        ComparisonSettings settings = new ComparisonSettings();
        settings.setShowDeletedContent(true);
        settings.setStyleChangeDetection(true);
        settings.setCalculateComponentCoordinates(true);
        ICompareResult compareResult = comparer.compare(
                loadDocumentRequestFirst.getGuid(),
                convertEmptyPasswordToNull(loadDocumentRequestFirst.getPassword()),
                loadDocumentRequestSecond.getGuid(),
                convertEmptyPasswordToNull(loadDocumentRequestSecond.getPassword()),
                settings);
        if (compareResult == null) {
            throw new TotalGroupDocsException("Something went wrong. We've got null result.");
        }
        return compareResult;
    }

    /**
     * Save file
     *
     * @param guid        unique key of results
     * @param inputStream stream for saving
     * @param ext         result file extension
     * @return path to saved file
     */
    private String saveFile(String guid, InputStream inputStream, String ext) {
        String imageFileName = calculateResultFileName(guid, ext);
        try {
            Files.copy(inputStream, Paths.get(imageFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error("Exception occurred while write result images files.");
        }
        return imageFileName;
    }

    public String calculateResultFileName(String documentGuid, String ext) {
        // configure file name for results
        String resultDirectory = getResultDirectory();
        String extension = ext != null ? getRightExt(ext.toLowerCase()) : "";
        return String.format("%s%s%s.%s", resultDirectory, File.separator, documentGuid, extension);
    }

    /**
     * Fix file extensions for some formats
     *
     * @param ext extension string
     * @return right extension for result file
     */
    private String getRightExt(String ext) {
        switch (ext) {
            case DOC:
            case DOCX:
                return DOCX;
            case XLS:
            case XLSX:
                return XLSX;
            case PPT:
            case PPTX:
                return PPTX;
            default:
                return ext;
        }
    }

    private String getResultDirectory() {
        return StringUtils.isEmpty(comparisonConfiguration.getResultDirectory()) ? comparisonConfiguration.getFilesDirectory() : comparisonConfiguration.getResultDirectory();
    }

}
