package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareCellsFromStreamTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = CompareCellsFromStream.run(SampleFiles.SOURCE_XLSX, SampleFiles.TARGET_XLSX);
        assertThat(resultPath).isNotNull().exists();
    }
}