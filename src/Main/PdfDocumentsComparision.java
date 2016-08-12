package Main;

import java.io.InputStream;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;

public class PdfDocumentsComparision {
	// document extension
	private static String extension = ".pdf";

	/*
	 * Comparing two pdf documents from streams, with settings and saving output
	 * to a resultant file
	 */
	public static void ComparePdfFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		// Create two streams of textFiles
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Main.Utilities.outputFileName(extension),
				ComparisonType.Pdf, new PdfComparisonSettings());
	}

	/*
	 * Comparing two pdf documents from streams, with settings
	 */
	public static void ComparePdfFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Pdf,
				new PdfComparisonSettings());

	}

	/*
	 * Comparing two pdf documents from streams without settings and saving
	 * results to a file
	 */
	public static void ComparePdfFromStreamToFileWitoutSettings(String sourceFile, String targetFile) throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension),
				ComparisonType.Pdf);
	}

	/*
	 * Comparing two pdf documents from streams without settings and saving file
	 */
	public static void ComparePdfFromStreamWithoutSettings(String sourceFile, String targetFile) throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Pdf);
	}

	/*
	 * Compare two pdf documents from files with saving file and settings
	 */
	public static void ComparePdfFromFileToFileWithSettings(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension),
				ComparisonType.Pdf, new PdfComparisonSettings());
	}

	/*
	 * Compare two pdf documents from files with settings
	 */
	public static void ComparePdfFromFileWithSettings(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Pdf,
				new PdfComparisonSettings());
	}

	/*
	 * Comparing two pdf documents from files to file without settings
	 */
	public static void ComparePdfFromFileToFileWithoutSettings(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension),
				ComparisonType.Pdf);
	}

	/*
	 * Comparing two pdf documents from files without settings
	 */
	public static void ComparePdfFromFileWithoutSettings(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Pdf);
	}

}
