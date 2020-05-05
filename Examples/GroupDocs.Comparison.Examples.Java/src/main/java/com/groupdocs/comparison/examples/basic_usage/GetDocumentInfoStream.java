package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.interfaces.IDocumentInfo;

import java.io.FileInputStream;

/**
 * This example demonstrates document info extraction
 */
public class GetDocumentInfoStream {
    public static void run() throws Exception {
        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_WORD));
        try {
            IDocumentInfo info = comparer.getSource().getDocumentInfo();
            System.out.println(String.format("\nFile type: %s\nNumber of pages: %d\nDocument size: %d bytes", info.getFileType().getFileFormat(), info.getPageCount(), info.getSize()));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocument info extracted successfully.");
    }
}