---
id: groupdocs-comparison-for-java-17-3-0-release-notes
url: comparison/java/groupdocs-comparison-for-java-17-3-0-release-notes
title: GroupDocs.Comparison for Java 17.3.0 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparsion for Java 17.3.0{{< /alert >}}

## Major Features

There are improvements and fixes in this regular monthly release. The most notable are:

*   Introduced support of Shapes in Comparison.Cells
*   Introduced support of text watermarks in Comparison.PDF
*   Improved aligning of slides for more precise changes detection in GroupDocs.Comparison.Slides
*   Improved GroupDocs.Comparison.PDF object model and comparison efficiency
*   Introduced support of support for Apply/Discard changes in Comparison.Cells
*   Introduced support of support for Apply/Discard changes in Comparison.PDF
*   Introduced support of support for Watermarks, Hyperlinks, Comments, Text Box, Shapes in Comparison.Cells
*   Improved GroupDocs.Comparison.PDF comparison efficiency
*   Add support of Imaging DjVu
*   Introduced support of support for Text Font in Watermark in Comparison.PDF
*   Introduced support of support for Images, Charts,  Smart Art, VBA Controls, Formulas in Comparison.Cells
*   Improved GroupDocs.Comparison.PDF comparison efficiency
*   Add ability of comparing DICOM documents by Comparison.Imaging
*   Simplified and improved public API across all supported formats
*   Introduced the process absorbing of tables with merged cells for GroupDocs.Comparison.PDF
*   Fixed comparing filled tables for GroupDocs.Comparison.PDF

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| COMPARISONNET-1034 | GroupDocs.Comparison.Cells: add support for Shapes | New Feature |
| COMPARISONNET-1011 | GroupDocs.Comparison.PDF: add support of styles to text watermarks | New Feature |
| COMPARISONNET-1053 | GroupDocs.Comparison.PDF: Add support for Apply/Discard changes | New Feature |
| COMPARISONNET-975 | GroupDocs.Comparison.PDF: Add support for Watermarks | New Feature |
| COMPARISONNET-1065 | GroupDocs.Comparison.Cells: Add support for Hyperlinks | New Feature |
| COMPARISONNET-1069 | GroupDocs.Comparison.Cells: Add support for Comments | New Feature |
| COMPARISONNET-1072 | GroupDocs.Comparison.Cells: Add support for Text Box | New Feature |
| COMPARISONNET-1063 | GroupDocs.Comparison.Cells: Add support of Apply/Discard changes | New Feature |
| COMPARISONNET-1073 | GroupDocs.Comparison.Cells: Add support for Shapes | New Feature |
| COMPARISONNET-1123 | Integrate Metered licensing | New Feature |
| COMPARISONNET-1122 | GroupDocs.Comparison.PDF: Add support of comparing Text Font in Watermarks | New Feature |
| COMPARISONNET-1068 | GroupDocs.Comparison.Cells: Add support for Formulas | New Feature |
| COMPARISONNET-1065 | GroupDocs.Comparison.Cells: Add support for Images | New Feature |
| COMPARISONNET-1070 | GroupDocs.Comparison.Cells: Add support for Chart | New Feature |
| COMPARISONNET-1066 | GroupDocs.Comparison.Cells: Add support for Smart Art | New Feature |
| COMPARISONNET-1067 | GroupDocs.Comparison.Cells: Add support for VBA Controls | New Feature |
| COMPARISONNET-1108 | Add support of mobi format | New Feature |
| COMPARISONNET-1156 | Add ability of comparing DICOM documents by Comparison.Imaging | New Feature |
| COMPARISONNET-1163 | Apply/Discard changes for DICOM format | New Feature |
| OMPARISONNET-1165 | Add summary page to images streams | New Feature |
| COMPARISONNET-1014 | GroupDocs.Comparison.Slides: Improve aligning of slides for more precise changes detection | Improvement |
| COMPARISONNET-1029 | GroupDocs.Comparison.PDF: Remove Text Artifacts from documents before Paragraph absorbation | Improvement |
| COMPARISONNET-1048 | GroupDocs.Comparison.PDF: Improve set coordinates for components | Improvement |
| COMPARISONNET-1047 | GroupDocs.Comparison.PDF: Improve set HorizontalAlignment | Improvement |
| COMPARISONNET-1075 | GroupDocs.Comparison.Cells: Add borders for deleted and inserted cells and Range of cells | Improvement |
| COMPARISONNET-679 | Fix problem when moving modified table into new page and not deleting previous version of added table | Improvement |
| COMPARISONNET-1055 | Improve Trim paragraphs by pages after some change in absorbing paragraphs | Improvement |
| COMPARISONNET-1080 | GroupDocs.Comparison.PDF: Improve comparison changes detection for Paragraphs | Improvement |
| COMPARISONNET-1056 | Improve GroupDocs.Comparison.PDF comparison quality for images in header, footer, setting coordinates for components and paragraphs by pages | Improvement |
| COMPARISONNET-1112 | Add support of Imaging DjVu | Improvement |
| COMPARISONNET-1080 | GroupDocs.Comparison.PDF: Improve comparison changes detection for Paragraphs | Improvement |
| COMPARISONNET-778 | Implement the process absorbing of tables with merged cells | Improvement |
| COMPARISONNET-1148 | Improved public API | Improvement |
| COMPARISONNET-1161 | Add ability for comparison of result and original files in Imaging.Tests | Improvement |
| COMPARISONNET-1157 | Add localize exceptions for wrong passwords while opening documents in Cells, Words, Slides and PDF | Improvement |
| COMPARISONNET-953 | Compile Error on Comparison Document for VB.NET | Bug |
| COMPARISONNET-946 | Exception: The newChild was created from a different document than the one that created this node. | Bug |
| COMPARISONNET-1074 | GroupDocs.Comparison: PDF: Set type change for paragraph runs after page break | Bug |
| COMPARISONNET-1077 | Comparison.Cells: Fix cells appearance after critical update for Aligner comparer and Document builder | Bug |
| COMPARISONNET-1129 | GroupDocs.Comparison.PDF: Fix bug when some lines are deleted or inserted where should not be | Bug |
| COMPARISONNET-1130 | GroupDocs.Comparison.PDF: Fix bug when first line of paragraph don't have indent but should have | Bug |
| COMPARISONNET-1131 | GroupDocs.Comparison.PDF: Fix bug when component change its page but dont change its position but should be | Bug |
| COMPARISONNET-1128 | GroupDocs.Comparison.PDF: Fix bug when first line of paragraph use as not paragraph line | Bug |
| COMPARISONNET-1132 | GroupDocs.Comparison.PDF: Fix bug when text from tables use twice with simple paragraphs | Bug |
| COMPARISONNET-1160 | PDF Comparison - PDF files with tables and footer lines generating unexpected output | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Comparison for Java 17.3.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Comparison which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Updated way to use Comparison Settings for following derived objects:

