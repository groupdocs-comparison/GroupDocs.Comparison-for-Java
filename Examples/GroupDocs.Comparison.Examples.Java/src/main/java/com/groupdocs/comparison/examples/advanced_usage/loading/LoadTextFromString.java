package com.groupdocs.comparison.examples.advanced_usage.loading;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.load.LoadOptions;

/**
 * This example demonstrates comparing of two texts loaded by string variables
 */
public class LoadTextFromString {
    public static void run() {
        // Instantiate LoadOptions object with set LoadText property to true
        // (this indicates that passed string contains text to be compared, not file path)
        final LoadOptions loadOptions = new LoadOptions();
        loadOptions.setLoadText(true);

        try (Comparer comparer = new Comparer("source text", loadOptions)) {
            // Use the same code structure, to pass second text
            comparer.add("target text", loadOptions);
            comparer.compare();

            // Call getResultString method to get text with comparison result
            System.out.println("Result string: \n" + comparer.getResultString());
        }
        System.out.println("\nTexts compared successfully.");
    }
}
