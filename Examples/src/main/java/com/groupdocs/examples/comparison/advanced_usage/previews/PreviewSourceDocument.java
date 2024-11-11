package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;
import com.groupdocs.examples.comparison.utils.FailureRegister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicReference;

import static com.groupdocs.examples.comparison.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to get document previews
 */
public class PreviewSourceDocument {
    public static Path run(Path sourceFile)  {

        AtomicReference<Path> pagePreviewPath = new AtomicReference<>();
        try (final Comparer comparer = new Comparer(sourceFile)) {

            PreviewOptions previewOptions = new PreviewOptions.Builder(pageNumber -> {
                pagePreviewPath.set(makeOutputPath(String.format("PreviewSourceDocument_%d.png", pageNumber)));
                try {
                    return Files.newOutputStream(pagePreviewPath.get());
                } catch (IOException e) {
                    FailureRegister.getInstance().registerFailedSample(e);
                    e.printStackTrace();
                }
                return null;
            })
                    .setPreviewFormat(PreviewFormats.PNG)
                    .setPageNumbers(new int[]{1, 2})
                    .build();
            comparer.getSource().generatePreview(previewOptions);

            System.out.println("\nDocument previews generated successfully.\nCheck output: " + pagePreviewPath.get().getParent());
            return pagePreviewPath.get();
        }
    }
}
