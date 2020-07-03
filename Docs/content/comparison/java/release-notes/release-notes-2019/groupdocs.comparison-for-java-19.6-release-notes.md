---
id: groupdocs-comparison-for-java-19-6-release-notes
url: comparison/java/groupdocs-comparison-for-java-19-6-release-notes
title: GroupDocs.Comparison for Java 19.6 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparsion for Java 19.6{{< /alert >}}

## Major Features

Below is the list of most notable changes in release of GroupDocs.Comparsion for Java. The most notable are:

*   Added comparison of group shapes for Diagrams
*   Implemented adding shape without Diagram’s Master
*   Improved Paragraph Comparer for Diagram’s
*   Improved StyleSheet Comparer for Html
*   Fixed issue with Style changes not highlighted in some specific cases of PDF documents comparison
*   Improved PDF Comparison in some specific cases
*   Improved aligner for HTML that increased comparison accuracy
*   Fixed and improved Anchors tags on Comparison.HTML
*   Improved tables comparison for Slides
*   Fixed issue with comparing tables with different styles
*   Fixed comparing styles of the first column of the table
*   Fixed issue with incorrect size of result Slides documents
*   Improved chart comparison for Slides
*   Insured and made needed changes to Comparison to make it thread-safe
*   Improved comparison tester for Words
*   Improve style detection on Slides
*   Fixed issue with AutoShapes in Slides
*   Improved large sized files comparing in PDF
*   Improved worksheet name generation in result file
*   Implemented chart title comparing in Cells
*   Implemented autosize in auto shapes in result file generation on Cells documents
*   Implemented chart generation in result files (instead of picture) on Cells
*   Improved Paragraph absorber in PDF for comparing speed increase
*   Fixed issue with setting paragraphs line
*   Fixed issue in setting Hyperlinks in big size PDF file
*   Full List of Issues Covering all Changes in this Release
*   Implemented ability to convert documents of different formats to images
*   Fixed issue with SuperScript and SubScript elements on Words documents
*   Fixed style settings for GroupDocs.Comparison.Html
*   Fixed issue with comparing large sized PDF files (another cases)
*   Fixed not working comparison of EndNote element on Words
*   Implemented calculation of changes for Diagrams, Slides and PDF formats
*   Implemented getting document information method
*   Improved exceptions and error handling all around the projects for all supported formats
*   Fixed issue with getting images for HTML files
*   Fixed issue with Fonts detection
*   Fixed incorrect different in PDF
*   Improved changes detection in tables on Words documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| COMPARISONNET-1605 | Implement Group Shapes for Diagrams | Feature |
| COMPARISONNET-1587 | Implement comparison different formats as image | Feature |
| COMPARISONNET-1607 | Implement GluedShapes in Diagram | Feature |
| COMPARISONNET-1637 | Implement new Setting for text highlighting Comparison.Html | Feature |
| COMPARISONNET-1636 | Implement new Setting for text highlighting Comparison.Slides | Feature |
| COMPARISONNET-1635 | Implement new Setting for text highlighting Comparison.Notes | Feature |
| COMPARISONNET-1634 | Implement new Setting for text highlighting Comparison.Pdf | Feature |
| COMPARISONNET-1633 | Implement new Setting for text highlighting Comparison.Words | Feature |
| COMPARISONNET-1836 | Save documents as images for Words | Feature |
| COMPARISONNET-1837 | Save documents as images for Cells | Feature |
| COMPARISONNET-1838 | Save documents as images for Slides | Feature |
| COMPARISONNET-1839 | Save documents as images for PDF | Feature |
| COMPARISONNET-1840 | Save documents as images for HTML | Feature |
| COMPARISONNET-1841 | Save documents as images for Email | Feature |
| COMPARISONNET-1842 | Save documents as images for Note | Feature |
| COMPARISONNET-1843 | Save documents as images for Text | Feature |
| COMPARISONNET-1844 | Save documents as images for Diagrams | Feature |
| COMPARISONNET-1847 | Calculate correct coordinates of changes for Slides | Feature |
| COMPARISONNET-1849  | Calculate correct coordinates of changes for PDF | Feature |
| COMPARISONNET-1852  | Calculate correct coordinates of changes for Diagrams | Feature |
| COMPARISONNET-1895  | Implement Get document info method | Feature |
| COMPARISONNET-1608 | Improve StyleSheet Comparer for Html | Improvement |
| COMPARISONNET-1606 | Add shape without Diagram's Master | Improvement |
| COMPARISONNET-1645 | Security improvements update | Improvement |
| COMPARISONNET-1644 | Improve PDF mapper | Improvement |
| COMPARISONNET-1640 | Improve support of comparing different formats with image | Improvement |
| COMPARISONNET-740  | Improve Html Anchors comparing | Improvement |
| COMPARISONNET-753 | Improve PDF comparison | Improvement |
| COMPARISONNET-758 | Improve HTML aligner | Improvement |
| COMPARISONNET-1725  | Improve TableFormatSetter for Slides | Improvement |
| COMPARISONNET-1734  | Make Comparison thread-safe | Improvement |
| COMPARISONNET-1748 | Improve charts comparing on Slides | Improvement |
| COMPARISONNET-1739 | Improve style detection on Slides | Improvement |
| COMPARISONNET-735  | Improve comparison tester for Words | Improvement |
| COMPARISONNET-1738 | Improve paragraph absorber in result document | Improvement |
| COMPARISONNET-1742 | Improve charts comparing on Cells | Improvement |
| COMPARISONNET-1773  | Error handling improvements for all formats | Improvement |
| COMPARISONNET-1799  | Improve change detection in tables on Words | Improvement |
| COMPARISONJAVA-589 | Add functionality to replace missing fonts either automatically or with an setting | Improvement |
| COMPARISONNET-1619 | Output of PDF with images is not as expected | Bug |
| COMPARISONNET-1620 | Output of PDF with graphs is not as expected | Bug |
| COMPARISONNET-1619 | Output of PDF with images is not as expected | Bug |
| COMPARISONNET-752  | Error when comparing Words files protected with password | Bug |
| COMPARISONNET-750 | Cannot compare PDF documents | Bug |
| COMPARISONNET-1727 | Slides table does not display text style change | Bug |
| COMPARISONNET-1726 | Slides: issue with table theme | Bug |
| COMPARISONNET-1724  | Slides: issue when comparing styles in first column | Bug |
| COMPARISONNET-1723 | Slides: issue with a sizes of result document | Bug |
| COMPARISONNET-1744 | Fix issues with autoshape on Slides | Bug |
| COMPARISONNET-1760 | Incorrect Sheet Name in result file in Cells | Bug |
| COMPARISONNET-1747 | Issue in comparing large sized PDF files | Bug |
| COMPARISONNET-1769 | Issue when setting ParaghraphLines. | Bug |
| COMPARISONNET-1766 | Issue in setting Hyperlinks in big size PDF file | Bug |
| COMPARISONNET-1806 | Issue on SuperScript and SubScript | Bug |
| COMPARISONNET-1802 | Settings StyleSettings is not working for html | Bug |
| COMPARISONNET-1803 | Issue in comparing large sized PDF files (another cases) | Bug |
| COMPARISONNET-1804 | EndNote Comparison is not working | Bug |
| COMPARISONNET-1808  | Comparison is not working on Footnote | Bug |
| COMPARISONNET-1772  | PDF comparison has overlapping and mangled output | Bug |
| COMPARISONNET-1774  | Can't get images for HTML files | Bug |
| COMPARISONNET-1805  | Deleted items in comparison output is not as expected | Bug |
| COMPARISONNET-1892  | Incorrect difference info in PDF | Bug |
| COMPARISONNET-1899  | Html MarkDeletedInsertedContentDeep Bug | Bug |
| COMPARISONNET-1903  | License issue in GroupDocs.Comparison for .NET application | Bug |
| COMPARISONNET-1906  | Font detection exception | Bug |
| COMPARISONNET-1909  | Word separation exception | Bug |
| COMPARISONJAVA-147 | Cannot compare two PDF files using GroupDocs.Comparison for Java 17.3.0 | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Comparison for Java 19.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Comparison which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Use "DiagramMasterSetting" to manage masters of the Comparison.Diagram.
    
    ```java
    setMasterPath(String);// - User set custom master path
    setUseSourceMaster(boolean);// - true - use master from source and target together, false - use default or custom master
    ```
    
    Example:
    
    *   UseSourceMaster – false without MasterPath - use default master path
    *   UseSourceMaster – false with MasterPath - use custom master path
    *   UseSourceMaster – true - use master from source and target documents together
    
    Use "OriginalSize" to set document size when comparing image with different formats, this size will be used when document is converted to the picture.
    
    ```java
    OriginalSize -> setWidth(...);// int
    OriginalSize -> setHeigth(...);// int;
    ```
    
      
    
