package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to get document specific size previews
 */
public class PreviewWithSpecificImagesSize {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("PreviewWithSpecificImagesSize" + obtainExtension(sourceFile));

        Path resultPath = null;
        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {

            comparer.add(targetFile);

            resultPath = comparer.compare(resultStream);

            if (resultPath == null) {
                resultPath = outputPath;
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        Path[] pagePreviewPath = new Path[1];
        try (InputStream documentStream = Files.newInputStream(resultPath);
             Document document = new Document(documentStream)) {

            document.generatePreview(
                    new PreviewOptions.Builder(
                            pageNumber -> {
                                pagePreviewPath[0] = FilesUtils.makeOutputPath(String.format("PreviewWithSpecificImagesSize_%d.jpeg", pageNumber));
                                try {
                                    return Files.newOutputStream(pagePreviewPath[0]);
                                } catch (Exception e) {
                                    throw new RuntimeException("Failed to generate preview for page " + pageNumber, e);
                                }
                            })
                            .setPreviewFormat(PreviewFormats.JPEG)
                            .setPageNumbers(new int[]{1, 2})
                            .setHeight(1000)
                            .setWidth(1000)
                            .build());

            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
