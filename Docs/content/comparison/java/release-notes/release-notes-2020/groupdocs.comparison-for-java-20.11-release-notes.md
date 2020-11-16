---
id: groupdocs-comparison-for-java-20-11-release-notes
url: comparison/java/groupdocs-comparison-for-java-20-11-release-notes
title: GroupDocs.Comparison for Java 20.11 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Comparison for Java 20.11{{< /alert >}}

## Major Features

Below the list of most notable changes in  release of GroupDocs.Comparison for Java:

*   Added ability to compare the most popular scripts and programming languages files 
*   Included all supported file fromats
*   Added new function for show only inserted content
*   Added page preview sizes
*   Implemented ability to compare more than two SpreadSheet documents
*   Implemented ability to compare more than two Note documents
*   Improved calculating of coordinates of changes for PDF
*   Improved performance of multiple comparing of text documents
*   Improved function for showing target text for Presentations, Spreadsheet, Diagrams PDF, Notes, and Text
*   Improved exception usage 
*   Functions optimization through code refactoring
*   Fixed element movement changes detection for Presentation(Slides) documents
*   Fixed creating output HTML file while comparing source code files
*   Fixed exception when compare Diagrams documents
*   Fixed issues with library compatibility for Spreadsheed and Notes
*   Fixed number of exception while comparing Diagrams
*   Fixed exception handling with Invalid Password message during generating preview of the password-protected PDF file
*   Fixed issue with Note library version
*   Fixed unexpected borders on the comparison results page.
*   Fixed empty space between two lines in PDF comparison
*   Fixed error occurred in comparing Word documents with tables    
*   Fixed unexpected sizes of the Excel file sheets/pages.     
*   Fixed incorrect positions of compared elements in result for SpreadSheet comparing    
*   Fixed issue with comparing Word documents with checkboxes and form fields in table cells

| Key | Summary | Issue Type |
| --- | --- | --- |
| COMPARISONNET-2188 | Implement Groovy files comparing | Feature |
| COMPARISONNET-2187 | Implement JSON files comparing | Feature |
| COMPARISONNET-2186 | Implement comparing ActionScipt files | Feature |
| COMPARISONNET-2185 | Implement Perl files comparing | Feature |
| COMPARISONNET-2184 | Implement comparing Objctive C/C++ files | Feature |
| COMPARISONNET-2180 | Implement comparing Ruby files | Feature |
| COMPARISONNET-2179 | Implement Shell/batch script, Log, Diff, Config, LESS files comparing | Feature |
| COMPARISONNET-2178 | Implement comparing PHP files | Feature |
| COMPARISONNET-2177 | Implement comparing SQL files | Feature |
| COMPARISONNET-2176 | Implement comparing C-based files | Feature |
| COMPARISONNET-2175 | Implement comparing Scala files | Feature |
| COMPARISONNET-2174 | Implement comparing Javascript files | Feature |
| COMPARISONNET-2173 | Implement comparing Assembler files | Feature |
| COMPARISONNET-2172 | Implement comparing Python files | Feature |
| COMPARISONNET-2171 | Implement comparing Java files | Feature |
| COMPARISONNET-2169 | Implement comparing CSharp files | Feature |
| COMPARISONNET-2165 | Implement Multicomparer for Cells | Feature |
| COMPARISONNET-2103 | Implement Multi Comparer for Note | Feature |
| COMPARISONNET-2234 | Implement ShowInsertedContent function | Feature |
| COMPARISONNET-2183 | Improve calculating of coordinates of changes for PDF | Improvement |
| COMPARISONNET-2168 | Update getSupportedFileTypes method so it will contain all supported formats from documentation | Improvement |
| COMPARISONNET-2214 | Increase performance for TXT multiComparer | Improvement |
| COMPARISONNET-2269 | Improve getTargetText function for Diagrams | Improvement |
| COMPARISONNET-2242 | Improve getTargetText function for Slides | Improvement |
| COMPARISONNET-2241 | Improve getTargetText function for Cells | Improvement |
| COMPARISONNET-2245 | Improve getTargetText function for PDF | Improvement |
| COMPARISONNET-2244 | Improve getTargetText function for Notes | Improvement |
| COMPARISONNET-2243 | Improve getTargetText function for Text | Improvement |
| COMPARISONNET-2271 | Improve exceptions usage | Improvement |
| COMPARISONNET-2273 | Page preview sizes | Improvement |
| COMPARISONNET-2181 | Compare PPT/PPTX documents with element movement changes detection | Bug |
| COMPARISONNET-2097 | PDF comparison, output document title getting distorted | Bug |
| COMPARISONNET-2235 | TextComparerResult does not create .html file for programming languages files | Bug |
| COMPARISONNET-2209 | Comparing two vsdx files throws an exception | Bug |
| COMPARISONNET-2208 | Diagram text line break problem | Bug |
| COMPARISONNET-2316 | Exception with Invalid Password message during generating preview of the password-protected PDF file | Bug |
| COMPARISONNET-2320 | Unexpected borders on the comparison results page | Bug |
| COMPARISONNET-2295 | Empty space between two lines in PDF comparison | Bug |
| COMPARISONNET-2322 | Unexpected sizes of the Excel file sheets/pages | Bug |
| COMPARISONNET-2350 | Comparison.Cells: Incorrect positions of compared elements in result | Bug |
| COMPARISONNET-2349 | Comparing Word documents with checkboxes and form fields in table cells | Bug |
| COMPARISONJAVA-374 | Multithreading comparing returns null | Bug |
| COMPARISONJAVA-375 | Wrong comparing result for pdf | Bug |
| COMPARISONJAVA-866 | Document comparison trial issues | Bug |
| COMPARISONJAVA-867 | Table cannot be cast to Paragraph | Bug |
| COMPARISONJAVA-872 | Font size difference not detected in same line | Bug |
| COMPARISONJAVA-894 | License issue when both Comparison and Conversion APIs are used | Bug |
| COMPARISONJAVA-896 | Particular XLS files comparison issue | Bug |
| COMPARISONJAVA-1009 | License issue in Spring application | Bug |
| COMPARISONJAVA-1010 | Exception throws when comparing two html files | Bug |
| COMPARISONJAVA-1031 | Not enough space for all components | Bug |


## Public API and Backward Incompatible Changes

Starting from version 20.11 **[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows getting target text of specific changes in Result document this working for **Word** documents.

To use this feature you should call *getChanges().get(...).getTargetText()* getter

```java
try (Comparer comparer = new Comparer(sourceDocumentPath)) {
     comparer.add(targetDocumentPath);
     comparer.compare(outputPath);
     ChangeInfo[] changes = comparer.getChanges();
     for (ChangeInfo change : changes) {
         String targetText = change.getTargetText();
         System.out.println(targetText);
     }
}
```

Starting from version 20.11 **[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** provides the ability to disable the display of added content in the result file.  
  
To use this feature you should use *compareOptions.setShowInsertedContent(false)*  

```java
CompareOptions compareOptions = new CompareOptions();
compareOptions.setShowInsertedContent(false);

try (Comparer comparer = new Comparer(sourceDocumentPath)) {
     comparer.add(targetDocumentPath);
     comparer.compare(outputPath, new SaveOptions(), compareOptions);
}
```

Starting from version 20.11 **[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** provides the ability to set paths to folder with custom fonts.  
  
To use this feature you should use *FontsHelper.setFonts(...);*  

```java
FontsHelper.setFonts(Arrays.asList("path1", "path2", "path3"));
```