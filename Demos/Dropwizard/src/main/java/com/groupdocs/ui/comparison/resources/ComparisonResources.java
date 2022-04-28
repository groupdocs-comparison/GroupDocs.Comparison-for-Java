package com.groupdocs.ui.comparison.resources;

import com.groupdocs.comparison.common.Utils;
import com.groupdocs.comparison.license.License;
import com.groupdocs.ui.common.Defaults;
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
import com.groupdocs.ui.comparison.provider.FilesProvider;
import com.groupdocs.ui.comparison.service.ComparisonService;
import com.groupdocs.ui.comparison.service.ComparisonServiceImpl;
import com.groupdocs.ui.comparison.views.Comparison;
import io.dropwizard.jersey.sessions.Session;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static javax.ws.rs.core.MediaType.*;

@Path(value = "/comparison")
public class ComparisonResources extends Resources implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(ComparisonResources.class);
    private static final String SESSION_CACHE_KEY = "SESSION_CACHE";

    private final ComparisonService comparisonService;

    /**
     * Constructor
     *
     * @param globalConfiguration global application configuration
     */
    public ComparisonResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);
        try {
            FilesProvider.create(globalConfiguration);
            comparisonService = new ComparisonServiceImpl(globalConfiguration);
            // set GroupDocs license
            try {
                final String licensePath = globalConfiguration.getApplication().getLicensePath();
                final String licenseExtension = Defaults.Application.DEFAULT_LICENSE_EXTENSION;
                License license = new License();
                if (licensePath.startsWith("http://") || licensePath.startsWith("https://")) {
                    final URL url = new URL(licensePath);
                    try (final InputStream inputStream = new BufferedInputStream(url.openStream())) {
                        license.setLicense(inputStream);
                    }
                } else {
                    final java.nio.file.Path path = Paths.get(licensePath);
                    if (Files.exists(path)) {
                        if (Files.isRegularFile(path)) {
                            license.setLicense(licensePath);
                        } else {
                            try (final Stream<java.nio.file.Path> pathStream = Files.list(path)) {
                                final Optional<java.nio.file.Path> first = pathStream.filter(it -> it.endsWith(licenseExtension)).findFirst();
                                first.ifPresent(license::setLicense);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Can not verify Comparison license!", e);
            }
        } catch (TotalGroupDocsException e) {
            logger.error("Initialization error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Initialization error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
    }

    @GET
    @Path(value = "/loadConfig")
    @Produces(APPLICATION_JSON)
    public ComparisonConfigurationModel loadConfig() {
        try {
            return ComparisonConfigurationModel.createComparisonConfiguration(globalConfiguration.getComparison(), globalConfiguration.getCommon());
        } catch (TotalGroupDocsException e) {
            logger.error("Loading config error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Loading config error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
    }

    /**
     * Get comparison page
     *
     * @return template name
     */
    @GET
    public Comparison getView() {
        try {
            logger.debug("comparison config: {}", globalConfiguration.getComparison());
            // initiate index page
            return new Comparison(globalConfiguration, DEFAULT_CHARSET);
        } catch (TotalGroupDocsException e) {
            logger.error("Loading view error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Loading view error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
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
        try {
            return comparisonService.loadFileTree(fileTreeRequest);
        } catch (TotalGroupDocsException e) {
            logger.error("Loading file tree error error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Loading file tree error error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
    }

    /**
     * Download results
     *
     * @param fileGuid unique key of results
     */
    @GET
    @Path(value = "/downloadDocument")
    @Produces(APPLICATION_OCTET_STREAM)
    public Response downloadDocument(@Session HttpSession httpSession, @QueryParam("guid") String fileGuid, @Context HttpServletRequest request,
                                     @Context HttpServletResponse response) {
        try {
            comparisonService.downloadFile(fileGuid, (length, inputStream) -> {
                String fileName = FilenameUtils.getName(fileGuid);
                // don't delete, should be before writing
                addFileDownloadHeaders(response, fileName, length);
                // download the document
                try (OutputStream outputStream = response.getOutputStream()) {
                    IOUtils.copyLarge(inputStream, outputStream);
                }
            });
        } catch (TotalGroupDocsException e) {
            logger.error("Downloading file error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Downloading file error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
        return Response.ok().build();
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
    public UploadedDocumentEntity uploadDocument(@FormDataParam("file") InputStream fileStream,
                                                 @FormDataParam("file") FormDataContentDisposition fileDetail,
                                                 @FormDataParam("url") String fileUrl,
                                                 @FormDataParam("rewrite") Boolean rewrite) {
        try {
            final String fileName;
            InputStream inputStream = null;
            try {
                if (StringUtils.isBlank(fileUrl)) {
                    fileName = fileDetail.getFileName();
                    inputStream = fileStream;
                } else {
                    URL url = new URL(fileUrl);
                    inputStream = url.openStream();
                    fileName = FilenameUtils.getName(url.getPath());
                }
                // upload file
                String pathName = comparisonService.uploadFile(inputStream, fileName, rewrite);
                // create response
                UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
                uploadedDocument.setGuid(pathName);
                return uploadedDocument;
            } finally {
                Utils.closeStreams(inputStream);
            }
        } catch (TotalGroupDocsException e) {
            logger.error("Uploading file error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Uploading file error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
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
        try {
            // check formats
            if (comparisonService.checkFiles(compareRequest)) {
                final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
                if (attribute instanceof SessionCache) {
                    final SessionCache sessionCache = (SessionCache) attribute;
                    // compare
                    return comparisonService.compare(compareRequest, sessionCache);
                } else if (attribute != null) {
                    throw new IllegalStateException("Unknown session cache object");
                }
            } else {
                throw new TotalGroupDocsException("Document types are not supported in sample app or are different");
            }
            throw new IllegalStateException("Session cache object does not exist");

        } catch (TotalGroupDocsException e) {
            logger.error("Comparing error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Comparing error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
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
    public PageDescriptionEntity loadDocumentPage(@Session HttpSession httpSession, LoadDocumentPageRequest loadDocumentPageRequest) {
        try {
            final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
            if (attribute instanceof SessionCache) {
                final SessionCache sessionCache = (SessionCache) attribute;

                return comparisonService.loadDocumentPage(loadDocumentPageRequest, sessionCache);
            } else if (attribute != null) {
                throw new IllegalStateException("Unknown session cache object");
            }
            throw new IllegalStateException("Session cache object does not exist");
        } catch (TotalGroupDocsException e) {
            logger.error("Loading document error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Loading document error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
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
        try {
            final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
            if (attribute instanceof SessionCache) {
                final SessionCache sessionCache = (SessionCache) attribute;

                return comparisonService.loadDocumentDescription(loadDocumentRequest, sessionCache);
            } else if (attribute != null) {
                throw new IllegalStateException("Unknown session cache object");
            }
            throw new IllegalStateException("Session cache object does not exist");
        } catch (TotalGroupDocsException e) {
            logger.error("Loading document error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Loading document error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        logger.debug("sessionCreated is called, id=" + session.getId());
        final ComparisonConfiguration comparisonConfiguration = comparisonService.getComparisonConfiguration();
        java.nio.file.Path path = Paths.get(comparisonConfiguration.getCacheDirectory());
        final boolean isRelative = !path.isAbsolute();
        if (isRelative) {
            path = FileSystems.getDefault().getPath(path.toString()).toAbsolutePath();
        }
        try {
            logger.debug("Cache directory is going to be '" + path + "'");
            final java.nio.file.Path cacheDirectory = Files.createDirectories(path);
            session.setAttribute(SESSION_CACHE_KEY, new SessionCache(cacheDirectory, session.getId()));
        } catch (IOException e) {
            throw new RuntimeException("Can't create cache directory: '" + path + "'", e);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        logger.debug("sessionDestroyed is called, id=" + session.getId());
        final Object attribute = session.getAttribute(SESSION_CACHE_KEY);
        if (attribute instanceof SessionCache) {
            final SessionCache sessionCache = (SessionCache) attribute;
            sessionCache.clear();
        } else if (attribute != null) {
            logger.warn("Unknown session cache object");
        }
    }
}
