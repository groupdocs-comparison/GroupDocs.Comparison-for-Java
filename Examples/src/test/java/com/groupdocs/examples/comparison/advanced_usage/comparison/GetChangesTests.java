package com.groupdocs.examples.comparison.advanced_usage.comparison;

import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.examples.comparison.SampleFiles;
import com.groupdocs.examples.comparison.TestsSetUp;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetChangesTests extends TestsSetUp {

    @Test
    public void testGetChangesCoordinates() {
        final ChangeInfo[] changeInfos = GetChanges.getChangesCoordinates(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(changeInfos).isNotNull();
    }

    @Test
    public void testGetListOfChangesPath() {
        final int changeCount = GetChanges.getListOfChangesPath(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(changeCount).isNotZero();
    }

    @Test
    public void testGetListOfChangesStream() {
        final int changeCount = GetChanges.getListOfChangesStream(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(changeCount).isNotZero();
    }

    @Test
    public void testGetTargetText() {
        final ChangeInfo[] changeInfos = GetChanges.getTargetText(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
        assertThat(changeInfos).isNotNull();
    }
}