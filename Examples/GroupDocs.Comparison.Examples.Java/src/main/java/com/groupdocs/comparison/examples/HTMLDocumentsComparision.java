package com.groupdocs.comparison.examples;

import java.io.InputStream;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.ICompareResult;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.HtmlComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;
import com.groupdocs.comparison.examples.Utilities;

public class HTMLDocumentsComparision {

	// document extension
		private static String extension = ".html";
		/*
		 * Comparing two html files from streams
		 */
		public static void CompareHtmlFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
			//ExStart:CompareHtmlFromStreamToFile
			// Create two streams of textFiles
			InputStream sourceStream = Utilities.sourceStream(sourceFile);
			InputStream targetStream = Utilities.targetStream(targetFile);
			// Create instance of GroupDocs.Comparison.Comparison and call method
			// Compare.
			Comparer comparison = new Comparer();
			ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
			result.saveDocument(Utilities.outputFileName(".html"));
			//ExEnd:CompareHtmlFromStreamToFile
		}
		
		/*
		 * Comparing two html files with method compareWith
		 */
//		public static void CompareHtmlFiles(String sourceFile, String targetFile) throws Throwable {
//			IComparisonHtmlDocument source = new ComparisonHtmlDocument(sourcePath);
//			IComparisonHtmlDocument target = new ComparisonHtmlDocument(targetPath);
//			// Create instance of GroupDocs.Comparison.Comparison and call method
//			// Compare.
//			Comparison comparison = new Comparison();
//			InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension));
//		}
}
