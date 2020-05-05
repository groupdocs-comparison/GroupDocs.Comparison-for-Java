package com.groupdocs.comparison.examples.advanced_usage.saving;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.enums.PasswordSaveOption;
import com.groupdocs.comparison.options.save.SaveOptions;

/**
 * This example demonstrates how protect result document by password
 */
public class SetPasswordForResultantDocument {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SetPasswordForResultantDocument");

        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {
            comparer.add(SampleFiles.TARGET_WORD);

            {
                // Note: It is the same with commented code below
                comparer.compare(outputFileName,
                        new SaveOptions.Builder()
                                .setPassword("3333")
                                .build(),
                        new CompareOptions.Builder()
                                .setPasswordSaveOption(PasswordSaveOption.User)
                                .build());

                // Note: It is the same with the code above
//                CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setPasswordSaveOption(PasswordSaveOption.User);
//                SaveOptions saveOptions = new SaveOptions();
//                saveOptions.setPassword("3333");
//                comparer.compare(outputFileName, saveOptions, compareOptions);
            }
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