2.  Inserted, deleted and style changed items styles setting used for set font color, highlight color , styles(bold, italic, underline, strike through) and tags for marked changes in result document.
    
    ```java
    settings.getInsertedItemsStyle().setFontColor(Color.getBrown());
    settings.getInsertedItemsStyle().setHighlightColor(Color.getRed());
    settings.getInsertedItemsStyle().setBeginSeparatorString("<inserted>");
    settings.getInsertedItemsStyle().setEndSeparatorString("</inserted>");
    ```
    
    ```java
    settings.getDeletedItemsStyle().setFontColor(Color.getAquamarine());
    settings.getDeletedItemsStyle().setHighlightColor(Color.getBlue());
    settings.getDeletedItemsStyle().setBeginSeparatorString("<deleted>");
    settings.getDeletedItemsStyle().setEndSeparatorString("</deleted>");
    ```
    
    ```java
    settings.getStyleChangedItemsStyle().setFontColor(Color.getAqua());
    settings.getStyleChangedItemsStyle().setHighlightColor(Color.getGreen());
    settings.getStyleChangedItemsStyle().setBeginSeparatorString("<style>");
    settings.getStyleChangedItemsStyle().setEndSeparatorString("</style>");
    ```
    
      
    
3.   Getting Image representation of document pages.
    
    ```java
    Comparer comparer = new Comparer();
    ComparisonSettings cs = new ComparisonSettings();
    cs.setStyleChangeDetection(true);
     
     
    //compare document
    ICompareResult result = comparer.compare(sourcePath, targetPath, cs);
    result.saveDocument(resultPath);
     
     
    //get list of pages
    List<PageImage> resultImages = comparer.convertToImages(resultPath);
     
     
    //save them as bitmap to separate folder
    if (!new File(savePath + "/Result Pages").exists()) 
       new File(savePath + "/Result Pages").mkdir();
     
     
    for (PageImage image : resultImages)
    { 
         BufferedImage bitmap = ImageIO.read(image.getPageStream()); 
         ImageIO.write(bitmap, "png", new FileOutputStream(savePath + "/Result Pages/result_" + image.getPageNumber() + ".png")); 
    }
    ```
