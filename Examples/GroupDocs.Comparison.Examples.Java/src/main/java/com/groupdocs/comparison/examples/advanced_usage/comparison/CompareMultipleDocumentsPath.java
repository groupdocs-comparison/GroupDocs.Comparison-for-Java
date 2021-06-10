package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.exceptions.ComparisonException;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.comparison.options.style.DiagramMasterSetting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * This class demonstrates comparing of multi documents
 */
public class CompareMultipleDocumentsPath {
    /**
     * This example demonstrates comparing of multi words documents
     */
    public static void compareMultipleWordsDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "compareMultipleWordsDocuments");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET1_WORD, SampleFiles.TARGET2_WORD, SampleFiles.TARGET3_WORD);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_WORD);
//                comparer.add(SampleFiles.TARGET2_WORD);
//                comparer.add(SampleFiles.TARGET3_WORD);
            }

            final Path resultPath = comparer.compare(outputFileName);
        }

        System.out.println("\nChanges updated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi txt documents
     */
    public static void compareMultipleTxtDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_TXT, "compareMultipleTxtDocuments");
        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_TXT)) {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_TXT, SampleFiles.TARGET2_TXT, SampleFiles.TARGET3_TXT);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_TXT);
//                comparer.add(SampleFiles.TARGET2_TXT);
//                comparer.add(SampleFiles.TARGET3_TXT);
            }

            final Path resultPath = comparer.compare(resultStream, new SaveOptions(), new CompareOptions());
        }

        System.out.println("\nText documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi email documents
     */
    public static void compareMultipleEmailDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_EMAIL, "compareMultipleEmailDocuments");
        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_EMAIL)) {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_EMAIL, SampleFiles.TARGET2_EMAIL, SampleFiles.TARGET3_EMAIL);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_EMAIL);
//                comparer.add(SampleFiles.TARGET2_EMAIL);
//                comparer.add(SampleFiles.TARGET3_EMAIL);
            }

            final Path resultPath = comparer.compare(resultStream, new SaveOptions(), new CompareOptions());
        }

        System.out.println("\nEmail documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi pdf documents
     */
    public static void compareMultiplePdfDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_PDF, "compareMultiplePdfDocuments");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_PDF)) {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_PDF, SampleFiles.TARGET2_PDF, SampleFiles.TARGET3_PDF);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_PDF);
//                comparer.add(SampleFiles.TARGET2_PDF);
//                comparer.add(SampleFiles.TARGET3_PDF);
            }
            final Path resultPath = comparer.compare(resultStream, new SaveOptions(), new CompareOptions());
        } catch (ComparisonException e) {
            if (e.getMessage() != null && e.getMessage().contains("It is impossible to process this document without license")) {
                System.err.println("Valid license is required to run this sample");
            } else {
                throw e;
            }
        }
        System.out.println("\nPDF documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi diagram documents
     */
    public static void compareMultipleDiagramDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_DIAGRAM, "compareMultipleDiagramDocuments");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_DIAGRAM)) {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_DIAGRAM, SampleFiles.TARGET2_DIAGRAM, SampleFiles.TARGET3_DIAGRAM);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_DIAGRAM);
//                comparer.add(SampleFiles.TARGET2_DIAGRAM);
//                comparer.add(SampleFiles.TARGET3_DIAGRAM);
            }

            {
                // Note: It is the same with commented code below
                final Path resultPath = comparer.compare(resultStream, new SaveOptions(),
                        new CompareOptions.Builder()
                                .setDiagramMasterSetting(
                                        new DiagramMasterSetting.Builder()
                                                .setMasterPath(SampleFiles.DIAGRAM_SETTINGS)
                                                .build())
                                .build());
                // Note: It is the same with the code above
//                final DiagramMasterSetting diagramMasterSetting = new DiagramMasterSetting();
//                diagramMasterSetting.setMasterPath(SampleFiles.DIAGRAM_SETTINGS);
//                final CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setDiagramMasterSetting(diagramMasterSetting);
//                final Path resultPath = comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(), compareOptions);
            }
        }
        System.out.println("\nDiagram documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}