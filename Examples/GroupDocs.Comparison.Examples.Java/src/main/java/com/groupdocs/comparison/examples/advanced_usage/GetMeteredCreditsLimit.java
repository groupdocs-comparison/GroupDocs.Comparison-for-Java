package com.groupdocs.comparison.examples.advanced_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.license.Metered;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.save.SaveOptions;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * This example demonstrates how to get credit consumption quantity
 */
public class GetMeteredCreditsLimit {
    public static void run() throws Exception {
        System.out.println("Credits before using Comparer: " + Metered.getConsumptionQuantity());
        try (OutputStream resultStream = new FileOutputStream(SampleFiles.RESULT_WORD);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            comparer.compare(resultStream, new SaveOptions(), new CompareOptions());
        }
        System.out.println("Credits after using Comparer: " + Metered.getConsumptionQuantity());
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
