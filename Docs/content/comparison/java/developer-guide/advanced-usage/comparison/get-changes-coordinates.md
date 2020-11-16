---
id: get-changes-coordinates
url: comparison/java/get-changes-coordinates
title: Get changes coordinates
weight: 5
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows to detect changes between source and target files and obtain changes coordinates at files preview images.

The following are the steps to obtain changes coordinates.

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source file path or stream;    
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target file path or stream.     
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object and set [CalculateCoordinates](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setCalculateCoordinates(boolean)) setter to *true*;    
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String,%20com.groupdocs.comparison.options.CompareOptions)) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object from previous step.    
*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method 
    

The following code sample shows how to get changes coordinates.

## Coordinates calculation example

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");

    CompareOptions compareOptions = new CompareOptions();
    compareOptions.setCalculateCoordinates(true);
    comparer.compare("C:\\result.pdf", compareOptions);

    ChangeInfo[] changes = comparer.getChanges();
    for (ChangeInfo change : changes) {
        System.out.println(String.format("Change Type: %d, X: %f, Y: %f, Text: %s", change.getType(), change.getBox().getX(), change.getBox().getY(), change.getText()));
    }
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
