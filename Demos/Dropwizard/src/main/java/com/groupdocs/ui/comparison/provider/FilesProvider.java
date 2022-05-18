package com.groupdocs.ui.comparison.provider;

import com.groupdocs.ui.common.Defaults;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.exception.ApiException;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;

public abstract class FilesProvider {
    private static FilesProvider INSTANCE;

    @FunctionalInterface
    public interface DirectoryContentVisitor {
        void visit(String guid, String name, boolean isDirectory, long size);
    }

    public abstract void visitDirectoryContent(String path, DirectoryContentVisitor visitor) throws ApiException;

    public abstract void receiveFilesInputStream(String path, Consumer<InputStream> streamConsumer) throws ApiException;

    public abstract void receiveFilesOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws ApiException;

    public abstract void receiveResultInputStream(String fileName, Consumer<InputStream> streamConsumer) throws ApiException;

    public abstract void receiveResultOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws ApiException;

    public abstract boolean isFileExists(String fileName) throws ApiException;

    public static void create(GlobalConfiguration globalConfiguration) {
        final ComparisonConfiguration comparisonConfiguration = globalConfiguration.getComparison();

        final Defaults.Comparison.FilesProviderType filesProviderType = comparisonConfiguration.getFilesProviderType();

        switch (filesProviderType) {
            case GOOGLE:
                INSTANCE = new GoogleFilesProvider(globalConfiguration.getGoogle());
                break;
            case DROPBOX:
                INSTANCE = new DropboxFilesProvider(globalConfiguration.getDropbox());
                break;
            default:
                INSTANCE = new LocalFilesProvider(globalConfiguration.getLocal());
        }
    }

    public static FilesProvider getInstance() {
        return INSTANCE;
    }
}
