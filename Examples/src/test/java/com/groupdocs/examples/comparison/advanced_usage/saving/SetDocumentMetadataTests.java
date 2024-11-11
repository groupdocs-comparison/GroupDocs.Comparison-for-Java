package com.groupdocs.examples.comparison.advanced_usage.saving;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class SetDocumentMetadataTests extends TestsSetUp {

    @Test
    public void testCloneSource() {
        final Path resultPath = SetDocumentMetadata.cloneSource(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCloneTarget() {
        final Path resultPath = SetDocumentMetadata.cloneTarget(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCloneUserDefined() {
        final Path resultPath = SetDocumentMetadata.cloneUserDefined(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }
}