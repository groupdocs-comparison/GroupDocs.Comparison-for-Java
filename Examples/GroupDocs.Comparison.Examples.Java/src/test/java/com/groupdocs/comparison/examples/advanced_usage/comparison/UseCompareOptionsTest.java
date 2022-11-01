package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class UseCompareOptionsTest extends TestsSetUp {

    @Test
    void ignoreHeaderFooter() throws IOException {
        UseCompareOptions.ignoreHeaderFooter();
    }

    @Test
    void setOutputPaperSize() throws IOException {
        UseCompareOptions.setOutputPaperSize();
    }

    @Test
    void adjustComparisonSensitivity() throws IOException {
        UseCompareOptions.adjustComparisonSensitivity();
    }

    @Test
    void customizeChangesStylesStream() throws IOException {
        UseCompareOptions.customizeChangesStylesStream();
    }

    @Test
    void customizeChangesStylesPath() throws IOException {
        UseCompareOptions.customizeChangesStylesPath();
    }
}