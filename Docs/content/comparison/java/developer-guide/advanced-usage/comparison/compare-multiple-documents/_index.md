---
id: compare-multiple-documents
url: comparison/java/compare-multiple-documents
title: Compare multiple documents
weight: 3
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}NOTE: This feature is available only for Word processing documents, PowerPoint presentations, Email and Text document formats.{{< /alert >}}

**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows to compare more that 2 documents.

The following are the steps to compare multiple documents.

*   Instantiate [Comparer](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer) objectwith source document path or stream;
*   Call [add](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer/methods/add/index) method and specify target document path or stream. Repeat this step for every target document.
*   Call [compare](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer) method.

The following code sample shows how to compare multiple documents with specific options.

## Compare multiple documents from local disk

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target1.pdf");
    comparer.add("C:\\target2.pdf");
    comparer.add("C:\\target3.pdf");
    comparer.compare("C:\\result.pdf");
}
```

## Compare multiple documents from stream

```java
try (Comparer comparer = new Comparer(new FileInputStream("C:\\source.pdf"))) {
    comparer.add(new FileInputStream("C:\\target1.pdf"));
    comparer.add(new FileInputStream("C:\\target2.pdf"));
    comparer.add(new FileInputStream("C:\\target3.pdf"));
    comparer.compare(new FileOutputStream("C:\\result.pdf"));
}
```

## More resources

### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Comparison for Java examples, plugins, and showcase](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java)
*   [GroupDocs.Comparison for .NET examples, plugins, and showcase](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET)
*   [Document Comparison for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard)    
*   [Document Comparison for Java Spring UI Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java-Spring)    
*   [Document Comparison for .NET MVC UI Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-MVC)    
*   [Document Comparison for .NET App WebForms UI Modern Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-WebForms)
    

### Free Online App
Along with full-featured Java library we provide simple, but powerful free Apps.
You are welcome to compare your DOC or DOCX, XLS or XLSX, PPT or PPTX, PDF, EML, EMLX, MSGand other documents with free to use online **[GroupDocs Comparison App](https://products.groupdocs.app/comparison)**.
