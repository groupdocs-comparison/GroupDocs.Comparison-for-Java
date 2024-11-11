package com.groupdocs.examples.comparison.advanced_usage;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import com.groupdocs.examples.comparison.advanced_usage.saving.SetDocumentMetadata;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class GetMeteredCreditsLimitTests extends TestsSetUp {

    @Test
    @Ignore("You should set metered key firstly.")
    public void testRun() {
        final Path resultPath = GetMeteredCreditsLimit.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
        assertThat(resultPath).isNotNull().exists();
    }
}