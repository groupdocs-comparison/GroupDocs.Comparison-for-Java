package com.groupdocs.comparison.examples;

import java.io.InputStream;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;

public class TextDocumentsComparision {

	// document extension
	private static String extension = ".txt";
	/*
	 * Comparing two text document from streams, with settings and saving output
	 * to a resultant file
	 */
	public static void CompareTextDcumentsFromStreamToFileWithSettings(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromStreamToFileWithSettings
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromStreamToFileWithSettings
	}
	/*
	 * Comparing two text documents from stream without saving and with settings
	 */
	public static void CompareTextDcumentsFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromStreamWithSettings
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromStreamWithSettings
	} 
	/*
	 * Comparing two text documents from streams to file without settings 
	 */
	public static void CompareTextDcumentsFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromStreamToFile
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromStreamToFile
	} 
	/*
	 * Comparing two text documents from streams without saving and settings 
	 */
	public static void CompareTextDcumentsFromStream(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromStream
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
	    ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromStream
	} 
	/*
	 * Comparing two text documents from files to files with settings 
	 */
	public static void CompareTextDcumentsFromFileToFileWithSetting(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromFileToFileWithSetting
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromFileToFileWithSetting
	} 
	/*
	 * Comparing two text documents from files with settings 
	 */
	public static void CompareTextDcumentsFromFileWithSetting(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromFileWithSetting
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromFileWithSetting
	} 
	/*
	 * Comparing two text documents from files to file without setting
	 */
	public static void CompareTextDcumentsFromFileToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromFileToFile
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
	    ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromFileToFile
	} 
	/*
	 * Comparing two text documents from files without saving and settings
	 */
	public static void CompareTextDcumentsFromFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareTextDcumentsFromFile
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
	    ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".txt"));
		//ExEnd:CompareTextDcumentsFromFile
	} 
	
}
