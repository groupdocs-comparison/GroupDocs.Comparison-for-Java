---
id: accept-or-reject-document-changes
url: comparison/java/accept-or-reject-document-changes
title: Accept or Reject document changes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** provides an ability to apply or discard specific changes between source and target files and save result with (or without) selected changes. 

The following are the steps to apply/reject changes to resultant file.

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method  and specify path target document path or stream;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String)) method;
*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method and obtain detected changes list;
*   Set [ComparisonAction](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction) of needed change object to [ComparisonAction.ACCEPT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#ACCEPT) or [ComparisonAction.REJECT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#REJECT) value;
*   Call [applyChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#applyChanges(java.io.OutputStream,%20com.groupdocs.comparison.options.ApplyChangeOptions)) method and pass collection of changes to it;

ApplyChangeOptions class:

*   **getChanges** - List of changes that must be applied (or not) to the resulting document;

The following code sample shows how to accept/reject detected changes.

## Accept or Reject changes from local disk

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    comparer.compare("C:\\result.pdf");
}
```

## Accept or Reject changes from stream

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    comparer.compare();
    ChangeInfo[] changes = comparer.getChanges();
    changes[0].setComparisonAction(ComparisonAction.REJECT);
    comparer.applyChanges(new FileOutputStream("C:\\result.pdf"), new ApplyChangeOptions(changes));
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