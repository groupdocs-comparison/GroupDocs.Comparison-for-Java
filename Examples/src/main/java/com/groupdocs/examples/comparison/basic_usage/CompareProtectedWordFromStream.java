package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.options.load.LoadOptions;
import com.groupdocs.examples.comparison.utils.FailureRegister;
import com.groupdocs.examples.comparison.utils.FilesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.obtainExtension;

public class CompareProtectedWordFromStream {
    public static Path run(Path sourceFile, Path targetFile) {

        final Path outputPath = FilesUtils.makeOutputPath("CompareProtectedWordFromStream" + obtainExtension(sourceFile));

        try (InputStream sourceInputStream = Files.newInputStream(sourceFile);
             InputStream targetInputStream = Files.newInputStream(targetFile);
             OutputStream outputStream = Files.newOutputStream(outputPath);
             Comparer comparer = new Comparer(sourceInputStream, new LoadOptions("1234"))) {
            comparer.add(targetInputStream, new LoadOptions("5678"));

            Path resultPath = comparer.compare(outputStream);

            if (resultPath == null) {
                resultPath = outputPath;
            }

            System.out.println("\nDocuments compared successfully.\nCheck output: " + outputPath.getParent());
            return resultPath;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
