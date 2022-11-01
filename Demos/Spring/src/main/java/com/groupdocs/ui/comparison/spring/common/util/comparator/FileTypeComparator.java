package com.groupdocs.ui.comparison.spring.common.util.comparator;

import com.groupdocs.ui.comparison.spring.common.entity.web.FileDescriptionEntity;

import java.util.Comparator;

/**
 * FileTypeComparator
 * Compare and sort file types - folders first
 *
 * @author Aspose Pty Ltd
 */
public class FileTypeComparator implements Comparator<FileDescriptionEntity> {

    public static FileTypeComparator instance = new FileTypeComparator();

    /**
     * Compare two file types
     */
    @Override
    public int compare(FileDescriptionEntity file1, FileDescriptionEntity file2) {

        if (file1.isDirectory() && !file2.isDirectory()) {
            return -1;
        }
        if (file1.isDirectory() && file2.isDirectory()) {
            return 0;
        }
        if (!file1.isDirectory() && !file2.isDirectory()) {
            return 0;
        }
        return 1;
    }
}
