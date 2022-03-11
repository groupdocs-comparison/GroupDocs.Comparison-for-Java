package com.groupdocs.ui.comparison.resources;

import com.groupdocs.comparison.license.License;
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
import com.groupdocs.ui.common.util.SessionCache;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.model.ComparisonConfigurationModel;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import com.groupdocs.ui.comparison.service.ComparisonService;
import com.groupdocs.ui.comparison.service.ComparisonServiceImpl;
import com.groupdocs.ui.comparison.views.Comparison;
import io.dropwizard.jersey.sessions.Session;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.*;

@Path(value = "/comparison")
public class ComparisonResources extends Resources implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(ComparisonResources.class);
    private static final String SESSION_CACHE_KEY = "SESSION_CACHE";

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
    public List<FileDescriptionEntity> loadFileTree(@Session HttpSession httpSession, FileTreeRequest fileTreeRequest) {
        return comparisonService.loadFileTree(fileTreeRequest);
    }

    /**
     * Download results
     *
     * @param documentGuid unique key of results
     */
    @GET
    @Path(value = "/downloadDocument")
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadDocument(@Session HttpSession httpSession, @QueryParam("guid") String documentGuid, @Context HttpServletRequest request,
                                 @Context HttpServletResponse response) {
//        request.
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
    public CompareResultResponse compareWithPaths(@Session HttpSession httpSession, CompareRequest compareRequest) {
        // check formats
        if (comparisonService.checkFiles(compareRequest)) {
            final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
            if (attribute instanceof SessionCache) {
                final SessionCache sessionCache = (SessionCache) attribute;
                // compare
                return comparisonService.compare(compareRequest, sessionCache);
            } else if (attribute != null) {
                logger.warn("Unknown session cache object");
                throw new TotalGroupDocsException("Unknown session cache object");
            }
        } else {
            logger.error("Document types are different");
            throw new TotalGroupDocsException("Document types are different");
        }
        logger.warn("Session cache object does not exist");
        throw new TotalGroupDocsException("Session cache object does not exist");
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
    public PageDescriptionEntity loadDocumentPage(@Session HttpSession httpSession, LoadDocumentPageRequest loadDocumentPageRequest) {
        final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
        if (attribute instanceof SessionCache) {
            final SessionCache sessionCache = (SessionCache) attribute;

            return comparisonService.loadDocumentPage(loadDocumentPageRequest, sessionCache);
        } else if (attribute != null) {
            logger.warn("Unknown session cache object");
            throw new TotalGroupDocsException("Unknown session cache object");
        }
        logger.warn("Session cache object does not exist");
        throw new TotalGroupDocsException("Session cache object does not exist");
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
    public LoadDocumentEntity loadDocumentDescription(@Session HttpSession httpSession, LoadDocumentRequest loadDocumentRequest) {
        final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
        if (attribute instanceof SessionCache) {
            final SessionCache sessionCache = (SessionCache) attribute;

            return comparisonService.loadDocumentDescription(loadDocumentRequest, sessionCache);
        } else if (attribute != null) {
            logger.warn("Unknown session cache object");
            throw new TotalGroupDocsException("Unknown session cache object");
        }
        logger.warn("Session cache object does not exist");
        throw new TotalGroupDocsException("Session cache object does not exist");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        logger.warn("sessionCreated is called, id=" + session.getId());
        final ComparisonConfiguration comparisonConfiguration = comparisonService.getComparisonConfiguration();
        final String resultDirectory = comparisonConfiguration.getResultDirectory();
        session.setAttribute(SESSION_CACHE_KEY, new SessionCache(Paths.get(resultDirectory), session.getId()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        logger.warn("sessionDestroyed is called, id=" + session.getId());
        final Object attribute = session.getAttribute(SESSION_CACHE_KEY);
        if (attribute instanceof SessionCache) {
            final SessionCache sessionCache = (SessionCache) attribute;
            sessionCache.clear();
        } else if (attribute != null) {
            logger.warn("Unknown session cache object");
        }
    }
}
