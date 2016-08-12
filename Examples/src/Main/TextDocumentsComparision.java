package Main;

import java.io.InputStream;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.TextComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;

public class TextDocumentsComparision {

	// document extension
	private static String extension = ".txt";

	/*
	 * Comparing two text document from streams, with settings and saving output
	 * to a resultant file
	 */
	public static void CompareTextDcumentsFromStreamToFileWithSettings(String sourceFile, String targetFile) throws Throwable {
		// Create two streams of textFiles
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Main.Utilities.outputFileName(extension),
				ComparisonType.Text, new TextComparisonSettings());
	}
	/*
	 * Comparing two text documents from stream without saving and with settings
	 */
	public static void CompareTextDcumentsFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable {
		// Create two streams of textFiles
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream,
				ComparisonType.Text, new TextComparisonSettings());
	} 
	/*
	 * Comparing two text documents from streams to file without settings 
	 */
	public static void CompareTextDcumentsFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		// Create two streams of textFiles
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension),
				ComparisonType.Text);
	} 
	/*
	 * Comparing two text documents from streams without saving and settings 
	 */
	public static void CompareTextDcumentsFromStream(String sourceFile, String targetFile) throws Throwable {
		// Create two streams of textFiles
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream,
				ComparisonType.Text);
	} 
	/*
	 * Comparing two text documents from files to files with settings 
	 */
	public static void CompareTextDcumentsFromFileToFileWithSetting(String sourceFile, String targetFile) throws Throwable {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension), ComparisonType.Text, new TextComparisonSettings());
	} 
	/*
	 * Comparing two text documents from files with settings 
	 */
	public static void CompareTextDcumentsFromFileWithSetting(String sourceFile, String targetFile) throws Throwable {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Text, new TextComparisonSettings());
	} 
	/*
	 * Comparing two text documents from files to file without setting
	 */
	public static void CompareTextDcumentsFromFileToFile(String sourceFile, String targetFile) throws Throwable {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension), ComparisonType.Text);
	} 
	/*
	 * Comparing two text documents from files without saving and settings
	 */
	public static void CompareTextDcumentsFromFile(String sourceFile, String targetFile) throws Throwable {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Text);
	} 
	
}
