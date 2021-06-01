---
id: how-to-compare-source-code-files
url: comparison/java/how-to-compare-source-code-files
title: How to compare Source Code Files
weight: 6
description: "This article describes how can you compare programming files and merge them into one file with applied or canceled changes. GroupDocs.Comparison for Java provides the ability to find differences in such files as: CS, Java, Python, C ++, Ruby and others"
keywords: Compare cs files, compare java files, merge documents
productName: GroupDocs.Comparison for Java
hideChildren: False
---

***

There are plenty of comparison tools that allow multiple users to effectively manage, accept or reject their changes when collaborate over source code written in CSharp, Java, Python, Ruby and other programming languages. Most part of such tools are desktop applications that are free or paid, provide powerful set of features, have their pros and cons, but all of them assume you will compare files manually.

Let's review some common use case when you need to review two versions of C# (CSharp) source code file edited by two different people and chose the proper variant for each edited code block. Please check source.cs and target.cs files that we are going to compare at the image below.

![](comparison/java/images/how-to-compare-source-code-files1.png)

As we can see there are multiple differences between compared files:
*   class names are different - *CropImage* vs *ImageCropTests*;
*   *Test1* method is not present in a *target.cs* file;
*   Bitmap image path was changed in *Test2* - *input.png* vs *original.png*;
*   *Start* method was renamed to *Launch* and its content was also modified - *Test1* method call removed;
*   some empty lines removed etc.

The image below demonstrates all mentioned changes detected by some of desktop comparison tools. It works just fine, all differences detected and highlighted in a user interface.

![](comparison/java/images/how-to-compare-source-code-files2.png)

However sometimes you may need some features that existing comparison tools do not provide, or you want to implement comparison process in your own way. Then you will definitely need a possibility to compare documents programmatically and manage discovered changes via code. This is where **[GroupDocs.Comparsion](https://products.groupdocs.com/comparison)** features will come to the rescue, so lets see how to compare source code files with it.

## Compare CSharp, Java, C++, JavaScript, Python and Ruby files using GroupDocs.Comparison
 
---

Using **[GroupDocs.Comparsion](https://products.groupdocs.com/comparison)** API you are able to compare two or more source code files, detect differences between them and then decide what to do with every detected change - accept or discard it before saving the resultant document, generate HTML report with comparison results etc.

In general you have to follow these steps to compare two source code files (please find other supported formats list [here](https://wiki.lisbon.dynabic.com/display/comparison/Supported+File+Formats)):

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method  and specify path target document path or stream;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method and perform file comparison.

At this stage you is able to save comparison report in HTML form and review it. If you need to programmatically obtain collection of detected changes for further processing you have to:

*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method and obtain detected changes list;
*   Set [ComparisonAction](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction) of needed change object to [ComparisonAction.ACCEPT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#ACCEPT) or [ComparisonAction.REJECT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#REJECT) value;
*   Instantiate [ApplyChangeOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/ApplyChangeOptions) object that contains list of changes to be applied (or rejects) to the resultant document;
*   Call [applyChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#applyChanges(java.lang.String,%20com.groupdocs.comparison.options.save.SaveOptions,%20com.groupdocs.comparison.options.ApplyChangeOptions)) method and save the document.

You can learn more about the ComparisonAction property [here](https://wiki.lisbon.dynabic.com/display/comparison/How+to+merge+source+code+files).

The following code samples demonstrate how to compare two CS files and accept or reject detected changes in a specific range.

```java
try (Comparer comparer = new Comparer(SOURCE_FILE)) {
    comparer.add(TARGET_FILE); // NOTE: Put here actual path to target document
    final Path resultPath = comparer.compare();
    ChangeInfo[] changes = comparer.getChanges();
    changes[0].setComparisonAction(ComparisonAction.REJECT); // This is how to reject first detected difference;
    changes[1].setComparisonAction(ComparisonAction.REJECT); // This is how to reject second detected difference;
    changes[2].setComparisonAction(ComparisonAction.REJECT); // This is how to reject third detected difference;
    comparer.applyChanges(RESULT_FILE, new ApplyChangeOptions(changes));
}
```

As a result, we get a merged CS file where the deleted elements are marked in <font color="red">red</font>, the added – in <font color="blue">blue</font>, and the modified – in <font color="green">green</font>.

Also, you will receive a file in HTML format with changed places in the code.

|  The result HTML file | The result HTML file using the ComparisonAction property |
| --- | --- |
| ![](comparison/java/images/how-to-compare-source-code-files_result1.png) | ![](comparison/java/images/how-to-compare-source-code-files_result2.png) |

## More resources

---

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

