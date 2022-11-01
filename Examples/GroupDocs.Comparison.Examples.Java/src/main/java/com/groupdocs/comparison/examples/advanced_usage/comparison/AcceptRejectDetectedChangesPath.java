package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.ApplyChangeOptions;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.ComparisonAction;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * This example demonstrates how to update changes from path
 */
public class AcceptRejectDetectedChangesPath {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "AcceptRejectDetectedChangesPath");

        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            final Path resultPath = comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            // inserted word "Cool" was not be added to result document
            changes[0].setComparisonAction(ComparisonAction.REJECT);
            comparer.applyChanges(resultStream, new ApplyChangeOptions(changes));
        }
          System.out.println("\nChanges updated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
