package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.ApplyChangeOptions;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.ComparisonAction;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;


/**
 * This example demonstrates how to update changes from stream
 */
public class AcceptRejectDetectedChangesStream {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("AcceptRejectDetectedChangesStream" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream targetInputStream = Files.newInputStream(targetFile);
             OutputStream outputStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceInputStream)) {

            comparer.add(targetInputStream);
            final Path resultPath = comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            // inserted word "Cool" was not be added to result document
            changes[0].setComparisonAction(ComparisonAction.REJECT);
            comparer.applyChanges(outputStream, new ApplyChangeOptions(changes));

            System.out.println("\nChanges updated successfully.\nCheck output: " + resultPath.getParent());
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return outputPath;
    }
}
