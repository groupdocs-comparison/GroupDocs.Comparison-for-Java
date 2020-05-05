package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * This example demonstrates comparing of multi protected documents from stream
 */
public class CompareMultipleDocumentsProtectedStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsProtectedStream");
        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_WORD), new LoadOptions("1234"));
        try {
            comparer.add(new FileInputStream(SampleFiles.TARGET_WORD_PROTECTED), new LoadOptions("5678"));
            comparer.add(new FileInputStream(SampleFiles.TARGET2_WORD_PROTECTED), new LoadOptions("5678"));
            comparer.add(new FileInputStream(SampleFiles.TARGET3_WORD_PROTECTED), new LoadOptions("5678"));
            comparer.compare(new FileOutputStream(outputFileName));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}