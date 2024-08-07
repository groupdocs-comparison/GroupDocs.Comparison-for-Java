package com.groupdocs.comparison.examples.quick_start;

import com.groupdocs.comparison.examples.TestsSetUp;
import com.groupdocs.comparison.license.License;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SetLicenseTest extends TestsSetUp {

    @Test
    public void runFromUrl() {
        // Environment variable 'GROUPDOCS_LIC_PATH' must contain license url
        SetLicenseFromUrl.run();

        Assertions.assertThat(License.isValidLicense())
                .withFailMessage("License was not set!")
                .isTrue();
    }

    @Test
    @Ignore("You must have license file")
    public void runFromFile() {
        SetLicenseFromFile.run();
    }

    @Test
    @Ignore("You must have license stream")
    public void runFromStream() throws Exception {
        SetLicenseFromStream.run();
    }

    @Test
    @Ignore("You must have public and private keys")
    public void runMeteredLicense() {
        SetMeteredLicense.run();
    }
}