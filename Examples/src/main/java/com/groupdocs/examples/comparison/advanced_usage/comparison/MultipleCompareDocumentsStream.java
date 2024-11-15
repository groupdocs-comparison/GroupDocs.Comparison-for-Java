package com.groupdocs.examples.comparison.advanced_usage.comparison;

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
 * This example demonstrates comparing of multi documents
 */
public class MultipleCompareDocumentsStream {
    public static Path run(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsStream" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream target1InputStream = Files.newInputStream(target1File);
             InputStream target2InputStream = Files.newInputStream(target2File);
             InputStream target3InputStream = Files.newInputStream(target3File);
             OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceInputStream)) {

            comparer.add(target1InputStream, target2InputStream, target3InputStream);

            Path resultPath = comparer.compare(resultStream);

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