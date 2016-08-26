package com.groupdocs.comparison.examples;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.text.Utilities;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;
import com.groupdocs.comparison.words.nodes.ComparisonDocument;

public class WordDocumentComparison {

	//document extension
	private static String extension = ".docx";
	
	/*
	 * Comparing two word document from streams, with settings and saving output to a resultant file
	 */
	public static void CompareWordDocumentsFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareWordDocumentsFromStreamToFile
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, com.groupdocs.comparison.examples.Utilities.outputFileName(extension), ComparisonType.Words, new WordsComparisonSettings());
		//ExEnd:CompareWordDocumentsFromStreamToFile
	}
	/*
	 * Comparing two word document from streams, with settings 
	 */
	public static void CompareWordDocumentsFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:CompareWordDocumentsFromStreamWithSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream,
				ComparisonType.Words, new WordsComparisonSettings());
			//ExEnd:CompareWordDocumentsFromStreamWithSettings
	}
	/*
	 * Comparing two word document from streams without settings and saving results to a file
	 */
	public static void CompareWordDocumentsFromStreamToFileWitoutSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:CompareWordDocumentsFromStreamToFileWitoutSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, com.groupdocs.comparison.examples.Utilities.outputFileName(extension), ComparisonType.Words);
	//ExEnd:CompareWordDocumentsFromStreamToFileWitoutSettings
	}
	/*
	 * Comparing two word document from streams without settings and saving file
	 */
	public static void CompareWordDocumentsFromStreamWithoutSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:CompareWordDocumentsFromStreamWithoutSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Words);
	//ExEnd:CompareWordDocumentsFromStreamWithoutSettings
	}
	/*
	 * Compare two word document from files with saving file and  settings
	 */
	public static void CompareWordDocumentsFromFileToFileWithSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileToFileWithSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, com.groupdocs.comparison.examples.Utilities.outputFileName(extension), ComparisonType.Words, new WordsComparisonSettings());
	//ExEnd:CompareWordDocumentsFromFileToFileWithSettings
	}
	/*
	 * Compare two word document from files with settings
	 */
	public static void CompareWordDocumentsFromFileWithSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileWithSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Words, new WordsComparisonSettings());
	//ExEnd:CompareWordDocumentsFromFileWithSettings
	}
	/*
	 * Comparing two word document from files to file without settings 
	 */
	public static void CompareWordDocumentsFromFileToFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileToFileWithoutSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, com.groupdocs.comparison.examples.Utilities.outputFileName(extension), ComparisonType.Words);
		//ExEnd:CompareWordDocumentsFromFileToFileWithoutSettings
	}
	/*
	 * Comparing two word document from files without settings
	 */
	public static void CompareWordDocumentsFromFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileWithoutSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Words);
		//ExEnd:CompareWordDocumentsFromFileWithoutSettings
	}
	
}
