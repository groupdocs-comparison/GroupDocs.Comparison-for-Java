package com.groupdocs.comparison.examples.quick_start;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class SetLicenseTest extends TestsSetUp {

    @Test
    void runFromUrl() {
        // Environment variable 'GROUPDOCS_LIC_PATH' must contain license url
        SetLicenseFromUrl.run();
    }

    @Test
    @Disabled("You must have license file")
    void runFromFile() {
        SetLicenseFromFile.run();
    }

    @Test
    @Disabled("You must have license stream")
    void runFromStream() throws Exception {
        SetLicenseFromStream.run();
    }

    @Test
    @Disabled("You must have public and private keys")
    void runMeteredLicense() {
        SetMeteredLicense.run();
    }
}