package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.interfaces.IDocumentInfo;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * This example demonstrates target document object info extraction
 */
public class GetDocumentInfoFromResultDocument {
    public static void run() throws Exception {
        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET1_WORD);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetStream);
            try (IDocumentInfo info = comparer.getTargets().get(0).getDocumentInfo()) {
                System.out.printf("\nFile type: %s\nNumber of pages: %d\nDocument size: %d bytes%n", info.getFileType().getFileFormat(), info.getPageCount(), info.getSize());
            }
        }
        System.out.println("\nDocument info extracted successfully.");
    }
}
