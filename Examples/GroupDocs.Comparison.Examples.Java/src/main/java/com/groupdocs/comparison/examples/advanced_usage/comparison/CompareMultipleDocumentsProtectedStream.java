package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This example demonstrates comparing of multi protected documents from stream
 */
public class CompareMultipleDocumentsProtectedStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsProtectedStream");
        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream target1Stream = new FileInputStream(SampleFiles.TARGET_WORD_PROTECTED);
             InputStream target2Stream = new FileInputStream(SampleFiles.TARGET2_WORD_PROTECTED);
             InputStream target3Stream = new FileInputStream(SampleFiles.TARGET3_WORD_PROTECTED);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream, new LoadOptions("1234"))) {
            comparer.add(target1Stream, new LoadOptions("5678"));
            comparer.add(target2Stream, new LoadOptions("5678"));
            comparer.add(target3Stream, new LoadOptions("5678"));
            comparer.compare(resultStream);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}