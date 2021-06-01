---
id: how-to-compare-invoices
url: comparison/java/how-to-compare-invoices
title: How to Compare Invoices
weight: 3
description: "You will find how you can use GroupDocs.Comparison for Java inside your production when comparing invoices. Look at file comparison sensitivity configuration and other use cases of the GroupDocs.Comparison API"
keywords: Compare docx files, invoices comparison, how to compare invoices
productName: GroupDocs.Comparison for Java
hideChildren: False
---
Sometimes you need to achieve maximum accuracy in comparing files. Suppose you have two versions of an important document and you need to find differences character-by-character or the opposite case, you need to compare the documents, but the details are not important to you, and you only need words that have changes. **[GroupDocs.Comparison](https://products.groupdocs.com/comparison)** provides the ability to compare documents with sensitivity settings

For example, there are two invoices in the DOCX format and you need to compare their contents with the maximum level of detail and comparison sensitivity.

|  | Files  |
| --- | --- |
|Source Invoice|![](comparison/java/images/how-to-compare-invoices.png) | |Target Invoice |![](comparison/java/images/how-to-compare-invoices_1.png)|  

[**GroupDocs.Comparison**](https://products.groupdocs.com/comparison) provides the ability to compare two files in DOCX format(or any other [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}})) with adjustment of detalization level and[comparison sensitivity](https://docs.groupdocs.com/display/comparisonjava/Set+Comparison+Sensitivity+While+Comparing+Documents).

The following are the steps to compare two DOCX files with specific settings of detalization level and[comparison sensitivity.]({{< ref "comparison/java/developer-guide/advanced-usage/comparison/adjusting-comparison-sensitivity.md" >}})

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target document path or stream;
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object with desired [setSensitivityOfComparison](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setSensitivityOfComparison(int)) and [setDetalisationLevel](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#setDetalisationLevel(int)) value;    
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String,%20com.groupdocs.comparison.options.CompareOptions)) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object to method.
    

The following code samples demonstrate how to compare two DOCX files.

```java
try (Comparer comparer = new Comparer(SOURCE_FILE)) {
    comparer.add(TARGET_FILE);
 
    final CompareOptions compareOptions = new CompareOptions();
    compareOptions.setSensitivityOfComparison(100);
    compareOptions.setDetalisationLevel(DetalisationLevel.High);

    final Path resultPath = comparer.compare(RESULT_FILE, compareOptions);
}
```

As a result, we get a DOCX file where the deleted elements are marked in <font color="red">**red**</font>, the added – in <font color="blue">**blue**</font>, and the modified – in <font color="green">**green**</font>

| Result Invoice |
| --- |
| ![](comparison/java/images/how-to-compare-invoices_2.png)| 

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
