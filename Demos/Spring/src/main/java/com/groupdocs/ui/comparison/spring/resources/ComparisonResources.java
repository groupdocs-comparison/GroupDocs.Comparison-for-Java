package com.groupdocs.ui.comparison.spring.resources;

import com.groupdocs.comparison.common.exceptions.PasswordProtectedFileException;
import com.groupdocs.comparison.license.License;
import com.groupdocs.ui.comparison.spring.common.Defaults;
import com.groupdocs.ui.comparison.spring.common.config.GlobalConfiguration;
import com.groupdocs.ui.comparison.spring.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.comparison.spring.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.comparison.spring.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.comparison.spring.common.entity.web.UploadedDocumentEntity;
import com.groupdocs.ui.comparison.spring.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.comparison.spring.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.comparison.spring.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.comparison.spring.common.resources.Resources;
import com.groupdocs.ui.comparison.spring.common.util.SessionCache;
import com.groupdocs.ui.comparison.spring.common.util.TempFilesManager;
import com.groupdocs.ui.comparison.spring.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.spring.model.ComparisonConfigurationModel;
import com.groupdocs.ui.comparison.spring.model.request.CompareRequest;
import com.groupdocs.ui.comparison.spring.model.response.CompareResultResponse;
import com.groupdocs.ui.comparison.spring.provider.FilesProvider;
import com.groupdocs.ui.comparison.spring.service.ComparisonService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.servlet.http.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.groupdocs.ui.comparison.spring.common.util.Utils.setLocalPort;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@RequestMapping("/comparison")
public class ComparisonResources extends Resources implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(ComparisonResources.class);
    private static final String SESSION_CACHE_KEY = "SESSION_CACHE";
    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Autowired
    private ComparisonService comparisonService;

    /**
     * Autowired fields are already filled
     */
    @PostConstruct
    public void init() {
        try {
            TempFilesManager.createInstance(globalConfiguration.getComparison().getTempDirectory());
            FilesProvider.create(globalConfiguration);
            setLicense();
        } catch (TotalGroupDocsException e) {
            logger.error("Initialization error!", e);
            // Message is correct to show it to user
            throw new TotalGroupDocsException(e.getMessage());
        } catch (Exception e) {
            logger.error("Initialization error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/app-name")
    @ResponseBody
    public String appName() {
        return "comparison-spring";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadConfig", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
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
     * @param model model data for template
     * @return template name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getView(HttpServletRequest request, Map<String, Object> model) {
        try {
            logger.debug("comparison config: {}", globalConfiguration.getComparison());
            setLocalPort(request, globalConfiguration.getServer());

            model.put("globalConfiguration", globalConfiguration);
            logger.debug("comparison config: {}", comparisonService.getComparisonConfiguration());
            model.put("comparisonConfiguration", comparisonService.getComparisonConfiguration());
            return "comparison";
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
    @RequestMapping(method = RequestMethod.POST, value = "/loadFileTree", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FileDescriptionEntity> loadFileTree(@RequestBody FileTreeRequest fileTreeRequest) {
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
    @RequestMapping(method = RequestMethod.GET, value = "/downloadDocument")
    public void downloadDocument(@RequestParam(name = "guid") String fileGuid, HttpServletResponse response) {
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
                                                 @RequestParam(value = "url", required = false) String fileUrl,
                                                 @RequestParam("rewrite") Boolean rewrite) {
        boolean isUploadEnabled = globalConfiguration.getCommon().isUpload();
        if (!isUploadEnabled) {
            throw new TotalGroupDocsException("Files uploading is disabled!");
        }

        try {
            final String fileName;
            InputStream inputStream = null;
            try {
                if (content != null && StringUtils.isBlank(fileUrl)) {
                    fileName = content.getOriginalFilename();
                    inputStream = content.getInputStream();
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
                com.groupdocs.comparison.common.Utils.closeStreams(inputStream);
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
    @RequestMapping(method = RequestMethod.POST, value = "/compare", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public CompareResultResponse compareWithPaths(@RequestBody CompareRequest compareRequest, HttpSession httpSession) {
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
                throw new TotalGroupDocsException("Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Comparison itself. Other probable reason of the error - documents types are different.");
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
     * Get result page
     *
     * @return result page image
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDocumentPage", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageDescriptionEntity loadDocumentPage(@RequestBody LoadDocumentPageRequest loadDocumentPageRequest, HttpSession httpSession) {
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
     * Get document description
     *
     * @return document description
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDocumentDescription", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoadDocumentEntity loadDocumentDescription(@RequestBody LoadDocumentPageRequest loadDocumentRequest, HttpSession httpSession) {
        try {
            final Object attribute = httpSession.getAttribute(SESSION_CACHE_KEY);
            if (attribute instanceof SessionCache) {
                final SessionCache sessionCache = (SessionCache) attribute;

                return comparisonService.loadDocumentDescription(loadDocumentRequest, sessionCache);
            } else if (attribute != null) {
                throw new IllegalStateException("Unknown session cache object");
            }
            throw new IllegalStateException("Session cache object does not exist");
        } catch (PasswordProtectedFileException e) {
            throw e;
        } catch (TotalGroupDocsException e) {
            logger.error("Loading document error!", e);
            // Message is correct to show it to user
            throw e;
        } catch (Exception e) {
            logger.error("Loading document error!", e);
            throw new TotalGroupDocsException("Internal server error! Check details in server logs.");
        }
    }

    private void setLicense() {
        try {
            // set GroupDocs license
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
                        try (final Stream<Path> pathStream = Files.list(path)) {
                            final Optional<Path> first = pathStream.filter(it -> it.endsWith(licenseExtension)).findFirst();
                            first.ifPresent(license::setLicense);
                        }
                    }
                }
            }
            logger.info("License was set!");
        } catch (Exception e) {
            logger.error("Can not verify Comparison license!", e);
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
