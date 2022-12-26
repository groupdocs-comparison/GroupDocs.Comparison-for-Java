package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.Test;

import java.io.IOException;

public class UseCompareOptionsTest extends TestsSetUp {

    @Test
    public void ignoreHeaderFooter() throws IOException {
        UseCompareOptions.ignoreHeaderFooter();
    }

    @Test
    public void setOutputPaperSize() throws IOException {
        UseCompareOptions.setOutputPaperSize();
    }

    @Test
    public void adjustComparisonSensitivity() throws IOException {
        UseCompareOptions.adjustComparisonSensitivity();
    }

    @Test
    public void customizeChangesStylesStream() throws IOException {
        UseCompareOptions.customizeChangesStylesStream();
    }

    @Test
    public void customizeChangesStylesPath() throws IOException {
        UseCompareOptions.customizeChangesStylesPath();
    }
}