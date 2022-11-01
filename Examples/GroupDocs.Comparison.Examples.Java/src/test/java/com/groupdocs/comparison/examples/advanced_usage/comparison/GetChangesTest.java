package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class GetChangesTest extends TestsSetUp {

    @Test
    void getChangesCoordinates() throws IOException {
        GetChanges.getChangesCoordinates();
    }

    @Test
    void getListOfChangesPath() {
        GetChanges.getListOfChangesPath();
    }

    @Test
    void getListOfChangesStream() throws Exception {
        GetChanges.getListOfChangesStream();
    }

    @Test
    void getTargetText() {
        GetChanges.getTargetText();
    }
}