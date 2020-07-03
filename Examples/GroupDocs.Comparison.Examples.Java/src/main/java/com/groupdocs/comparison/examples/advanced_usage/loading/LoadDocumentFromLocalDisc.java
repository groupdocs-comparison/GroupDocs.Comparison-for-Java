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
        Comparer comparer = new Comparer(sourcePath);
        try {
            comparer.add(SampleFiles.TARGET_WORD);
            comparer.compare(outputFileName);
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
