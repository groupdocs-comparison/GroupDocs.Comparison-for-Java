---
id: presentation-comparison
url: comparison/java/presentation-comparison
title: How to Compare Presentations
weight: 5
description: "The article describes a possible example of using the GroupDocs.Comparison for Java in your work practice and the possibility of a software product for finding differences in styles within PowerPoint Presentations"
keywords: Compare Presentation, compare style changes, compare pptx, How to compare PowerPoint files
productName: GroupDocs.Comparison for Java
hideChildren: False
---
You made a presentation at different times. But the elements on the slides are not located as you originally did. To find where the slides differ, you can compare two files in PPTX format using the **[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** functionality along with a built-in option that helps find changes in styles.

  
|   |  Slide |
| --- | --- |
| Source | ![](comparison/java/images/presentation-comparison.png) |
| Target | ![](comparison/java/images/presentation-comparison_1.png)|

[**GroupDocs.Comparison**](https://products.groupdocs.com/comparison/java) provides the ability to compare two files in PPTX format(or any other [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}}))

The following are the steps to compare two PPTX files.

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source document path or stream; 
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object with desired parameters; 
*   Call[ compare ](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String,%20com.groupdocs.comparison.options.CompareOptions)) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object to method;

The following code samples demonstrate how to compare two PPTX files.

```java
try (Comparer comparer = new Comparer(SOURCE_FILE)) {
    comparer.add(TARGET_FILE);
 
    final CompareOptions compareOptions = new CompareOptions();
    compareOptions.setDetectStyleChanges(true);
    compareOptions.setDetalisationLevel(DetalisationLevel.High);
 
    comparer.compare(RESULT_FILE, compareOptions);
}
```

As a result, we get a PPTX file where the deleted elements are marked in **red**, the added – in **blue**, and the modified – in **green**

| Result Slide |
| --- |
| ![](comparison/java/images/presentation-comparison_2.png) |
