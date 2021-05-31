---
id: accept-or-reject-revisions
url: comparison/java/accept-or-reject-revisions
title: Accept or Reject revisions
weight: 4
description: "Following this guide, you will learn how to apply or discard revisions found during document comparison using built-in Microsoft Word functionality."
keywords: Revision, revision processing, accept or reject revision, apply change for revision
productName: GroupDocs.Comparison for Java
hideChildren: False
---
**[GroupDocs.Comparison](https://products.groupdocs.com/comparison)** provides the ability to get revisions from a Docx file format, process and save the processing result.
Below are the steps to *take* revisions from a document, *accept / reject* revisions, and *write* the processing result to a final file.

*   Instantiate [RevisionHandler](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionHandler) object with source document path or stream;
*   Call [getRevisions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionHandler#getRevisions()) method and obtain detected revision list;
*   Set [Action](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionInfo#setAction(com.groupdocs.comparison.words.revision.RevisionAction)) of needed change object to [RevisionAction.Accept](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionAction#Accept) or [RevisionAction.Reject](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionAction#Reject) value;
*   Call the [applyRevisionChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionHandler#applyRevisionChanges(com.groupdocs.comparison.words.revision.ApplyRevisionOptions))  method, to which you need to pass the newly created instance of the [ApplyRevisionOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/ApplyRevisionOptions) object and pass to it path or stream of the resulting document, collecting changes in the revisions.

It is also possible to process all changes together, applying one action for all changes. Below are the steps to handle all changes:
*   Instantiate [RevisionHandler](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionHandler) object with source document path or stream;
*   Call the [applyRevisionChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionHandler#applyRevisionChanges(com.groupdocs.comparison.words.revision.ApplyRevisionOptions)) method, to which you need to pass the newly created instance of the [ApplyRevisionOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/ApplyRevisionOptions) object and pass to it action ([RevisionAction.Accept](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionAction#Accept), [RevisionAction.Reject](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionAction#Reject) or [RevisionAction.None](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/RevisionAction#None)) that will apply to all revisions.

[ApplyRevisionOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/ApplyRevisionOptions) class:
*   [getChanges](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/ApplyRevisionOptions#getChanges()) - List of revision changes that need to be applied to the final document.
*   [CommonHandler](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/ApplyRevisionOptions#getCommonHandler()) - Property that allows you to define one action to handle all revision.

If you do not pass the path or file to the resulting document to the [ApplyRevisionOptions](https://apireference.groupdocs.com/comparison/java/com.groupdocs.comparison.words.revision/ApplyRevisionOptions) method, the changes will be written to the same file from which the revisions were taken.

The following code example demonstrates how to get revisions from a document, accept / reject detected revisions and save changes to the resulting document.

## Accept or Reject revisions from local disk

```java
try (RevisionHandler revisionHandler = new RevisionHandler(pathRevision + "Document_with_revision.docx")) {
    List<RevisionInfo> revisionList = revisionHandler.getRevisions();
    for (RevisionInfo revision : revisionList) {
        if (revision.getType() == RevisionType.Insertion) {
            revision.setAction(RevisionAction.Accept);
        }
    }
    ApplyRevisionOptions revisionOptions = new ApplyRevisionOptions();
    revisionOptions.setChanges(revisionList);
    revisionHandler.applyRevisionChanges(pathRevision + "result.docx", revisionOptions);
}
```

## Accept or Reject revisions from stream

```java
try (InputStream inputStream = new FileInputStream("Document_with_revision.docx");
    RevisionHandler revisionHandler = new RevisionHandler(inputStream)) {
    List<RevisionInfo> revisionList = revisionHandler.getRevisions();
    for (RevisionInfo revision : revisionList) {
        if (revision.getType() == RevisionType.Insertion) {
            revision.setAction(RevisionAction.Accept);
        }
    }
    ApplyRevisionOptions revisionOptions = new ApplyRevisionOptions(revisionList);
    revisionHandler.applyRevisionChanges(pathRevision + "result.docx", revisionOptions);
}
```

## Accept or Reject all revisions

```java
try (RevisionHandler revisionHandler = new RevisionHandler(pathRevision + "Document_with_revision.docx")) {
    ApplyRevisionOptions revisionOptions = new ApplyRevisionOptions();
    revisionOptions.setCommonHandler(RevisionAction.Accept);
	revisionHandler.applyRevisionChanges(pathRevision + "result.docx", revisionOptions);
}
```

## Result of revision processing
Below are the source and output files based on the code presented earlier.

| Source file | Result  file |
| --- | --- |
| ![](comparison/java/images/revision-file.png) | ![](comparison/java/images/result-revision-file.png) |

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Comparison for .NET examples, plugins, and showcase](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET)
*   [GroupDocs.Comparison for Java examples, plugins, and showcase](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java)
*   [Document Comparison for .NET MVC UI Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-MVC)
*   [Document Comparison for .NET App WebForms UI Modern Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-.NET-WebForms)
*   [Document Comparison for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java-Dropwizard)
*   [Document Comparison for Java Spring UI Example](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java-Spring)

### Free Online App
Along with full-featured Java library we provide simple, but powerful free Apps.  
You are welcome to compare your DOC or DOCX, XLS or XLSX, PPT or PPTX, PDF, EML, EMLX, MSG and other documents with free to use online [GroupDocs Comparison App](https://products.groupdocs.app/comparison).