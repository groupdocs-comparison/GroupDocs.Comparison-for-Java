package com.groupdocs.comparison.examples.quick_start;

import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.license.License;

import java.io.File;

/**
 * This example demonstrates how to set license from file.
 * <p>
 * The SetLicense method attempts to set a license from several locations relative to the executable and GroupDocs.Comparison.dll.
 * You can also use the additional overload to load a license from a stream, this is useful for instance when the
 * License is stored as an embedded resource.
 */
public class SetLicenseFromFile {

    /**
     * This example demonstrates how to set license from file.
     * <p>
     * The SetLicense method attempts to set a license from several locations
     * relative to the executable. You can also use the
     * additional overload to load a license from a stream, this is useful for
     * instance when the License is stored as an embedded resource.
     */
    public static void run() {
        if (new File(Utils.LICENSE_PATH).exists()) {
            License license = new License();
            license.setLicense(Utils.LICENSE_PATH);
            System.out.println("\nLicense set successfully.");
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}