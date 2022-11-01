package com.groupdocs.ui.comparison.dropwizard.provider;

import com.groupdocs.ui.comparison.dropwizard.common.exception.LocalDiskException;
import com.groupdocs.ui.comparison.dropwizard.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.comparison.dropwizard.config.LocalProviderConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.util.function.Consumer;

public class LocalFilesProvider extends FilesProvider {
    private static final Logger logger = LoggerFactory.getLogger(LocalFilesProvider.class);
    private final Path filesDirectory;
    private final Path resultDirectory;

    public LocalFilesProvider(LocalProviderConfiguration local) {
        final String filesDirectory = local.getFilesDirectory();
        final String resultDirectory = local.getResultDirectory();

        this.filesDirectory = makePathAbsoluteAndCreateDirectoriesIfNeed(filesDirectory);
        logger.debug("Files directory is '" + this.filesDirectory + "'");

        if (filesDirectory.equals(resultDirectory)) {
            this.resultDirectory = this.filesDirectory;
        } else {
            this.resultDirectory = makePathAbsoluteAndCreateDirectoriesIfNeed(resultDirectory);
        }
        logger.debug("Result directory is '" + this.resultDirectory + "'");
    }

    private Path makePathAbsoluteAndCreateDirectoriesIfNeed(String srcPath) {
        Path path = Paths.get(srcPath);
        final boolean isRelative = !path.isAbsolute();
        if (isRelative) {
            path = FileSystems.getDefault().getPath(path.toString()).toAbsolutePath();
        }
        try {
            if (Files.notExists(path)) {
                return Files.createDirectories(path);
            } else {
                return path;
            }
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't create files directory!", e);
        }
    }

    @Override
    public void visitDirectoryContent(String path, DirectoryContentVisitor visitor) throws LocalDiskException {
        logger.debug("Getting directory content for '" + path + "'");
        Path directoryPath = filesDirectory.resolve(path);
        try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {

            directoryStream.forEach(itemPath -> {
                try {
                    final Path absolutePath = itemPath.toAbsolutePath();
                    final Path fileName = absolutePath.getFileName();
                    final boolean isDirectory = Files.isDirectory(itemPath);
                    final long size = isDirectory ? 0 : Files.size(itemPath);
                    visitor.visit(
                            absolutePath.toString(),
                            fileName.toString(),
                            isDirectory,
                            size
                    );
                } catch (Exception e) {
                    logger.warn("Can't get data for '" + directoryPath + "'", e);
                }
            });
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't list files in directory", e);
        }
    }

    @Override
    public void receiveFilesInputStream(String path, Consumer<InputStream> streamConsumer) throws LocalDiskException {
        logger.debug("Creating document input stream for '" + path + "'");
        try (final BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(filesDirectory.resolve(path)))) {
            streamConsumer.accept(inputStream);
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't receive file data! Try to reload page.", e);
        }
    }

    @Override
    public void receiveFilesOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws LocalDiskException {
        logger.debug("Creating document output stream for '" + fileName + "'");

        try (final BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(filesDirectory.resolve(fileName)))) {
            streamConsumer.accept(outputStream);
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't upload file data!", e);
        }
    }

    @Override
    public void receiveResultInputStream(String fileName, Consumer<InputStream> streamConsumer) throws LocalDiskException {
        logger.debug("Creating result input stream for '" + fileName + "'");

        try (final BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(resultDirectory.resolve(fileName)))) {
            streamConsumer.accept(inputStream);
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't receive result file data!", e);
        }
    }

    @Override
    public void receiveResultOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws LocalDiskException {
        logger.debug("Creating result output stream for '" + fileName + "'");

        try (final BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(resultDirectory.resolve(fileName)))) {
            streamConsumer.accept(outputStream);
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't upload result file data!", e);
        }
    }

    @Override
    public boolean isFileExists(String path) {
        logger.debug("Checking is file exists: '" + path + "'");
        return Files.exists(filesDirectory.resolve(path));
    }

    @Override
    public void deleteFile(String path) throws TotalGroupDocsException {
        logger.debug("Deleting the file: '" + path + "'");
        try {
            Files.delete(filesDirectory.resolve(path));
        } catch (IOException e) {
            throw new LocalDiskException("Storage exception: Can't delete the file!", e);
        }
    }
}
