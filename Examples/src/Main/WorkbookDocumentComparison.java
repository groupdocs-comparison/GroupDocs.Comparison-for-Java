package Main;

import java.io.InputStream;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.CellsComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;

public class WorkbookDocumentComparison {
	private static String extension = ".xlsx";

	/*
	 * Comparing two workbooks from streams, with settings and saving output to
	 * a resultant file
	 */
	public static void CompareWorkBooksFromStreamToFileWithSettings(String sourceFile, String targetFile)
			throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension),
				ComparisonType.Cells, new CellsComparisonSettings());
	}

	/*
	 * Comparing two workbooks from streams with settings
	 */
	public static void CompareWorkBooksFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Cells,
				new CellsComparisonSettings());
	}

	/*
	 * Comparing two workbooks from streams to file without settings
	 */
	public static void CompareWorkBooksFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension),
				ComparisonType.Cells);
	}

	/*
	 * Comparing two workbooks from streams without settings
	 */
	public static void CompareWorkBooksFromStream(String sourceFile, String targetFile) throws Throwable {
		InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
		InputStream targetStream = Main.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Cells);
	}

	/*
	 * Comparing two workbooks from files and saving file and settings
	 */
	public static void CompareWorkBooksFromFilesToFileWithSettings(String sourceFile, String targetFile)
			throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of *GroupDocs.Comparison.Comparison* and call method
		// *Compare*.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension),
				ComparisonType.Cells, new CellsComparisonSettings());
	}

	/*
	 * Comparing two workbooks from files with settings
	 */
	public static void CompareWorkBooksFromFilesWithSettings(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of *GroupDocs.Comparison.Comparison* and call method
		// *Compare*.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Cells,
				new CellsComparisonSettings());
	}

	/*
	 * Comparing two workbooks from files to file without settings
	 */
	public static void CompareWorkBooksFromFilesToFile(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of *GroupDocs.Comparison.Comparison* and call method
		// *Compare*.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension),
				ComparisonType.Cells);
	}

	/*
	 * Comparing two workbooks from files without saving and settings
	 */
	public static void CompareWorkBooksFromFiles(String sourceFile, String targetFile) throws Exception {
		String sourcePath = Main.Utilities.sourcePath + sourceFile;
		String targetPath = Main.Utilities.targetPath + targetFile;
		// Create instance of *GroupDocs.Comparison.Comparison* and call method
		// *Compare*.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Cells);
	}
}
