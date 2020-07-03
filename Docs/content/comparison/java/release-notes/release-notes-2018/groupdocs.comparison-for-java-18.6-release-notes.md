---
id: groupdocs-comparison-for-java-18-6-release-notes
url: comparison/java/groupdocs-comparison-for-java-18-6-release-notes
title: GroupDocs.Comparison for Java 18.6 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparsion for Java 18.6{{< /alert >}}

## Major Features

Below the list of fixed bugs in this release of GroupDocs.Comparsion for Java. The most notable are:

*   Add ability of comparing DICOM documents by Comparison.Imaging
*   Simplified and improved public API across all supported formats
*   Introduced the process absorbing of tables with merged cells for GroupDocs.Comparison.PDF
*   Fixed comparing filled tables for GroupDocs.Comparison.PDF
*   Introduced support of multi compare for formats to GroupDocs.Comparison public API
*   Introduced supporting of CAD formats
*   Improved comparison of Imaging formats
*   Simplify API across all supported formats
*   Fixed comparing multi-column tables for GroupDocs.Comparison.PDF
*   GroupDocs.Comparison.PDF: Fix bug when the text from the paragraphs overlaps tables
*   Introduced support of PNG, BMP and PNG formats
*   Added strikeout option for deleted/changed text in words comparison
*   Improve comparison performance for Text and Imaging formats
*   Added support of ChangeInfo
*   Introduced support of Emails formats
*   Improved comparison performance for Cells, Slides, HTML formats
*   Improved Summary Pages information about comparison results for all formats
*   Added ability of applying or discarding for category of changes in Words formats
*   Introduced support of style settings for all formats
*   Introduced setting for cloning passwords for all formats
*   Introduced setting for cloning metadata for all foramts
*   Added clone ability for Cells formats
*   Added comparing Note documents
*   Improvemet Cells comparison
*   Fixed a number of Comparison.Slides iisue
*   Upated logger
*   added new features for Cells format (Pivot tables, header and footers)
*   Fixed summary page working
*   Authors were added to all changes
*   Bug with changed styles in Note was fixed
*   SaveImages and GetImages methods in Note were fixed
*   Cell’s Aligner was improved
*   Intermediate paragraph algorithm was added to Note
*   Outline’s styles were added
*   AlignWithoutPositioning algorithm was added to Note
*   Note’s Summary page was fixed
*   Comparison of headerFoters was added to PDF
*   Fixed a number of specific cases for Note format (words breaking, paragraph comparing)
*   Added intermediate paragraphs mechanism for simplifying comparing (for Words and Note)
*   Fixed styles comparing in Notes
*   PDF structure update
*   Fixes for working with images on PDF format

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| COMPARISONNET-1156 | Add ability of comparing DICOM documents by Comparison.Imaging | New Feature |
| COMPARISONNET-1163 | Apply/Discard changes for DICOM format | New Feature |
| OMPARISONNET-1165 | Add summary page to images streams | New Feature |
| COMPARISONNET-1143 | Add support of multi compare for formats to GroupDocs.Comparison public API | New Feature |
| COMPARISONNET-1172 | Add UpdateChanges Model for Imaging | New Feature |
| COMPARISONNET-1175 | Add supporting of comparison CAD | New Feature |
| COMPARISONNET-1217 | Add support for JPG, BMP and PNG formats | New Feature |
| COMPARISONNET-1170 | GroupDocs.Comparison.PDF: Add comparison of page context before building of the object model | New Feature |
| COMPARISONNET-1273 | GroupDocs.Comparison.Words: Add support of setting for cloning document metadata | New Feature |
| COMPARISONNET-1295 | Add support of Emails format by GroupDocs.Comparison for .NET | New Feature |
| COMPARISONNET-1276 | GroupDocs.Comparison all formats: Add support of Check Box and Page in Change Info | New Feature |
| COMPARISONNET-1272 | GroupDocs.Comparison.Words: Add ability of applying or discarding for category of changes | New Feature |
| COMPARISONNET-1274 | GroupDocs.Comparison: All formats: Add support of style settings: bold, italic, underline and strike through | New Feature |
| COMPARISONNET-1332 | Add setting for cloning passwords for all formats | New Feature |
| COMPARISONNET-1331 | Groupdocs.Comparison: Add setting for cloning metadata | New Feature |
| COMPARISONNET-1339 | Add ability of applying or discarding for category of changes | New Feature |
| COMPARISONNET-1407 | Add coordinates of Images as Styles | New Feature |
| COMPARISONNET-1395 | Add ParagraphMerger | New Feature |
| COMPARISONNET-1387 | Add set password to document for PDF | New Feature |
| COMPARISONNET-1367 | Comparison.Cells: Add support Headers and Footers | New Feature |
| COMPARISONNET-1365 | Add support for headers and footers for pivot tables | New Feature |
| COMPARISONNET-1362 | Add support of pivot tables in Cells | New Feature |
| COMPARISONNET-1305 | Add support of OneNote format by GroupDocs.Comparison for .NET | New Feature |
| COMPARISONNET-778 | Implement the process absorbing of tables with merged cells | Improvement |
| COMPARISONNET-1148 | Improved public API | Improvement |
| COMPARISONNET-1161 | Add ability for comparison of result and original files in Imaging.Tests | Improvement |
| COMPARISONNET-1157 | Add localize exceptions for wrong passwords while opening documents in Cells, Words, Slides and PDF | Improvement |
| COMPARISONNET-1188 | Improve comparison of Imaging formats | Improvement |
| COMPARISONNET-1182 | Cross-format API simplifications across all supported formats | Improvement |
| COMPARISONNET-1080 | Comparison.PDF: Improve comparison changes detection for Paragraphs | Improvement |
| COMPARISONNET-1254 | Strikeout option for deleted/changed text in words comparison | Improvement |
| COMPARISONNET-1237 | GroupDocs.Comparison.Imaging: Improve comparison performance | Improvement |
| COMPARISONNET-1235 | GroupDocs.Comparison.Text: Improve comparison performance | Improvement |
| COMPARISONNET-1218 | Fix the support of new settings for PDF | Improvement |
| COMPARISONNET-1245 | Comparison.Words: Fix case with absolutely different paragraphs | Improvement |
| OMPARISONNET-1244 | Add styles change detection for Comparison.Imaging (height, width) | Improvement |
| COMPARISONNET-1263 | Improve Summary Pages information about comparison results for all formats | Improvement |
| COMPARISONNET-1232 | GroupDocs.Comparison.Slides: Improved comparison performance | Improvement |
| COMPARISONNET-1275 | GroupDocs.Comparison.Words: Add support of UpdateChanges for StyleChanged changes | Improvement |
| COMPARISONNET-1288 | GroupDocs.Comparison.Cells: defining Cells coordinates for components | Improvement |
| COMPARISONNET-1245 | GroupDocs.Comparison.HTML: Improved comparison performance | Improvement |
| COMPARISONNET-1234 | GroupDocs.Comparison.Cell: Improved comparison performance | Improvement |
| COMPARISONNET-1311 | GroupDocs.Comparison.Cells: Introduced IComparisonStyle interface | Improvement |
| COMPARISONNET-1313 | Comparison.Cells: Add clone ability | Improvement |
| COMPARISONNET-1378 | Find correct position of pivot table if its coordinates have already been used | Improvement |
| COMPARISONNET-1372 | Cells comparison improvement | Improvement |
| COMPARISONNET-1358 | GroupDocs.Comparison.Slides: Add support of HyperLinks on Shape | Improvement |
| COMPARISONNET-1326 | Update logger | Improvement |
| COMPARISONNET-1409 | Pdf Improvements:Check compare and add HeaderFooter to document | Improvement |
| COMPARISONNET-1408 | Pdf Improvements: Update page properties | Improvement |
| COMPARISONNET-1402 | Improve compare of comments in Comparison.Cells | Improvement |
| COMPARISONNET-1400 | Refactoring for settings code | Improvement |
| COMPARISONNET-1396 | Remove null checking from FeelChild method | Improvement |
| COMPARISONNET-1390 | Improve Comparison.Note | Improvement |
| COMPARISONNET-1431 | Comparison.Pfd: Refactor document builder using new content map | Improvement |
| COMPARISONNET-1429 | Comparison.Pdf: Implement page content map | Improvement |
| COMPARISONNET-1427 | Pdf Improving: Check and fix colums comparing | Improvement |
| COMPARISONNET-1424 | Improve Style changed deep for Comparison.Note | Improvement |
| COMPARISONNET-1422 | Add ParagraphMerger for Comparison.Note | Improvement |
| COMPARISONNET-1420 | Update pdf structure | Improvement |
| COMPARISONNET-1418 | Add IntermediateParagraphComparer to Words | Improvement |
| COMPARISONNET-1160 | PDF Comparison - PDF files with tables and footer lines generating unexpected output | Bug |
| COMPARISONNET-1184 | GroupDocs.Comparison.Words: Text files with html content compared by Words engine | Bug |
| COMPARISONNET-1185 | GroupDocs.Comparison.Text: Fix compare html code in .txt files using word comparer | Bug |
| COMPARISONNET-1200 | GroupDocs.Comparison.PDF: Fix bug when the text from the paragraphs overlaps tables | Bug |
| COMPARISONNET-1208 | Disposed Images in Facade | Bug |
| COMPARISONNET-1256 | New Version 17.4.0 have Missing Properties for ChangeInfo | Bug |
| COMPARISONNET-1246 | Comparison.Slides: Two almost identical comments compared as different | Bug |
| COMPARISONNET-1292 | Comparison.Slides: wrong style of table cells after reject or accept the changes | Bug |
| COMPARISONNET-1300 | Comparison.Slides: After rejection of deleted SmartNode was lost content | Bug |
| COMPARISONNET-1284 | Comparison.Words: Incorrect table comparison with different styles | Bug |
| COMPARISONNET-1314 | Comparison.Cells: Fix getting style change when content of the cell is not changed | Bug |
| COMPARISONNET-1333 | Fix getting style change when content of the cell is not changed | Bug |
| COMPARISONNET-1315 | Comparison.Cells: Improve accepting and rejecting of components with hyperlinks | Bug |
| COMPARISONNET-1370 | Licensing is not working | Bug |
| COMPARISONNET-1315 | Comparison.Cells: Improve accepting and rejecting of components with hyperlinks | Bug |
| COMPARISONNET-1376 | Summary Page is not working with API v 17.7.0 | Bug |
| COMPARISONNET-1291 | Comparison.Slides: Accept\\Reject bugs | Bug |
| COMPARISONNET-1410 | Fix summary page style | Bug |
| COMPARISONNET-1405 | Fix Deep Changed Nodes | Bug |
| COMPARISONNET-1399 | Fix saveImages and getImages methods for Comparison.Note | Bug |
| COMPARISONNET-1394 | Bug with same text divided on different paragraphs | Bug |
| COMPARISONNET-1392 | Bug with excess outline | Bug |
| COMPARISONNET-1385 | issue in Getting author for the changes (Changeinfo) | Bug |
| COMPARISONNET-1433 | Intermediate paragraphs problem in Word | Bug |
| COMPARISONNET-1432 | Comparison.Note: Fix special cases of word division | Bug |
| COMPARISONNET-1430 | Comparison.Note:Break line in the middle of a word | Bug |
| COMPARISONNET-1428 | Fix infinite loop in image rectangle PDF | Bug |
| COMPARISONNET-1423 | Comparison.Note Insert\\Delete empty paragraph before text | Bug |
| COMPARISONNET-1421 | Tables with similar coordinates overlap on each other | Bug |
| COMPARISONJAVA-419 | For RTF comparison, API detects style changes but does not highlight them like it does with DOCX. | Bug |
| COMPARISONJAVA-418 | Comparison of particular PDFs returns null | Bug |
| COMPARISONJAVA-383 | Invalid comparison for PDF documents | Bug |
| COMPARISONJAVA-380 | Comparing a file with itself, gives poor result | Bug |
| COMPARISONJAVA-377 | HTML Comparison is not working | Bug |
| COMPARISONNET-1523 | PDF Comparison - scrambled/text overlapped output | Bug |
| COMPARISONJAVA-226 | Comparer is not comparing any format and returning null in ICompareResult | Bug |
| COMPARISONJAVA-421 | Output of PDF comparison is not as expected, all the text exceeding first line is missing | Bug |
| COMPARISONJAVA-420 | No style changes are detected in PDF comparison and PDF is also truncated in multiple places | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Comparison for Java 18.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Comparison which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

None.
