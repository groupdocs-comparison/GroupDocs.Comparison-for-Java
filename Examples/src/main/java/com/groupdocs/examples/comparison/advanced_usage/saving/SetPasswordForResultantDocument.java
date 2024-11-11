package com.groupdocs.examples.comparison.advanced_usage.saving;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.enums.PasswordSaveOption;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how protect result document by password
 */
public class SetPasswordForResultantDocument {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("SetPasswordForResultantDocument" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);
            final SaveOptions saveOptions =
                    new SaveOptions.Builder()
                            .setPassword("3333")
                            .build();
            final CompareOptions compareOptions = new CompareOptions.Builder()
                    .setPasswordSaveOption(PasswordSaveOption.USER)
                    .build();

            Path resultPath = comparer.compare(outputPath, saveOptions, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }
            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        }
    }
}
