package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * This example demonstrates comparing of two cells files
 */
public class CompareCellsFromStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_CELLS, "CompareCellsFromStream");

        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_CELLS));
        try {
            comparer.add(new FileInputStream(SampleFiles.TARGET_CELLS));
            comparer.compare(new FileOutputStream(outputFileName));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
