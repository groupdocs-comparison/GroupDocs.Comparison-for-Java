---
id: groupdocs-comparison-for-java-20-4-release-notes
url: comparison/java/groupdocs-comparison-for-java-20-4-release-notes
title: GroupDocs.Comparison for Java 20.4 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparison for Java 20.4{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check Public Docs section. The legacy API have been removed.{{< /alert >}}

Below the list of most notable changes in  release of GroupDocs.Comparison for Java:

*   Added option to compare documents header/footer
*   Added option for specifying paper size for output documents
*   Implemented multicomparing for Text and Email documents
*   Fixed issue with releasing document handlers
*   Improved accuracy for PDF documents comparing
*   Fixed issue with wrong result files in Cells
*   Fixed accuracy of coordinates of changes on document preview
*   Improved showing comparison result without license for TXT, HTML and Images documents
*   Improved annotation comparison for PDF
*   Improve creation result PDF documents 
*   Fixed issue with duplicate Images in Result file in PDF
*   Fixed issue with DeletedItemsStyle in Spreadsheet
*   Fixed PDF comparison acurracy
*   Implemented comparing more than 2 PDF documents
*   Implemented comparing more than 2 Diagrams documents
*   Improve table comparison in PDF    
*   Fixed error when comparing two identical Word documents 

| Key | Summary | Issue Type |
| --- | --- | --- |
| COMPARISONNET-2072 | Add option that will allow to set output format (paper size) | Feature |
| COMPARISONNET-2069 | Implement Multi comparer for Email | Feature |
| COMPARISONNET-2068  | Implement multi comparer for Text | Feature |
| COMPARISONNET-2028  | Add Comparison option to switch header/footer comparison | Feature |
| COMPARISONNET-2104 | Implement Multicomparer for Diagram | Feature |
| COMPARISONNET-2105  | Implement Multicomparer for PDF | Feature |
| COMPARISONNET-2112 | Improve TXT comparison result without a license | Improvement |
| COMPARISONNET-2111 | Improve showing HTML comparison result without a license | Improvement |
| COMPARISONNET-2110 | Improve Imaging comparison result without a license | Improvement |
| COMPARISONNET-2107 | Improve creation result document in Comparison.PDF | Improvement |
| COMPARISONNET-2101 | Improve annotation comparison for PDF | Improvement |
| COMPARISONNET-2133  | Improve table comparison in PDF | Improvement |
| COMPARISONNET-2094   | API is not releasing file handles | Bug |
| COMPARISONNET-2071  | Difference width and height is incorrect | Bug |
| COMPARISONNET-2070   | Wrong Cells result file | Bug |
| COMPARISONNET-2014  | Unexpected amount of changes in the comparing results of a PDF-files. | Bug |
| COMPARISONNET-2012   | Exception during comparing PDF-files without license. | Bug |
| COMPARISONNET-1993 | Incorrect box dimensions and position | Bug |
| COMPARISONNET-1971 | Difference width and height is incorrect | Bug |
| COMPARISONNET-1950 | PDF comparison is not accurate | Bug |
| COMPARISONNET-2108 | Duplicate Images in Result file in PDF | Bug |
| COMPARISONNET-2102 | Issue with Spreadsheet DeletedItemsStyle | Bug |
| COMPARISONNET-1950 | PDF comparison is not accurate | Bug |
| COMPARISONNET-2148  | Error occurred in comparing two identical Word documents | Bug |
| COMPARISONJAVA-764 | Compare PPT/PPTX documents with element movement changes detection | Bug |
| COMPARISONJAVA-698 | Wrong comparing result data | Bug |
| COMPARISONJAVA-699 | Wrong comparing result data | Bug |
| COMPARISONJAVA-607 | In some cases XLSX output is not correct | Bug |
| COMPARISONJAVA-605 | Document comparison issue for Japaneses files | Bug |
| COMPARISONJAVA-346 | Is there a way to keep previous style and font? | Bug |

## Public API and Backward Incompatible Changes

*   In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check **Public Docs** section. The legacy API have been removed.
