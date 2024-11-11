package com.groupdocs.examples.comparison.quick_start;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path resultPath = HelloWorld.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
        assertThat(resultPath).isNotNull().exists();
    }
}