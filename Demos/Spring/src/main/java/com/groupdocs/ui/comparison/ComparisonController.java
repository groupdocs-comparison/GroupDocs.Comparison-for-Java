package com.groupdocs.ui.comparison;

import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.model.response.LoadDocumentEntity;
import com.groupdocs.ui.model.response.PageDescriptionEntity;
import com.groupdocs.ui.model.response.UploadedDocumentEntity;
import com.groupdocs.ui.util.Utils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.groupdocs.ui.util.Utils.setLocalPort;
import static com.groupdocs.ui.util.Utils.uploadFile;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@RequestMapping("/comparison")
public class ComparisonController {
    private static final Logger logger = LoggerFactory.getLogger(ComparisonController.class);

    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Autowired
    private ComparisonService comparisonService;

    @RequestMapping(method = RequestMethod.GET, value = "/loadConfig", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ComparisonConfiguration loadConfig() {
        return comparisonService.getComparisonConfiguration();
    }

    /**
     * Get comparison page
     *
     * @param model model data for template
     * @return template name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getView(HttpServletRequest request, Map<String, Object> model) {
        setLocalPort(request, globalConfiguration.getServer());

        model.put("globalConfiguration", globalConfiguration);
        logger.debug("comparison config: {}", comparisonService.getComparisonConfiguration());
        model.put("comparisonConfiguration", comparisonService.getComparisonConfiguration());
        return "comparison";
    }

    /**
     * Get files and directories
     *
     * @return files and directories list
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadFileTree", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FileDescriptionEntity> loadFileTree(@RequestBody FileTreeRequest fileTreeRequest) {
        return comparisonService.loadFiles(fileTreeRequest);
    }

    /**
     * Download results
     *
     * @param documentGuid unique key of results
     */
    @RequestMapping(method = RequestMethod.GET, value = "/downloadDocument")
    public void downloadDocument(@RequestParam(name = "guid") String documentGuid,
                                 HttpServletResponse response) {
        File file = new File(documentGuid);
        // set response content info
        Utils.addFileDownloadHeaders(response, file.getName(), file.length());
        // download the document
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(documentGuid));
             ServletOutputStream outputStream = response.getOutputStream()) {

            IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            logger.error("Exception in downloading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Upload document
     *
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadDocument",
            consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public UploadedDocumentEntity uploadDocument(@Nullable @RequestParam("file") MultipartFile content,
                                                 @RequestParam(value = "url", required = false) String url,
                                                 @RequestParam("rewrite") Boolean rewrite) {
        // get documents storage path
        String documentStoragePath = comparisonService.getComparisonConfiguration().getFilesDirectory();
        // save the file
        String pathname = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }

    /**
     * Compare files from local storage
     *
     * @param compareRequest request with paths to files
     * @return response with compare results
     */
    @RequestMapping(method = RequestMethod.POST, value = "/compare", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public CompareResultResponse compare(@RequestBody CompareRequest compareRequest) {
        // check formats
        if (comparisonService.checkFiles(compareRequest)) {
            // compare
            return comparisonService.compare(compareRequest);
        } else {
            logger.error("Document types are different");
            throw new TotalGroupDocsException("Document types are different");
        }
    }

    /**
     * Get document description
     *
     * @return document description
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDocumentDescription", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoadDocumentEntity loadDocumentDescription(@RequestBody LoadDocumentPageRequest loadDocumentRequest) {
        return comparisonService.loadDocumentDescription(loadDocumentRequest);
    }

    /**
     * Get result page
     *
     * @return result page image
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDocumentPage", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageDescriptionEntity loadDocumentPage(@RequestBody LoadDocumentPageRequest loadDocumentPageRequest) {
        return comparisonService.loadDocumentPage(loadDocumentPageRequest);
    }

}
