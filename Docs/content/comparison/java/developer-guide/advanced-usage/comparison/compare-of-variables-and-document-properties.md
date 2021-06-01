---
id: compare-of-variables-and-document-properties
url: comparison/java/compare-of-variables-and-document-properties
title: Compare of Variables and Document properties
weight: 11
description: "This article explains how to activate the comparison of document properties in GroupDocs.Comparison for Java."
keywords: variables properties, built properties, custom properties, compare document properties, CompareVariableProperty, CompareDocumentProperty
productName: GroupDocs.Comparison for Java
hideChildren: False
---

***

**[GroupDocs.Comparison](https://products.groupdocs.com/comparison)** allows you to compare various properties of a WORD document such as *Variable*, *Built*, and *Custom* properties.

The following fields of the CompareOptions class are used to enable comparison functions for document properties:

*   [CompareVariableProperty](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setCompareVariableProperty(boolean)) - to activate the comparison of *variable* properties;
*   [CompareDocumentProperty](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setCompareDocumentProperty(boolean)) - to activate the comparison of *built* and *custom* properties.

Following are the steps to activate compare document properties:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source file path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target file path or stream;
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object and set [CompareVariableProperty](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setCompareVariableProperty(boolean)) property to *true* ([CompareDocumentProperty](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setCompareDocumentProperty(boolean)) to *true* for *built* and *custom* properties);
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object from previous step.

## Example code block to activate comparison of Variable, Built and Custom properties

---

```java
try (Comparer comparer = new Comparer(sourcePath)) {
    comparer.add(targetPath);
    CompareOptions options = new CompareOptions();
    options.setCompareVariableProperty(true); // to activate the comparison of variable properties
    options.setCompareDocumentProperty(true); // to activate the comparison of built and custom properties

    final Path resultPath = comparer.compare(RESULT_PATH, options);
}
```

## The result of comparing properties

---

The result of comparing properties is presented on a separate page - *Properties summary page*.

![](comparison/java/images/properties-summary-page.png)

## More resources

---
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