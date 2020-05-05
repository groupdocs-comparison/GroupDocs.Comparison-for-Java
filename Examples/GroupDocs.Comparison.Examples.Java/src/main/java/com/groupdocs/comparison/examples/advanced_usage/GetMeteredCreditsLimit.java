package com.groupdocs.comparison.examples.advanced_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.license.Metered;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.save.SaveOptions;

import java.io.FileOutputStream;

/**
 * This example demonstrates how to get credit consumption quantity
 */
public class GetMeteredCreditsLimit {
    public static void run() throws Exception {
        System.out.println("Credits before using Comparer: " + Metered.getConsumptionQuantity());
        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {
            comparer.add(SampleFiles.TARGET_WORD);
            comparer.compare(new FileOutputStream(SampleFiles.RESULT_WORD), new SaveOptions(), new CompareOptions());
        } finally {
            comparer.dispose();
        }
        System.out.println("Credits after using Comparer: " + Metered.getConsumptionQuantity());
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
