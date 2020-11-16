package com.groupdocs.comparison.examples.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

/**
 * This example demonstrates comparing of two documents loaded by file path
 */
public class LoadDocumentFromLocalDisc {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "LoadDocumentFromLocalDisc");

        String sourcePath = SampleFiles.SOURCE_WORD;
        try (Comparer comparer = new Comparer(sourcePath)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            comparer.compare(outputFileName);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
