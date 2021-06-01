---
id: get-only-summary-page
url: comparison/java/get-only-summary-page
title: Get only summary page
weight: 9
description: "This article explains how to get only summary page when comparing documents with GroupDocs.Comparison for Java."
keywords: Compare documents, summary page, SummaryPage, ShowOnlySummaryPage
productName: GroupDocs.Comparison for Java
hideChildren: False
---

***

**[GroupDocs.Comparison for Java](https://products.groupdocs.com/comparison/java)** allows you to detect changes between source and target files and serve only summary page.

The following are the steps to get only summary page:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target document path or stream;
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object and set [setShowOnlySummaryPage(...)](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setShowOnlySummaryPage(boolean)) property to *true*;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object from previous step.

The following code sample shows how to get only summary page.

## Example code block to get only summary page

---

```java
try (Comparer comparer = new Comparer(sourcePath)) {
	comparer.add(targetPath);
	CompareOptions options = new CompareOptions();
    options.setShowOnlySummaryPage(true);
    final Path resultPath = comparer.compare(RESULT_PATH, options);
}
```

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