package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.result.ChangeInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GetChanges {
    /**
     * This example demonstrates how to get changes coordinates
     */
    public static void getChangesCoordinates() throws IOException {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "getChangesCoordinates");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {
            comparer.add(SampleFiles.TARGET_WORD);

            {
                // Note: It is the same with commented code below
                comparer.compare(new FileOutputStream(outputFileName),
                        new CompareOptions.Builder()
                                .setCalculateCoordinates(true)
                                .build());
                // Note: It is the same with the code above
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setCalculateCoordinates(true);
//                comparer.compare(new FileOutputStream(outputFileName), compareOptions);
            }
            ChangeInfo[] changes = comparer.getChanges();
            for (ChangeInfo change : changes) {
                System.out.println(String.format("Change Type: %d, X: %f, Y: %f, Text: %s", change.getType(), change.getBox().getX(), change.getBox().getY(), change.getText()));
            }
        } finally {
            comparer.dispose();

        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to get changes from path
     */
    public static void getListOfChangesPath() {
        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);

        try {
            comparer.add(SampleFiles.TARGET_WORD);
            comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            System.out.println("Count of changes: " + changes.length);
        } finally {
            comparer.dispose();

        }
        System.out.println("\nChanges received successfully.");
    }

    /**
     * This example demonstrates how to get changes from stream
     */
    public static void getListOfChangesStream() throws FileNotFoundException {
        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_WORD));
        try {
            comparer.add(new FileInputStream(SampleFiles.TARGET_WORD));
            comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            System.out.println("Count of changes: " + changes.length);
        } finally {
            comparer.dispose();
        }
        System.out.println("\nChanges received successfully.");
    }

    /**
     * This example demonstrates how to get target text
     */
    public static void getTargetText() {
        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {
            comparer.add(SampleFiles.TARGET_WORD);
            comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            for (ChangeInfo change : changes) {
                String text = change.getText();
                System.out.println(text);
            }
        } finally {
            comparer.dispose();
        }
        System.out.println("\nGet Target Text received successfully.");
    }
}