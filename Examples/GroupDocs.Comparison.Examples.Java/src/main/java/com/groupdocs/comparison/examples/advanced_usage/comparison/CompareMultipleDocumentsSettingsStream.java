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
 * This example demonstrates comparing of multi documents from stream
 */
public class CompareMultipleDocumentsSettingsStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsSettingsStream");

        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_WORD));
        try {

            {
                // Note: It is the same with commented code below
                comparer.add(
                        new FileInputStream(SampleFiles.TARGET_WORD),
                        new FileInputStream(SampleFiles.TARGET2_WORD),
                        new FileInputStream(SampleFiles.TARGET3_WORD));

                // Note: It is the same with the code above
//                comparer.add(new FileInputStream(SampleFiles.TARGET_WORD));
//                comparer.add(new FileInputStream(SampleFiles.TARGET2_WORD));
//                comparer.add(new FileInputStream(SampleFiles.TARGET3_WORD));
            }
            {
                // Note: It is the same with commented code below
                comparer.compare(new FileOutputStream(outputFileName),
                        new CompareOptions.Builder()
                                .setInsertedItemStyle(
                                        new StyleSettings.Builder()
                                                .setFontColor(Color.YELLOW)
                                                .build())
                                .build());

                // Note: It is the same with the code above
//                final StyleSettings styleSettings = new StyleSettings();
//                styleSettings.setFontColor(Color.YELLOW);
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