package com.groupdocs.comparison.examples.advanced_usage.loading;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class LoadDocumentFromStreamTest extends TestsSetUp {

    @Test
    void run() throws Exception {
        LoadDocumentFromStream.run();
    }
}