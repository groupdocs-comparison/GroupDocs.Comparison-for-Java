package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of two documents with passwords
 */
public class CompareProtectedWordFromPath {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareProtectedWordFromPath" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile, new LoadOptions("1234"))) {
            comparer.add(targetFile, new LoadOptions("5678"));
            Path resultPath = comparer.compare(outputPath);
            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        }
    }
}
