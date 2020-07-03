package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * This example demonstrates comparing of multi documents
 */
public class CompareMultipleDocumentsStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsStream");

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
            comparer.compare(new FileOutputStream(outputFileName));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}