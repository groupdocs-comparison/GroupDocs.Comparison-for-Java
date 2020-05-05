package com.groupdocs.comparison.examples.quick_start;

import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.license.License;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * This example demonstrates how to set license from stream.
 */
public class SetLicenseFromStream {

    /**
     * This example demonstrates how to set license from stream.
     */

    public static void run() throws Exception {
        if (new File(Utils.LICENSE_PATH).exists()) {
            InputStream stream = new FileInputStream(Utils.LICENSE_PATH);
            try {
                License license = new License();
                license.setLicense(stream);
            } finally {
                com.groupdocs.comparison.common.Utils.closeStreams(stream);
            }

            System.out.println("License set successfully.");
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}