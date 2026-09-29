package com.groupdocs.comparison.examples.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.options.load.LoadOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to load custom font for comparison
 */
public class LoadCustomFonts {
    public static void run() throws IOException {
        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "LoadCustomFonts");

        // Need to set the directory of the file with the font
        List<String> fontDirectories = new ArrayList<>();
        fontDirectories.add(SampleFiles.CUSTOM_FONTS_DIRECTORY);

        // Instantiate the LoadOptions object and pass in a list of directories with custom fonts
        final LoadOptions loadOptions = new LoadOptions();
        loadOptions.setFontDirectories(fontDirectories);

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD_FONT);
             InputStream targetStream = new FileInputStream(SampleFiles.TARGET_WORD_FONT);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream, loadOptions)) {
            comparer.add(targetStream);
            comparer.compare(resultStream);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