*   WordsComparisonSettings
*   PdfComparisonSettings
*   CellsComparisonSettings
*   SlidesComparisonSettings
*   TextComparisonSettings

#### Properties

| Name | Description |
| --- | --- |
| **ShowDeletedContent** | Shows or Hides deleted content of comparison |
| **GenerateSummaryPage** | Enables or Disables an ability to generate summary page for result document |
| **StyleChangeDetection** | Gets or Sets an ability to detect style changes for documents subcomponents |
| **MovedContentDetection** | Gets or Sets an ability to detect content movement |
| **InsertedItemsStyle** | Gets or Sets style for inserted components |
| **StyleChangedItemsStyle** | Gets or sets style for component that changed style |
| **DeletedItemsStyle** | Gets or Sets style for deleted components |
| **WordsSeparatorChars** | Gets or Sets a list of chars thatparses text content into text fragmentwhile comparison |
| **ComparisonDepth** | Gets or Sets the depth of comparison(chars or text fragments) |
| **ExceptionSilentMode** | Gets or Sets silent mode for an application |
| **ComparerSplitter** | Gets or Sets a Regex Splitter that parses text content into text fragment while comparison |

#### Style Setting

| Name | Description |
| --- | --- |
| **ChartImage** | Gets or Sets a value, save Charts as image. |

## Word Comparison Settings

### Properties

| Name | Description |
| --- | --- |
| **ProcessHyperLinksAsAText** | Gets or Sets a value indicating whether hyperlinks proceeded as a text |

