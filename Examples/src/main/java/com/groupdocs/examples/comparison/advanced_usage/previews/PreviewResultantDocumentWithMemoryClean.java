package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;
import com.groupdocs.examples.comparison.utils.FailureRegister;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.makeOutputPath;
import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to get document previews with user memory clean code
 */
public class PreviewResultantDocumentWithMemoryClean {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = makeOutputPath("PreviewResultantDocumentWithMemoryClean" + obtainExtension(sourceFile));

        Path resultPath = null;
        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            resultPath = comparer.compare(resultStream);
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        if (resultPath == null) {
            resultPath = outputPath;
        }

        Path[] pagePreviewPath = new Path[1];
        try (InputStream documentStream = Files.newInputStream(resultPath);
             Document document = new Document(documentStream)) {

            PreviewOptions previewOptions = new PreviewOptions.Builder(pageNumber -> {
                pagePreviewPath[0] = makeOutputPath(String.format("PreviewResultantDocumentWithMemoryClean_%d.png", pageNumber));
                try {
                    return Files.newOutputStream(pagePreviewPath[0]);
                } catch (IOException e) {
                    throw new RuntimeException("Error creating preview output stream for page " + pageNumber, e);
                }
            })
                    .setPreviewFormat(PreviewFormats.PNG)
                    .setPageNumbers(new int[]{1, 2})
                    .setReleasePageStream((page, outputStream) -> {
                        System.out.println("Releasing memory for page: " + page);
                        com.groupdocs.comparison.common.Utils.closeStreams(outputStream);
                    })
                    .build();
            document.generatePreview(previewOptions);

            System.out.println("\nDocument previews generated successfully.\nCheck output: " + pagePreviewPath[0].getParent());
            return pagePreviewPath[0];
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
