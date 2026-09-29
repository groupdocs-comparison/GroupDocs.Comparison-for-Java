package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.WordCompareOptions;

import java.io.IOException;

/**
 * This example demonstrates comparing of two Word documents with Word-specific options
 */
public class WordComparisonSample {
    public static void run() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "WordComparisonSample");

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
}
