package com.groupdocs.comparison.examples.advanced_usage.saving;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.enums.MetadataType;
import com.groupdocs.comparison.options.save.SaveOptions;

import java.nio.file.Path;

/**
 * This example demonstrates using option for select metadata
 */
public class SetDocumentMetadataSource {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SetDocumentMetadataSource");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            {
                // Note: It is the same with commented code below
                final Path resultPath = comparer.compare(outputFileName,
                        new SaveOptions.Builder()
                                .setCloneMetadataType(MetadataType.SOURCE)
                                .build());

                // Note: It is the same with the code above
//                final SaveOptions saveOptions = new SaveOptions();
//                saveOptions.setCloneMetadataType(MetadataType.Source);
//                final Path resultPath = comparer.compare(outputFileName, saveOptions);
            }
        }
          System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
