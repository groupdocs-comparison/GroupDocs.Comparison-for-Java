package Main;
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
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Main.Utilities.outputFileName(extension), ComparisonType.Words, new WordsComparisonSettings());
	}
	/*
	 * Comparing two word document from streams, with settings 
	 */
	public static void CompareWordDocumentsFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable{
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream,
				ComparisonType.Words, new WordsComparisonSettings());
			
	}
	/*
	 * Comparing two word document from streams without settings and saving results to a file
	 */
	public static void CompareWordDocumentsFromStreamToFileWitoutSettings(String sourceFile, String targetFile) throws Throwable{
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Main.Utilities.outputFileName(extension), ComparisonType.Words);
	}
	/*
	 * Comparing two word document from streams without settings and saving file
	 */
	public static void CompareWordDocumentsFromStreamWithoutSettings(String sourceFile, String targetFile) throws Throwable{
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Words);
	}
	/*
	 * Compare two word document from files with saving file and  settings
	 */
	public static void CompareWordDocumentsFromFileToFileWithSettings(String sourceFile, String targetFile) throws Exception{
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Main.Utilities.outputFileName(extension), ComparisonType.Words, new WordsComparisonSettings());
	}
	/*
	 * Compare two word document from files with settings
	 */
	public static void CompareWordDocumentsFromFileWithSettings(String sourceFile, String targetFile) throws Exception{
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Words, new WordsComparisonSettings());
	}
	/*
	 * Comparing two word document from files to file without settings 
	 */
	public static void CompareWordDocumentsFromFileToFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Main.Utilities.outputFileName(extension), ComparisonType.Words);
	}
	/*
	 * Comparing two word document from files without settings
	 */
	public static void CompareWordDocumentsFromFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Words);
	}
	
}
