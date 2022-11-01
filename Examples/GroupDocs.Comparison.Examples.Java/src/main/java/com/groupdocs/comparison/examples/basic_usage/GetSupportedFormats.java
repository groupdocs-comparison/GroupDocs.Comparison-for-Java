package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.result.FileType;

/**
 * This example demonstrates file types support
 */
public class GetSupportedFormats {
    public static void run() {
        Iterable<FileType> fileTypes = FileType.getSupportedFileTypes();
        for (FileType fileType : fileTypes) {
            System.out.println(fileType);
        }
          System.out.println("\nSupported file types retrieved successfully.");
    }
}
