package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of multi protected documents from stream
 */
public class MultipleCompareProtectedDocumentsStream {
    public static Path run(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsProtectedStream.docx" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream target1InputStream = Files.newInputStream(target1File);
             InputStream target2InputStream = Files.newInputStream(target2File);
             InputStream target3InputStream = Files.newInputStream(target3File);
             Comparer comparer = new Comparer(sourceInputStream, new LoadOptions("1234"))) {

            comparer.add(target1InputStream, new LoadOptions("5678"));
            comparer.add(target2InputStream, new LoadOptions("5678"));
            comparer.add(target3InputStream, new LoadOptions("5678"));

            Path resultPath = comparer.compare(outputPath);

            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return null;
    }
}