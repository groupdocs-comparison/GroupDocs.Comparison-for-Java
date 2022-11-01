package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.interfaces.IDocumentInfo;

import java.io.IOException;

/**
 * This example demonstrates document info extraction
 */
public class GetDocumentInfoPath {
    public static void run() throws IOException {
        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            try (IDocumentInfo info = comparer.getSource().getDocumentInfo()) {
                System.out.printf("\nFile type: %s\nNumber of pages: %d\nDocument size: %d bytes%n", info.getFileType().getFileFormat(), info.getPageCount(), info.getSize());
            }
        }
        System.out.println("\nDocument info extracted successfully.");
    }
}
