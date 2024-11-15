package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.ApplyChangeOptions;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.ComparisonAction;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to update changes from path
 */
public class AcceptRejectDetectedChangesPath {
    public static Path run(Path sourceFile, Path targetFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AcceptRejectDetectedChangesPath" + obtainExtension(sourceFile));

        try (InputStream sourceStream = Files.newInputStream(sourceFile);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetFile);

            Path resultPath = comparer.compare();

            if (resultPath == null) {
                resultPath = outputPath;
            }
            ChangeInfo[] changes = comparer.getChanges();

            // inserted word "Cool" was not be added to result document
            changes[0].setComparisonAction(ComparisonAction.REJECT);
            comparer.applyChanges(outputPath, new ApplyChangeOptions(changes));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
