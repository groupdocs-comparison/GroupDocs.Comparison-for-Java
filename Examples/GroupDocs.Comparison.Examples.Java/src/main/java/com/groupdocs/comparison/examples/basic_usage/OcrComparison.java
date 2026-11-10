package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.OcrDisplayMode;
import com.groupdocs.comparison.options.OcrOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This example demonstrates OCR comparing of two images
 */
public class OcrComparison {

    /**
     * This example demonstrates OCR comparing of two images with side-by-side display mode
     */
    public static void displayModeSideBySide() throws IOException {
        compareWithOcr(OcrDisplayMode.SIDE_BY_SIDE, "OcrComparisonSideBySide");
    }

    /**
     * This example demonstrates OCR comparing of two images with recognized text display mode
     */
    public static void displayModeText() throws IOException {
        compareWithOcr(OcrDisplayMode.TEXT, "OcrComparisonText");
    }

    private static void compareWithOcr(OcrDisplayMode displayMode, String resultSuffix) throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_IMAGE, resultSuffix);

        try (InputStream sourceStream = new FileInputStream(SampleFiles.OCR_SOURCE_IMAGE);
             InputStream targetStream = new FileInputStream(SampleFiles.OCR_TARGET_IMAGE);
             Comparer comparer = new Comparer(sourceStream)) {
            final OcrOptions ocrOptions = new OcrOptions();
            ocrOptions.setEnabled(true);
            ocrOptions.setDisplayMode(displayMode);

            final CompareOptions options = new CompareOptions();
            options.setOcr(ocrOptions);
            options.setGenerateSummaryPage(false);

            comparer.add(targetStream);
            comparer.compare(outputFileName, options);
        }
        System.out.println("\nOCR comparing of two images finished successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
