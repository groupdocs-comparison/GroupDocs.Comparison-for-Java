package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * This example demonstrates comparing of two cells files
 */
public class CompareCellsFromStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_CELLS, "CompareCellsFromStream");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_CELLS);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET_CELLS);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetStream);
            final Path resultPath = comparer.compare(resultStream);
        }
          System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
