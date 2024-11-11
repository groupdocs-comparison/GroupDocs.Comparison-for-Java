package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of multi protected documents from path
 */
public class MultipleCompareProtectedDocumentsPath {
    public static Path run(Path sourceFile, Path target1File, Path target2File, Path target3File) {
        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsProtectedPath" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile, new LoadOptions("1234"))) {
            comparer.add(target1File, new LoadOptions("5678"));
            comparer.add(target2File, new LoadOptions("5678"));
            comparer.add(target3File, new LoadOptions("5678"));

            Path resultPath = comparer.compare(outputPath);
            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        }
    }
}