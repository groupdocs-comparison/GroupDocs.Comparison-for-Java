package com.groupdocs.examples.comparison.advanced_usage.loading;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import com.groupdocs.examples.comparison.advanced_usage.saving.SetDocumentMetadata;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class LoadDocumentFromStreamTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = LoadDocumentFromStream.run(SampleFiles.SOURCE_PDF, SampleFiles.TARGET1_PDF);
        assertThat(resultPath).isNotNull().exists();
    }
}