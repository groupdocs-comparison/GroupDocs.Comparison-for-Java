package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.PdfCompareOptions;

import java.io.IOException;

/**
 * This example demonstrates comparing of two PDF documents with side-by-side display mode
 */
public class PdfComparisonSample {
    public static void run() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_PDF, "PdfComparisonSample");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_PDF_NEW)) {
            comparer.add(SampleFiles.TARGET_PDF_NEW);

            final PdfCompareOptions options = new PdfCompareOptions();
            options.setDisplayMode(PdfCompareOptions.ComparisonDisplayMode.SIDE_BY_SIDE);

            comparer.compare(outputFileName, options);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
