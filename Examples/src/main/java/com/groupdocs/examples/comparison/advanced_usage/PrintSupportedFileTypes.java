package com.groupdocs.examples.comparison.advanced_usage;

import com.groupdocs.comparison.result.FileType;

import java.util.List;

public class PrintSupportedFileTypes {

    public static FileType[] run() {
        final List<FileType> supportedFileTypes = FileType.getSupportedFileTypes();
        for (FileType fileType : supportedFileTypes) {
            System.out.printf("%s ('%s') - %s%n", fileType.name(), fileType.getExtension(), fileType.getFileFormat());
        }
        return supportedFileTypes.toArray(new FileType[0]);
    }
}
