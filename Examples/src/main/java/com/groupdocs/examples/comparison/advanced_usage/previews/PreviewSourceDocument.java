package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;
import com.groupdocs.examples.comparison.utils.FailureRegister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to get document previews
 */
public class PreviewSourceDocument {
    public static Path run(Path sourceFile)  {

        Path[] pagePreviewPath = new Path[1];
        try (final Comparer comparer = new Comparer(sourceFile)) {

            PreviewOptions previewOptions = new PreviewOptions.Builder(pageNumber -> {
                pagePreviewPath[0] = makeOutputPath(String.format("PreviewSourceDocument_%d.png", pageNumber));
                try {
                    return Files.newOutputStream(pagePreviewPath[0]);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to create output stream for preview.", e);
                }
            })
                    .setPreviewFormat(PreviewFormats.PNG)
                    .setPageNumbers(new int[]{1, 2})
                    .build();
            comparer.getSource().generatePreview(previewOptions);

            System.out.println("\nDocument previews generated successfully.\nCheck output: " + pagePreviewPath[0].getParent());
            return pagePreviewPath[0];
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
