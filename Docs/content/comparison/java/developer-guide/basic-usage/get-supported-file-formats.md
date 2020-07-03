---
id: get-supported-file-formats
url: comparison/java/get-supported-file-formats
title: Get supported file formats
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows to get the list of all [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}}) by following the below steps:

*   Call [getSupportedFileTypes](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/FileType#getSupportedFileTypes()) of [FileType](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/FileType) class;
*   Enumerate through the collection of [FileType](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/FileType) objects.

The following code sample demonstrates how to get supported file formats list.

```java
Iterable<FileType> fileTypes = FileType.getSupportedFileTypes();
for (FileType fileType : fileTypes) {
    System.out.println(fileType);
}
```

## More resources
### Advanced Usage Topics
To learn more about document comparison features, please refer to the [advanced usage section]({{< ref "comparison/java/developer-guide/advanced-usage/_index.md" >}}).

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
