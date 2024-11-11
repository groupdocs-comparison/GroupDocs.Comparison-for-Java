package com.groupdocs.examples.comparison.advanced_usage.previews;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PreviewSourceDocumentTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = PreviewSourceDocument.run(SampleFiles.SOURCE_DOC);
        assertThat(resultPath).isNotNull().exists();
    }
}