---
id: evaluation-limitations-and-licensing-of-groupdocs-comparison
url: comparison/java/evaluation-limitations-and-licensing-of-groupdocs-comparison
title: Licensing and Evaluation Limitations
weight: 5
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}You can use GroupDocs.Comparison without the license. The usage and functionalities are pretty much same as the licensed one but you will face few limitations while using the non-licensed API.{{< /alert >}}

## Evaluation Limitations

You can easily download **[GroupDocs.Comparison](https://products.groupdocs.com/comparison/java)** for evaluation. The evaluation download is the same as the purchased download. The evaluation version simply becomes licensed when you add a few lines of code to apply the license. You will face following limitations while using the API without the license:

*   Only first 3 document pages with simple structure are processed.
*   PDF documents should not have more then four elements in any collection.
*   Trial badges are placed in the document on the top of each page.

## Licensing

The license file contains details such as the product name, number of developers it is licensed to, subscription expiry date and so on. It contains the digital signature, so don't modify the file. Even inadvertent addition of an extra line break into the file will invalidate it. You need to set a license before utilizing GroupDocs.Comparison API if you want to avoid its evaluation limitations.  License can be applied using file path or stream.

### Apply License Using License File Path

Code given below justifies how to apply license using file path.

```java
	License lic = new License();
	lic.setLicense(licensePath.toString());
```

### Apply License Using License File Stream

Code given below explains how to apply license using stream.

```java
try (InputStream licenseStream = new FileInputStream(filePath)) {
	License lic = new License();
	lic.setLicense(licenseStream);
}
```

{{< alert style="info" >}}Calling License#setLicense multiple times is not harmful but simply wastes processor time. Call License#setLicense in your startup code, before using GroupDocs.Comparison API for compare two or more files in applications on the Java platform. Compiled file shows line-by-line difference of content, paragraphs, characters, styles, shapes and positions.
classes.{{< /alert >}}

### Metered Licensing

{{< alert style="info" >}}You can also set Metered license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful for the customers who want to be billed based on the usage of the API features. For more details, please refer to [Metered Licensing FAQ](https://purchase.groupdocs.com/faqs/licensing/metered) section.{{< /alert >}}

Create metered object and use method `setMeteredKey`

```java
// Set metered key
Metered metered = new Metered();
metered.setMeteredKey("****", "****");
```

To check current consumption quantity:
1.  Call method `getConsumptionQuantity` of the `Metered` class.
2.  It will return the amount/quantity of API requests that you have consumed so far.
3.  call method `getConsumptionCredit` of the `Metered` class.
4.  It will return the credit that you have consumed so far.

```java
// Get consumption quantity from metered
BigDecimal amountBefor = Metered.getConsumptionQuantity();

// Call comparison
String sourcePath = "./data/source.docx";
String targetPath = "./data/target.docx";
try (Comparer comparer = new Comparer(sourcePath)) {
    comparer.add(targetPath);
    final Path resultPath = comparer.compare(new CompareOptions());
    
    // Get consumption quantity from metered after several calls of comparison
    BigDecimal amountAfter = Metered.getConsumptionQuantity();
}
```

## Validate the License

You can validate if the license has been set properly or not. The **[License](http://www.aspose.com/api/java/words/com.aspose.words/classes/License)** class has `isValidLicense` method that will return true if license has been properly set.

```java
	License lic = new License();
	lic.setLicense(licensePath);
	if(License.isValidLicense()){
	     System.out.println("License is Set!");
	}
```
