package com.groupdocs.comparison.examples.advanced_usage.saving;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.enums.MetadataType;
import com.groupdocs.comparison.options.save.SaveOptions;

/**
 * This example demonstrates using option for select metadata
 */
public class SetDocumentMetadataTarget {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SetDocumentMetadataTarget");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            {
                // Note: It is the same with commented code below
                comparer.compare(outputFileName, new SaveOptions.Builder()
                        .setCloneMetadataType(MetadataType.Target)
                        .build());

                // Note: It is the same with the code above
//                final SaveOptions saveOptions = new SaveOptions();
//                saveOptions.setCloneMetadataType(MetadataType.Target);
//                comparer.compare(outputFileName, saveOptions);
            }
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}