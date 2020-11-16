---
id: set-document-metadata-on-save
url: comparison/java/set-document-metadata-on-save
title: Set document metadata on save
weight: 1
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** provides an ability to select metadata source when saving resultant file. Files have metadata information – author, organization, etc.  

Possible metadata sources are:
*   **Source** file metadata;    
*   **Target** file metadata;    
*   **User-defined** metadata.
    

The following are the steps to set resultant file metadata:
*   Instantiate [Comparer](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer) objectwith source file path or stream;    
*   Call [add](https://apireference.groupdocs.com/net/comparison/groupdocs.comparison/comparer/methods/add/index) method and specify target file path or stream.    
*   Instantiate [SaveOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options.save/SaveOptions) object and use setter [setCloneMetadataType](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options.save/SaveOptions#setCloneMetadataType(int))to set desired [MetadataType](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options.enums/MetadataType) variant;    
*   Call [compare](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison/Comparer#compare(java.lang.String,%20com.groupdocs.comparison.options.CompareOptions)) method and pass [SaveOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.options.save/SaveOptions) object to method;
    

The following code demonstrates how to set resultant file metadata.

## Set metadata from source file

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    final SaveOptions saveOptions = new SaveOptions();
    saveOptions.setCloneMetadataType(MetadataType.Source);
    comparer.compare("C:\\result.pdf", saveOptions);
}
```

## Set metadata from target file

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    final SaveOptions saveOptions = new SaveOptions();
    saveOptions.setCloneMetadataType(MetadataType.Target);
    comparer.compare("C:\\result.pdf", saveOptions);
}
```

## Set user-defined metadata 

```java
try (Comparer comparer = new Comparer("C:\\source.pdf")) {
    comparer.add("C:\\target.pdf");
    final FileAuthorMetadata fileAuthorMetadata = new FileAuthorMetadata();
    fileAuthorMetadata.setAuthor("Tom");
    fileAuthorMetadata.setCompany("GroupDocs");
    fileAuthorMetadata.setLastSaveBy("Jack");
    final SaveOptions saveOptions = new SaveOptions();
    saveOptions.setCloneMetadataType(MetadataType.FileAuthor);
    saveOptions.setFileAuthorMetadata(fileAuthorMetadata);
    comparer.compare("C:\\result.pdf", saveOptions);
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
