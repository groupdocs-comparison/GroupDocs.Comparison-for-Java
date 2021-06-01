package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.nio.file.Path;

/**
 * This example demonstrates comparing of two documents with passwords
 */
public class CompareDocumentsProtectedPath {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareDocumentsProtectedPath");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD_PROTECTED, new LoadOptions("1234"))) {
            comparer.add(SampleFiles.TARGET_WORD_PROTECTED, new LoadOptions("5678"));
            final Path resultPath = comparer.compare(outputFileName);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
