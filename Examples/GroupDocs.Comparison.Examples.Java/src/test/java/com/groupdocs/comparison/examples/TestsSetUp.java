package com.groupdocs.comparison.examples;

import com.groupdocs.comparison.examples.quick_start.SetLicenseFromUrl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

import java.lang.reflect.Method;

public abstract class TestsSetUp {
    private static boolean started = false;

    @BeforeAll
    public static void init() {
        if (!started) {
            started = true;
            System.out.print("\nPreparing environment...\n\t");
            // Environment variable 'GROUPDOCS_LIC_PATH' must contain license url
            SetLicenseFromUrl.run();
            System.out.println("\tDone");
        }
    }

    public static class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

        private static final String START_TIME = "start time";

        @Override
        public void beforeTestExecution(ExtensionContext context) {
            getStore(context).put(START_TIME, System.currentTimeMillis());
        }

        @Override
        public void afterTestExecution(ExtensionContext context) {
            Method testMethod = context.getRequiredTestMethod();
            long startTime = getStore(context).remove(START_TIME, long.class);
            long duration = System.currentTimeMillis() - startTime;

            System.out.format("\tMethod [%s#%s] took %s ms.\n", testMethod.getDeclaringClass().getSimpleName(), testMethod.getName(), duration);
        }

        private Store getStore(ExtensionContext context) {
            return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
        }
    }
}
