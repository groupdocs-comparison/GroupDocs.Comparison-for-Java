---
id: load-file-from-stream
url: comparison/java/load-file-from-stream
title: Load file from stream
weight: 2
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
In case when you have the file in the form of a stream. To avoid the overhead of saving stream as a file on disk, **[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** provides a way to work with file streams directly. 

The following are the steps to be followed:

*   Obtain file stream;     
*   Pass opened source stream to [Comp](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer)[a](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer)[rer](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer)[class constructor or pass opened target stream to ](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer)[add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.io.InputStream))[method.](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer)
    

Following code snippet describes how to load file from stream.

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
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
