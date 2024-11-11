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

            {
                // Note: It is the same with commented code below
                final CompareOptions compareOptions = new CompareOptions.Builder()
                        .setInsertedItemStyle(
                                new StyleSettings.Builder()
                                        .setHighlightColor(Color.RED)
                                        .setFontColor(Color.GREEN)
                                        .setUnderline(true)
                                        .build()
                        ).build();

                // Note: It is the same with the code above
//                final StyleSettings styleSettings = new StyleSettings();
//                styleSettings.setHighlightColor(Color.RED);
//                styleSettings.setFontColor(Color.GREEN);
//                styleSettings.setUnderline(true);
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setInsertedItemStyle(styleSettings);

                final Path resultPath = comparer.compare(outputStream, compareOptions);
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return outputPath;
    }
}