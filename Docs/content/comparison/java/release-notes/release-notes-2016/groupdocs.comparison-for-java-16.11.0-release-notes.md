---
id: groupdocs-comparison-for-java-16-11-0-release-notes
url: comparison/java/groupdocs-comparison-for-java-16-11-0-release-notes
title: GroupDocs.Comparison for Java 16.11.0 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparsion for Java 16.11.0{{< /alert >}}

## Major Features

*   Improved the comparison of tables for Comparison.Words
*   Improved the comparison of tables for Comparison.PDF
*   Improved Comparison.Cells performance
*   Improved comparison for contents list for Comparison.Words
*   Introduced forms comparison support for Comparison.Words
*   Introduced support of multi-language documents  for Comparison.Words
*   Introduced support of WordArt objects for Comparison.Words
*   Introduced support of comparison of comments for Comparison.Words
*   Introduced new paragraph absorber for Comparison.PDF
*   Introduced new table absorber for Comparison.PDF
*   Introduced multiple comparison support for Comparison.Words
*   Introduced apply/discart support for multiple comparison for Comparison.Words
*   Introduced page header and foooter text absorbers for Comparison.PDF
*   Improved  paragraph absorber for Comparison.PDF
*   Introduced  support for new components in Comparison.Slides: comments, charts
*   Introduced support for watermarks  in Comparison.PDF
*   Introduced support for new components in Comparison.PDF: media objects, image positioning
*   Improved ComparisonParagraphAbsorber for cases with tables
*   Introduced support for new components in Comparison.Slides: objects with VBA scripts, style changes detection, detection of Picture Frames
*   Fixed issues with Comparison.Words with nested paragraphs
*   Fixed issues with Comparison.Cells with table structures
*   Improved ComparisonParagraphAbsorber for cases with tables

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| COMPARISONNET-792 | GroupDocs.Comparison.Words: Add page numbers comparison | New Feature |
| COMPARISONNET-818 | GroupDocs.Comparison.Words: Add group shapes support | New Feature |
| COMPARISONNET-856 | GroupDocs.Comparison.Words: comparison of comments | New Feature |
| COMPARISONNET-857 | GroupDocs.Comparison.Words: comparison of WordArt objects | New Feature |
| COMPARISONNET-858 | GroupDocs.Comparison.Words: comparison of Table in table | New Feature |
| COMPARISONNET-854 | GroupDocs.Comparison.Words: comparison of Forms | New Feature |
| COMPARISONNET-855 | GroupDocs.Comparison.Words: comparison of multi-language | New Feature |
| COMPARISONNET-669 | GroupDocs.Comparison.PDF: object model of Paragraph | New Feature |
| COMPARISONNET-853 | GroupDocs.Comparison.Words: comparison of objects with VBA scripts | New Feature |
| COMPARISONNET-738 | GroupDocs.Comparison.PDF: implementation of absorber of paragraphs for the basic cases | New Feature |
| COMPARISONNET-877 | GroupDocs.Comparison.Words: Add option to compose multiple result list from result lists of each document | New Feature |
| COMPARISONNET-876 | GroupDocs.Comparison.Words: Support comparing multiple documents with track changes | New Feature |
| COMPARISONNET-909 | GroupDocs.Comparison.PDF: Add support of absorption of the Page Footer | New Feature |
| COMPARISONNET-910 | GroupDocs.Comparison.PDF: Add support of absorption of the Page Header | New Feature |
| COMPARISONNET-880 | GroupDocs.Comparison.Words: Add apply/discard changes support for multiple result changes list | New Feature |
| COMPARISONNET-970 | GroupDocs.Comparison.PDF: add support for new components: media objects, image positioning | New Feature |
| COMPARISONNET-961 | GroupDocs.Comparison.PDF: add support of comparing watermarks | New Feature |
| COMPARISONNET-962 | GroupDocs.Comparison.Slides: Add support of comparing charts | New Feature |
| COMPARISONNET-965 | GroupDocs.Comparison.Slides: Add support of comparing comments | New Feature |
| COMPARISONNET-1009 | GroupDocs.Comparison.Slides: Add support of comparing objects with VBA scripts | New Feature |
| COMPARISONNET-1013 | GroupDocs.Comparison.Slides: Add support of style changes detection | New Feature |
| COMPARISONNET-1026 | GroupDocs.Comparison.Slides: add support of detection of Picture Frames | New Feature |
| COMPARISONNET-782 | GroupDocs.Comparison.Words: Improve the comparison of tables, Some tables differ on two cell but algorithm not defined the tables as similar | Improvement |
| COMPARISONNET-783 | GroupDocs.Comparison.Words: Improve comparison for contents list | Improvement |
| COMPARISONNET-817 | GroupDocs.Comparison.Cells: Improve cells performance | Improvement |
| COMPARISONNET-687  | GroupDocs.Comparison.PDF: Improve working with tables | Improvement |
| COMPARISONNET-864 | GroupDocs.Comparison.PDF: implementation of tables absorption for simple cases | Improvement |
| COMPARISONNET-776 | GroupDocs.Comparison.PDF: Implement the function CleanOperatorsList | Improvement |
| COMPARISONNET-880 | GroupDocs.Comparison.Words: Document processing performance improvement | Improvement |
| COMPARISONNET-886 | GroupDocs.Comparison.PDF: Divide text into paragraphs by checking if the text fragments are contained in different parent objects | Improvement |
| COMPARISONNET-904 | GroupDocs.Comparison.PDF: Improved Comparison paragraph absorber for cases with plain text | Improvement |
| COMPARISONNET-873 | GroupDocs.Comparison.PDF: Improved text comparison support for all Adobe Acrobat formats | Improvement |
| COMPARISONNET-949 | GroupDocs.Comparison.PDF: improve compare tables | Improvement |
| COMPARISONNET-903 | GroupDocs.Comparison.PDF: improve ComparisonParagraphAbsorber for cases with tables | Improvement |
| COMPARISONNET-982 | GroupDocs.Comparison.PDF: improve document builder and page mapper | Improvement |
| COMPARISONNET-904 | GroupDocs.Comparison.PDF:Checking and improving of ComparisonParagraphAbsorber for cases with plain text | Improvement |
| COMPARISONNET-1015 | GroupDocs.Comparison.Slides: Improve comparison performance | Improvement |
| COMPARISONNET-1012 | GroupDocs.Comparison.Slides: Extend engine to support all kind of images | Improvement |
| COMPARISONNET-957 | Cross-format engine: The case the comparison of tables with different results for all formats | Improvement |
| COMPARISONNET-970 | GroupDocs.Comparison.PDF:Add support for new components to new core | Improvement |
| COMPARISONNET-698 | GroupDocs.Comparison.PDF: Fix bug when you can not open document with tables after comparison | Bug |
| COMPARISONNET-727 | GroupDocs.Comparison.Words: Files generating zero output (no change is detected ) for attached files only | Bug |
| COMPARISONNET-736 | GroupDocs.Comparison.PDF: Some tables differ on two cell but algorithm not defined the tables as similar | Bug |
| COMPARISONNET-795 | GroupDocs.Comparison.Words: The target file is modification of source file but defined as different | Bug |
| COMPARISONNET-850 | GroupDocs.Comparison.Words:Cannot open result file: graphics objects | Bug |
| COMPARISONNET-851 | GroupDocs.Comparison.Words:Some images (or graphical objects) are not displayed | Bug |
| COMPARISONNET-888 | Result of comparison is System.ArgumentException: Invalid font name | Bug |
| COMPARISONNET-883 | TablesAligner for Pdf: fix function GetText of ComparisonCell class | Bug |
| COMPARISONNET-968 | GroupDocs.Comparison.Words: Identical text from neighboring paragraphs is defined as deleted and inserted | Bug |
| COMPARISONNET-964 | GroupDocs.Comparison.Slides: Files are not opened after comparison | Bug |
| COMPARISONNET-966 | GroupDocs.Comparison.Cells: If content of row is unique then row should be marked as Inserted or Deleted | Bug |
| COMPARISONNET-967 | GroupDocs.Comparison.Cells: The result table structure not conforming to primary table structure | Bug |
| COMPARISONNET-946 | GroupDocs.Comparison.Words: Exception: The newChild was created from a different document than the one that created this node. | Bug |
| COMPARISONNET-107 | Comparing PDF documents neither generate any error nor the output PDF with Gradle | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Comparison for Java 16.11.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Comparison which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### MultiCompareWith: Support comparing multiple documents with track changes

