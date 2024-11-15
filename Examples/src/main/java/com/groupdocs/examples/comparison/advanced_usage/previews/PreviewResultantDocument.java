package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.makeOutputPath;
import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to get document previews
 */
public class PreviewResultantDocument {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("PreviewResultantDocument" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath); final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder().build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            Path[] pagePreviewPath = new Path[1];
            try (InputStream documentStream = Files.newInputStream(resultPath);
                 Document document = new Document(documentStream)) {

                PreviewOptions previewOptions = new PreviewOptions.Builder(pageNumber -> {
                    pagePreviewPath[0] = makeOutputPath(String.format("PreviewResultantDocument_%d.png", pageNumber));
                    try {
                        return Files.newOutputStream(pagePreviewPath[0]);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to create preview for page " + pageNumber, e);
                    }
                })
                        .setPreviewFormat(PreviewFormats.PNG)
                        .setPageNumbers(new int[]{1, 2})
                        .build();

                document.generatePreview(previewOptions);
            }

            System.out.println("\nDocument previews generated successfully.\nCheck output: " + resultPath.getParent());
            return pagePreviewPath[0];
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
