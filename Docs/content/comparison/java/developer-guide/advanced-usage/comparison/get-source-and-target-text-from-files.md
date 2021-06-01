---
id: get-source-and-target-text-from-files
url: comparison/java/get-source-and-target-text-from-files
title: Get source and target text from files
weight: 7
description: "This article explains how to get source and target texts of specific changes using GroupDocs.Comparison for Java."
keywords: Get target txt, Get source txt, documents diff, compare documents, compare files
productName: GroupDocs.Comparison for Java
hideChildren: False
---
[**GroupDocs.Comparison for Java**](https://products.groupdocs.com/comparison/java) allows to getting source and target texts of specific changes in result file.

The following are the steps to get a list of changed source and target texts:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target document path or stream;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method;
*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method.

The following code example demonstrates how to get specified texts from a file.

## Get target text from local disk

```java
try (Comparer comparer = new Comparer(sourceDocumentPath)) {
    comparer.add(targetDocumentPath);
    final Path resultPath = comparer.compare(outputPath);
    ChangeInfo[] changes = comparer.getChanges();
    for (ChangeInfo change : changes) {
        System.out.println();
        System.out.println("Source text: " + change.getSourceText());
        System.out.println("Target text: " + change.getTargetText());
    }
}
```

## Get target text from stream

```java
try (InputStream inputStream = new FileInputStream(sourceDocumentPath);
        Comparer comparer = new Comparer(inputStream)) {
        comparer.add(targetDocumentPath);
        final Path resultPath = comparer.compare(outputPath);
        ChangeInfo[] changes = comparer.getChanges();
        for (ChangeInfo change : changes) {
        System.out.println();
        System.out.println("Source text: " + change.getSourceText());
        System.out.println("Target text: " + change.getTargetText());
    }
}
```

## More resources

### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Comparison for .NET examples, plugins, and showcase](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET)
*   [GroupDocs.Comparison for Java examples, plugins, and showcase](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java)
*   [Document Comparison for .NET MVC UI Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-MVC)
*   [Document Comparison for .NET App WebForms UI Modern Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-WebForms)
*   [Document Comparison for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard)
*   [Document Comparison for Java Spring UI Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java-Spring)
    
### Free Online App
Along with full-featured Java library we provide simple, but powerful free Apps.  
You are welcome to compare your DOC or DOCX, XLS or XLSX, PPT or PPTX, PDF, EML, EMLX, MSG and other documents with free to use online [GroupDocs Comparison App](https://products.groupdocs.app/comparison).