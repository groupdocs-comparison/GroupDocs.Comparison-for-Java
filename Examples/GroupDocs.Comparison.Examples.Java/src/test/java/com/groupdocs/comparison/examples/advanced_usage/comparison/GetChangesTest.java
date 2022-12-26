package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.Test;

import java.io.IOException;

public class GetChangesTest extends TestsSetUp {

    @Test
    public void getChangesCoordinates() throws IOException {
        GetChanges.getChangesCoordinates();
    }

    @Test
    public void getListOfChangesPath() {
        GetChanges.getListOfChangesPath();
    }

    @Test
    public void getListOfChangesStream() throws Exception {
        GetChanges.getListOfChangesStream();
    }

    @Test
    public void getTargetText() {
        GetChanges.getTargetText();
    }
}