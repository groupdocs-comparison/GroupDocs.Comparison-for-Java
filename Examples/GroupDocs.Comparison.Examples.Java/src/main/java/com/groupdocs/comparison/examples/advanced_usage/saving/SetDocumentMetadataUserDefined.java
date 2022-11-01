package com.groupdocs.comparison.examples.advanced_usage.saving;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.FileAuthorMetadata;
import com.groupdocs.comparison.options.enums.MetadataType;
import com.groupdocs.comparison.options.save.SaveOptions;

import java.nio.file.Path;

/**
 * This example demonstrates using option for select user metadata
 */
public class SetDocumentMetadataUserDefined {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "SetDocumentMetadataUserDefined");

        try (Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);

            {
                // Note: It is the same with commented code below
                final Path resultPath = comparer.compare(outputFileName,
                        new SaveOptions.Builder()
                                .setCloneMetadataType(MetadataType.FileAuthor)
                                .setFileAuthorMetadata(
                                        new FileAuthorMetadata.Builder()
                                                .setAuthor("Tom")
                                                .setCompany("GroupDocs")
                                                .setLastSaveBy("Jack").build())
                                .build());

                // Note: It is the same with the code above
//                SaveOptions saveOptions = new SaveOptions();
//                saveOptions.setCloneMetadataType(MetadataType.FileAuthor);
//                final FileAuthorMetadata fileAuthorMetadata = new FileAuthorMetadata();
//                fileAuthorMetadata.setAuthor("Tom");
//                fileAuthorMetadata.setCompany("GroupDocs");
//                fileAuthorMetadata.setLastSaveBy("Jack");
//                saveOptions.setFileAuthorMetadata(fileAuthorMetadata);
//                final Path resultPath = comparer.compare(outputFileName, saveOptions);
            }
        }
          System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
