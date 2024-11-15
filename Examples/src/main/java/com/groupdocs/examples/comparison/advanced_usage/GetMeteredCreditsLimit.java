package com.groupdocs.examples.comparison.advanced_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.license.Metered;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to get credit consumption quantity
 */
public class GetMeteredCreditsLimit {
    public static Path run(Path sourceFile, Path targetFile) {
        Path outputPath = FilesUtils.makeOutputPath("GetMeteredCreditsLimit" + obtainExtension(sourceFile));
        Path resultPath = null;
        try {
            double creditsBefore = Metered.getConsumptionQuantity();
            try (OutputStream outputStream = Files.newOutputStream(outputPath);
                 Comparer comparer = new Comparer(sourceFile)) {
                comparer.add(targetFile);

                resultPath = comparer.compare(outputStream, new SaveOptions(), new CompareOptions());

                if (resultPath == null) {
                    resultPath = outputPath;
                }
            }
            double creditsAfter = Metered.getConsumptionQuantity();

            System.out.println("Credits before using Comparer: " + creditsBefore);
            System.out.println("Credits after using Comparer: " + creditsAfter);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return resultPath;
    }
}
