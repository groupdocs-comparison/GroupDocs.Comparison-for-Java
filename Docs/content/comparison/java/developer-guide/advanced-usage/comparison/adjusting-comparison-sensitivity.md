---
id: adjusting-comparison-sensitivity
url: comparison/java/adjusting-comparison-sensitivity
title: Adjusting comparison sensitivity
weight: 2
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** allows to adjust comparison sensitivity to achieve the necessary balance between file comparison speed and accuracy. Possible comparison sensitivity values range is from **0** to **100**.

*   **Minimal value** - the minimal value is **0**. Setting sensitivity to a minimal value provides the fastest comparison speed, but it may produce worst comparison quality.  
    If there is at least one common letter in two compared words then these words will not be treated as fully inserted and deleted
*   **Value by default**  - the default value is **75**. Comparison occurs when the percentage of deleted or inserted elements in relation to all elements does not exceed 75%.
*   **Maximum value** - the maximum values is **100**. Comparison occurs at any length of a common sub-sequence of two compared objects. This option provides the best quality, but slowest comparison speed.    

For better understanding about how comparison algorithms work let's suppose we have two strings:

```java
1. It is our equity poetry
2. Jack is a glad calf
```

*Case 1.* If **SensitivityOfComparison = 80%** comparison of these two strings will produce the next result:We will highlight removed text parts with **red **and inserted parts with **blue** color. So, these strings have two common sub-sequences: **"is  "** word and 4 space symbols.  
Common sub-sequence is - **"is   "** and its length is 6 symbols (there are 4 space symbols in it).  
Length of inserted sub-sequence is 13 symbols - **Jackagladcalf** Removed sub-sequence length is 17 symbols - **Itourequitypoetry** Lets calculate percent of removed and inserted symbols: (17 + 13) / (17 + 13 + 6) \* 100 = 83%

**Jack is a glad calf****It is our equity poetry**

Because calculated percent of removed and inserted symbols equals **83%** and it is bigger than value of **SensitivityOfComparison** (equals **80%**) then this common sub-sequence will be not taken into account.  
The first string considered completely removed and the second string considered completely inserted. The same results will be produced for any calculated percent less than **83%**.

*Case 2. *If**SensitivityOfComparison = 85%**, comparison of these two strings will produce the next result:  
**Jack****It**** is ****a****our****glad****equity****calf****poetry**

Common sub-sequence was found, because **85% > 83%**. The same results will be produced for any calculated percent bigger than **83%**.

Here are the steps to compare files with specific comparison sensitivity:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source file path or stream;    
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target file path or stream.    
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object with desired [setSensitivityOfComparison](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions#getSensitivityOfComparison()) value;    
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String,%20com.groupdocs.comparison.options.CompareOptions)) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object to method;
    

The following code snippet demonstrates how compare files with specific sensitivity: 

## Compare files with sensitivity adjustment

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");

    CompareOptions compareOptions = new CompareOptions();
    compareOptions.setSensitivityOfComparison(100);

    comparer.compare("C:\\result.pdf", compareOptions);
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
