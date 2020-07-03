package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.ApplyChangeOptions;
import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.ComparisonAction;

import java.io.FileOutputStream;

/**
 * This example demonstrates how to update changes from path
 */
public class AcceptRejectDetectedChangesPath {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "AcceptRejectDetectedChangesPath");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {
            comparer.add(SampleFiles.TARGET_WORD);
            comparer.compare();
            ChangeInfo[] changes = comparer.getChanges();
            // inserted word "Cool" was not be added to result document
            changes[0].setComparisonAction(ComparisonAction.REJECT);
            comparer.applyChanges(new FileOutputStream(outputFileName), new ApplyChangeOptions(changes));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nChanges updated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
