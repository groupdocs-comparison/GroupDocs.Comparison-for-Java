package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * This example demonstrates using some of compare settings
 */
public class CompareDocumentsSettingsStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareDocumentsSettingsStream");

        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_WORD));
        try {
            comparer.add(new FileInputStream(SampleFiles.TARGET_WORD));

            {
                // Note: It is the same with commented code below
                comparer.compare(new FileOutputStream(outputFileName),
                        new CompareOptions.Builder()
                                .setInsertedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.RED)
                                                .setFontColor(Color.GREEN)
                                                .setUnderline(true)
                                                .build()
                                ).build());

                // Note: It is the same with the code above
//                final StyleSettings styleSettings = new StyleSettings();
//                styleSettings.setHighlightColor(Color.RED);
//                styleSettings.setFontColor(Color.GREEN);
//                styleSettings.setUnderline(true);
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setInsertedItemStyle(styleSettings);
//                comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }

        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}