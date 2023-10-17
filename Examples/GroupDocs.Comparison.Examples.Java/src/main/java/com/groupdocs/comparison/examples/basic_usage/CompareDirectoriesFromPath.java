package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.enums.FolderComparisonExtension;

import java.io.IOException;

/**
 * This example demonstrates comparing of two directories
 */
public class CompareDirectoriesFromPath {
    public static void run() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_DIRECTORIES, "CompareDirectoriesFromPath");

        final CompareOptions compareOptions = new CompareOptions();
        compareOptions.setDirectoryCompare(true);
        compareOptions.setFolderComparisonExtension(FolderComparisonExtension.HTML);

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_DIRECTORIES, compareOptions)) {
            comparer.add(SampleFiles.TARGET_DIRECTORIES, compareOptions);
            comparer.compareDirectory(outputFileName, compareOptions);
        }
        System.out.println("\nDirectories compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
