---
id: groupdocs-comparison-for-java-3-2-2-release-notes
url: comparison/java/groupdocs-comparison-for-java-3-2-2-release-notes
title: GroupDocs.Comparison for Java 3.2.2 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparsion for Java 3.2.2{{< /alert >}}

## Major Features

There are improvements and fixes in this regular monthly release. The most notable are:

*   Comparison engines for all formats has been rewritten completely from scratch.
*   Simplified and much flexible API.
*   Better organized and simplified product structure.
*   Code optimization.
*   Apply/Discard changes support for all formats
*   Designed as native library which allow usage in all possible project types.
*   Introduced support of encrypted files
*   Introduced automatic detection of file types
*   Introduced improved Words comparison performance up to 8 times
*   Introduced improved Words comparison quality for text and tables
*   Introduced improved PDF comparison quality for text, tables and images
*   Introduced support of saving comparison results as images
*   Introduced support of HTML format
*   Introduced improved Words comparison performance
*   Introduced improved Words comparison quality for tables
*   Introduced improved PDF comparison quality for tables and images
*   Introduced improved Cells general comparison quality
*   Introduced Apply/Discard changes support for Text format

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| COMPARISONNET-445 | GroupDocs.Comparison.Cells: original Excel tables layout is not supported. | Bug |
| COMPARISONNET-533 | Implement of comparing pdf with the images | Improvement |
| COMPARISONNET-588 | Implement localization for exceptions handling | Improvement |
| COMPARISONNET-605 | Add support of File Type Detection from Stream | New Feature |
| COMPARISONNET-616 | Implement formulas comparison for Words format | Improvement |
| COMPARISONNET-638 | If content of slide is unique then slide should be marked as Inserted or Deleted | Improvement |
| COMPARISONNET-663 | Add support of password protected files for Words, Cells, Slides and PDF | New Feature |
| COMPARISONNET-664 | Implement comparison Words with alignment by identical and formation result-document using target-doc and insertion deleted components from source-doc | Improvement |
| COMPARISONNET-681 | Add checker for result document after merging comparison results | Improvement |
| COMPARISONNET-682 | Add resetting of stream positions in documents constructors | Improvement |
| COMPARISONNET-683 | Modify Comparison Settings in order to support culture information | Improvement |
| COMPARISONNET-684 | Change differ in CommonAligner to improve comparison performance | Improvement |
| COMPARISONNET-697 | Comparing attached documents runs between 8-13 minutes depending on hardware, then ends with 0 byte result. | Bug |
| COMPARISONNET-700 | Extend PDF Comparison functionality to get changes or confirm that documents are identical | New Feature |
| COMPARISONNET-719 | Comparison Results creating Blank page and Extra Spaces for DOCX/PDF | Bug |
| COMPARISONNET-722 | Update comparison differs according to performance improvement for Words. | Improvement |
| COMPARISONNET-726 | Implement function for correction of position and size Image after ImagePlacementAbsorber for Images from XForms | Improvement |
| COMPARISONNET-728 | Improve the displaying of images and text after process the comparison | Improvement |
| COMPARISONNET-730 | PDF: Implement the own absorber of tables | New Feature |
| COMPARISONNET-737 | Cannot open result file when graphics objects are used | Bug |
| COMPARISONNET-742 | Implement the Saving of result Comparison as images | New Feature |
| COMPARISONNET-750 | GroupDocs.Comparison.Words significant performance improvements with new aligners | Improvement |
| COMPARISONNET-769 | Add GetChanges and UpdateChanges methods for Comparison.Text | New Feature |
| COMPARISONNET-780 | Out of memory exception in ComparisonText | Bug |
| COMPARISONNET-787 | Save html files to word document when use Comparison.Text for comparison | New Feature |
| COMPARISONNET-794 | GroupDocs.Comparison.Words: Aligning of paragraphs mismatch for the case when paragraphs is moved by page break | Bug |
| COMPARISONNET-801 | Improve speed comparison Cells | Improvement |

## Public API and Backward Incompatible Changes

This is the first version of new generation GroupDocs.Comparison for Java.
