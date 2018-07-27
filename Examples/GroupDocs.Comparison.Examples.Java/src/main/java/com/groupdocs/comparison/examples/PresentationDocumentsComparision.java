package com.groupdocs.comparison.examples;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.common.compareresult.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;

public class PresentationDocumentsComparision {
	// document extension
	private static String extension = ".pptx";

	/*
	 * Comparing two presentations from streams, with settings and saving output
	 * to a resultant file
	 */

	public static void ComparePresentationsFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		// ExStart:ComparePresentationsFromStreamToFile
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromStreamToFile
	}

	/* Comparing two presentations from streams, with settings */

	public static void ComparePresentationsFromStreamWithSettings(String sourceFile, String targetFile)
			throws Throwable {
		// ExStart:ComparePresentationsFromStreamWithSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		ComparisonSettings settings = new ComparisonSettings();
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromStreamWithSettings
	}

	/*
	 * Comparing two presentations from streams without settings and saving
	 * results to a file
	 */

	public static void ComparePresentationsFromStreamToFileWitoutSettings(String sourceFile, String targetFile)
			throws Throwable {
		// ExStart:ComparePresentationsFromStreamToFileWitoutSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromStreamToFileWitoutSettings
	}

	/*
	 * Comparing two presentations from streams without settings and saving file
	 */

	public static void ComparePresentationsFromStreamWithoutSettings(String sourceFile, String targetFile)
			throws Throwable {
		// ExStart:ComparePresentationsFromStreamWithoutSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromStreamWithoutSettings
	}

	/* Compare two presentations from files with saving file and settings */

	public static void ComparePresentationsFromFileToFileWithSettings(String sourceFile, String targetFile)
			throws Exception {
		// ExStart:ComparePresentationsFromFileToFileWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromFileToFileWithSettings
	}

	/* Compare two presentations from files with settings */

	public static void ComparePresentationsFromFileWithSettings(String sourceFile, String targetFile) throws Exception {
		// ExStart:ComparePresentationsFromFileWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromFileWithSettings
	}

	/* Comparing two presentations from files to file without settings */

	public static void ComparePresentationsFromFileToFileWithoutSettings(String sourceFile, String targetFile)
			throws Exception {
		// ExStart:ComparePresentationsFromFileToFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromFileToFileWithoutSettings
	}

	/* Comparing two presentations from files without settings */

	public static void ComparePresentationsFromFileWithoutSettings(String sourceFile, String targetFile)
			throws Exception {
		// ExStart:ComparePresentationsFromFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		//// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".ppt"));
		// ExEnd:ComparePresentationsFromFileWithoutSettings
	}
}
