package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of two cells files
 */
public class CompareCellsFromStream {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareCellsFromStream" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream targetInputStream = Files.newInputStream(targetFile);
             OutputStream outputStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceInputStream)) {
            comparer.add(targetInputStream);
            comparer.compare(outputStream);

            System.out.println("\nDocuments compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return outputPath;
    }
}
