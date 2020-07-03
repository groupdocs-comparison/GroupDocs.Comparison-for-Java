package com.groupdocs.comparison.examples.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * This example demonstrates comparing of two documents loaded by file stream
 */
public class LoadDocumentFromStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "LoadDocumentFromStream");

        InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
        InputStream targetStream = new FileInputStream(SampleFiles.TARGET_WORD);
        Comparer comparer = new Comparer(sourceStream);
        try {
            comparer.add(targetStream);
            comparer.compare(new FileOutputStream(outputFileName));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}