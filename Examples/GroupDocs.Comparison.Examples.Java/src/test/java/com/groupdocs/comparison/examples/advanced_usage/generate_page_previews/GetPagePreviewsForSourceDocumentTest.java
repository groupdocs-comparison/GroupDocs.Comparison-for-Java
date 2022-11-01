package com.groupdocs.comparison.examples.advanced_usage.generate_page_previews;

import com.groupdocs.comparison.examples.TestsSetUp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestsSetUp.TimingExtension.class)
public class GetPagePreviewsForSourceDocumentTest extends TestsSetUp {

    @Test
    void run() {
        GetPagePreviewsForSourceDocument.run();
    }
}