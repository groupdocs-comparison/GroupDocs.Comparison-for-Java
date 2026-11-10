package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.WordCompareOptions;

import java.io.IOException;

/**
 * This example demonstrates comparing of two Word documents with different display modes
 */
public class WordComparisonSample {

    /**
     * This example demonstrates comparing of two Word documents with changes shown as revisions
     */
    public static void displayModeRevisions() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "WordComparisonRevisions");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            final WordCompareOptions options = new WordCompareOptions();
            options.setDisplayMode(WordCompareOptions.ComparisonDisplayMode.REVISIONS);
            options.setRevisionAuthorName("GroupDocs");
            options.setCompareBookmarks(true);

            comparer.compare(outputFileName, options);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of two Word documents with changes highlighted
     */
    public static void displayModeHighlight() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "WordComparisonHighlight");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            final WordCompareOptions options = new WordCompareOptions();
            options.setDisplayMode(WordCompareOptions.ComparisonDisplayMode.HIGHLIGHT);
            options.setRevisionAuthorName("GroupDocs");
            options.setCompareBookmarks(true);

            comparer.compare(outputFileName, options);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
