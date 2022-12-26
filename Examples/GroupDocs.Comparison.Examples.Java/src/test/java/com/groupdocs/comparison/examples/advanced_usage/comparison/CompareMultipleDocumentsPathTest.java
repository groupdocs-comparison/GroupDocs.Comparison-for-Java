package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.examples.TestsSetUp;
import com.groupdocs.comparison.logging.ComparisonLogger;
import com.groupdocs.comparison.logging.ConsoleLogger;
import org.junit.Test;

import java.io.IOException;

public class CompareMultipleDocumentsPathTest extends TestsSetUp {

    @Test
    public void compareMultipleWordsDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleWordsDocuments();
    }

    @Test
    public void compareMultipleTxtDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleTxtDocuments();
    }

    @Test
    public void compareMultipleEmailDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleEmailDocuments();
    }

    @Test
    public void compareMultiplePdfDocuments() throws IOException {
        ComparisonLogger.setLogger(new ConsoleLogger(false, true, true, true));
        CompareMultipleDocumentsPath.compareMultiplePdfDocuments();
    }

    @Test
    public void compareMultipleDiagramDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleDiagramDocuments();
    }
}