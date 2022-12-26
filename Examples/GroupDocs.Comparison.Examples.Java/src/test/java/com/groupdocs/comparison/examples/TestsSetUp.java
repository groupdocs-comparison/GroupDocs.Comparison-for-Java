package com.groupdocs.comparison.examples;

import com.groupdocs.comparison.examples.quick_start.SetLicenseFromUrl;
import org.junit.Before;

public abstract class TestsSetUp {
    private static boolean started = false;

    @Before
    public void init() {
        if (!started) {
            started = true;
            System.out.print("\nSetting license..");
            // Environment variable 'GROUPDOCS_LIC_PATH' must contain license url
            SetLicenseFromUrl.run();
            Utils.deleteOutputDirectory();
        }
    }
}
