---
id: get-list-of-changes
url: comparison/java/get-list-of-changes
title: Get list of changes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows to obtain list of changes between source and target files.

The following are the steps to obtain changes list.

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source file path or stream;    
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target file path or stream;    
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method;    
*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method.
    

The following code sample demonstrates how to get list of all changes.

## Get list of changes from local disk

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    comparer.compare();
    ChangeInfo[] changes = comparer.getChanges();
    System.out.println("Count of changes: " + changes.length);
}
```

## Get list of changes from stream

```java
try (Comparer comparer = new Comparer(new FileInputStream("C:\\source.pdf"))) {
    comparer.add(new FileInputStream("C:\\target.pdf"));
    comparer.compare();
    ChangeInfo[] changes = comparer.getChanges();
    System.out.println("Count of changes: " + changes.length);
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
