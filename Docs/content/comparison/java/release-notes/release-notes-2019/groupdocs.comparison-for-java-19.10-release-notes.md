---
id: groupdocs-comparison-for-java-19-10-release-notes
url: comparison/java/groupdocs-comparison-for-java-19-10-release-notes
title: GroupDocs.Comparison for Java 19.10 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparsion for Java 19.10{{< /alert >}}

## Major Features

Below the list of fixed bugs in this release of GroupDocs.Comparsion for Java. The most notable are:

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
*   Fixed problem when sections moved to the new page
*   Fixed typos in API reference
*   Implemented sensitivity option
*   Implemented calculation coordinates of changes for Words documents
*   Fixed content overlapping in resultant PDF documents
*   Fixed problem when sections moved to the new page
*   Integrated credit based billing system using latest version of Metered
*   Updated namespace to more logical and convenient  (some some of namespaces were renamed)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
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
| COMPARISONNET-1773  | Error handling improvements for all formats | Improvement |
| COMPARISONNET-1799  | Improve change detection in tables on Words | Improvement |
| COMPARISONNET-1846 | Calculate correct coordinates of changes for Words | Improvement |
| COMPARISONNET-1929 | Implement sensitivity option | Improvement |
| COMPARISONNET-1901 | Integrate latest version of Dynabic.Metered into products | Improvement |
| COMPARISONNET-1815 | Ignore comments (for code files mostly). | Improvement |
| COMPARISONNET-1816 | Ignore White Space - All, Leading, Trailing, Changes in amount | Improvement |
| COMPARISONNET-1813 | Ignore Case - Ignore character case differences. | Improvement |
| COMPARISONNET-1931 | Refactor GroupDocs.Comparison namespaces | Improvement |
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
| COMPARISONNET-1906  | Font detection exception | Bug |
| COMPARISONNET-1909  | Word separation exception | Bug |
| COMPARISONNET-1927 | Merged Document and then document Comparison failed | Bug |
| COMPARISONNET-1891 | Text got overlapped with other text or images | Bug |
| COMPARISONNET-1930 | Duplicate Images in Result file in PDF | Bug |
| COMPARISONNET-1772 | PDF comparison has overlapping and mangled output | Bug |
| COMPARISONJAVA-374 | Multithreading comparing returns null | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Comparison for Java 19.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Comparison which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Extended PageImage properties**  
    For now PageImage class was extended by adding 2 public properties *Width* and *Height*
    
    ```java
    Comparer comparer = new Comparer();
    // get the list of pages as images
    List<PageImage> sourceImages = comparer.convertToImages(sourcePath);
    // getting sizes of first page
    int height = sourceImages.get(0).getHeight();
    int width = sourceImages.get(0).getWidth();
    ```
    
2.  **Getting coordinates of changes**  
    
    Getting coordinates of specific changes in Result document is working for **Slides, PDF** and **Diagrams, Word** documents.
    
    To use this feature you should specify in *ComparisonSettings CalculateComponentCoordinates* property
    
    ```java
    ComparisonSetting settings = new ComparisonSetting
    ...
    settings.setCalculateComponentCoordinates(true);
    ...
    ```
    
    The coordinates of changes will be stored in  *Box* property of *ChangeInfo* class
    
    ```java
    Comparer comparer = new Comparer();
    // Settings
    ComparisonSettings comparisonSettings = new ComparisonSettings();
    comparisonSettings.setCalculateComponentCoordinates(true);
    // Compare documents
    ICompareResult compareResult = comparer.compare(sourcePath, targetName, comparisonSettings);
    // Getting sizes of the first change
    ChangeInfo[] changes = compareResult.getChanges();
    // Coordinates of first change
    final Rectangle rectangle = changes[0].getBox();
    ```
    
    Example of further using this option:
    
    ```java
    ComparisonSettings comparisonSettings = new ComparisonSettings();
    comparisonSettings.setStyleChangeDetection(true);
    //this setting specify that we want to have change coordinates
    comparisonSettings.setCalculateComponentCoordinates(true);
    comparisonSettings.setDetailLevel(DetailLevel.High);
     
    Comparer comparer = new Comparer();
    ICompareResult result = comparer.compare(sourcePath, targetPath, comparisonSettings);
    result.saveDocument(resultPath);
     
     
    List<PageImage> resultImages = comparer.convertToImages(resultPath);
    final ChangeInfo[] changes = result.getChanges();
     
     
    // Below the one of cases how we could use changes coordinates.
    // We are passing through pages object and draw a rectangle in the coordinates of changes
    for (PageImage pageImage : resultImages) {
        final InputStream pageStream = pageImage.getPageStream();
        final BufferedImage bufferedImage = ImageIO.read(pageStream);
        final Graphics graphics = bufferedImage.getGraphics();
        for (ChangeInfo changeInfo : changes) {
            final Rectangle rectangle = changeInfo.getBox();
            //if something was Inserted draw a Blue rectange
            if (changeInfo.getType() == TypeChanged.Inserted) {
                graphics.setColor(Color.BLUE);
                graphics.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            }
            //if something was Deleted draw a Red rectange
            if (changeInfo.getType() == TypeChanged.Deleted) {
     
                graphics.setColor(Color.RED);
                graphics.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            }
            //if something was Changes draw a Green rectange
            if (changeInfo.getType() == TypeChanged.StyleChanged) {
                graphics.setColor(Color.GREEN);
                graphics.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            }
        }
        ImageIO.write(bufferedImage, "png", new File(resultPath.replace("result", "result_" + pageImage.getPageNumber()) + ".png"));
        graphics.dispose();
        pageStream.close();
    }
    ```
    
