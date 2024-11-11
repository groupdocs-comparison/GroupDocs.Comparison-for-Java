package com.groupdocs.examples.comparison.basic_usage;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareCellsFromPathTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = CompareCellsFromPath.run(SampleFiles.SOURCE_XLSX, SampleFiles.TARGET_XLSX);
        assertThat(resultPath).isNotNull().exists();
    }
}