package com.groupdocs.comparison.examples;

import java.io.File;

public class SampleFiles {


    public static final String SOURCE_CELLS = getSampleFilePath("source.xlsx");
    public static final String SOURCE_DIRECTORIES = getSampleFilePath("sourceDirectory");
    public static final String TARGET_DIRECTORIES = getSampleFilePath("targetDirectory");
    public static final String TARGET_CELLS = getSampleFilePath("target.xlsx");

    public static final String SOURCE_WORD = getSampleFilePath("source.docx");
    public static final String TARGET1_WORD = getSampleFilePath("target.docx");
    public static final String TARGET2_WORD = getSampleFilePath("target2.docx");
    public static final String TARGET3_WORD = getSampleFilePath("target3.docx");
    public static final String SOURCE_WORD_PROTECTED = getSampleFilePath("source_protected.docx");
    public static final String TARGET_WORD_PROTECTED = getSampleFilePath("target_protected.docx");
    public static final String TARGET2_WORD_PROTECTED = getSampleFilePath("target2_protected.docx");
    public static final String TARGET3_WORD_PROTECTED = getSampleFilePath("target3_protected.docx");

    public static final String SOURCE_SLIDES = getSampleFilePath("source.pptx");
    public static final String TARGET_SLIDES = getSampleFilePath("target.pptx");

    public static final String SOURCE_TXT = getSampleFilePath("source.txt");
    public static final String TARGET_TXT = getSampleFilePath("target.txt");
    public static final String TARGET2_TXT = getSampleFilePath("target2.txt");
    public static final String TARGET3_TXT = getSampleFilePath("target3.txt");

    public static final String SOURCE_EMAIL = getSampleFilePath("source.eml");
    public static final String TARGET_EMAIL = getSampleFilePath("target.eml");
    public static final String TARGET2_EMAIL = getSampleFilePath("target2.eml");
    public static final String TARGET3_EMAIL = getSampleFilePath("target3.eml");

    public static final String SOURCE_PDF = getSampleFilePath("source.pdf");
    public static final String TARGET_PDF = getSampleFilePath("target.pdf");
    public static final String TARGET2_PDF = getSampleFilePath("target2.pdf");
    public static final String TARGET3_PDF = getSampleFilePath("target3.pdf");

    public static final String SOURCE_DIAGRAM = getSampleFilePath("source.vsdx");
    public static final String TARGET_DIAGRAM = getSampleFilePath("target.vsdx");
    public static final String TARGET2_DIAGRAM = getSampleFilePath("target2.vsdx");
    public static final String TARGET3_DIAGRAM = getSampleFilePath("target3.vsdx");

    public static final String SOURCE_WITH_FOOTER = getSampleFilePath("sourceWithFooter.docx");
    public static final String TARGET_WITH_FOOTER = getSampleFilePath("targetWithFooter.docx");

    public static final String RESULT_WORD = "result-%s.docx";
    public static final String RESULT_CELLS = "result-%s.xlsx";
    public static final String RESULT_DIRECTORIES = "result-%s.html";
    public static final String RESULT_SLIDES = "result-%s.pptx";
    public static final String RESULT_TXT = "result-%s.txt";
    public static final String RESULT_EMAIL = "result-%s.eml";
    public static final String RESULT_PDF = "result-%s.pdf";
    public static final String RESULT_DIAGRAM = "result-%s.vsdx";

    public static final String DIAGRAM_SETTINGS = getSampleFilePath("basicShapes.vssx");

    private static String getSampleFilePath(String filePath) {
        return new File(Utils.SAMPLES_PATH, filePath).getPath();
    }
}
