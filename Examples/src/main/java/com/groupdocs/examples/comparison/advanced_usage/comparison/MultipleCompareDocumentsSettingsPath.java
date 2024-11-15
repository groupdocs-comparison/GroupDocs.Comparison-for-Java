package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.awt.*;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates comparing of multi documents from path
 */
public class MultipleCompareDocumentsSettingsPath {
    public static Path run(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsSettingsPath" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(target1File, target2File, target3File);

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