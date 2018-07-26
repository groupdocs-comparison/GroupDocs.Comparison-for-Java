package com.groupdocs.comparison.examples;

import java.io.InputStream;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.CellsComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;

public class WorkbookDocumentComparison {
	private static String extension = ".xlsx";

	/*
	 * Comparing two workbooks from streams, with settings and saving output to
	 * a resultant file
	 */
	public static void CompareWorkBooksFromStreamToFileWithSettings(String sourceFile, String targetFile)
			throws Throwable {
		//ExStart:CompareWorkBooksFromStreamToFileWithSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromStreamToFileWithSettings
	}

	/*
	 * Comparing two workbooks from streams with settings
	 */
	public static void CompareWorkBooksFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareWorkBooksFromStreamWithSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromStreamWithSettings
	}

	/*
	 * Comparing two workbooks from streams to file without settings
	 */
	public static void CompareWorkBooksFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareWorkBooksFromStreamToFile
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromStreamToFile
	}

	/*
	 * Comparing two workbooks from streams without settings
	 */
	public static void CompareWorkBooksFromStream(String sourceFile, String targetFile) throws Throwable {
		//ExStart:CompareWorkBooksFromStream
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromStream
	}

	/*
	 * Comparing two workbooks from files and saving file and settings
	 */
	public static void CompareWorkBooksFromFilesToFileWithSettings(String sourceFile, String targetFile)
			throws Exception {
		//ExStart:CompareWorkBooksFromFilesToFileWithSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromFilesToFileWithSettings
	}

	/*
	 * Comparing two workbooks from files with settings
	 */
	public static void CompareWorkBooksFromFilesWithSettings(String sourceFile, String targetFile) throws Exception {
		//ExStart:CompareWorkBooksFromFilesWithSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromFilesWithSettings
	}

	/*
	 * Comparing two workbooks from files to file without settings
	 */
	public static void CompareWorkBooksFromFilesToFile(String sourceFile, String targetFile) throws Exception {
		//ExStart:CompareWorkBooksFromFilesToFile
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromFilesToFile
	}

	/*
	 * Comparing two workbooks from files without saving and settings
	 */
	public static void CompareWorkBooksFromFiles(String sourceFile, String targetFile) throws Exception {
		//ExStart:CompareWorkBooksFromFiles
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".xlsx"));
		//ExEnd:CompareWorkBooksFromFiles
	}
}
