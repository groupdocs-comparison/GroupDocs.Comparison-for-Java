package com.groupdocs.comparison.examples.advanced_usage.generate_page_previews;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.delegates.Delegates;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.PreviewOptions;
import com.groupdocs.comparison.options.enums.PreviewFormats;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * This example demonstrates how to get document previews
 */
public class GetPagePreviewsForSourceDocument {
    public static void run() {
        Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD);
        try {

            {
                // Note: It is the same with commented code below
                comparer.getSource().generatePreview(new PreviewOptions.Builder(
                        new Delegates.CreatePageStream() {
                            @Override
                            public OutputStream invoke(int pageNumber) {
                                String pagePath = Utils.OUTPUT_PATH + "/result-GetPagePreviewsForSourceDocument_" + pageNumber + ".png";
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
                        .build());

                // Note: It is the same with the code above
//                PreviewOptions previewOptions = new PreviewOptions(new Delegates.CreatePageStream() {
//                    @Override
//                    public OutputStream invoke(int pageNumber) {
//                        String pagePath = Utils.SAMPLES_PATH + "/result-GetPagePreviewsForSourceDocument_" + pageNumber + ".png";
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
//                comparer.getSource().generatePreview(previewOptions);
            }
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocument previews generated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
