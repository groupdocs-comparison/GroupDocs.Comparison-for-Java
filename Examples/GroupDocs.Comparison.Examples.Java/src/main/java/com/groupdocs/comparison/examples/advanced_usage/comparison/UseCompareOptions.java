package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.enums.PaperSize;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.comparison.options.style.StyleSettings;

import java.awt.*;
import java.io.*;

/**
 * This class demonstrates how to use CompareOptions
 */
public class UseCompareOptions {
    /**
     * This example demonstrates how to ignore Header/Footer
     */
    public static void ignoreHeaderFooter() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "IgnoreHeaderFooter");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WITH_FOOTER)) {
            comparer.add(SampleFiles.TARGET_WITH_FOOTER);
            {
                // Note: It is the same with commented code below
                comparer.compare(resultStream, new SaveOptions(),
                        new CompareOptions.Builder()
                                .setHeaderFootersComparison(false)
                                .build());

                // Note: It is the same with the code above
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setHeaderFootersComparison(false);
//                comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(), compareOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to set output paper size
     */
    public static void setOutputPaperSize() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SetOutputPaperSize");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            {
                // Note: It is the same with commented code below
                comparer.compare(resultStream,
                        new CompareOptions.Builder()
                                .setPaperSize(PaperSize.A6)
                                .build());

                // Note: It is the same with the code above
//                final CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setPaperSize(PaperSize.A6);
//                comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of two documents using sensitivity option
     */
    public static void adjustComparisonSensitivity() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "AdjustComparisonSensitivity");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            {
                // Note: It is the same with commented code below
                comparer.compare(resultStream,
                        new CompareOptions.Builder()
                                .setSensitivityOfComparison(100)
                                .build());

                // Note: It is the same with the code above
//                final CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setSensitivityOfComparison(100);
//                comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to customized change styles from path
     */
    public static void customizeChangesStylesStream() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CustomizeChangesStylesStream");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET1_WORD);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetStream);
            {
                // Note: It is the same with commented code below
                comparer.compare(resultStream,
                        new CompareOptions.Builder()
                                .setInsertedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.RED)
                                                .setFontColor(Color.GREEN)
                                                .setUnderline(true)
                                                .setBold(true)
                                                .setStrikethrough(true)
                                                .setItalic(true)
                                                .build())
                                .setDeletedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.PINK)
                                                .setFontColor(Color.CYAN)
                                                .setUnderline(true)
                                                .setBold(true)
                                                .setStrikethrough(true)
                                                .setItalic(true)
                                                .build())
                                .setChangedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.LIGHT_GRAY)
                                                .setFontColor(Color.GRAY)
                                                .setUnderline(true)
                                                .setBold(true)
                                                .setStrikethrough(true)
                                                .setItalic(true)
                                                .build())
                                .build());

                // Note: It is the same with the code above
//                CompareOptions compareOptions = new CompareOptions();
//                final StyleSettings insertedStyleSettings = new StyleSettings();
//                insertedStyleSettings.setHighlightColor(Color.RED);
//                insertedStyleSettings.setFontColor(Color.GREEN);
//                insertedStyleSettings.setUnderline(true);
//                insertedStyleSettings.setBold(true);
//                insertedStyleSettings.setStrikethrough(true);
//                insertedStyleSettings.setItalic(true);
//                compareOptions.setInsertedItemStyle(insertedStyleSettings);
//                final StyleSettings deletedStyleSettings = new StyleSettings();
//                deletedStyleSettings.setHighlightColor(Color.PINK);
//                deletedStyleSettings.setFontColor(Color.CYAN);
//                deletedStyleSettings.setUnderline(true);
//                deletedStyleSettings.setBold(true);
//                deletedStyleSettings.setStrikethrough(true);
//                deletedStyleSettings.setItalic(true);
//                compareOptions.setDeletedItemStyle(deletedStyleSettings);
//                final StyleSettings changedStyleSettings = new StyleSettings();
//                changedStyleSettings.setHighlightColor(Color.LIGHT_GRAY);
//                changedStyleSettings.setFontColor(Color.GRAY);
//                changedStyleSettings.setUnderline(true);
//                changedStyleSettings.setBold(true);
//                changedStyleSettings.setStrikethrough(true);
//                changedStyleSettings.setItalic(true);
//                compareOptions.setChangedItemStyle(changedStyleSettings);
//                comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to customized change styles from path
     */
    public static void customizeChangesStylesPath() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CustomizeChangesStylesPath");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            {
                // Note: It is the same with commented code below
                comparer.compare(outputFileName,
                        new CompareOptions.Builder()
                                .setInsertedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.RED)
                                                .setFontColor(Color.GREEN)
                                                .setUnderline(true)
                                                .setBold(true)
                                                .setStrikethrough(true)
                                                .setItalic(true)
                                                .build())
                                .setDeletedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.PINK)
                                                .setFontColor(Color.CYAN)
                                                .setUnderline(true)
                                                .setBold(true)
                                                .setStrikethrough(true)
                                                .setItalic(true)
                                                .build())
                                .setChangedItemStyle(
                                        new StyleSettings.Builder()
                                                .setHighlightColor(Color.LIGHT_GRAY)
                                                .setFontColor(Color.GRAY)
                                                .setUnderline(true)
                                                .setBold(true)
                                                .setStrikethrough(true)
                                                .setItalic(true)
                                                .build())
                                .build());

                // Note: It is the same with the code above
//                CompareOptions compareOptions = new CompareOptions();
//                final StyleSettings insertedStyleSettings = new StyleSettings();
//                insertedStyleSettings.setHighlightColor(Color.RED);
//                insertedStyleSettings.setFontColor(Color.GREEN);
//                insertedStyleSettings.setUnderline(true);
//                insertedStyleSettings.setBold(true);
//                insertedStyleSettings.setStrikethrough(true);
//                insertedStyleSettings.setItalic(true);
//                compareOptions.setInsertedItemStyle(insertedStyleSettings);
//                final StyleSettings deletedStyleSettings = new StyleSettings();
//                deletedStyleSettings.setHighlightColor(Color.PINK);
//                deletedStyleSettings.setFontColor(Color.CYAN);
//                deletedStyleSettings.setUnderline(true);
//                deletedStyleSettings.setBold(true);
//                deletedStyleSettings.setStrikethrough(true);
//                deletedStyleSettings.setItalic(true);
//                compareOptions.setDeletedItemStyle(deletedStyleSettings);
//                final StyleSettings changedStyleSettings = new StyleSettings();
//                changedStyleSettings.setHighlightColor(Color.LIGHT_GRAY);
//                changedStyleSettings.setFontColor(Color.GRAY);
//                changedStyleSettings.setUnderline(true);
//                changedStyleSettings.setBold(true);
//                changedStyleSettings.setStrikethrough(true);
//                changedStyleSettings.setItalic(true);
//                compareOptions.setChangedItemStyle(changedStyleSettings);
//                comparer.compare(outputFileName, compareOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}