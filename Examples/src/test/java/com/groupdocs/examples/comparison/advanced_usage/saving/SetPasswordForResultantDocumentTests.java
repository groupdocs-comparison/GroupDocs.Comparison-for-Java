package com.groupdocs.examples.comparison.advanced_usage.saving;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SetPasswordForResultantDocumentTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = SetPasswordForResultantDocument.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }
}