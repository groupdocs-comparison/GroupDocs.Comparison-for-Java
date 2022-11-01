package com.groupdocs.comparison.examples.advanced_usage;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class GetMeteredCreditsLimitTest extends TestsSetUp {

    @Test
    @Disabled("You must have public and private keys")
    void run() throws Exception {
        GetMeteredCreditsLimit.run();
    }
}