package com.groupdocs.ui.comparison.dropwizard.provider;

import com.groupdocs.ui.comparison.dropwizard.common.Defaults;
import com.groupdocs.ui.comparison.dropwizard.common.config.GlobalConfiguration;
import com.groupdocs.ui.comparison.dropwizard.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.comparison.dropwizard.config.ComparisonConfiguration;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;

public abstract class FilesProvider {
    private static FilesProvider INSTANCE;

    @FunctionalInterface
    public interface DirectoryContentVisitor {
        void visit(String guid, String name, boolean isDirectory, long size);
    }

    public abstract void visitDirectoryContent(String path, DirectoryContentVisitor visitor) throws TotalGroupDocsException;

    public abstract void receiveFilesInputStream(String path, Consumer<InputStream> streamConsumer) throws TotalGroupDocsException;

    public abstract void receiveFilesOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws TotalGroupDocsException;

    public abstract void receiveResultInputStream(String fileName, Consumer<InputStream> streamConsumer) throws TotalGroupDocsException;

    public abstract void receiveResultOutputStream(String fileName, Consumer<OutputStream> streamConsumer) throws TotalGroupDocsException;

    public abstract boolean isFileExists(String fileName) throws TotalGroupDocsException;

    public abstract void deleteFile(String path) throws TotalGroupDocsException;

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
