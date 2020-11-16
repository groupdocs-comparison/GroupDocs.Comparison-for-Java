package com.groupdocs.comparison.examples.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This example demonstrates comparing of two documents loaded by file stream
 */
public class LoadDocumentFromStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "LoadDocumentFromStream");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET1_WORD);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetStream);
            comparer.compare(resultStream);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}