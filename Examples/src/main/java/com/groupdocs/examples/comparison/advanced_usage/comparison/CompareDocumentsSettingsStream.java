package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates using compare settings
 */
public class CompareDocumentsSettingsStream {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareDocumentsSettingsStream" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream targetInputStream = Files.newInputStream(targetFile);
             OutputStream outputStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceInputStream)) {
            comparer.add(targetInputStream);

            final CompareOptions compareOptions = new CompareOptions.Builder()
                    .setInsertedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.RED)
                                    .setFontColor(Color.GREEN)
                                    .setUnderline(true)
                                    .build()
                    ).build();

            Path resultPath = comparer.compare(outputStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}