package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of two cells files
 */
public class CompareCellsFromPath {
    public static Path run(Path sourceFile, Path targetFile) {
        final Path outputPath = FilesUtils.makeOutputPath("CompareCellsFromPath" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);
            Path resultPath = comparer.compare(outputPath);
            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        }
    }
}