### Working with settings

To start working with settings for Comparison, you have to create a new instance of ComparisonSettings for necessary file format. For example



```java
CellsComparisonSettings settings = new CellsComparisonSettings()

//Or 

WordsComparisonSettings settings = new WordsComparisonSettings()
```

You can create a ComparisonSettings object for every comparison type which is supported by GroupDocs.Comparison library

After creating a new instance of ComparisonSettings you are able to change settings properties. For example:



```java
settings.setShowDeletedContent(false);
settings.setGenerateSummaryPage(true);
```

User is able to change also parameters that is specific for certain format. For example:



```java
WordsComparisonSettings settings = new WordsComparisonSettings()
settings.setProcessHyperLinksAsAText(true);
```

## **Updated Open Document API to work with .opt format**

### Open words document from InputStream

NOTE: Assuming there are files in source.docx, source.xlsx, source.pdf, source.pptx, source.txt are in the resource folder.



```java
// Enter document path
String sourcePath = "./source.docx";

// Create stream of document
FileInputStream sourceStream = new FileInputStream(sourcePath);

// Open ComparisonDocument.
ComparisonDocument document = new ComparisonDocument(sourceStream);
 
```

### Open words document from file



```java
// Enter document path
String sourcePath = "./source.docx";

// Open ComparisonDocument.
ComparisonDocument document = new ComparisonDocument(sourcePath);
```

## **Open **workbook****

### Open workbook from InputStream



```java
// Enter workbook path
String sourcePath = "./source.xlsx";

// Create stream of workbook
FileInputStream sourceStream = new FileInputStream(sourcePath);

// Open ComparisonWorkbook.
ComparisonWorkbook workbook = new ComparisonWorkbook(sourceStream); 
```

### Open workbook from file



```java
// Enter workbook path
String sourcePath = "./source.xlsx";

// Open ComparisonWorkbook.
ComparisonWorkbook workbook = new ComparisonWorkbook(sourcePath);

```

## **Open **PDF document****

### Open PDF document from InputStream



```java
// Enter document path
String sourcePath = "./source.pdf";

// Create stream of document
FileInputStream sourceStream = new FileInputStream(sourcePath);

// Open ComparisonDocument.
ComparisonPdfDocument document = new ComparisonPdfDocument(sourceStream);


```

### Open PDF document from file 



```java
// Enter document path
String sourcePath = "./source.pdf";

// Open ComparisonDocument.
ComparisonPdfDocument document = new ComparisonPdfDocument(sourcePath);

```

## **Open **Presentation****

### Open presentation from InputStream



```java
// Enter presentation path
String sourcePath = "./source.pptx";

// Create stream of presentation
FileInputStream sourceStream = new FileInputStream(sourcePath);

// Open ComparisonPresentation.
ComparisonPresentation presentation = new ComparisonPresentation(sourceStream);

```

### Open presentation from file



```java
// Enter presentation path
String sourcePath = "./source.pptx";

// Open ComparisonPresentation.
ComparisonPresentation presentation = new ComparisonPresentation(sourcePath);


```

## **Open **Text file****

### Open text file from InputStream



```java
// Enter textFile path
String sourcePath = "./source.txt";

// Create stream of document
FileInputStream sourceStream = new FileInputStream(sourcePath);

// Open ComparisonTextFile.
ComparisonTextFile textFile = new ComparisonTextFile(sourceStream);


```

### Open text file from file 



```java
// Enter document path
String sourcePath = "./source.txt";

// Open ComparisonTextFile.
ComparisonTextFile textFile = new ComparisonTextFile(sourcePath);
 
```

## **Open HTML **file****

### Open HTML  file from InputStream



```java
// Enter document path
String sourcePath = "./source.html";
InputStream sourceStream = this.getClass().getClassLoader().getResourceAsStream(sourcePath);

// Open ComparisonTextFile.
IComprisonHtmlDocument htmlFile = new ComparisonHtmlDocument(sourceStream);

```

### Open HTML file from file 



```java
// Enter document path
String sourcePath = "./source.html";

// Open ComparisonTextFile.
IComparisonHtmlDocument htmlFile = new ComparisonHtmlDocument(sourcePath);

```

## Updated Presentation API to work with .opt format

