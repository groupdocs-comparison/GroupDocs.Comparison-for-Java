package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.enums.FolderComparisonExtension;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates comparing of two directories
 */
public class CompareDirectoriesFromPath {
    public static Path run(Path sourceDirectory, Path targetDirectory) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareDirectoriesFromPath.html");

        final CompareOptions compareOptions = new CompareOptions();
        compareOptions.setDirectoryCompare(true);
        compareOptions.setFolderComparisonExtension(FolderComparisonExtension.HTML);

        try (Comparer comparer = new Comparer(sourceDirectory, compareOptions)) {
            comparer.add(targetDirectory, compareOptions);

            comparer.compareDirectory(outputPath, compareOptions);

            System.out.println("\nDocuments compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
