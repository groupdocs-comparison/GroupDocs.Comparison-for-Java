---
id: migration-notes
url: comparison/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
## Why To Migrate?

Here are the key reasons to use the new updated API provided by **[GroupDocs.Comparison for Java](https://products.groupdocs.com/comparison/java)** since version 20.4:

*   **Comparer** class introduced as a **single entry point** to compare documents of any supported file format with various options and ability to accept/reject found differences in resultant document.  
*   Document **compare options** for all document types. Instead of using document related options now options are related to compare type only.
*   The overall document related classes were unified to common.     
*   Product architecture was redesigned from scratch in order to simplify passing options and classes to manipulate comparison.    
*   Document information and preview generation procedures were simplified.  
    

## How To Migrate? 

Here is a brief comparison of how to compare document with old and new API.  

**Old coding style**

```java
Comparer comparer = new Comparer();
ComparisonSettings settings = new ComparisonSettings();
settings.setStyleChangeDetection(true);
ICompareResult result = comparer.compare("source.docx", "target.docx", settings);
result.saveDocument("result.docx");
```

**New coding style**

```java
try (Comparer comparer = new Comparer("source.docx")) {
    comparer.add("target.docx");
    CompareOptions compareOptions = new CompareOptions();
    compareOptions.setDetectStyleChanges(true);
    comparer.compare("result.docx", compareOptions);
}
```
