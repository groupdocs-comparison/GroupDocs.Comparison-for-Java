package com.groupdocs.comparison.examples.quick_start;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class HelloWorldTest extends TestsSetUp {

    @Test
    void run() throws Exception {
        HelloWorld.run();
    }
}