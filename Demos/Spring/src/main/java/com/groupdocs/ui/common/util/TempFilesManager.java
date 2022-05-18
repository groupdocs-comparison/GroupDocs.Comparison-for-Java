package com.groupdocs.ui.common.util;

import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class TempFilesManager {
    private static final Logger logger = LoggerFactory.getLogger(TempFilesManager.class);
    private static TempFilesManager INSTANCE;
    private final Path tempDirectoryAbsolutePath;

    private TempFilesManager(Path tempDirectory) {
        final boolean isRelative = !tempDirectory.isAbsolute();
        if (isRelative) {
            tempDirectory = FileSystems.getDefault().getPath(tempDirectory.toString()).toAbsolutePath();
        }
        logger.debug("Temp directory is going to be '" + tempDirectory + "', creating it...");
        Path createdTempDirectory = tempDirectory;
        try {
            if (Files.notExists(tempDirectory)) {
                createdTempDirectory = Files.createDirectories(tempDirectory);
            }
        } catch (IOException e) {
            logger.error("Exception throws while creating temp directory: '" + tempDirectory + "'");
            throw new TotalGroupDocsException("Can't access temp directory", e);
        }
        this.tempDirectoryAbsolutePath = createdTempDirectory.toAbsolutePath();
    }

    public static void createInstance(String tempDirectory) {
        if (tempDirectory == null) {
            throw new IllegalArgumentException("tempDirectory must not be null");
        }
        INSTANCE = new TempFilesManager(Paths.get(tempDirectory));
    }

    public static TempFilesManager getInstance() {
        return INSTANCE;
    }

    public Path createTempPath(String fileName) {

        return tempDirectoryAbsolutePath.resolve(fileName);
    }
}
