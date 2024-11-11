package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareProtectedWordFromStreamTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = CompareProtectedWordFromStream.run(SampleFiles.SOURCE_DOCX_PROTECTED, SampleFiles.TARGET_DOCX_PROTECTED);
        assertThat(resultPath).isNotNull().exists();
    }
}