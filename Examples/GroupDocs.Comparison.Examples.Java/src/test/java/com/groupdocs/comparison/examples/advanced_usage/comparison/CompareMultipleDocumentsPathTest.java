package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class CompareMultipleDocumentsPathTest extends TestsSetUp {

    @Test
    void compareMultipleWordsDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleWordsDocuments();
    }

    @Test
    void compareMultipleTxtDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleTxtDocuments();
    }

    @Test
    void compareMultipleEmailDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleEmailDocuments();
    }

    @Test
    void compareMultiplePdfDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultiplePdfDocuments();
    }

    @Test
    void compareMultipleDiagramDocuments() throws IOException {
        CompareMultipleDocumentsPath.compareMultipleDiagramDocuments();
    }
}