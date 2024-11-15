package com.groupdocs.examples.comparison.quick_start;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to compare two documents.
 */
public class HelloWorld {

    /**
     * This example demonstrates how to render document into HTML.
     */
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("HelloWorld" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            Path resultPath = comparer.compare(outputPath);

            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}