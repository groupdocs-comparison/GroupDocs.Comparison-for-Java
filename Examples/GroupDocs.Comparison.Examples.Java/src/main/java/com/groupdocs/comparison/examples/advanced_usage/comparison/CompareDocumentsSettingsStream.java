package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * This example demonstrates using some of compare settings
 */
public class CompareDocumentsSettingsStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareDocumentsSettingsStream");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET1_WORD);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetStream);

            {
                // Note: It is the same with commented code below
                final Path resultPath = comparer.compare(resultStream,
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
//                final Path resultPath = comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }

        }
          System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}