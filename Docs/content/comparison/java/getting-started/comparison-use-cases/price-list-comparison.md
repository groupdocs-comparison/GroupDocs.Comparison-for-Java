---
id: price-list-comparison
url: comparison/java/price-list-comparison
title: How to Compare Price Lists
weight: 6
description: "This article describes how to compare files using Microsoft Excel feature and GroupDocs.Comparison API for Java. You will also learn how to compare two or more tables and get the difference in files"
keywords: Compare Excel files, compare spreedsheet, how to compare Excel files
productName: GroupDocs.Comparison for Java
hideChildren: False
---
There are three or more price list for few years (For example: "2018", "2019", "2020") in the XLSX format and you need to compare their contents.

  

|  | Files |
| --- | --- |
| Source | ![](comparison/java/images/price-list-comparison.png) |
| Target #1 | ![](comparison/java/images/price-list-comparison_1.png) | 
| Target #2!|[](comparison/java/images/price-list-comparison_2.png) |

[**GroupDocs.Comparison**](https://products.groupdocs.com/comparison/java) provides the ability to compare three or more files in XLSX format(or any other [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}})).

The following are the steps to compare three or more XLSX files

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target document path or stream. Repeat this step for every target document;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String)) method.

The following code samples demonstrate how to compare three or more XLSX files.

```java
try (Comparer comparer = new Comparer(SOURCE_FILE)) {
    comparer.add(TARGET_FILE_ONE);
    comparer.add(TARGET_FILE_TWO);
 
    comparer.compare(RESULT_FILE);
}
```

As a result, we get a XSLX file where the deleted elements are marked in **red**, the added – in **blue**, and the modified – in **green**

| Result Price List |
| --- |
| ![](comparison/java/images/price-list-comparison_3.png) | 
