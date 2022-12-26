package com.groupdocs.comparison.examples.advanced_usage.generate_page_previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.common.delegates.Delegates;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This example demonstrates how to get document previews with user memory clean code
 */
public class GetPagePreviewsResouresCleaning {
    /**
     * User example code for releasing image stream memory
     */
    private static void UserReleaseStreamMethod(int pageNumber, OutputStream stream) {
        System.out.println("Releasing memory for page: " + pageNumber);
        com.groupdocs.comparison.common.Utils.closeStreams(stream);
    }

    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_SLIDES, "GetPagePreviewsResouresCleaning");

        Path resultPath;
        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_SLIDES)) {
            comparer.add(SampleFiles.TARGET_SLIDES);
            resultPath = comparer.compare(resultStream);
        }
        if (resultPath == null) {
            resultPath = Paths.get(outputFileName);
        }
        try (InputStream documentStream = new FileInputStream(resultPath.toFile());
             Document document = new Document(documentStream)) {
            {
                // Note: It is the same with commented code below
                document.generatePreview(new PreviewOptions.Builder(
                        new Delegates.CreatePageStream() {
                            @Override
                            public OutputStream invoke(int pageNumber) {
                                try {
                                    String pagePath = Utils.getOutputDirectoryPath("result-GetPagePreviewsResouresCleaning_%s.png", String.valueOf(pageNumber));
                                    return new FileOutputStream(pagePath);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    throw new RuntimeException(e);
                                }
                            }
                        })
                        .setPreviewFormat(PreviewFormats.PNG)
                        .setPageNumbers(new int[]{1, 2})
                        .setReleasePageStream(new Delegates.ReleasePageStream() {
                            @Override
                            public void invoke(int pageNumber, OutputStream outputStream) {
                                UserReleaseStreamMethod(pageNumber, outputStream);
                            }
                        })
                        .build());

                // Note: It is the same with the code above
//                PreviewOptions previewOptions = new PreviewOptions(new Delegates.CreatePageStream() {
//                    @Override
//                    public OutputStream invoke(int pageNumber) {
//                        try {
//                              String pagePath = Utils.getOutputDirectoryPath("result-GetPagePreviewsResouresCleaning_%s.png", String.valueOf(pageNumber));
//                            return new FileOutputStream(pagePath);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
//                previewOptions.setPreviewFormat(PreviewFormats.PNG);
//                previewOptions.setPageNumbers(new int[]{1, 2});
//                previewOptions.setReleasePageStream(new Delegates.ReleasePageStream() {
//                    @Override
//                    public void invoke(int pageNumber, OutputStream outputStream) {
//                        UserReleaseStreamMethod(pageNumber, outputStream);
//                    }
//                });
//                document.generatePreview(previewOptions);
            }
        }
        System.out.println("\nDocument previews generated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
