package com.groupdocs.comparison.examples;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.ImagingComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;
import com.groupdocs.comparison.imaging.ComparisonDjvuImage;
import com.groupdocs.comparison.imaging.contracts.IImageCompareResult;
import com.groupdocs.comparison.imaging.contracts.IPdfDocument;

public class PdfDocumentsComparision {
	// document extension
	private static String extension = ".pdf";
	
	/* Comparing two pdf documents from streams, with settings and saving output
	 * to a resultant file
	 */
	 
	public static void ComparePdfFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:ComparePdfFromStreamToFile
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromStreamToFile
	}

	
	 /* Comparing two pdf documents from streams, with settings*/
	 
	public static void ComparePdfFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable {
		//ExStart:ComparePdfFromStreamWithSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromStreamWithSettings
	}
	
	 /* Comparing two pdf documents from streams without settings and saving
	 * results to a file
	 */
	 
	public static void ComparePdfFromStreamToFileWitoutSettings(String sourceFile, String targetFile) throws Throwable {
		//ExStart:ComparePdfFromStreamToFileWitoutSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromStreamToFileWitoutSettings
	}

	
	 /* Comparing two pdf documents from streams without settings and saving file*/
	 
	public static void ComparePdfFromStreamWithoutSettings(String sourceFile, String targetFile) throws Throwable {
		//ExStart:ComparePdfFromStreamWithoutSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromStreamWithoutSettings
	}

	
	 /* Compare two pdf documents from files with saving file and settings*/
	 
	public static void ComparePdfFromFileToFileWithSettings(String sourceFile, String targetFile) throws Exception {
		//ExStart:ComparePdfFromFileToFileWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromFileToFileWithSettings
	}

	
	 /* Compare two pdf documents from files with settings*/
	 
	public static void ComparePdfFromFileWithSettings(String sourceFile, String targetFile) throws Exception {
		//ExStart:ComparePdfFromFileWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromFileWithSettings
	}

	
	 /* Comparing two pdf documents from files to file without settings*/
	 
	public static void ComparePdfFromFileToFileWithoutSettings(String sourceFile, String targetFile) throws Exception {
		//ExStart:ComparePdfFromFileToFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare. 
		Comparer comparison = new Comparer(); 
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromFileToFileWithoutSettings
	}

	
	 /* Comparing two pdf documents from files without settings*/
	 
	public static void ComparePdfFromFileWithoutSettings(String sourceFile, String targetFile) throws Exception {
		//ExStart:ComparePdfFromFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//ExEnd:ComparePdfFromFileWithoutSettings
	}
	
	//Compare imaging documents from stream and get result in file
	public static void compareImagingDocumentFromStreamToFile(String sourceFile, String targetFile) throws Exception{
		//ExStart:compareImagingDocumentFromStreamToFile
		InputStream sourceStream = new FileInputStream(Utilities.sourcePath + sourceFile);
		InputStream targetStream = new FileInputStream(Utilities.targetPath + targetFile);
		 
		ComparisonDjvuImage sourceImage = new ComparisonDjvuImage(sourceStream);
		ComparisonDjvuImage targetImage = new ComparisonDjvuImage(targetStream);
		ImagingComparisonSettings settings = new ImagingComparisonSettings();
		 
		//Compare
		IImageCompareResult cr = sourceImage.compareWith(targetImage, settings);
		IPdfDocument resultPdf = cr.getPdfDocument();
		 
		//save results into a file
		resultPdf.save(Utilities.outputFileName(extension));
		sourceStream.close();
		targetStream.close();		
		//ExEnd:compareImagingDocumentFromStreamToFile
	}
	
	//Compare imaging documents from file and get result in file
	public static void compareImagingDocumentFromFileToFile(String sourceFile, String targetFile) throws Exception{
		//compareImagingDocumentFromFileToFile		
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		
		ComparisonDjvuImage sourceImage = new ComparisonDjvuImage(sourcePath);
		ComparisonDjvuImage targetImage = new ComparisonDjvuImage(targetPath);
		ImagingComparisonSettings settings = new ImagingComparisonSettings();
		 
		//Compare
		IImageCompareResult cr = sourceImage.compareWith(targetImage, settings);
		IPdfDocument resultPdf = cr.getPdfDocument();
		 
		//save results into a file
		resultPdf.save(Utilities.outputFileName(extension));
		//compareImagingDocumentFromFileToFile
	}
	
	//Compare imaging documents from file with setting and get result in file
	public static void compareImagingDocumentFromFileWithSetting(String sourceFile, String targetFile) throws Exception {
		//compareImagingDocumentFromFileWithSetting
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;		
		//Open files
		ComparisonDjvuImage sourceImage = new ComparisonDjvuImage(sourcePath);
		ComparisonDjvuImage targetImage = new ComparisonDjvuImage(targetPath);		 
		//Create instance of setting
		ImagingComparisonSettings settings = new ImagingComparisonSettings();		 
		//Accuracy by X coordinate
		settings.setAccuracyX(200);		 
		//Accuracy by Y coordinate
		settings.setAccuracyY(200);		 
		//filling density color changed objects
		//settings.setSaprayFulness(10);		 
		//Fill color for rectangles
		settings.setRectangleColor(Color.RED);		 
		//Compare
		IImageCompareResult cr = sourceImage.compareWith(targetImage,settings);
		IPdfDocument resultPdf = cr.getPdfDocument();
		 
		//save results into a file
		resultPdf.save(Utilities.outputFileName(extension));
		//compareImagingDocumentFromFileWithSetting
	}
	
}
