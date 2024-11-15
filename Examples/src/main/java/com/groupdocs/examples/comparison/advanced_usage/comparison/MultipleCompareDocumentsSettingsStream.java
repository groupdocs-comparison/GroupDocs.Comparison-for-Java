package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of multi documents from stream
 */
public class MultipleCompareDocumentsSettingsStream {
    public static Path run(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsSettingsStream" + obtainExtension(sourceFile));


        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream target1InputStream = Files.newInputStream(target1File);
             InputStream target2InputStream = Files.newInputStream(target2File);
             InputStream target3InputStream = Files.newInputStream(target3File);
             OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceInputStream)) {

            comparer.add(target1InputStream, target2InputStream, target3InputStream);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setInsertedItemStyle(
                            new StyleSettings.Builder()
                                    .setFontColor(Color.YELLOW)
                                    .build())
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

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