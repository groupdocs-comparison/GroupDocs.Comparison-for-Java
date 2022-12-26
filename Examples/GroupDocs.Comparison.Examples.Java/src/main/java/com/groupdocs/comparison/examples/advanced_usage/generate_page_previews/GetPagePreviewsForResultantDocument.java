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
 * This example demonstrates how to get document previews
 */
public class GetPagePreviewsForResultantDocument {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "GetPagePreviewsForResultantDocument");

        Path resultPath;
        try (OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(SampleFiles.SOURCE_WORD)) {
            comparer.add(SampleFiles.TARGET1_WORD);
            resultPath = comparer.compare(resultStream);
        }
        if (resultPath == null) {
            resultPath = Paths.get(outputFileName);
        }
        try (InputStream documentStream = new FileInputStream(resultPath.toFile());
             Document document = new Document(documentStream)) {

            {
                // Note: It is the same with commented code below
                document.generatePreview(
                        new PreviewOptions.Builder(
                                new Delegates.CreatePageStream() {
                                    @Override
                                    public OutputStream invoke(int pageNumber) {
                                        String pagePath = Utils.OUTPUT_PATH + "/result-GetPagePreviewsForResultantDocument_" + pageNumber + ".png";
                                        try {
                                            return new FileOutputStream(pagePath);
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                            throw new RuntimeException(e);
                                        }
                                    }
                                })
                                .setPreviewFormat(PreviewFormats.PNG)
                                .setPageNumbers(new int[]{1, 2}).build());

                // Note: It is the same with the code above
//                PreviewOptions previewOptions = new PreviewOptions(new Delegates.CreatePageStream() {
//                    @Override
//                    public OutputStream invoke(int pageNumber) {
//                        try {
//                              String pagePath = Utils.getOutputDirectoryPath("result-GetPagePreviewsForResultantDocument_%s.png", String.valueOf(pageNumber));
//                            return new FileOutputStream(pagePath);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
//                previewOptions.setPreviewFormat(PreviewFormats.PNG);
//                previewOptions.setPageNumbers(new int[]{1, 2});
//                document.generatePreview(previewOptions);
            }
        }
        System.out.println("\nDocument previews generated successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
