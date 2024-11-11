package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleCompareProtectedDocumentsPathTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = MultipleCompareProtectedDocumentsPath.run(SampleFiles.SOURCE_DOCX_PROTECTED, SampleFiles.TARGET1_DOCX_PROTECTED, SampleFiles.TARGET2_DOCX_PROTECTED, SampleFiles.TARGET3_DOCX_PROTECTED);
        assertThat(resultPath).isNotNull().exists();
    }
}