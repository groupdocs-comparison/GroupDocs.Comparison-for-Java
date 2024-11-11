package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PreviewResultantDocumentWithMemoryCleanTests extends TestsSetUp {

    @Test
    @Ignore("An error occurred while trying to create a document. Try to use setUseSourceMaster(true) with custom value for getUserMasterPath(...).")
    public void testRun() {
        final Path resultPath = PreviewResultantDocumentWithMemoryClean.run(SampleFiles.SOURCE_VSDX, SampleFiles.TARGET1_VSDX);
        assertThat(resultPath).isNotNull().exists();
    }
}