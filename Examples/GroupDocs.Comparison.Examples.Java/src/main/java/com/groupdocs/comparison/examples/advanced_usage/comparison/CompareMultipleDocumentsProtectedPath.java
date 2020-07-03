package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

/**
 * This example demonstrates comparing of multi protected documents from path
 */
public class CompareMultipleDocumentsProtectedPath {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsProtectedPath");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD, new LoadOptions("1234"));
        try {
            comparer.add(SampleFiles.TARGET_WORD_PROTECTED, new LoadOptions("5678"));
            comparer.add(SampleFiles.TARGET2_WORD_PROTECTED, new LoadOptions("5678"));
            comparer.add(SampleFiles.TARGET3_WORD_PROTECTED, new LoadOptions("5678"));
            comparer.compare(outputFileName);
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}