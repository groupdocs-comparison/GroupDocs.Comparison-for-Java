---
id: how-to-compare-contracts-drafts-and-legal-documents
url: comparison/java/how-to-compare-contracts-drafts-and-legal-documents
title: How to Compare Contracts Drafts and Legal Documents
weight: 2
description: "This article describes how to compare contracts, drafts and legal documents using Microsoft Word blacklining feature and GroupDocs.Comparison API."
keywords: Compare contracts, compare drafts, compare blacklining, compare redlining
productName: GroupDocs.Comparison for Java
hideChildren: False
---
An ordinary employee is often faced with the need to compare two versions of the same document. For example, upon receipt of a signed version of an agreement, it is important to ensure that the counterparty has not made major changes affecting the terms of the transaction. And on the next round of approval of the draft document within the company, you only need to look at the changed sections so as not to waste time re-reading the entire text.

The "**[GroupDocs.Comparison](https://products.groupdocs.com/comparison)**" solution automatically compares two versions and generates a report with convenient visualization of differences. As a result, labor costs for comparing documents are reduced and the likelihood of error due to the human factor is reduced.

## How to compare Microsoft Word documents


As a result of creating a text file, we have to subject it to multiple changes. And it is noteworthy that some non-final version of the document may be agreed upon by the interested person. The final text file, which is agreed by another person, may differ significantly from the previously agreed upon original version. And such situations can be repeated every day. To partially automate the process of comparing files, you can use Microsoft Word resources

*   First, open the Microsoft Word. Go to the "**Review**" tab, in the "**Comparison**" section, click "**Compare**".
*   "**Version comparison**" pop-up window appears in front of which you now need to load two types of documents: the original and the modified one.

![](comparison/java/images/how-to-compare-contracts-drafts-and-legal-documents.png)

*   After you have selected two versions of a text document, click **OK**  
    ![](comparison/java/images/how-to-compare-contracts-drafts-and-legal-documents_1.png)


*   The comparison results will open in a new window, and it will look something like this:

![](comparison/java/images/how-to-compare-contracts-drafts-and-legal-documents_2.png)

*   In the highlighted square with the number "1", all deleted and inserted words will appear. To the right, the zone with the number "2" Shows the document being compared with the presence in the text and the words deleted and inserted in their place.  
    The workspace with the number "3" shows us the source document (before making changes), while the space with the number "4" shows us the changed document with the changes made.  
    The remaining working field with the number "5" is a set of tools necessary for editing the final version of the document being developed.
*   By pressing "**Accept**" / "**Reject**" for the first time, you select the word that you accept or reject, the second time you click, you will change to one of the proposed options.
*   Red crossed out words are marked for deletion, while red underlined words will be replaced.


## How to compare contracts using GroupDocs.Comparison

Sometimes Microsoft Word comparison features may be not enough to satisfy your requirements - for example you need your own way to implement comparison logic or you are developing your own application. [**GroupDocs.Comparison**](https://products.groupdocs.com/comparison/java) provides a possibility to compare documents programmatically and manage found differences in code for wide range of [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}}). Here is an example of how to compare two contracts using GroupDocs.Comparsion API. Usually you just have to follow these steps:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method and specify target document path or stream;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String)) method.

Let's say you have two contracts in DOCX format that were concluded in different years (For example, for 2018 and 2019). Now you are going to compare how the conditions have changed after some time.

|  | Files |
| --- | --- |
|Source File - Contract signed in 2018| ![](comparison/java/images/how-to-compare-contracts-drafts-and-legal-documents_3.png) |
|Target File- Contract signed in 2019|![](comparison/java/images/how-to-compare-contracts-drafts-and-legal-documents_4.png)|

Here is the code that is used to compare two contracts.

```java
    try (Comparer comparer = new Comparer("source-contract.docx")) {
        comparer.add("target_contract.docx");
        final Path resultPath = comparer.compare("result-contract.docx");
    }
```

As a result, we get a DOCX file where the deleted elements are marked in <font color="red">**red**</font>, the added – in <font color="blue">**blue**</font>, and the modified – in <font color="green">**green**</font>.

![](comparison/java/images/how-to-compare-contracts-drafts-and-legal-documents_5.png)

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
