package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.result.ChangeInfo;

import java.io.*;
import java.nio.file.Path;

public class GetChanges {
    /**
     * This example demonstrates how to get changes coordinates
     */
    public static void getChangesCoordinates() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "getChangesCoordinates");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            {
                // Note: It is the same with commented code below
                final Path resultPath = comparer.compare(resultStream,
                        new CompareOptions.Builder()
                                .setCalculateCoordinates(true)
                                .build());
                // Note: It is the same with the code above
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setCalculateCoordinates(true);
//                final Path resultPath = comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }
            ChangeInfo[] changes = comparer.getChanges();
            for (ChangeInfo change : changes) {
                System.out.printf("Change Type: %d, X: %f, Y: %f, Text: %s%n", change.getType(), change.getBox().getX(), change.getBox().getY(), change.getText());
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to get changes from path
     */
    public static void getListOfChangesPath() {
        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            final Path resultPath = comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            System.out.println("Count of changes: " + changes.length);
        }
        System.out.println("\nChanges received successfully.");
    }

    /**
     * This example demonstrates how to get changes from stream
     */
    public static void getListOfChangesStream() throws Exception {
        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET1_WORD);
             Comparer comparer = new Comparer(sourceStream)) {
            comparer.add(targetStream);
            final Path resultPath = comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            System.out.println("Count of changes: " + changes.length);
        }
        System.out.println("\nChanges received successfully.");
    }

    /**
     * This example demonstrates how to get target text
     */
    public static void getTargetText() {
        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            final Path resultPath = comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            for (ChangeInfo change : changes) {
                String text = change.getText();
                System.out.println(text);
            }
        }
        System.out.println("\nGet Target Text received successfully.");
    }
}