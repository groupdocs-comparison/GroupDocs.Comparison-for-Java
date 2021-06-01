---
id: how-to-merge-source-code-files
url: comparison/java/how-to-merge-source-code-files
title: How to merge source code files
weight: 8
description: "This article explains how to control file merging in GroupDocs.Comparison for Java."
keywords: Merging documents, documents diff, compare documents, compare files
productName: GroupDocs.Comparison for Java
hideChildren: False
---

***

[**GroupDocs.Comparison for Java**](https://products.groupdocs.com/comparison/java) provides an ability to merge source code files by using the [ComparisonAction](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction) properties:

*   [ComparisonAction.ACCEPT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#ACCEPT) accepts the found changes and adds them to the file without highlighting;
*   [ComparisonAction.REJECT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#REJECT) cancels found changes and removes them from the result file.

The following are the steps to apply/reject changes to resultant file.

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.lang.String)) method  and specify path target document path or stream;
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method;
*   Call [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#getChanges()) method and obtain detected changes list;
*   Set [ComparisonAction](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction) of needed change object to [ComparisonAction.ACCEPT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#ACCEPT) or [ComparisonAction.REJECT](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction#REJECT) value;
*   Call [applyChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#applyChanges(java.io.OutputStream,%20com.groupdocs.comparison.options.ApplyChangeOptions)) method and pass collection of changes to it.

## Example of merge source code file by using GroupDocs.Comparison

---

For example, you need to compare and merge several versions of source code files and you need to accept or discard changes made by different persons.

![](comparison/java/images/how-to-merge-source-code-file-source.png)
![](comparison/java/images/how-to-merge-source-code-file-target.png)

The differences show that two methods are written in the **source.cs** file: *AddNumbers* and *Sum*.

If you did not use ComparisonAction, then in the resulting file, all changes will be committed, and these methods will be removed, but if you need to control the merging of files, the [ComparisonAction](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.result/ComparisonAction) property will help you with this.

## Example of using ComparisonAction

---

The following code samples demonstrate how to merge two source code files.
```java
try (Comparer comparer = new Comparer(sourcePath)) {
    comparer.add(targetPath);
    final Path resultPath = comparer.compare(RESULT_PATH);

    ChangeInfo[] changes = comparer.getChanges();
    for (int i = 0; i < 10; i++) {
        changes[i].setComparisonAction(ComparisonAction.ACCEPT);
    }

    for (int i = 10; i < changes.length; i++) {
    	changes[i].setComparisonAction(ComparisonAction.REJECT);
    }

    comparer.applyChanges(resultPath, new ApplyChangeOptions(changes));
}
```
## The result of merging files

---

As a result, we get a merged source code file where the deleted elements are marked in <font color="red">**red**</font>, the added – in <font color="blue">**blue**</font>, and the modified – in <font color="green">**green**</font>. 

Also, you will receive a file in HTML format with changed places in the code.

| Result source code file | Result HTML file |
| --- | --- |
| ![](comparison/java/images/how-to-merge-source-code-file-result-CS.png) | ![](comparison/java/images/how-to-merge-source-code-file-result-HTML.png) |

As you can see from the resulting files, only one of the two methods was removed.

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