### Compare two presentations from streams with saving to file and settings

NOTE: Assuming there are files in source.docx, source.xlsx, source.pdf, source.pptx, source.txt are in the resources folder of samples.



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";
String resultPath = "./result.pptx";
        
// Create stream of document
InputStream sourceStream = new FileInputStream(sourcePath);
InputStream targetStream = new FileInputStream(targetPath);

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourceStream, targetStream, resultPath, ComparisonType.Slides, new SlidesComparisonSettings());

```

###  Compare two presentations from streams with settings



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";

// Create two streams of presentations

InputStream sourceStream = new FileInputStream(sourcePath);
InputStream targetStream = new FileInputStream(targetPath);

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Slides, new SlidesComparisonSettings());

```

###  Compare two presentations from streams with saving to file



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";
String resultPath = "./result.pptx";

// Create two streams of presentations
InputStream sourceStream = new FileInputStream(sourcePath);
InputStream targetStream = new FileInputStream(targetPath);

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourceStream, targetStream, resultPath, ComparisonType.Slides);

```

### Compare two presentations from streams



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";

// Create two streams of presentations
InputStream sourceStream = new FileInputStream(sourcePath);
InputStream targetStream = new FileInputStream(targetPath);

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Slides);

```

### Compare two presentations from files with saving to file and settings



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";
String resultPath = "./result.pptx";

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourcePath, targetPath, resultPath, ComparisonType.Slides, new SlidesComparisonSettings());

```

### Compare two presentations from files with settings



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Slides, new SlidesComparisonSettings());

```

###  **Compare two presentations from files with saving to file**



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";
String resultPath = "./result.pptx";

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourcePath, targetPath, resultPath, ComparisonType.Slides);

```

### Compare two presentations from files



```java
// Enter presentations paths
String sourcePath = "./source.pptx";
String targetPath = "./target.pptx";

// Create instance of *GroupDocs.Comparison.Comparison* and call method *Compare*.
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Slides);
```

## Updated Save presentation as image API to work with .opt format

### **Save presentation as image**

To start working with image saving for Slides component you have to add GroupDocs.Comparison library and add following imports to your code

```java
import com.groupdocs.comparison.slides.*;
import com.groupdocs.comparison.slides.contracts.*;
import com.groupdocs.comparison.slides.contracts.comparison.*;
import com.groupdocs.comparison.slides.contracts.enums.*;
import com.groupdocs.comparison.common.images.*;

```

After that you have to specify a path to document which you want to save as image. The easiest way to do it just put the document to output folder of your working project

### **Save presentation to image via image folder**

saveAsImages(String imagePath, ComparsionSlidesImageSettings settings)

| Parameter | Description |
| --- | --- |
| String imagePath | Path to folder where save images |
| ComparsionSlidesImageSettings settings | Image save settings |



```java
//path to file
String filePath = "./presentation.xlsx";

//path to image folder
String imageFolderPath = "./FolderForImage/";

//Open  document
ComparisonPresentationBase presentation = new ComparisonPresentation(filePath);

//Set settings
ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();

//Save as Image
presentation.saveAsImages(imageFolderPath, settings);
```

### **Save presentation to image via stream**

saveAsImages(ArrayList<ByteArrayOutputStream> imageStream, ComparsionSlidesImageSettings settings)

| Name | Description |
| --- | --- |
| ArrayList<ByteArrayOutputStream> imageStream | The images streams – where each stream from list contains a single page from document |
| ComparsionSlidesImageSettings settings | Image save settings |



```java
//path to file
String filePath = "./presentation.xlsx";

//stream
ArrayList<ByteArrayOutputStream> imageStream = new ArrayList<ByteArrayOutputStream>();

//Open  document
ComparisonPresentationBase presentation = new ComparisonPresentation(filePath);

//Set settings
ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();

//Save as Image
presentation.saveAsImages(imageStream, settings);

```

### **Save slide from presentation to image via image folder**

saveSlideAsImage (String imagePath, ComparsionSlidesImageSettings settings, int slideIndex )

| Name | Description |
| --- | --- |
| String imagePath | Path to folder where save images |
| ComparsionSlidesImageSettings settings | Image save settings |
| int slideIndex | Index of slide |



```java
//path to file
String filePath = "./presentation.xlsx";

