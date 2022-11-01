package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class CompareCellsFromStreamTest extends TestsSetUp {

    @Test
    void run() throws Exception {
        CompareCellsFromStream.run();
    }
}