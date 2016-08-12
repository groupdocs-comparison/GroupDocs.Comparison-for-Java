package Main;

import java.io.InputStream;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.HtmlComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;

public class HTMLDocumentsComparision {

	// document extension
		private static String extension = ".html";

		/*
		 * Comparing two html files from streams
		 */
		public static void CompareHtmlFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
			// Create two streams of textFiles
			InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
			InputStream targetStream = Main.Utilities.targetStream(targetFile);
			// Create instance of GroupDocs.Comparison.Comparison and call method
			// Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension));
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
