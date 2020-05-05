package com.groupdocs.comparison.examples.advanced_usage.generate_page_previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Document;
import com.groupdocs.comparison.common.delegates.Delegates;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

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

        Comparer comparer = new Comparer(SampleFiles.SOURCE_SLIDES);
        try {
            comparer.add(SampleFiles.TARGET_SLIDES);
            comparer.compare(new FileOutputStream(outputFileName));
            Document document = new Document(new FileInputStream(outputFileName));
            {
                // Note: It is the same with commented code below
                document.generatePreview(new PreviewOptions.Builder(
                        new Delegates.CreatePageStream() {
                            @Override
                            public OutputStream invoke(int pageNumber) {
                                String pagePath = Utils.SAMPLES_PATH + "result-GetPagePreviewsResouresCleaning_" + pageNumber + ".png";
                                try {
                                    return new FileOutputStream(pagePath);
                                } catch (FileNotFoundException e) {
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
//                        String pagePath = Utils.SAMPLES_PATH + "result-GetPagePreviewsResouresCleaning_" + pageNumber + ".png";
//                        try {
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
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocument previews generated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
