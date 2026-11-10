package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.PdfCompareOptions;

import java.io.IOException;

/**
 * This example demonstrates comparing of two PDF documents with different display modes
 */
public class PdfComparisonSample {

    /**
     * This example demonstrates comparing of two PDF documents with side-by-side display mode
     */
    public static void displayModeSideBySide() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_PDF, "PdfComparisonSideBySide");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_PDF_NEW)) {
            comparer.add(SampleFiles.TARGET_PDF_NEW);

            final PdfCompareOptions options = new PdfCompareOptions();
            options.setDisplayMode(PdfCompareOptions.ComparisonDisplayMode.SIDE_BY_SIDE);

            comparer.compare(outputFileName, options);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of two PDF documents with inline display mode
     */
    public static void displayModeInline() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_PDF, "PdfComparisonInline");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_PDF_NEW)) {
            comparer.add(SampleFiles.TARGET_PDF_NEW);

            final PdfCompareOptions options = new PdfCompareOptions();
            options.setDisplayMode(PdfCompareOptions.ComparisonDisplayMode.INLINE);

            comparer.compare(outputFileName, options);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
