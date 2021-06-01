---
id: get-extended-information-on-the-summary-page
url: comparison/java/get-extended-information-on-the-summary-page
title: Get extended information on the summary page
weight: 10
description: "This article explains how to get extended information about comparison of documents on the summary page with GroupDocs.Comparison for Java."
keywords: Compare documents, summary page, SummaryPage, extended information, ExtendedSummaryPage
productName: GroupDocs.Comparison for Java 

hideChildren: False
---

***

**[GroupDocs.Comparison](https://products.groupdocs.com/comparison)** allows you to detect changes between source and target files and display changes on the separate page - [SummaryPage](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setGenerateSummaryPage(boolean)).
Аlso you can get extended information about comparison of documents, which will be display in the [SummaryPage](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setGenerateSummaryPage(boolean)).

The following are the steps to get extended information:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target document path or stream;
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object and set [ExtendedSummaryPage](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setExtendedSummaryPage(boolean)) property to *true*;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object from previous step.

The following code sample shows how to get extended information about comparison of documents.

## Example code block to get extended information

---

```java
try (Comparer comparer = new Comparer(sourcePath)) {
	comparer.add(targetPath);
	CompareOptions options = new CompareOptions();
    options.setExtendedSummaryPage(true);
    final Path resultPath = comparer.compare(resultPath, options);
}
```

## Example of displaying the summary page with extended information

---

![](comparison/java/images/how-to-get-extended-information-image.png)

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