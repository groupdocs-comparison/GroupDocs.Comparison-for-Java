package com.groupdocs.ui.comparison.provider;

import com.groupdocs.ui.comparison.config.LocalProviderConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;

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
            throw new RuntimeException("Can't create files directory: '" + path + "'", e);
        }
    }

    @Override
    public void visitDirectoryContent(String path, DirectoryContentVisitor visitor) throws IOException {
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
        }
    }

    @Override
    public InputStream createFilesInputStream(String path) throws IOException {
        logger.debug("Creating document input stream for '" + path + "'");
        return new BufferedInputStream(Files.newInputStream(filesDirectory.resolve(path)));
    }

    @Override
    public OutputStream createFilesOutputStream(String fileName) throws IOException {
        logger.debug("Creating document output stream for '" + fileName + "'");

        return new BufferedOutputStream(Files.newOutputStream(filesDirectory.resolve(fileName)));
    }

    @Override
    public OutputStream createResultOutputStream(String fileName) throws IOException {
        logger.debug("Creating result output stream for '" + fileName + "'");

        return new BufferedOutputStream(Files.newOutputStream(resultDirectory.resolve(fileName)));
    }

    @Override
    public InputStream createResultInputStream(String fileName) throws IOException {
        logger.debug("Creating result input stream for '" + fileName + "'");

        return new BufferedInputStream(Files.newInputStream(resultDirectory.resolve(fileName)));
    }

    @Override
    public boolean isFileExists(String fileName) {
        logger.debug("Checking is result file exists: '" + fileName + "'");
        return Files.exists(filesDirectory.resolve(fileName));
    }
}
