---
id: get-file-info
url: comparison/java/get-file-info
title: Get file info
weight: 2
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows to get file information which includes:

*   [FileType](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.interfaces/IDocumentInfo#getFileType())
*   [PageCount](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.interfaces/IDocumentInfo#getPageCount())
*   [FileSize](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.interfaces/IDocumentInfo#getSize())

The following code samples demonstrate how to get file information.

## Get file info for the file from local disk

```java
try (Comparer comparer = new Comparer("C:\\source.docx")) {
    IDocumentInfo info = comparer.getSource().getDocumentInfo();
    System.out.println(String.format("\nFile type: %s\nNumber of pages: %d\nDocument size: %d bytes", info.getFileType().getFileFormat(), info.getPageCount(), info.getSize()));
}
```

## Get file for the file from stream

```java
try (Comparer comparer = new Comparer(new FileInputStream("C:\\source.docx"))) {
    IDocumentInfo info = comparer.getSource().getDocumentInfo();
    System.out.println(String.format("\nFile type: %s\nNumber of pages: %d\nDocument size: %d bytes", info.getFileType().getFileFormat(), info.getPageCount(), info.getSize()));
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
