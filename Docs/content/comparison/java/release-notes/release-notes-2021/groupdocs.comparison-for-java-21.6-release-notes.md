---
id: groupdocs-comparison-for-java-21-6-release-notes
url: comparison/java/groupdocs-comparison-for-java-21-6-release-notes
title: GroupDocs.Comparison for Java 21.6 Release Notes
weight: 20
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparison for Java 21.6{{< /alert >}}

## Major Features

Below is the list of most notable changes in release of GroupDocs.Comparison for Java 21.6:

*   Refactor getDocumentInfo Method for Cells
*   Improved comparing of DocumentTags Word
*   Improved sheet rendering for Cells
*   Fixed invalid page height and width in getChanges method
*   Fixed issue with  comparing problem with tables in PDF
*   Added ability to merge source code file
*   Added more options for SummaryPage
*   Fixed issue with style comparison in the types math formula in word
*   Fixed issue with comparing PDF protected with password documents
*   Fixed incorrect counting of changes in SummaryPage
*   Fixed comparing span tags in HTML document
*   Fixed number of issues with HTML documents comparing
*   Extended SummaryPage
*   Fixed issue with comparing complex PDF documents
*   Fixed comparing PDF without license
*   Fixed wrong comparing of hyperlinks in Word documents
*   Improved comparing tables with several columns of different sizes in a Word Document
*   Improved accept\reject changes Words document
*   Added SaveOriginalState option for applyChanges method
*   Improved images output
*   Fixed issue with comparing tables on Words documents
*   Fixed issue with numbered list in output document
*   Fixed issue when losses anchor and range information for all the comments
*   Added comparison of bookmarks for Word format
*   Added comparison of variables and document properties for Word format
*   Added the ability to load custom fonts for a documents
*   Improved image comparison and image positioning after comparison for Cells format
*   Fixed comparison of Pen images for Word format
*   Fixed сomparison crashes for particular Word files
*   Fixed getting special revisions from document
*   Improve Revisions handling in Words documents
*   Fixed issue with text duplication in Words
*   Fixed issue with incorrect display of tables without displaying added or deleted cells
*   Improved display of elements with a border in Pdf format
*   Improved text display in Pdf format
*   Added comparison of footnote types in Word format
*   Added SourceText property to ChangeInfo class and improved TargetText property for Cells, Words and Pdf formats
*   Fixed closing the stream after generating preview in PDF format
*   Fixed generating previews in Diagram format
*   Fixed generating previews in HTML format
*   Fixed saving the comparison result in HTML format using the file stream
*   Improved comparison in Excel format using pictures and diagrams
*   Improved TargetText property for Diagram, Slide, Txt and Note formats

| Key | Summary | Issue Type |
| --- | --- | --- |
| COMPARISONNET-2416 | Add more SummaryPage options | Feature |
| COMPARISONNET-2425 | Add ExtendedSummaryPage option | Feature |
| COMPARISONNET-2483 | Accept or reject all changes in a single Word Document | Feature |
| COMPARISONNET-2427 | Added SaveOriginalState option for ApplyChanges method | Feature |
| COMPARISONNET-2133 | Comparison of bookmarks for Word format | Feature |
| COMPARISONNET-2145 | Ability to load custom fonts for a documents | Feature |
| COMPARISONNET-2585 | Improve ability of getting source text for Words documents | Feature |
| COMPARISONNET-2586 | Improve ability of getting source text for PDF documents | Feature |
| COMPARISONNET-2587 | Improve ability of getting source text for Cells documents | Feature |
| COMPARISONNET-2134 | Comparison of variables and document properties for Word format | Feature |
| COMPARISONJAVA-822 | Implement ShowInsertedContent Function | Feature |
| COMPARISONJAVA-882 | Comments comparison in Presentation slides | Improvement |
| COMPARISONNET-2383 | Comparison.Cells Compare empty cells with a modified style | Improvement |
| COMPARISONNET-2380 | Refactor getDocumentInfo Method for Cells | Improvement |
| COMPARISONNET-2388 | Improving sheet rendering for Cells | Improvement |
| COMPARISONNET-2384 | Improve comparing of DocumentTags Word | Improvement |
| COMPARISONNET-2458 | Improved images output | Improvement |
| COMPARISONNET-2140 | Issue with comparing images and their position after comparison in Cell format | Improvement |
| COMPARISONNET-2557 | Improve Revisions handling in Words documents | Improvement |
| COMPARISONNET-2563 | Footnotes are not compared | Improvement |
| COMPARISONNET-2595 | Improve ability of getting source text for Diagrams documents | Improvement |
| COMPARISONNET-2594 | Improve ability of getting source text for Slides documents | Improvement |
| COMPARISONNET-2589 | Improve ability of getting source text for Text documents | Improvement |
| COMPARISONNET-2598 | Improve ability of getting source text for Notes documents | Improvement |
| COMPARISONNET-2387 | Invalid page height and width in getChanges method | Bug |
| COMPARISONNET-2385 | Cells error comparing with table tools | Bug |
| COMPARISONNET-2412 | Incorrect style comparison in the types math formula in word | Bug |
| COMPARISONNET-2421 | Comparing two PDF files, incorrect password exception | 	Bug |
| COMPARISONNET-2420 | Incorrect counting of changes in SummaryPage | Bug |
| COMPARISONNET-2418 | Html fix comparing of span tags | 	Bug |
| COMPARISONNET-2351 | HTML comparison issue | 	Bug |
| COMPARISONNET-2422 | The problem when comparing tables with several columns of different sizes in a Word Document | Bug |
| COMPARISONNET-2419 | Comparing two Word files doesn't show deleted comment | Bug |
| COMPARISONNET-2455 | Wrong comparing of Hyperlinks in word | Bug |
| COMPARISONNET-2456 | Issue in comparing complex PDF files | Bug |
| COMPARISONNET-2457 | Simple PDF comparison without license returns nothing | Bug |
| COMPARISONNET-2487 | Numbered List issue in the output document | Bug |
| COMPARISONNET-2482 | Word comparison doesn't show inserted/deleted table | Bug |
| COMPARISONNET-2481 | The result of comparison loses anchor and range information for all the comments | Bug |
| COMPARISONNET-2477 | Same images appear as inserted or deleted in Word comparison | Bug |
| COMPARISONNET-2100 | Pen results comparison issue | Bug |
| COMPARISONNET-2146 | Comparison crashes for particular Word files | Bug |
| COMPARISONNET-2151 | Error getting revisions | Bug |
| COMPARISONNET-2513 | Comparison crashes for particular Word files| Bug |
| COMPARISONNET-2537 | Comparison of DOCX files Text is duplicated after comparison, rather than being recognized as replaced in the output | Bug |
| COMPARISONNET-2533 | Comparison issue in Word documents with tables (Incorrect document creation with disabled display of changes in tables in Word format) | Bug |
| COMPARISONNET-2451 | Text Box Comparison issue in PDF | Bug |
| COMPARISONNET-2454 | Part of the symbols are not displayed when comparing PDF files | Bug |
| COMPARISONNET-2592 | Cannot compare particular Excel sheets | Bug |
| COMPARISONNET-2599 | Preview generator closes stream for pdf | Bug |
| COMPARISONNET-2600 | Diagram preview does not insert text inside shapes | Bug |
| COMPARISONNET-2603 | Incorrect display of Excel document | Bug |
| COMPARISONNET-2602 | Charts are not displayed in Excel format | Bug |
| COMPARISONNET-2601 | HTML preview renders only one image | Bug |
| COMPARISONJAVA-870 | Table of contents comparison wrong results | Bug |
| COMPARISONJAVA-869 | Pen comparison results issue | Bug |
| COMPARISONJAVA-876 | Issue in comparing Excel files with table tools | Bug |
| COMPARISONJAVA-928 | Text Box Comparison issue in PDF | Bug |
| COMPARISONJAVA-937 | Graph comparison issue in Excel | Bug |
| COMPARISONJAVA-975 | Document comparison shows no difference and a warning message in the output | Bug |
| COMPARISONJAVA-978 | Expected Spreadsheets with images comparison output | Bug |
| COMPARISONJAVA-977 | Find character string before and after the difference | Bug |

