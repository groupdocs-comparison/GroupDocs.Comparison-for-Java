package com.groupdocs.ui.comparison.provider;

import com.groupdocs.ui.common.Defaults;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class FilesProvider {
    private static FilesProvider INSTANCE;

    @FunctionalInterface
    public interface DirectoryContentVisitor {
        void visit(String guid, String name, boolean isDirectory, long size);
    }

    public abstract void visitDirectoryContent(String path, DirectoryContentVisitor visitor) throws IOException;

    public abstract InputStream createFilesInputStream(String path) throws IOException, Exception;

    public abstract OutputStream createFilesOutputStream(String fileName) throws IOException;

    public abstract OutputStream createResultOutputStream(String fileName) throws IOException;

    public abstract InputStream createResultInputStream(String fileName) throws IOException;

    public abstract boolean isFileExists(String fileName) throws IOException;

    public static void create(GlobalConfiguration globalConfiguration) {
        final ComparisonConfiguration comparisonConfiguration = globalConfiguration.getComparison();

        final Defaults.Comparison.FilesProviderType filesProviderType = comparisonConfiguration.getFilesProviderType();

        switch (filesProviderType) {
            case GOOGLE:
                INSTANCE = new GoogleFilesProvider(globalConfiguration.getGoogle());
                break;
            default:
                INSTANCE = new LocalFilesProvider(globalConfiguration.getLocal());
        }
    }

    public static FilesProvider getInstance() {
        return INSTANCE;
    }
}
