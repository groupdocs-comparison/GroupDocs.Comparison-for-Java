package com.groupdocs.comparison.examples.quick_start;


import com.groupdocs.comparison.license.Metered;

/**
 * This example demonstrates how to set Metered license.
 * Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
 */
public class SetMeteredLicense {

    /**
     * This example demonstrates how to set Metered license.
     * Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
     */

    public static void run() {
        String publicKey = "*****"; // Your public license key
        String privateKey = "*****"; // Your private license key
        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);
        System.out.println("License set successfully.");
    }
}