### Compare words documents - Compare source document with two target documents.

```java
// Create list of targets documents
List<IComparisonDocument> ListOfTargetDocuments = new ArrayList<IComparisonDocument>();

// Open documents
ComparisonDocument source = new ComparisonDocument(sourcePath);
ComparisonDocument target1 = new ComparisonDocument(target1Path);
ComparisonDocument target2 = new ComparisonDocument(target2Path);

// Add target documents in list
ListOfTargetDocuments.add(target1);
ListOfTargetDocuments.add(target2);

// Call method MultiCompareWith.
IWordsCompareResult result = source.multiCompareWith(ListOfTargetDocuments, new WordsComparisonSettings());

```

### Compare source document with three target documents.

```java
// Create list of targets documents
List<IComparisonDocument> ListOfTargetDocuments = new ArrayList<IComparisonDocument>();

// Open documents
ComparisonDocument source = new ComparisonDocument(sourcePath);
ComparisonDocument target1 = new ComparisonDocument(target1Path);
ComparisonDocument target2 = new ComparisonDocument(target2Path);
ComparisonDocument target3 = new ComparisonDocument(target3Path);

// Add target documents in list
ListOfTargetDocuments.add(target1);
ListOfTargetDocuments.add(target2);
ListOfTargetDocuments.add(target3);

// Call method MultiCompareWith.
IWordsCompareResult result = source.multiCompareWith(ListOfTargetDocuments, new WordsComparisonSettings());

```
