package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.style.StyleSettings;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.awt.*;
import java.io.IOException;
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
            {
                // Note: It is the same with commented code below
                comparer.add(target1File, target2File, target3File);

                // Note: It is the same with the code above
//                comparer.add(target1File);
//                comparer.add(target2File);
//                comparer.add(target3File);
            }
            Path resultPath;
            {
                // Note: It is the same with the code above
                CompareOptions compareOptions = new CompareOptions.Builder()
                        .setInsertedItemStyle(
                                new StyleSettings.Builder()
                                        .setFontColor(Color.YELLOW)
                                        .build())
                        .build();
                // Note: It is the same with commented code below
//                final StyleSettings styleSettings = new StyleSettings();
//                styleSettings.setFontColor(Color.YELLOW);
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setInsertedItemStyle(styleSettings);

                resultPath = comparer.compare(resultStream, compareOptions);
                if (resultPath == null) {
                    resultPath = outputPath;
                }
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