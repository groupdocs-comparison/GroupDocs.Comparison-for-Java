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
import java.util.concurrent.atomic.AtomicReference;

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

            AtomicReference<Path> pagePreviewPath = new AtomicReference<>();
            try (InputStream documentStream = Files.newInputStream(resultPath); Document document = new Document(documentStream)) {

                PreviewOptions previewOptions = new PreviewOptions.Builder(pageNumber -> {
                    pagePreviewPath.set(makeOutputPath(String.format("PreviewResultantDocument_%d.png", pageNumber)));
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

                document.generatePreview(previewOptions);
            }

            System.out.println("\nDocument previews generated successfully.\nCheck output: " + resultPath.getParent());
            return pagePreviewPath.get();
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return null;
    }
}