//path to image folder
String imageFolderPath = "./FolderForImage/";

//Open  document
ComparisonPresentationBase presentation = new ComparisonPresentation(filePath);

//Set settings
ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();

//Save slide as Image
presentation.saveSlideAsImage(imageFolderPath, settings, slideIndex);

```

### Save slide of presentation to image via stream

saveSlideAsImage (ArrayList<ByteArrayOutputStream> imageStream, ComparsionSlidesImageSettings settings, int slideIndex )

| Name | Description |
| --- | --- |
| ArrayList<ByteArrayOutputStream> imageStream | The images streams – where each stream from list contains a single page from document |
| ComparsionSlidesImageSettings settings | Image save settings |
| int slideIndex | Index of slide |



```java
//path to file
String filePath = "./presentation.xlsx";

//Stream
ArrayList<ByteArrayOutputStream> imageStream = new ArrayList<ByteArrayOutputStream>();

//Open  document
ComparisonPresentationBase presentation = new ComparisonPresentation(filePath);

//Set settings
ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();

//Save slide as Image
presentation.saveSlideAsImage(imageStream, settings, slideIndex);

```

## Metered licensing

```java
// Create new instance of GroupDocs.Comparison.Metered classs
Metered metered = new Metered();
 
// Set public and private key to metered instance
metered.setMeteredKey("***", "***");
 
// Get metered value before usage of the comparison
BigDecimal amountBefore = Metered.getConsumptionQuantity();
 
System.out.println("Amount consumed  before: " + amountBefore);
 
// compare files
String sourcePath = "./data/source.docx";
String targetPath = "./data/target.docx";
 
Comparison comparison = new Comparison();
InputStream result = comparison.compare(sourcePath, targetPath);
 
// Get metered value after usage of the comparison
BigDecimal amountAfter = Metered.getConsumptionQuantity();
 
System.out.println("Amount consumed  after: " + amountAfter);
```

## Extended Public API to support Imaging formats

### **Compare From Stream**

Compare two Imaging(DjVu) Documents from streams with saving results into a file



```java
// Create two streams of documents
InputStream sourceStream = new FileInputStream(sourcePath);
InputStream targetStream = new FileInputStream(targetPath);

ComparisonDjvuImage sourceImage = new ComparisonDjvuImage(sourceStream);
ComparisonDjvuImage targetImage = new ComparisonDjvuImage(targetStream);

ImagingComparisonSettings settings = new ImagingComparisonSettings();

//Compare
IImageCompareResult cr = sourceImage.compareWith(targetImage, settings);
IPdfDocument resultPdf = cr.getPdfDocument();

//save results into a file
resultPdf.save(resultPath);
sourceStream.close();
targetStream.close();
```

  

### Compare From File

Compare two Imaging(DjVu) Documents from file path with saving results into a file



```java
//Open files 
ComparisonDjvuImage sourceImage = new ComparisonDjvuImage(sourcePath);
ComparisonDjvuImage targetImage = new ComparisonDjvuImage(targetPath);
ImagingComparisonSettings settings = new ImagingComparisonSettings();

//Compare
IImageCompareResult cr = sourceImage.compareWith(targetImage, settings);
IPdfDocument resultPdf = cr.getPdfDocument();

//save results into a file
resultPdf.save(resultPath);
```

### Compare From File with document settings

Compare two Imaging(DjVu) Documents from File with saving results into a file with document settings



```java
//Open files
ComparisonDjvuImage sourceImage = new ComparisonDjvuImage(sourcePath);
ComparisonDjvuImage targetImage = new ComparisonDjvuImage(targetPath);

//Create instance of setting
ImagingComparisonSettings settings = new ImagingComparisonSettings();

//Accuracy by X coordinate
settings.setAccuracyX(200);

//Accuracy by Y coordinate
settings.setAccuracyY(200);

//filling density color changed objects
settings.setSaprayFulness(10);

//Fill color for rectangles
settings.setRectangleColor(Color.RED);

//Compare
IImageCompareResult cr = sourceImage.compareWith(targetImage,settings);
IPdfDocument resultPdf = cr.getPdfDocument();

//save results into a file
resultPdf.save(resultPath);
```
