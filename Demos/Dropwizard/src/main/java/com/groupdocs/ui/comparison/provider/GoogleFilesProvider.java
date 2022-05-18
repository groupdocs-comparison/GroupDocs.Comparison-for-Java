package com.groupdocs.ui.comparison.provider;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.groupdocs.ui.common.Defaults;
import com.groupdocs.ui.common.exception.ApiException;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.comparison.config.GoogleProviderConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.function.Consumer;

/**
 * Entering into folders is not implemented, folders are excluded from the list
 * The implementation is just an example, modify it according to your needs
 */
public class GoogleFilesProvider extends FilesProvider {
    private static final Logger logger = LoggerFactory.getLogger(GoogleFilesProvider.class);
    private static final JsonFactory JSON_FACTORY = new GsonFactory();
    private final Drive service;
    // It can use too much memory, restart app periodically
    private final Map<String, String> guid2name = new HashMap<>();

    public GoogleFilesProvider(GoogleProviderConfiguration googleProviderConfiguration) {
        logger.debug("Initializing GoogleFilesProvider...");
        try {
            final String credentialsPath = googleProviderConfiguration.getCredentialsPath();
            final String tokensDirectoryPath = googleProviderConfiguration.getTokensDirectoryPath();
            final Defaults.Google.AccessType accessType = googleProviderConfiguration.getAccessType();
            final int localServerReceiverPort = googleProviderConfiguration.getLocalServerReceiverPort();
            final String authorizationUserId = googleProviderConfiguration.getAuthorizationUserId();
            final String applicationName = googleProviderConfiguration.getApplicationName();
            if (credentialsPath == null) {
                throw new IllegalStateException("Can't use Google Drive API without credentials provided");
            }
            InputStream credentialsInputStream;
            if (googleProviderConfiguration.isCredentialsPathPresent()) {
                logger.debug("Using '" + credentialsPath + "' as a path to Google API credentials file (Usually 'credentials.json')");
                Path path = Paths.get(credentialsPath);
                final boolean isRelative = !path.isAbsolute();
                if (isRelative) {
                    path = FileSystems.getDefault().getPath(path.toString()).toAbsolutePath();
                }

                credentialsInputStream = new BufferedInputStream(Files.newInputStream(path));
            } else {
                logger.debug("Credentials path to Google API credentials file is not provided. Trying to load it from resources (Usually 'credentials.json')");
                final InputStream resourceCredentialsStream = getClass().getClassLoader().getResourceAsStream(credentialsPath);
                if (resourceCredentialsStream == null) {
                    throw new IllegalStateException("Google API credentials file '" + credentialsPath + "' was not found in resources");
                }
                credentialsInputStream = new BufferedInputStream(resourceCredentialsStream);
            }
            try {
                final NetHttpTransport netHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
                logger.debug("Loading Google API clients secrets...");
                GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(credentialsInputStream));
                final List<String> scopes = Collections.singletonList(DriveScopes.DRIVE);
                logger.debug("Creating Google API flow and triggering user authorization request");
                GoogleAuthorizationCodeFlow.Builder builder = new GoogleAuthorizationCodeFlow.Builder(
                        netHttpTransport, JSON_FACTORY, clientSecrets, scopes)
                        .setAccessType(accessType.name().toLowerCase(Locale.ROOT));
                if (tokensDirectoryPath != null) {
                    logger.debug("Using '" + tokensDirectoryPath + "' directory to save credentials file");
                    final Path tokensDirectory = Files.createDirectories(Paths.get(tokensDirectoryPath));
                    builder = builder.setDataStoreFactory(new FileDataStoreFactory(tokensDirectory.toFile()));
                } else {
                    logger.debug("tokensDirectoryPath is not provided. Authorization request will be retriggered");
                }
                GoogleAuthorizationCodeFlow flow = builder.build();
                LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(localServerReceiverPort).build();
                Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize(authorizationUserId);
                logger.debug("Creating Google API service...");
                this.service = new Drive.Builder(netHttpTransport, JSON_FACTORY, credential)
                        .setApplicationName(applicationName)
                        .build();
            } finally {
                credentialsInputStream.close();
            }
        } catch (IOException | GeneralSecurityException e) {
            throw new ApiException("Api exception: Can't connect to files API", e);
        }
    }

    @Override
    public void visitDirectoryContent(String path, DirectoryContentVisitor visitor) throws ApiException {
        logger.debug("Request to Google API to list files in directory '" + path + "'");
        try {
            FileList result = service.files().list()
                    .setFields("files(id, name, size, mimeType, parents)")
                    .setCorpora("user")
                    .set("ownedByMe", true)
                    .setSpaces("drive")
                    .set("trashed", false)
                    // Remove directories and their content from the list
                    .setQ("mimeType != 'application/vnd.google-apps.folder' and 'root' in parents")
                    .setOrderBy("name_natural")
                    .execute();
            final List<File> files = result.getFiles();
            logger.debug("Request returned " + files.size() + " files, processing...");
            files.stream()
                    // Remove Google Docs items from the list
                    .filter(item -> {
                        final String mimeType = item.getMimeType();
                        return mimeType == null || !mimeType.startsWith("application/vnd.google-apps");
                    })
                    .forEach(item -> {
                        final String guid = item.getId();
                        final String fileName = item.getName();
                        final boolean isDirectory = "application/vnd.google-apps.folder".equalsIgnoreCase(item.getMimeType());
                        final Long size = item.getSize();

                        guid2name.put(guid, fileName);

                        visitor.visit(
                                fileName,
                                fileName,
                                isDirectory,
                                isDirectory || size == null ? 0L : size
                        );
                    });
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't list files in directory", e);
        }
    }

    @Override
    public void receiveFilesInputStream(String path, Consumer<InputStream> streamConsumer) throws ApiException {
        logger.debug("Request to Google API to get file content '" + path + "'");
        try {
            final Optional<String> first = guid2name.entrySet().stream()
                    .filter(entry -> Objects.equals(entry.getValue(), path))
                    .map(Map.Entry::getKey).findFirst();
            if (first.isPresent()) {
                final Drive.Files.Get getFilesRequest = service.files().get(first.get());
                try (final InputStream inputStream = getFilesRequest.executeMediaAsInputStream()) {
                    streamConsumer.accept(inputStream);
                }
            } else {
                logger.debug("Guid for file '" + path + "' was not found");
                throw new TotalGroupDocsException("Can not get file! Try to reload page.");
            }
        } catch (TotalGroupDocsException e) {
            throw e;
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't receive file data! Try to reload page.", e);
        }
    }

    @Override
    public void receiveFilesOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws ApiException {
        logger.debug("Request to Google API to save uploaded file by name'" + fileName + "'");
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            final File fileMetadata = new File();
            fileMetadata.setName(fileName);
            streamConsumer.accept(outputStream);
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray())) {
                final InputStreamContent inputStreamContent = new InputStreamContent("application/octet-stream", inputStream);

                File file = service.files().create(fileMetadata, inputStreamContent)
                        .setFields("id")
                        .execute();

                final String guid = file.getId();

                guid2name.put(guid, fileName);
            }
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't upload file data!", e);
        }
    }

    @Override
    public void receiveResultInputStream(String fileName, Consumer<InputStream> streamConsumer) throws ApiException {
        logger.debug("Request to Google API to get result file content '" + fileName + "'");
        try {
            final Optional<String> first = guid2name.entrySet().stream()
                    .filter(entry -> Objects.equals(entry.getValue(), fileName))
                    .map(Map.Entry::getKey).findFirst();
            if (first.isPresent()) {
                final Drive.Files.Get getFilesRequest = service.files().get(first.get());
                try (final InputStream inputStream = getFilesRequest.executeMediaAsInputStream()) {
                    streamConsumer.accept(inputStream);
                }
            } else {
                logger.debug("Guid for result file '" + fileName + "' was not found");
                throw new TotalGroupDocsException("Api exception: File was not found!");
            }
        } catch (TotalGroupDocsException e) {
            throw e;
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't receive result file data!", e);
        }
    }

    @Override
    public void receiveResultOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws ApiException {
        logger.debug("Request to Google API to save result file by name'" + fileName + "'");
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            final File fileMetadata = new File();
            fileMetadata.setName(fileName);
            streamConsumer.accept(outputStream);
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray())) {
                final InputStreamContent inputStreamContent = new InputStreamContent("application/octet-stream", inputStream);

                File file = service.files().create(fileMetadata, inputStreamContent)
                        .setFields("id")
                        .execute();

                final String guid = file.getId();

                guid2name.put(guid, fileName);
            }
        } catch (Exception e) {
            throw new ApiException("Api exception: Can't upload result file data!", e);
        }

    }

    @Override
    public boolean isFileExists(String path) throws ApiException {
        logger.debug("Checking is result file exists: '" + path + "'");
        try {
            FileList result = service.files().list()
                    .setFields("files(id)")
                    .setCorpora("user")
                    .set("ownedByMe", true)
                    .setSpaces("drive")
                    .set("trashed", false)
                    // Remove directories and their content from the list, check by name is file exists
                    .setQ("mimeType != 'application/vnd.google-apps.folder' and 'root' in parents and name = '" + path + "'")
                    .execute();
            return !result.isEmpty();

        } catch (Exception e) {
            throw new ApiException("Api exception: Can't check if result file exists!", e);
        }
    }
}