## Public API and Backward Incompatible Changes

*   [How to merge source code files](https://docs.groupdocs.com/comparison/java/how-to-merge-source-code-files/)
*   [Get only summary page](https://docs.groupdocs.com/comparison/java/get-only-summary-page/)
*   [How to get extended information on the summary page](https://docs.groupdocs.com/comparison/java/get-extended-information-on-the-summary-page/)
*   [SaveOriginalState option for ApplyChanges method](https://docs.groupdocs.com/comparison/java/accept-or-reject-detected-changes/)
*   [Accept or Reject revisions﻿](https://docs.groupdocs.com/comparison/java/accept-or-reject-revisions/)
*   [Сomparison of bookmarks for Word format](https://docs.groupdocs.com/comparison/java/compare-bookmarks-in-word/)
*   [Comparison of variables and document properties for Word format](https://docs.groupdocs.com/comparison/java/compare-of-variables-and-document-properties/)
*   [Ability to load custom fonts](https://docs.groupdocs.com/comparison/java/load-custom-fonts/)
*   [Improved Accept\Reject Revisions functionality for Words documents](https://docs.groupdocs.com/comparison/java/accept-or-reject-revisions/)
*   Updated documentation about obtaining source and target texts, which can be found [here](https://docs.groupdocs.com/comparison/java/get-source-and-target-text-from-files/).

*   The problem with redisplaying changed content in a document occurred when there were already other *Revisions* in the documents being compared.

**Revision** - changes received when comparing documents using built-in Word tools.

To solve this problem, new *ShowRevisions* property was created that allows you to disable the display of these *Revisions* in the resulting document. An example of the code for using the new property is presented below.
*   Learn more about getting source and target texts, which can be found [here](https://docs.groupdocs.com/comparison/java/get-source-and-target-text-from-files/)

```java
try (Comparer comparer = new Comparer(sourcePath)) {
    comparer.add(targetPath);
    CompareOptions options = new CompareOptions();
    options.setShowRevisions(false);
    final Path resultPath = comparer.compare(RESULT_PATH, options);
}
```
More information about the new property can be found [here](https://docs.groupdocs.com/comparison/java/show-revisions/).

*  Comparison of types of footnotes refers to comparison of styles, besides, this type of change is difficult to display in the text. Therefore these changes are marked on the principle of blank lines or pictures in the document (using comments).
   For clarity comparison of footnote types, you could use the following code snippet:

```java
try (Comparer comparer = new Comparer(sourcePath)) {
    comparer.add(targetPath);
    CompareOptions options = new CompareOptions();
    options.setDetectStyleChanges(true);
    options.setDetalisationLevel(DetalisationLevel.High);
    final Path resultPath = comparer.compare(RESULT_PATH, options);
}
```

*  For some reasons result file extension can be changed, so you should use result of `compare` method instead of RESULT_PATH to get result data

```java
try(Comparer comparer = new Comparer(sourcePath)) {
    comparer.add(targetPath);
    final Path resultPath = comparer.compare(RESULT_PATH);
    if(resultPath != null) {
        // Use resultPath (if it is not null) to read the file, instead of RESULT_PATH
    }
}
```