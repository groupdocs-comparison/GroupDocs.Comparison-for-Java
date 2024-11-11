package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

public class GetChanges {
    /**
     * This example demonstrates how to get changes coordinates
     */
    public static ChangeInfo[] getChangesCoordinates(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("GetChanges-getChangesCoordinates" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setCalculateCoordinates(true)
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            ChangeInfo[] changes = comparer.getChanges();
            for (ChangeInfo change : changes) {
                System.out.printf("Change Type: %s, X: %f, Y: %f, Text: %s%n", change.getType(), change.getBox().getX(), change.getBox().getY(), change.getText());
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return changes;
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This example demonstrates how to get changes from path
     */
    public static int getListOfChangesPath(Path sourceFile, Path targetFile) {

        try (final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            comparer.compare();

            ChangeInfo[] changes = comparer.getChanges();
            System.out.println("\nCount of changes: " + changes.length);

            return changes.length;
        }
    }

    /**
     * This example demonstrates how to get changes from stream
     */
    public static int getListOfChangesStream(Path sourceFile, Path targetFile) {

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream targetInputStream = Files.newInputStream(targetFile);
             final Comparer comparer = new Comparer(sourceInputStream)) {
            comparer.add(targetInputStream);

            comparer.compare();

            ChangeInfo[] changes = comparer.getChanges();
            System.out.println("\nCount of changes: " + changes.length);

            return changes.length;
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * This example demonstrates how to get target text
     */
    public static ChangeInfo[] getTargetText(Path sourceFile, Path targetFile) {
        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            comparer.compare();

            ChangeInfo[] changes = comparer.getChanges();
            for (ChangeInfo change : changes) {
                String text = change.getText();
                System.out.println(text);
            }
            System.out.println("\nGet Target Text received successfully.");
            return changes;
        }
    }
}