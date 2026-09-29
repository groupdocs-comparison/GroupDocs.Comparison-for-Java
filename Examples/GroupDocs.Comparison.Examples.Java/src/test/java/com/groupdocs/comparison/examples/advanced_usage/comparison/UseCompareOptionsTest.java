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

    @Test
    public void compareBookmarks() throws IOException {
        UseCompareOptions.compareBookmarks();
    }

    @Test
    public void compareDocumentProperties() throws IOException {
        UseCompareOptions.compareDocumentProperties();
    }

    @Test
    public void disableShowRevisions() throws IOException {
        UseCompareOptions.disableShowRevisions();
    }

    @Test
    public void getExtendedSummaryPage() throws IOException {
        UseCompareOptions.getExtendedSummaryPage();
    }

    @Test
    public void getOnlySummaryPage() throws IOException {
        UseCompareOptions.getOnlySummaryPage();
    }

    @Test
    public void leaveGaps() throws IOException {
        UseCompareOptions.leaveGaps();
    }

    @Test
    public void wordTrackChanges() throws IOException {
        UseCompareOptions.wordTrackChanges();
    }
}