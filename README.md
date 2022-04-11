
# Document Comparison Java Library

GroupDocs.Comparison for Java is a [Document Comparison API](https://products.groupdocs.com/comparison/java) that provides the ability to detect differences between source and target files for changes at paragraph, word and character levels as well as can identify styling and formatting changes. The API supports over [50 document types](https://docs.groupdocs.com/comparison/java/supported-document-formats/) from popular categories such as Microsoft Office, OpenOffice, AutoCAD, Visio, images, programming, PDF & more.

<p align="center">
  <a title="Download complete GroupDocs.Comparison for Java source code" href="https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/archive/master.zip"> 
    <img src="https://camo.githubusercontent.com/11839cd752a2d367f3149c7bee1742b68e4a4d37/68747470733a2f2f7261772e6769746875622e636f6d2f4173706f73654578616d706c65732f6a6176612d6578616d706c65732d64617368626f6172642f6d61737465722f696d616765732f646f776e6c6f61645a69702d427574746f6e2d4c617267652e706e67" data-canonical-src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" style="max-width:100%;">
  </a>
</p>

Directory | Description
--------- | -----------
[Demos](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Demos)  | GroupDocs.Comparison for Java Dropwizard and Spring Demo projects.
[Examples](https://github.com/groupdocs-comparison/GroupDocs.Comparison-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly.

## Compare Documents via Java

- Accept or reject document changes.
- [Adjust comparison sensitivity](https://docs.groupdocs.com/comparison/java/adjusting-comparison-sensitivity/).
- Compare multiple documents at a time.
- Get change coordinates on the document.
- Set document metadata on save.
- Set password for resultant document.
- [Generate preview of document pages](https://docs.groupdocs.com/comparison/java/generate-document-pages-preview/).

## Get Started with GroupDocs.Comparison for Java

GroupDocs.Comparison for Java requires J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already.

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-comparison), so simply [configure](https://docs.groupdocs.com/comparison/java/installation/) your Maven project to fetch the dependencies automatically.

## Compare 2 PDF Documents

```java
try (Comparer comparer = new Comparer("source.pdf")) {
    comparer.add("target.pdf");
    comparer.compare("result.pdf");
}
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/comparison/java) | [Documentation](https://docs.groupdocs.com/comparison/java/) | [Demos](https://products.groupdocs.app/comparison/family) | [API Reference](https://apireference.groupdocs.com/java/comparison) | [Examples](https://github.com/groupdocs-comparison/GroupDocs.comparison-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/comparison/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/comparison) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
