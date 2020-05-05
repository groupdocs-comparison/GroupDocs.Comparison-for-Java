package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.comparison.options.style.DiagramMasterSetting;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class demonstrates comparing of multi documents
 */
public class CompareMultipleDocumentsPath {
    /**
     * This example demonstrates comparing of multi words documents
     */
    public static void compareMultipleWordsDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "compareMultipleWordsDocuments");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_WORD, SampleFiles.TARGET2_WORD, SampleFiles.TARGET3_WORD);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_WORD);
//                comparer.add(SampleFiles.TARGET2_WORD);
//                comparer.add(SampleFiles.TARGET3_WORD);
            }

            comparer.compare(outputFileName);
        } finally {
            comparer.dispose();
        }

        System.out.println("\nChanges updated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi txt documents
     */
    public static void compareMultipleTxtDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_TXT, "compareMultipleTxtDocuments");
        Comparer comparer = new Comparer(SampleFiles.SOURCE_TXT);
        try {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_TXT, SampleFiles.TARGET2_TXT, SampleFiles.TARGET3_TXT);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_TXT);
//                comparer.add(SampleFiles.TARGET2_TXT);
//                comparer.add(SampleFiles.TARGET3_TXT);
            }

            comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(), new CompareOptions());
        } finally {
            comparer.dispose();
        }

        System.out.println("\nText documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi email documents
     */
    public static void compareMultipleEmailDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_EMAIL, "compareMultipleEmailDocuments");
        Comparer comparer = new Comparer(SampleFiles.SOURCE_EMAIL);
        try {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_EMAIL, SampleFiles.TARGET2_EMAIL, SampleFiles.TARGET3_EMAIL);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_EMAIL);
//                comparer.add(SampleFiles.TARGET2_EMAIL);
//                comparer.add(SampleFiles.TARGET3_EMAIL);
            }

            comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(), new CompareOptions());
        } finally {
            comparer.dispose();
        }

        System.out.println("\nEmail documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi pdf documents
     */
    public static void compareMultiplePdfDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_PDF, "compareMultiplePdfDocuments");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_PDF);
        try {

            {
                // Note: It is the same with commented code below
                comparer.add(SampleFiles.TARGET_PDF, SampleFiles.TARGET2_PDF, SampleFiles.TARGET3_PDF);

                // Note: It is the same with the code above
//                comparer.add(SampleFiles.TARGET_PDF);
//                comparer.add(SampleFiles.TARGET2_PDF);
//                comparer.add(SampleFiles.TARGET3_PDF);
            }

            comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(), new CompareOptions());
        } finally {
            comparer.dispose();
        }
        System.out.println("\nPDF documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates comparing of multi diagram documents
     */
    public static void compareMultipleDiagramDocuments() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_DIAGRAM, "compareMultipleDiagramDocuments");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_DIAGRAM);
        try {

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
                comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(),
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
//                comparer.compare(new FileOutputStream(outputFileName), new SaveOptions(), compareOptions);
            }
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDiagram documents compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}