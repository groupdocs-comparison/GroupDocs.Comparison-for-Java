package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.exceptions.ComparisonException;
import com.groupdocs.comparison.options.CompareOptions;
import com.groupdocs.comparison.options.save.SaveOptions;
import com.groupdocs.comparison.options.style.DiagramMasterSetting;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

/**
 * This class demonstrates comparing of multi documents
 */
public class MultipleCompareDocumentsPath {
    /**
     * This example demonstrates comparing of multi words documents
     */
    public static Path compareMultipleWordsDocuments(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsPath-compareMultipleWordsDocuments" + obtainExtension(sourceFile));

        try (Comparer comparer = new Comparer(sourceFile)) {

            {
                // Note: It is the same with commented code below
                comparer.add(target1File, target2File, target3File);

                // Note: It is the same with the code above
//                comparer.add(target1File);
//                comparer.add(target2File);
//                comparer.add(target3File);
            }

            final Path resultPath = comparer.compare(outputPath);

            System.out.println("\nDocuments compared successfully.\nCheck output: " + outputPath.getParent());
        }

        return outputPath;
    }

    /**
     * This example demonstrates comparing of multi txt documents
     */
    public static Path compareMultipleTxtDocuments(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsPath-compareMultipleTxtDocuments" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {

            {
                // Note: It is the same with commented code below
                comparer.add(target1File, target2File, target3File);

                // Note: It is the same with the code above
//                comparer.add(target1File);
//                comparer.add(target2File);
//                comparer.add(target3File);
            }

            final Path resultPath = comparer.compare(resultStream, new SaveOptions(), new CompareOptions());

            System.out.println("\nText documents compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }

        return outputPath;
    }

    /**
     * This example demonstrates comparing of multi email documents
     */
    public static Path compareMultipleEmailDocuments(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsPath-compareMultipleEmailDocuments" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {

            {
                // Note: It is the same with commented code below
                comparer.add(target1File, target2File, target3File);

                // Note: It is the same with the code above
//                comparer.add(target1File);
//                comparer.add(target2File);
//                comparer.add(target3File);
            }

            final Path resultPath = comparer.compare(resultStream, new SaveOptions(), new CompareOptions());

            System.out.println("\nEmail documents compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }

        return outputPath;
    }

    /**
     * This example demonstrates comparing of multi pdf documents
     */
    public static Path compareMultiplePdfDocuments(Path sourceFile, Path target1File, Path target2File, Path target3File) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsPath-compareMultiplePdfDocuments" + obtainExtension(sourceFile));

        try (OutputStream resultStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {

            {
                // Note: It is the same with commented code below
                comparer.add(target1File, target2File, target3File);

                // Note: It is the same with the code above
//                comparer.add(target1File);
//                comparer.add(target2File);
//                comparer.add(target3File);
            }
            final Path resultPath = comparer.compare(resultStream, new SaveOptions(), new CompareOptions());

            System.out.println("\nPDF documents compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (ComparisonException e) {
            if (e.getMessage() != null && e.getMessage().contains("It is impossible to process this document without license")) {
                System.err.println("Valid license is required to run this sample");
            } else {
                throw e;
            }
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }

        return outputPath;
    }

    /**
     * This example demonstrates comparing of multi diagram documents
     */
    public static Path compareMultipleDiagramDocuments(Path sourceFile,
                                                       Path target1File,
                                                       Path target2File,
                                                       Path target3File,
                                                       Path masterFile) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareMultipleDocumentsPath-compareMultipleDiagramDocuments" + obtainExtension(sourceFile));

        try (OutputStream outputStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceFile)) {

            {
                // Note: It is the same with commented code below
                comparer.add(target1File, target2File, target3File);

                // Note: It is the same with the code above
//                comparer.add(target1File);
//                comparer.add(target2File);
//                comparer.add(target3File);
            }

            {
                // Note: It is the same with commented code below
                final CompareOptions compareOptions = new CompareOptions.Builder()
                        .setDiagramMasterSetting(
                                new DiagramMasterSetting.Builder()
                                        .setUseSourceMaster(true)
                                        .setMasterPath(masterFile.toString())
                                        .build())
                        .build();
                // Note: It is the same with the code above
//                final DiagramMasterSetting diagramMasterSetting = new DiagramMasterSetting();
//                diagramMasterSetting.setUseSourceMaster(true);
//                diagramMasterSetting.setMasterPath(masterFile.toString());
//                final CompareOptions compareOptions = new CompareOptions();
//                compareOptions.setDiagramMasterSetting(diagramMasterSetting);

                final Path resultPath = comparer.compare(outputStream, new SaveOptions(), compareOptions);
            }

            System.out.println("\nDiagram documents compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
            e.printStackTrace();
        }
        return outputPath;
    }
}