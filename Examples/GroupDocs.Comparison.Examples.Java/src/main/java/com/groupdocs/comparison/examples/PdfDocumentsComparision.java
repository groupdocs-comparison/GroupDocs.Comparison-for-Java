package com.groupdocs.comparison.examples;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.PageImage;
import com.groupdocs.comparison.common.compareresult.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;

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
	
	 /* Compare two pdf documents from files and get image representation of result document*/
	 
	public static void getImageRepresentationOfDocumentPages(String sourceFile, String targetFile) throws Exception {
		//ExStart:getImageRepresentationOfDocumentPages
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".pdf"));
		//get list of pages
		List<PageImage> resultImages = comparison.convertToImages(sourcePath,targetPath);
		  
		  
		//save them as bitmap to separate folder
		if (!new File(Utilities.resultFilePath + "/Result Pages").exists()) 
		   new File(Utilities.resultFilePath + "/Result Pages").mkdir();
		  
		  
		for (PageImage image : resultImages){ 
		     BufferedImage bitmap = ImageIO.read(image.getPageStream()); 
		     ImageIO.write(bitmap, "png", new FileOutputStream(Utilities.resultFilePath + "/Result Pages/result_" + image.getPageNumber() + ".png")); 
		}
		//ExEnd:getImageRepresentationOfDocumentPages
	}

}
