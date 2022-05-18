package com.groupdocs.ui.comparison.provider;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.*;
import com.groupdocs.ui.common.exception.ApiException;
import com.groupdocs.ui.comparison.config.DropboxProviderConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class DropboxFilesProvider extends FilesProvider {
    private static final Logger logger = LoggerFactory.getLogger(DropboxFilesProvider.class);
    private final String resultDirectory;
    private final DbxClientV2 client;

    public DropboxFilesProvider(DropboxProviderConfiguration dropboxProviderConfiguration) {
        logger.debug("Initializing DropboxFilesProvider...");
        try {
            final String clientIdentifier = dropboxProviderConfiguration.getClientIdentifier();
            final String accessToken = dropboxProviderConfiguration.getAccessToken();
            this.resultDirectory = dropboxProviderConfiguration.getResultDirectory();

            if (accessToken == null) {
                throw new IllegalStateException("Can't use Dropbox API without access token provided");
            }
            DbxRequestConfig config = DbxRequestConfig.newBuilder(clientIdentifier).build();
            this.client = new DbxClientV2(config, accessToken);
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't connect to files API", e);
        }
    }

    @Override
    public void visitDirectoryContent(String path, DirectoryContentVisitor visitor) {
        logger.debug("Request to Dropbox API to list files in directory '" + path + "'");
        try {
            ListFolderResult result = client.files().listFolder(StringUtils.isBlank(path) ? path : "/" + path);
            final List<Metadata> entries = result.getEntries();
            logger.debug("Request returned " + entries.size() + " files, processing...");
            for (Metadata metadata : entries) {

                final String guid = metadata.getPathLower();
                final String fileName = metadata.getName();
                final boolean isDirectory = metadata instanceof FolderMetadata;
                final long size = metadata instanceof FileMetadata ? ((FileMetadata) metadata).getSize() : 0;

                logger.trace("Processing " + guid + " ...");

                visitor.visit(
                        guid,
                        fileName,
                        isDirectory,
                        size
                );
            }
        } catch (DbxException e) {
            throw new ApiException("Api exception: Can't list files in directory", e);
        }
    }

    @Override
    public void receiveFilesInputStream(String path, Consumer<InputStream> streamConsumer) throws ApiException {
        logger.debug("Request to Dropbox API to get content of '" + path + "'");
        try {
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            final DbxUserFilesRequests filesRequests = client.files();
            try (final DbxDownloader<FileMetadata> apiDownloader = filesRequests.download(path)) {
                try (final InputStream inputStream = apiDownloader.getInputStream()) {
                    streamConsumer.accept(inputStream);
                }
            }
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't receive file data! Try to reload page.", e);
        }
    }

    @Override
    public void receiveFilesOutputStream(String path, Consumer<OutputStream> streamConsumer) throws ApiException {
        logger.debug("Request to Dropbox API to upload file with name'" + path + "'");

        try {
            final DbxUserFilesRequests filesRequests = client.files();
            try (final UploadUploader apiUploader = filesRequests.upload("/" + path)) {
                try (final OutputStream outputStream = apiUploader.getOutputStream()) {
                    streamConsumer.accept(outputStream);
                }
                apiUploader.finish();
            }
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't upload file data!", e);
        }
    }

    @Override
    public void receiveResultInputStream(String fileName, Consumer<InputStream> streamConsumer) throws ApiException {
        final String path = "/" + resultDirectory + "/" + fileName;
        logger.debug("Request to Dropbox API to get content of result file '" + path + "'");
        try {
            final DbxUserFilesRequests filesRequests = client.files();
            try (final DbxDownloader<FileMetadata> apiDownloader = filesRequests.download(path)) {
                try (final InputStream inputStream = apiDownloader.getInputStream()) {
                    streamConsumer.accept(inputStream);
                }
            }
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't receive result file data!", e);
        }
    }

    @Override
    public void receiveResultOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws ApiException {
        final String path = "/" + resultDirectory + "/" + fileName;
        logger.debug("Request to Dropbox API to upload result file '" + path + "'");
        try {
            // Always delete result file if it is already exist.
            if (isFileExists(path)) {
                deleteFile(path);
            }
            final DbxUserFilesRequests filesRequests = client.files();
            try (final UploadUploader apiUploader = filesRequests.upload(path)) {
                try (final OutputStream outputStream = apiUploader.getOutputStream()) {
                    streamConsumer.accept(outputStream);
                }
                apiUploader.finish();
            }
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't upload result file data!", e);
        }
    }

    @Override
    public boolean isFileExists(String path) {
        logger.debug("Checking is result file exists: '" + path + "'");
        try {
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            final String fileDirectory, fileName;
            if (path.contains("/")) {
                final int nameStartsFrom = path.lastIndexOf("/") + 1;
                fileDirectory = "/" + path.substring(0, nameStartsFrom);
                fileName = path.substring(nameStartsFrom);
            } else {
                fileDirectory = "";
                fileName = path;
            }

            ListFolderResult result = client.files().listFolder(fileDirectory);
            final List<Metadata> entries = result.getEntries();
            return entries.stream().anyMatch(metadata -> metadata.getName().equals(fileName.toLowerCase(Locale.ROOT)));
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't check if result file exists!", e);
        }
    }

    @Override
    public void deleteFile(String path) throws ApiException {
        logger.debug("Request to Dropbox API to delete file with path '" + path + "'");

        try {
            final DbxUserFilesRequests filesRequests = client.files();
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            filesRequests.deleteV2(path);
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't delete file data!", e);
        }
    }
}
