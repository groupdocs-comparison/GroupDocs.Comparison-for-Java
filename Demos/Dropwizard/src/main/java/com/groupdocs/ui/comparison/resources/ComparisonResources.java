package com.groupdocs.ui.comparison.resources;

import com.groupdocs.comparison.common.license.License;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.UploadedDocumentEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.resources.Resources;
import com.groupdocs.ui.comparison.model.ComparisonConfigurationModel;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import com.groupdocs.ui.comparison.service.ComparisonService;
import com.groupdocs.ui.comparison.service.ComparisonServiceImpl;
import com.groupdocs.ui.comparison.views.Comparison;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.*;

@Path(value = "/comparison")
public class ComparisonResources extends Resources {
    private static final Logger logger = LoggerFactory.getLogger(ComparisonResources.class);

    private ComparisonService comparisonService;

    /**
     * Constructor
     *
     * @param globalConfiguration global application configuration
     * @throws UnknownHostException
     */
    public ComparisonResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);
        comparisonService = new ComparisonServiceImpl(globalConfiguration);
        // set GroupDocs license
        try {
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Comparison license!");
        }
    }

    @GET
    @Path(value = "/loadConfig")
    @Produces(APPLICATION_JSON)
    public ComparisonConfigurationModel loadConfig() {
        return ComparisonConfigurationModel.createComparisonConfiguration(globalConfiguration.getComparison(), globalConfiguration.getCommon());
    }

    /**
     * Get comparison page
     *
     * @return template name
     */
    @GET
    public Comparison getView() {
        logger.debug("comparison config: {}", globalConfiguration.getComparison());
        // initiate index page
        return new Comparison(globalConfiguration, DEFAULT_CHARSET);
    }

    /**
     * Get files and directories
     *
     * @return files and directories list
     */
    @POST
    @Path(value = "/loadFileTree")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest) {
        return comparisonService.loadFiles(fileTreeRequest);
    }

    /**
     * Download results
     *
     * @param documentGuid unique key of results
     */
    @GET
    @Path(value = "/downloadDocument")
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadDocument(@QueryParam("guid") String documentGuid,
                                 @Context HttpServletResponse response) {
        downloadFile(response, documentGuid);
    }

    /**
     * Upload document
     *
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @POST
    @Path(value = "/uploadDocument")
    @Produces(APPLICATION_JSON)
    @Consumes(MULTIPART_FORM_DATA)
    public UploadedDocumentEntity uploadDocument(@FormDataParam("file") InputStream inputStream,
                                                 @FormDataParam("file") FormDataContentDisposition fileDetail,
                                                 @FormDataParam("url") String url,
                                                 @FormDataParam("rewrite") Boolean rewrite) {
        // upload file
        String pathname = uploadFile(url, inputStream, fileDetail, rewrite, null);
        // create response
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }

    @Override
    protected String getStoragePath(Map<String, Object> params) {
        return globalConfiguration.getComparison().getFilesDirectory();
    }

    /**
     * Compare files from local storage
     *
     * @param compareRequest request with paths to files
     * @return response with compare results
     */
    @POST
    @Path(value = "/compare")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public CompareResultResponse compareWithPaths(CompareRequest compareRequest) {
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
     * Get document page
     *
     * @return result page image
     */
    @POST
    @Path(value = "/loadDocumentPage")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        return comparisonService.loadResultPage(loadDocumentPageRequest);
    }

    /**
     * Get document
     *
     * @return result page image
     */
    @POST
    @Path(value = "/loadDocumentDescription")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        return comparisonService.loadDocument(loadDocumentRequest);
    }
}
