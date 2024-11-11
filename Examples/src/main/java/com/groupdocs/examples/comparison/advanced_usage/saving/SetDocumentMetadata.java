package com.groupdocs.examples.comparison.advanced_usage.saving;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.FileAuthorMetadata;
import com.groupdocs.comparison.options.enums.MetadataType;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

public class SetDocumentMetadata {
    public static Path cloneSource(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("SetDocumentMetadataSource" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            {
                final SaveOptions saveOptions = new SaveOptions.Builder()
                        .setCloneMetadataType(MetadataType.SOURCE)
                        .build();

                Path resultPath = comparer.compare(outputPath, saveOptions);

                if (resultPath == null) {
                    resultPath = outputPath;
                }
                System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
                return resultPath;
            }
        }
    }

    public static Path cloneTarget(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("SetDocumentMetadataTarget" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            {
                final SaveOptions saveOptions = new SaveOptions.Builder()
                        .setCloneMetadataType(MetadataType.TARGET)
                        .build();

                Path resultPath = comparer.compare(outputPath, saveOptions);

                if (resultPath == null) {
                    resultPath = outputPath;
                }
                System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
                return resultPath;
            }
        }
    }

    public static Path cloneUserDefined(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("SetDocumentMetadataUserDefined" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);
            {
                final SaveOptions saveOptions =
                        new SaveOptions.Builder()
                                .setCloneMetadataType(MetadataType.FILE_AUTHOR)
                                .setFileAuthorMetadata(
                                        new FileAuthorMetadata.Builder()
                                                .setAuthor("Tom")
                                                .setCompany("GroupDocs")
                                                .setLastSaveBy("Jack").build())
                                .build();
                Path resultPath = comparer.compare(outputPath, saveOptions);

                if (resultPath == null) {
                    resultPath = outputPath;
                }
                System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
                return resultPath;
            }
        }
    }
}
