package com.groupdocs.examples.comparison.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of two documents loaded by file stream
 */
public class LoadDocumentFromStream {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("LoadDocumentFromStream" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream targetInputStream = Files.newInputStream(targetFile);
             Comparer comparer = new Comparer(sourceInputStream)) {

            comparer.add(targetInputStream);

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
