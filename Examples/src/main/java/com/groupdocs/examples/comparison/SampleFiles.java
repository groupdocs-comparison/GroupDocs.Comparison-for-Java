package com.groupdocs.examples.comparison;

import java.nio.file.Path;

import static com.groupdocs.examples.comparison.utils.FilesUtils.makeFilesPath;

public interface SampleFiles {
    Path SOURCE_DOC = makeFilesPath("source.doc");
    Path TARGET_DOC = makeFilesPath("target.doc");

    Path DIAGRAM_MASTER = makeFilesPath("basicShapes.vssx");

    Path SOURCE_XLSX = makeFilesPath("source.xlsx");
    Path TARGET_XLSX = makeFilesPath("target.xlsx");
    Path SOURCE_DIRECTORY = makeFilesPath("sourceDirectory");
    Path TARGET_DIRECTORY = makeFilesPath("targetDirectory");
    Path SOURCE_DOCX_PROTECTED = makeFilesPath("source_protected.docx");
    Path TARGET_DOCX_PROTECTED = makeFilesPath("target_protected.docx");

    Path SOURCE_DOCX = makeFilesPath("source.docx");
    Path TARGET1_DOCX = makeFilesPath("target1.docx");
    Path TARGET2_DOCX = makeFilesPath("target2.docx");
    Path TARGET3_DOCX = makeFilesPath("target3.docx");

    Path SOURCE_TXT = makeFilesPath("source.txt");
    Path TARGET1_TXT = makeFilesPath("target.txt");
    Path TARGET2_TXT = makeFilesPath("target2.txt");
    Path TARGET3_TXT = makeFilesPath("target3.txt");

    Path SOURCE_EML = makeFilesPath("source.eml");
    Path TARGET1_EML = makeFilesPath("target.eml");
    Path TARGET2_EML = makeFilesPath("target2.eml");
    Path TARGET3_EML = makeFilesPath("target3.eml");

    Path SOURCE_PDF = makeFilesPath("source.pdf");
    Path TARGET1_PDF = makeFilesPath("target.pdf");
    Path TARGET2_PDF = makeFilesPath("target2.pdf");
    Path TARGET3_PDF = makeFilesPath("target3.pdf");

    Path SOURCE_VSDX = makeFilesPath("source.vsdx");
    Path TARGET1_VSDX = makeFilesPath("target1.vsdx");
    Path TARGET2_VSDX = makeFilesPath("target2.vsdx");
    Path TARGET3_VSDX = makeFilesPath("target3.vsdx");

    Path TARGET1_DOCX_PROTECTED = makeFilesPath("target1.docx");
    Path TARGET2_DOCX_PROTECTED = makeFilesPath("target2.docx");
    Path TARGET3_DOCX_PROTECTED = makeFilesPath("target3.docx");

    Path SOURCE_DOCX_WITH_FOOTER = makeFilesPath("source_with_footer.docx");
    Path TARGET_DOCX_WITH_FOOTER = makeFilesPath("target_with_footer.docx");
}
