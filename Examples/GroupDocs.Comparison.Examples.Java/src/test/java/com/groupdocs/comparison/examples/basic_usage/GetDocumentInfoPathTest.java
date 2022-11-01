package com.groupdocs.comparison.examples.basic_usage;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class GetDocumentInfoPathTest extends TestsSetUp {

    @Test
    void run() throws IOException {
        GetDocumentInfoPath.run();
    }
}