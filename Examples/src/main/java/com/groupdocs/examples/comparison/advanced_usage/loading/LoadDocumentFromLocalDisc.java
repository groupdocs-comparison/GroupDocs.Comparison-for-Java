package com.groupdocs.examples.comparison.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of two documents loaded by file path
 */
public class LoadDocumentFromLocalDisc {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("LoadDocumentFromLocalDisc" + obtainExtension(sourceFile));

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
