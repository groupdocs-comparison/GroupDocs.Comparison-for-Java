package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CompareDocumentsProtectedStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareDocumentsProtectedStream");

        Comparer comparer = new Comparer(new FileInputStream(SampleFiles.SOURCE_WORD_PROTECTED), new LoadOptions("1234"));
        try {
            comparer.add(new FileInputStream(SampleFiles.TARGET_WORD_PROTECTED), new LoadOptions("5678"));
            comparer.compare(new FileOutputStream(outputFileName));
        } finally {
            comparer.dispose();
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
