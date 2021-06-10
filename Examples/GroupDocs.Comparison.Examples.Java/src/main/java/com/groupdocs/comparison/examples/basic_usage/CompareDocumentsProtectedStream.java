package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

public class CompareDocumentsProtectedStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareDocumentsProtectedStream");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD_PROTECTED);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET_WORD_PROTECTED);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream, new LoadOptions("1234"))) {
            comparer.add(targetStream, new LoadOptions("5678"));
            final Path resultPath = comparer.compare(resultStream);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
