---
id: customize-changes-styles
url: comparison/java/customize-changes-styles
title: Customize changes styles
weight: 4
description: "Following this guide you will learn how to customize document comparison report and modify appearance of detected changes when use GroupDocs.Comparison for Java."
keywords: Style change detection, Compare document styles, Document comparison
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** provides compare options set with some default values that provides both - appropriate comparison speed and quality. However it is possible to customize comparison options from wide range of parameters and their values to fulfill some specific needs. Example below demonstrates how to change different changes types styling.

The following are the steps to compare two documents with custom change style settings:

*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) object with source document path or stream;    
*   Call [add](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#add(java.io.InputStream)) method and specify target document path or stream;    
*   Instantiate [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object with desired parameters;    
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare()) method and pass [CompareOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options/CompareOptions) object to method;
    

The following code snippet demonstrates how to compare files with specific options.

## Compare files from local disk with custom change styles

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    
    CompareOptions compareOptions = new CompareOptions();

    final StyleSettings insertedStyleSettings = new StyleSettings();
    insertedStyleSettings.setHighlightColor(Color.RED);
    insertedStyleSettings.setFontColor(Color.GREEN);
    insertedStyleSettings.setUnderline(true);
    insertedStyleSettings.setBold(true);
    insertedStyleSettings.setStrikethrough(true);
    insertedStyleSettings.setItalic(true);
    compareOptions.setInsertedItemStyle(insertedStyleSettings);

    final StyleSettings deletedStyleSettings = new StyleSettings();
    deletedStyleSettings.setHighlightColor(Color.PINK);
    deletedStyleSettings.setFontColor(Color.CYAN);
    deletedStyleSettings.setUnderline(true);
    deletedStyleSettings.setBold(true);
    deletedStyleSettings.setStrikethrough(true);
    deletedStyleSettings.setItalic(true);
    compareOptions.setDeletedItemStyle(deletedStyleSettings);

    final StyleSettings changedStyleSettings = new StyleSettings();
    changedStyleSettings.setHighlightColor(Color.LIGHT_GRAY);
    changedStyleSettings.setFontColor(Color.GRAY);
    changedStyleSettings.setUnderline(true);
    changedStyleSettings.setBold(true);
    changedStyleSettings.setStrikethrough(true);
    changedStyleSettings.setItalic(true);
    compareOptions.setChangedItemStyle(changedStyleSettings);

    final Path resultPath = comparer.compare("C:\\result.pdf", compareOptions);
}
```

## Compare files from stream with custom change styles

```java
try (Comparer comparer = new Comparer(new FileInputStream("C:\\source.pdf"))) {
    comparer.add(new FileInputStream("C:\\target.pdf"));
    
    CompareOptions compareOptions = new CompareOptions();

    final StyleSettings insertedStyleSettings = new StyleSettings();
    insertedStyleSettings.setHighlightColor(Color.RED);
    insertedStyleSettings.setFontColor(Color.GREEN);
    insertedStyleSettings.setUnderline(true);
    insertedStyleSettings.setBold(true);
    insertedStyleSettings.setStrikethrough(true);
    insertedStyleSettings.setItalic(true);
    compareOptions.setInsertedItemStyle(insertedStyleSettings);

    final StyleSettings deletedStyleSettings = new StyleSettings();
    deletedStyleSettings.setHighlightColor(Color.PINK);
    deletedStyleSettings.setFontColor(Color.CYAN);
    deletedStyleSettings.setUnderline(true);
    deletedStyleSettings.setBold(true);
    deletedStyleSettings.setStrikethrough(true);
    deletedStyleSettings.setItalic(true);
    compareOptions.setDeletedItemStyle(deletedStyleSettings);

    final StyleSettings changedStyleSettings = new StyleSettings();
    changedStyleSettings.setHighlightColor(Color.LIGHT_GRAY);
    changedStyleSettings.setFontColor(Color.GRAY);
    changedStyleSettings.setUnderline(true);
    changedStyleSettings.setBold(true);
    changedStyleSettings.setStrikethrough(true);
    changedStyleSettings.setItalic(true);
    compareOptions.setChangedItemStyle(changedStyleSettings);

    final Path resultPath = comparer.compare(new FileOutputStream("C:\\result.pdf"), compareOptions);
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
