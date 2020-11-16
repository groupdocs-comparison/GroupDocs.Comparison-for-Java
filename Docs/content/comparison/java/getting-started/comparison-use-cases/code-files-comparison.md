---
id: code-files-comparison
url: comparison/java/code-files-comparison
title: How to Compare CSharp, Java, Python, Ruby files
weight: 2
description: "This article describes how can you compare programming files and merge them into one file with applied or canceled changes. GroupDocs.Comparison for Java provides the ability to find differences in such files as: CS, Java, Python, C ++, Ruby and others"
keywords: Compare cs files, compare java files, merge documents
productName: GroupDocs.Comparison for Java
hideChildren: False
---
You are working in an IT project on one product. You need to compare two CS files and accept or reject the found changes found in the specified range. With this action, you will merge the two files into one with the edits from different developers.  

|  | Files |
| --- | --- |
| Source | ![](comparison/java/images/code-files-comparison.png) |
| Target | ![](comparison/java/images/code-files-comparison_1.png)|

[**GroupDocs.Comparison**](https://products.groupdocs.com/comparison/java) provides the ability to compare two files in CS format(or any other [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}})).

The following are the steps to compare two CS files

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method  and specify path target document path or stream;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method;
*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method and obtain detected changes list;
*   Set [ComparisonAction](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction) of needed change object to [ComparisonAction.ACCEPT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#ACCEPT) or [ComparisonAction.REJECT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#REJECT) value;
*   Call [applyChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#applyChanges(java.lang.String,%20com.groupdocs.comparison.options.save.SaveOptions,%20com.groupdocs.comparison.options.ApplyChangeOptions)) method and pass collection of changes to it.

ApplyChangeOptions class:

*   **getChanges** - List of changes that must be applied (or not) to the resulting document;  
      
    
The following code samples demonstrate how to compare two CS files and accept or reject detected changesin a specific range.

```java
try (Comparer comparer = new Comparer(SOURCE_FILE)) {
    comparer.add(TARGET_FILE); // NOTE: Put here actual path to target document
    comparer.compare();
    ChangeInfo[] changes = comparer.getChanges();
    for (int n = 0; n < 5; n++) {
        changes[n].setComparisonAction(ComparisonAction.REJECT);
    }
 
    for (int n = 6; n < 17; n++) {
        changes[n].setComparisonAction(ComparisonAction.ACCEPT);
    }
    comparer.applyChanges(RESULT_FILE, new SaveOptions(), new ApplyChangeOptions(changes));
}
```

As a result, we get a merged CS file where the deleted elements are marked in **red**, the added – in **blue**, and the modified – in **green**.

Also, you will receive a file in HTML format with changed places in the code.

| Result File |
| --- |
| ![](comparison/java/images/code-files-comparison_2.png)| 
