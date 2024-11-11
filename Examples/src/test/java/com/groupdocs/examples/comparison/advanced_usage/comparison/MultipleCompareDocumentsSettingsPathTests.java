package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleCompareDocumentsSettingsPathTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = MultipleCompareDocumentsSettingsPath.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX, SampleFiles.TARGET2_DOCX, SampleFiles.TARGET3_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }
}