package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.WordCompareOptions;

import java.io.IOException;

/**
 * This example demonstrates how to set author of changes
 */
public class SetAuthorOfChanges {
    public static void run() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SetAuthorOfChanges");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            final WordCompareOptions options = new WordCompareOptions();
            options.setShowRevisions(true);
            options.setDisplayMode(WordCompareOptions.ComparisonDisplayMode.REVISIONS);
            options.setRevisionAuthorName("New author");

            comparer.add(SampleFiles.TARGET1_WORD);
            comparer.compare(outputFileName, options);
        }
        System.out.println("\nChanges updated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
