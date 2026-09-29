package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This example demonstrates comparing of two images without SummaryPage
 */
public class CompareImage {
    public static void run() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_IMAGE, "CompareImage");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_IMAGE);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET_IMAGE);
             Comparer comparer = new Comparer(sourceStream)) {
            // If you set the GenerateSummaryPage property to true then the result will be saved in PDF format
            final CompareOptions options = new CompareOptions();
            options.setGenerateSummaryPage(false);

            comparer.add(targetStream);
            comparer.compare(outputFileName, options);
        }
        System.out.println("\nImages compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
