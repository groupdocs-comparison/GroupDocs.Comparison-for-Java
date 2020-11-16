---
id: evaluation-limitations-and-licensing-of-groupdocs-comparison
url: comparison/java/evaluation-limitations-and-licensing-of-groupdocs-comparison
title: Evaluation Limitations and Licensing of GroupDocs.Comparison
weight: 5
description: ""
keywords: 
productName: GroupDocs.Comparison for Java
hideChildren: False
---
{{< alert style="info" >}}You can use GroupDocs.Comparison without the license. The usage and functionalities are pretty much same as the licensed one but you will face few limitations while using the non-licensed API.{{< /alert >}}

## Evaluation Limits

1.  Only up to 3 first pages are processed.
2.  PDF documents: document should not have more then four elements of any collection
3.  Documents with more than 3 pages are not supported.
4.  Only 15 document Comparison per hour.
5.  Trial badges are placed in the document on the top of each page.

## Licensing

The license file contains details such as the product name, number of developers it is licensed to, subscription expiry date and so on. It contains digital signature, so don't modify the file. Even inadvertent addition of an extra line break into the file will invalidate it. You need to set a license before utilizing **GroupDocs.Comparison API** if you want to avoid its evaluation limitations. License can be applied using file path and stream.

### Apply License Using License File Path

Code given below justifies how to apply license using file path.

```java
try {
	// Setup license
	License lic = new License();
	lic.setLicense(licensePath.toString());
} catch (Exception exp) {
	System.out.println("Exception: " + exp.getMessage());
	exp.printStackTrace();
}
```

### Apply License Using License File Stream

Code given below explains how to apply license using stream.

```java
try (FileInputStream licenseStream = new FileInputStream(filePath)) {
	// Setup license
	License lic = new License();
	lic.setLicense(licenseStream);
} catch (Exception exp) {
	System.out.println("Exception: " + exp.getMessage());
	exp.printStackTrace();
}
```

### Metered Licensing

You can also set Metered license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful if you want to be billed based on the usage of the API features. For more details, please refer to [Metered Licensing FAQ](https://purchase.groupdocs.com/faqs/licensing/metered) section.

Create metered object and use method SetMeteredKey()

```java
// Set metered key
Metered metered = new Metered();
metered.setMeteredKey("****", "****");
```

To check current consumption quantity use getConsumptionQuantity() method

```java
// Get consumption quantity from metered
BigDecimal amountBefor = Metered.getConsumptionQuantity();

// Call comparison
String sourcePath = "./data/source.docx";
String targetPath = "./data/target.docx";
try (Comparer comparer = new Comparer()) {
    comparer.compare(sourcePath, targetPath, new ComparisonSettings());
    comparer.compare(sourcePath, targetPath, new ComparisonSettings()); 
    
    // Get consumption quantity from metered after several calls of comparison
    BigDecimal amountAfter = Metered.getConsumptionQuantity();
}
```

## Validate the License

You can validate if the license has been set properly or not. The **[L](http://www.aspose.com/api/java/words/com.aspose.words/classes/License)icense **class has **isValidLicense()** method that will return true if license has been properly set.

```java
try {
	// Setup license
	License lic = new License();
	lic.setLicense(licensePath);
        if(License.isValidLicense()){
	     System.out.println("License is Set!");
	}
} catch (Exception exp) {
	System.out.println("Exception: " + exp.getMessage());
	exp.printStackTrace();
}
```
