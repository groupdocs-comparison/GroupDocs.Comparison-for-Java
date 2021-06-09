---
id: how-to-compare-powerpoint-presentations
url: comparison/java/how-to-compare-powerpoint-presentations
title: How to Compare PowerPoint Presentations
weight: 4
description: "The article describes a possible example of using the GroupDocs.Comparison for Java in your work practice and the possibility of a software product for finding differences in styles within PowerPoint Presentations"
keywords: Compare Presentation, compare style changes, compare pptx, How to compare PowerPoint files
productName: GroupDocs.Comparison for Java
hideChildren: False
---
You may need to compare two versions of a PowerPoint Presentation to see the differences between them (e.g., if a colleague has edited it directly without noting the changes). And the quickest way to do this is with PowerPoint’s built-in Compare function. To use this:

*   Open the original version of your presentation
*   Go to **Review** > **Compare**
*   Click **Compare** to open a browser window
*   Select the edited version of the presentation and click **Merge**

You will then enter Review Mode. This will open the Reviewing Pane, which shows a list of all edits in the presentation at the right of the screen.

![](comparison/java/images/how-to-compare-powerpoint-presentations.png)

## How to Compare Two Presentations using GroupDocs.Comparison

Such functionality that is provided by third-party programs is clearly not enough. **[GroupDocs.Comparison](https://products.groupdocs.com/comparison)** provides many features for comparing a wide range of [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}}), including PowerPoint Presentation format. Let's make an example, you made a presentation at different times, but the elements on the slides are not located as you originally did. To find where the slides differ, you can compare two files in PPTX format using the **[GroupDocs.Comparison for Java](https://products.groupdocs.com/comparison/java)** functionality along with a built-in option that helps find changes in styles.

|   |  Presentations |
| --- | --- |
|Original | ![](comparison/java/images/how-to-compare-powerpoint-presentations_1.png)|
|Modified | ![](comparison/java/images/how-to-compare-powerpoint-presentations_2.png)|

[**GroupDocs.Comparison**](https://products.groupdocs.com/comparison/java) provides the ability to compare two files in PPTX format(or any other [supported file formats]({{< ref "comparison/java/getting-started/supported-document-formats.md" >}}))

The following are the steps to compare two PPTX files.

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source document path or stream; 
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object with desired parameters; 
*   Call[ compare ](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String,%20com.groupdocs.comparison.options.CompareOptions)) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object to method;

The following code samples demonstrate how to compare two PPTX files.

```java
try (Comparer comparer = new Comparer(SOURCE_FILE)) {
    comparer.add(TARGET_FILE);
 
    final CompareOptions compareOptions = new CompareOptions();
    compareOptions.setDetectStyleChanges(true);
    compareOptions.setDetalisationLevel(DetalisationLevel.High);

    final Path resultPath = comparer.compare(RESULT_FILE, compareOptions);
}
```

As a result, we get a PPTX file where the deleted elements are marked in <font color="red">**red**</font>, the added – in <font color="blue">**blue**</font>, and the modified – in <font color="green">**green**</font>

| Result Slide |
| --- |
| ![](comparison/java/images/how-to-compare-powerpoint-presentations_3.png)

To compare comments in presentation document, you have to set DetalisationLevel property to High:

```java
    try (Comparer comparer = new Comparer(sourcePath)) {
        comparer.add(targetPath);

        CompareOptions compareOptions = new CompareOptions();
        compareOptions.setDetalisationLevel(DetalisationLevel.High);

        final Path resultPath = comparer.compare(resultPath, compareOptions);
    }
```

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
