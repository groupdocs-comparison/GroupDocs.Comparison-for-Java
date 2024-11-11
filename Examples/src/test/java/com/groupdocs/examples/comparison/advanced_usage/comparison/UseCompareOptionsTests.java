package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class UseCompareOptionsTests extends TestsSetUp {

    @Test
    public void testIgnoreHeaderFooter() {
        final Path resultPath = UseCompareOptions.ignoreHeaderFooter(SampleFiles.SOURCE_DOCX_WITH_FOOTER, SampleFiles.TARGET_DOCX_WITH_FOOTER);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testSetOutputPaperSize() {
        final Path resultPath = UseCompareOptions.setOutputPaperSize(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testAdjustComparisonSensitivity() {
        final Path resultPath = UseCompareOptions.adjustComparisonSensitivity(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCustomizeChangesStylesStream() {
        final Path resultPath = UseCompareOptions.customizeChangesStylesStream(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCustomizeChangesStylesPath() {
        final Path resultPath = UseCompareOptions.customizeChangesStylesPath(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }
}