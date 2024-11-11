package com.groupdocs.examples.comparison.advanced_usage;

import com.groupdocs.comparison.result.FileType;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrintSupportedFileTypesTests extends TestsSetUp {

    @Test
    public void testRun() {
        final FileType[] fileTypes = PrintSupportedFileTypes.run();
        Assertions.assertThat(fileTypes).hasSize(154);
    }
}