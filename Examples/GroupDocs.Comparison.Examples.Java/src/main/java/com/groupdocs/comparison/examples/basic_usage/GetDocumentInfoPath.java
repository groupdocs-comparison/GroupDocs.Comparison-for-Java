package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.interfaces.IDocumentInfo;

/**
 * This example demonstrates document info extraction
 */
public class GetDocumentInfoPath {
    public static void run() {
        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {
            IDocumentInfo info = comparer.getSource().getDocumentInfo();
            System.out.println(String.format("\nFile type: %s\nNumber of pages: %d\nDocument size: %d bytes", info.getFileType().getFileFormat(), info.getPageCount(), info.getSize()));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocument info extracted successfully.");
    }
}
