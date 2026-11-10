package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.io.IOException;
import java.util.Collections;

/**
 * This example demonstrates how to skip loading of external resources
 * while allowing specific ones via whitelisted resources
 */
public class SkipExternalResources {
    public static void run() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SkipExternalResources");

        final LoadOptions loadOptions = new LoadOptions.Builder()
                .setSkipExternalResources(true)
                .setWhitelistedResources(Collections.singletonList("includepicture-field.png"))
                .build();

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD, loadOptions)) {
            comparer.add(SampleFiles.TARGET1_WORD, loadOptions);
            comparer.compare(outputFileName);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
