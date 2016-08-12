package Main;

import java.io.InputStream;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.SlidesComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.TextComparisonSettings;

public class PresentationDocumentsComparision {
	//document extension
		private static String extension = ".pptx";
		
		/*
		 * Comparing two presentations from streams, with settings and saving output to a resultant file
		 */
		public static void ComparePresentationsFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
			// Create two streams of textFiles
			InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
			InputStream targetStream = Main.Utilities.targetStream(targetFile);
			// Create instance of GroupDocs.Comparison.Comparison and call method
			// Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourceStream, targetStream, Main.Utilities.outputFileName(extension),
					ComparisonType.Slides, new SlidesComparisonSettings());
		}
		/*
		 * Comparing two presentations from streams, with settings 
		 */
		public static void ComparePresentationsFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable{
			InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
			InputStream targetStream = Main.Utilities.targetStream(targetFile);
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourceStream, targetStream,
					ComparisonType.Slides, new SlidesComparisonSettings());
				
		}
		/*
		 * Comparing two presentations from streams without settings and saving results to a file
		 */
		public static void ComparePresentationsFromStreamToFileWitoutSettings(String sourceFile, String targetFile) throws Throwable{
			InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
			InputStream targetStream = Main.Utilities.targetStream(targetFile);
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension), ComparisonType.Slides);
		}
		/*
		 * Comparing two presentations from streams without settings and saving file
		 */
		public static void ComparePresentationsFromStreamWithoutSettings(String sourceFile, String targetFile) throws Throwable{
			InputStream sourceStream = Main.Utilities.sourceStream(sourceFile);
			InputStream targetStream = Main.Utilities.targetStream(targetFile);
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Slides);
		}
		/*
		 * Compare two presentations from files with saving file and  settings
		 */
		public static void ComparePresentationsFromFileToFileWithSettings(String sourceFile, String targetFile) throws Exception{
			String sourcePath = Main.Utilities.sourcePath + sourceFile;
			String targetPath = Main.Utilities.targetPath + targetFile;
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension), ComparisonType.Slides, new SlidesComparisonSettings());
		}
		/*
		 * Compare two presentations from files with settings
		 */
		public static void ComparePresentationsFromFileWithSettings(String sourceFile, String targetFile) throws Exception{
			String sourcePath = Main.Utilities.sourcePath + sourceFile;
			String targetPath = Main.Utilities.targetPath + targetFile;
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Slides, new SlidesComparisonSettings());
		}
		/*
		 * Comparing two presentations from files to file without settings 
		 */
		public static void ComparePresentationsFromFileToFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
			String sourcePath = Main.Utilities.sourcePath + sourceFile;
			String targetPath = Main.Utilities.targetPath + targetFile;
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension), ComparisonType.Slides);
		}
		/*
		 * Comparing two presentations from files without settings
		 */
		public static void ComparePresentationsFromFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
			String sourcePath = Main.Utilities.sourcePath + sourceFile;
			String targetPath = Main.Utilities.targetPath + targetFile;
			// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
			Comparison comparison = new Comparison();
			InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Slides);
		}
		
}