3.  **Getting Image representation of document pages**
    
    ```java
    Comparer comparer = new Comparer();
    ComparisonSettings comparisonSettings = new ComparisonSettings();
    comparisonSettings.setStyleChangeDetection(true);
     
    // Compare document
    ICompareResult result = comparer.compare(sourcePath, targetPath, comparisonSettings);
    result.saveDocument(resultPath);
     
    // Get list of pages
    List<PageImage> resultImages = comparer.convertToImages(resultPath);
     
    // Save them as bitmap to separate folder
    for (PageImage pageImage : resultImages) {
        final InputStream pageStream = pageImage.getPageStream();
     
        Assert.assertNotNull(pageStream);
     
        final BufferedImage bufferedImage = ImageIO.read(pageStream);
        ImageIO.write(bufferedImage, "png", new File(resultPath.replace(resultName, "result_" + pageImage.getPageNumber()) + ".png"));
    }
    ```
    
4.  **New DocumentInfo class**
    
    New *DocumentInfo* class was added. This class contains following properties
    
    *NumberOfPages* (read only) - the count of document pages  
    *PagesData* (read only) - the list of *PageInfo* classes,
    
    *PageInfo* class contains following properties:  
    Width - the width of page  
    Height - the height of page
    
    ```java
    Informer informer = new Informer();
    // Get information about document from filePath
    DocumentInfo documentInfo = informer.getDocumentInfo(sourcePath);
    ```
    
5.  **Setting Comparison Detail level**
    
    1.  If we set *DetailLevel = Middle*, we don't  add comment in some document formats (Words, Slides, Cells) if element was added\\deleted\\modified 
        
    2.  If we set *DetailLevel = Middle*, we don't make case insensitive comparison. i.e. M = m.
        
    3.  Was added sensitivity property. This option defined limit in percents, when element is detected as deleted or inserted. 
        
    
    Minimal value - 0, comparison process not occurs for any length of sequences of two compared objects. 
    
    Value by default - 75, comparison occurs when the percentage of deleted or inserted elements in relation to all elements does not exceed 75%.
    
    Maximum value - 100, comparison occurs at any length of a common subsequence of two compared objects.
    
    **For instance, we have two words**
    
    ```java
    1)oneSource
     
    2)twoTarget
    ```
    
    This two words have very small a common subsequence.Therefore, when comparing them at 70% accuracy, it is not taken into account and we get a completely removed and inserted word:
    
    ```java
    (twoTarget)[oneSource]
    ```
    
    But at 100% accuracy, we take into account this subsequence, despite the fact that it consists of two letters
    
    ```java
    (tw)o[n](Targ)e[Source](t)
    ```
    
    Code snippet:
    
    ```java
    ComparisonSettings comparisonSettings = new ComparisonSettings();
    comparisonSettings.setSensitivityOfComparison(100);
    Comparer compare = new Comparer();
    ICompareResult result = compare.compare(sourcePath, targetPath, comparisonSettings);
    ```
