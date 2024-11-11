package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleCompareDocumentsPathTests extends TestsSetUp {

    @Test
    public void testCompareMultipleWordsDocuments() {
        final Path resultPath = MultipleCompareDocumentsPath.compareMultipleWordsDocuments(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX, SampleFiles.TARGET2_DOCX, SampleFiles.TARGET3_DOCX);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCompareMultipleTxtDocuments() {
        final Path resultPath = MultipleCompareDocumentsPath.compareMultipleTxtDocuments(SampleFiles.SOURCE_TXT, SampleFiles.TARGET1_TXT, SampleFiles.TARGET2_TXT, SampleFiles.TARGET3_TXT);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCompareMultipleEmailDocuments() {
        final Path resultPath = MultipleCompareDocumentsPath.compareMultipleEmailDocuments(SampleFiles.SOURCE_EML, SampleFiles.TARGET1_EML, SampleFiles.TARGET2_EML, SampleFiles.TARGET3_EML);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    public void testCompareMultiplePdfDocuments() {
        final Path resultPath = MultipleCompareDocumentsPath.compareMultiplePdfDocuments(SampleFiles.SOURCE_PDF, SampleFiles.TARGET1_PDF, SampleFiles.TARGET2_PDF, SampleFiles.TARGET3_PDF);
        assertThat(resultPath).isNotNull().exists();
    }

    @Test
    @Ignore("An error occurred while trying to create a document. Try to use setUseSourceMaster(true) with custom value for getUserMasterPath(...).")
    public void testCompareMultipleDiagramDocuments() {
        final Path resultPath = MultipleCompareDocumentsPath.compareMultipleDiagramDocuments(SampleFiles.SOURCE_VSDX, SampleFiles.TARGET1_VSDX, SampleFiles.TARGET2_VSDX, SampleFiles.TARGET3_VSDX, SampleFiles.DIAGRAM_MASTER);
        assertThat(resultPath).isNotNull().exists();
    }
}