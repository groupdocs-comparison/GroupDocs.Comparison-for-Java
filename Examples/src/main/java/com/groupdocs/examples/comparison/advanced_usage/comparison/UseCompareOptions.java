package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.enums.PaperSize;
import com.groupdocs.comparison.options.style.StyleSettings;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This class demonstrates how to use CompareOptions
 */
public class UseCompareOptions {
    /**
     * This example demonstrates how to ignore Header/Footer
     */
    public static Path ignoreHeaderFooter(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("UseCompareOptions-ignoreHeaderFooter" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setHeaderFootersComparison(false)
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }

    /**
     * This example demonstrates how to set output paper size
     */
    public static Path setOutputPaperSize(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("UseCompareOptions-setOutputPaperSize" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setPaperSize(PaperSize.A6)
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }

    /**
     * This example demonstrates comparing of two documents using sensitivity option
     */
    public static Path adjustComparisonSensitivity(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("UseCompareOptions-adjustComparisonSensitivity" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setSensitivityOfComparison(100)
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }

    /**
     * This example demonstrates how to customize change styles from path
     */
    public static Path customizeChangesStylesStream(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("UseCompareOptions-customizeChangesStylesStream" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setInsertedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.RED)
                                    .setFontColor(Color.GREEN)
                                    .setUnderline(true)
                                    .setBold(true)
                                    .setStrikethrough(true)
                                    .setItalic(true)
                                    .build())
                    .setDeletedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.PINK)
                                    .setFontColor(Color.CYAN)
                                    .setUnderline(true)
                                    .setBold(true)
                                    .setStrikethrough(true)
                                    .setItalic(true)
                                    .build())
                    .setChangedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.LIGHT_GRAY)
                                    .setFontColor(Color.GRAY)
                                    .setUnderline(true)
                                    .setBold(true)
                                    .setStrikethrough(true)
                                    .setItalic(true)
                                    .build())
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }

    /**
     * This example demonstrates how to customize change styles from path
     */
    public static Path customizeChangesStylesPath(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("UseCompareOptions-customizeChangesStylesPath" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             final Comparer comparer = new Comparer(sourceFile)) {
            comparer.add(targetFile);

            CompareOptions compareOptions = new CompareOptions.Builder()
                    .setInsertedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.RED)
                                    .setFontColor(Color.GREEN)
                                    .setUnderline(true)
                                    .setBold(true)
                                    .setStrikethrough(true)
                                    .setItalic(true)
                                    .build())
                    .setDeletedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.PINK)
                                    .setFontColor(Color.CYAN)
                                    .setUnderline(true)
                                    .setBold(true)
                                    .setStrikethrough(true)
                                    .setItalic(true)
                                    .build())
                    .setChangedItemStyle(
                            new StyleSettings.Builder()
                                    .setHighlightColor(Color.LIGHT_GRAY)
                                    .setFontColor(Color.GRAY)
                                    .setUnderline(true)
                                    .setBold(true)
                                    .setStrikethrough(true)
                                    .setItalic(true)
                                    .build())
                    .build();

            Path resultPath = comparer.compare(resultStream, compareOptions);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + resultPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}