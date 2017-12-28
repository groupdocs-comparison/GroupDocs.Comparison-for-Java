package com.groupdocs.comparison.examples;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.MultiComparer;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.ICompareResult;
import com.groupdocs.comparison.common.changes.ChangeInfo;
import com.groupdocs.comparison.common.comparisonsettings.ComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;

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
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".docx"));
		//ExEnd:CompareWordDocumentsFromStreamToFile
	}
	
	 /* Comparing two word document from streams, with settings */
	 
	public static void CompareWordDocumentsFromStreamWithSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:CompareWordDocumentsFromStreamWithSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, settings);
		result.saveDocument(Utilities.outputFileName(".docx"));
		//ExEnd:CompareWordDocumentsFromStreamWithSettings
	}
	
	 /* Comparing two word document from streams without settings and saving results to a file	  */
	 
	public static void CompareWordDocumentsFromStreamToFileWitoutSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:CompareWordDocumentsFromStreamToFileWitoutSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".docx"));
		//ExEnd:CompareWordDocumentsFromStreamToFileWitoutSettings
	}
	
	 /* Comparing two word document from streams without settings and saving file*/
	 
	public static void CompareWordDocumentsFromStreamWithoutSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:CompareWordDocumentsFromStreamWithoutSettings
		InputStream sourceStream = com.groupdocs.comparison.examples.Utilities.sourceStream(sourceFile);
		InputStream targetStream = com.groupdocs.comparison.examples.Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourceStream, targetStream, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".docx"));
		//ExEnd:CompareWordDocumentsFromStreamWithoutSettings
	}
	
	 /* Compare two word document from files with saving file and  settings*/
	 
	public static void CompareWordDocumentsFromFileToFileWithSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileToFileWithSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".docx"));
	//ExEnd:CompareWordDocumentsFromFileToFileWithSettings
	}
	
	 /* Compare two word document from files with settings*/
	 
	public static void CompareWordDocumentsFromFileWithSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileWithSettings
		String sourcePath = com.groupdocs.comparison.examples.Utilities.sourcePath + sourceFile;
		String targetPath = com.groupdocs.comparison.examples.Utilities.targetPath + targetFile;
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(false);
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, settings);
		result.saveDocument(Utilities.outputFileName(".docx"));
	//ExEnd:CompareWordDocumentsFromFileWithSettings
	}
	
	 /* Comparing two word document from files to file without settings */
	 
	public static void CompareWordDocumentsFromFileToFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileToFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".docx"));
		//ExEnd:CompareWordDocumentsFromFileToFileWithoutSettings
	}
	
	 /* Comparing two word document from files without settings*/
	 
	public static void CompareWordDocumentsFromFileWithoutSettings(String sourceFile, String targetFile) throws Exception{
		//ExStart:CompareWordDocumentsFromFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparer and call method
		// Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".docx"));
		//ExEnd:CompareWordDocumentsFromFileWithoutSettings
	}
	
	//Compare word documents from file using setting properties
	public static void compareWordDocumentsFromFileWithSettingsProperties(String sourceFile, String targetFile) throws Exception{
		//ExStart:compareWordDocumentsFromFileWithSettingsProperties
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		
		//CellsComparisonSettings settings = new CellsComparisonSettings()
		ComparisonSettings settings = new ComparisonSettings();  
		settings.setGenerateSummaryPage(true);
		settings.setShowDeletedContent(false);			
		//settings.setProcessHyperLinksAsAText(true);
		// Create instance of GroupDocs.Comparison.Comparison and call method Compare.
		Comparer comparison = new Comparer();
		ICompareResult result = comparison.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(".docx"));
	//ExEnd:compareWordDocumentsFromFileWithSettingsProperties
	}
	
	//Comparison settings when comparing files
	public static void comparisonSettingsWhenComparingFiles(String sourceFile, String targetFile) throws Exception{
		//ExStart:comparisonSettingsWhenComparingFiles		
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		
		ComparisonSettings settings = new ComparisonSettings();
		settings.setGenerateSummaryPage(true);
		settings.setShowDeletedContent(true);
		settings.setStyleChangeDetection(true);
		//settings.setDetailLevel(DetailLevel.Low);
		/**WordsSeparatorChars is array that contain separators for compared text**/
		//settings.setWordsSeparatorChars(new char[] {' '});
		/**setting to draw frames for shapes in Comparison.Words**/
		//settings.setUseFramesForDelInsElements(false);
		/**Inserted, deleted and style changed items styles setting**/
		/*
		settings.getInsertedItemsStyle().setColor(Color.LIGHT_GRAY);
		settings.getInsertedItemsStyle().setBeginSeparatorString("<inserted>");
		settings.getInsertedItemsStyle().setEndSeparatorString("</inserted>");
		settings.getDeletedItemsStyle().setColor(Color.CYAN);
		settings.getDeletedItemsStyle().setBeginSeparatorString("<deleted>");
		settings.getDeletedItemsStyle().setEndSeparatorString("</deleted>");
		 
		settings.getStyleChangedItemsStyle().setColor(Color.BLUE);
		settings.getStyleChangedItemsStyle().setBeginSeparatorString("<style>");
		settings.getStyleChangedItemsStyle().setEndSeparatorString("</style>");
		*/		 
		Comparer comparer = new Comparer();
		ICompareResult result = comparer.compare(sourcePath, targetPath,settings);
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:comparisonSettingsWhenComparingFiles
	}
	
	//Comparer for comparing two documents from file
	public static void comparerForDocsFromFiles(String sourceFile, String targetFile) throws Exception{		
		//ExStart:comparerForDocsFromFiles
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		
		Comparer comparer = new Comparer();
		ICompareResult result = comparer.compare(sourcePath, targetPath, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:comparerForDocsFromFiles
	}
	
	//Comparer for comparing two encrypted documents from file
	public static void comparerForEncryptedDocsFromFiles(String sourceFile, String targetFile) throws Exception{	
		//ExStart:comparerForEncryptedDocsFromFiles
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		
		String sourcePassword = Utilities.sourcePassword;
		String targetPassword = Utilities.targetPassword;
		Comparer comparer = new Comparer();
		ICompareResult result = comparer.compare(sourcePath, sourcePassword, targetPath, targetPassword, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:comparerForEncryptedDocsFromFiles
	}
	
	//Comparer for comparing two documents from stream
	public static void comparerForDocsFromStream(String sourceFile, String targetFile) throws Exception{		
		//ExStart:comparerForDocsFromStream		
		InputStream source = new FileInputStream(Utilities.sourcePath + sourceFile);
		InputStream target = new FileInputStream(Utilities.targetPath + targetFile);
		 
		Comparer comparer = new Comparer();
		ICompareResult result = comparer.compare(source, target, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:comparerForDocsFromStream
	}
	//Comparer for comparing two encrypted documents from stream
	public static void comparerForEncryptedDocsFromStream(String sourceFile, String targetFile) throws Exception{
		//ExStart:comparerForEncryptedDocsFromStream
		InputStream source = new FileInputStream(Utilities.sourcePath + sourceFile);
		InputStream target = new FileInputStream(Utilities.targetPath + targetFile);
		
		String sourcePassword = Utilities.sourcePassword;
		String targetPassword = Utilities.targetPassword;
		 
		Comparer comparer = new Comparer();
		ICompareResult result = comparer.compare(source, sourcePassword, target, targetPassword, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:comparerForEncryptedDocsFromStream
	}
	//Multi comparer for comparing more than two documents from file
	public static void multiComparerForDocsFromFiles(String sourceFile, String targetFile,String targetFile_2,String targetFile_3) throws Exception{		
		//ExStart:multiComparerForDocsFromFiles
		String sourcePath = Utilities.sourcePath + sourceFile;
		
		List<String> targets = Arrays.asList(
			Utilities.targetPath + targetFile,
			Utilities.targetPath + targetFile_2,
			Utilities.targetPath + targetFile_3
		);
		MultiComparer comparer = new MultiComparer();
		ICompareResult result = comparer.compare(sourcePath, targets, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:multiComparerForDocsFromFiles
	}
	
	//Multi comparer for comparing more than two documents from stream
	public static void multiComparerForDocsFromStream(String sourceFile, String targetFile,String targetFile_2,String targetFile_3) throws Exception{		
		//ExStart:multiComparerForDocsFromStream
		InputStream source = new FileInputStream(Utilities.sourcePath +sourceFile);
		List<InputStream> targets = Arrays.<InputStream>asList(
		        new FileInputStream(Utilities.targetPath + targetFile),
		        new FileInputStream(Utilities.targetPath + targetFile_2),
		        new FileInputStream(Utilities.targetPath + targetFile_3)
		);
		MultiComparer comparer = new MultiComparer();
		ICompareResult result = comparer.compare(source, targets, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:multiComparerForDocsFromStream
	}
	
	//Multi comparer for comparing more than two encrypted documents from file
	public static void multiComparerForEncryptedDocsFromFiles(String sourceFile, String targetFile,String targetFile_2,String targetFile_3) throws Exception{		
		//ExStart:multiComparerForEncryptedDocsFromFiles
		String sourcePath = Utilities.sourcePath + sourceFile;
		List<String> targets = Arrays.asList(
			Utilities.targetPath + targetFile,
			Utilities.targetPath + targetFile_2,
			Utilities.targetPath + targetFile_3
		);
		String sourcePassword = Utilities.sourcePassword;
		List<String> targetPasswords = Arrays.asList(
			Utilities.targetPassword,
			Utilities.targetPassword,
			Utilities.targetPassword
		);
		MultiComparer comparer = new MultiComparer();
		ICompareResult result = comparer.compare(sourcePath, sourcePassword, targets, targetPasswords, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:multiComparerForEncryptedDocsFromFiles
	}
	
	//Multi comparer for comparing more than two encrypted documents from stream 
	public static void multiComparerForEncryptedDocsFromStream(String sourceFile, String targetFile,String targetFile_2,String targetFile_3) throws Exception{		
		//ExStart:multiComparerForEncryptedDocsFromStream
		InputStream sourceStream = new FileInputStream(Utilities.sourcePath + sourceFile);
		List<InputStream> targets = Arrays.<InputStream>asList(
		        new FileInputStream(Utilities.targetPath + targetFile),
		        new FileInputStream(Utilities.targetPath + targetFile_2),
		        new FileInputStream(Utilities.targetPath + targetFile_3)
		);
		 
		String sourcePassword = Utilities.sourcePassword;
		List<String> targetPasswords = Arrays.asList(
			Utilities.targetPassword,
			Utilities.targetPassword,
			Utilities.targetPassword
		);
		 
		MultiComparer comparer = new MultiComparer();
		ICompareResult result = comparer.compare(sourceStream, sourcePassword, targets, targetPasswords, new ComparisonSettings());
		result.saveDocument(Utilities.outputFileName(extension));
		//ExEnd:multiComparerForEncryptedDocsFromStream
	}
	
	//Properties of ICompareResult
	public static void propertiesOfICompareResult(String sourceFile, String targetFile) throws Exception{		
		//ExStart:propertiesOfICompareResult		
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		
		Comparer comparer = new Comparer();
		ICompareResult result = comparer.compare(sourcePath, targetPath, new ComparisonSettings());
		//Save result document to file
		result.saveDocument(Utilities.outputFileName(extension));
		
		//Get stream of result document
		InputStream resultStream = result.getStream();
		 
		/**Save images of result document to folder**/
		//result.saveImages(Utilities.outputFileName(".jpg"));
		 
		/**Get images of result document as array of streams**/
		//List<InputStream> imgStreams = result.getImages();
		 
		//Get array of changes
		ChangeInfo[] changes = result.getChanges();
		 
		//Update changes in CompareResult object (this method updated result document)
		result.updateChanges(changes);
		
		/**To update changes use the following algorithm:**/		
		//Set actions of changes as Accept or Reject
		
		/*ChangeInfo[] changes = result.getChanges();
		changes[0].setAction(ComparisonAction.Accept);
		changes[1].setAction(ComparisonAction.Reject);
		result.updateChanges(changes);*/		
		//ExEnd:propertiesOfICompareResult
	}
}
