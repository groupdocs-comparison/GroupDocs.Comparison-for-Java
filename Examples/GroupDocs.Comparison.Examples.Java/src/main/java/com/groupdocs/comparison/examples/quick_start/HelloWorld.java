package com.groupdocs.comparison.examples.quick_start;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

/**
 * This example demonstrates how to compare two documents.
 */
public class HelloWorld {

    /**
     * This example demonstrates how to render document into HTML.
     */

    public static void run() throws Exception {
        String sourceDocumentPath = SampleFiles.SOURCE_WORD;
        String targetDocumentPath = SampleFiles.TARGET_WORD;

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "HelloWorld");

        Comparer comparer = new Comparer(sourceDocumentPath);
        try {
            comparer.add(targetDocumentPath);
            comparer.compare(outputFileName);
        } finally {
            comparer.dispose();
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputFileName + ".");
    }
}