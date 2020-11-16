package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * This example demonstrates comparing of multi documents from path
 */
public class CompareMultipleDocumentsSettingsPath {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsSettingsPath");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET1_WORD, SampleFiles.TARGET2_WORD, SampleFiles.TARGET3_WORD);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_WORD);
//                comparer.add(SampleFiles.TARGET2_WORD);
//                comparer.add(SampleFiles.TARGET3_WORD);
            }
            {
                // Note: It is the same with the code above
                comparer.compare(resultStream,
                        new CompareOptions.Builder()
                                .setInsertedItemStyle(
                                        new StyleSettings.Builder()
                                                .setFontColor(Color.YELLOW)
                                                .build())
                                .build());
                // Note: It is the same with commented code below
//                final StyleSettings styleSettings = new StyleSettings();
//                styleSettings.setFontColor(Color.YELLOW);
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setInsertedItemStyle(styleSettings);
//                comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}