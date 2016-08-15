package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.groupdocs.comparison.common.license.License;
import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		// Setup license
		License license = new License();
		license.setLicense(Utilities.licensePath);
		
		// Word documents comparison_______________________________________

		// compare word document streams and save output to a file
		// WordDocumentComparison.CompareWordDocumentsFromStreamToFile("source.docx","target.docx");

		// compare word document streams
		// WordDocumentComparison.CompareWordDocumentsFromStreamWithSettings("source.docx","target.docx");

		// compare word document streams without settings
		// WordDocumentComparison.CompareWordDocumentsFromStreamToFileWitoutSettings("source.docx","target.docx");

		// compare word document streams without settings and saving file
		// WordDocumentComparison.CompareWordDocumentsFromStreamWithoutSettings("source.docx","target.docx");

		// compare word document files with settings and saving file
		// WordDocumentComparison.CompareWordDocumentsFromFileToFileWithSettings("source.docx","target.docx");

		// compare word document files with settings
		// WordDocumentComparison.CompareWordDocumentsFromFileWithSettings("source.docx","target.docx");

		// compare word document files to file without settings
		// WordDocumentComparison.CompareWordDocumentsFromFileToFileWithoutSettings("source.docx","target.docx");

		// compare word document files without saving and settings
		// WordDocumentComparison.CompareWordDocumentsFromFileWithoutSettings("source.docx","target.docx");

		// End word documents comparison___________________________________________________

		// Workbooks comparison

		// compare workbooks from streams and save output to a file
		// WorkbookDocumentComparison.CompareWorkBooksFromStreamToFileWithSettings("source.xlsx","target.xlsx");

		// compare workbooks from streams with settings
		// WorkbookDocumentComparison.CompareWorkBooksFromStreamWithSettings("source.xlsx","target.xlsx");

		// compare workbooks from streams to file without settings
		// WorkbookDocumentComparison.CompareWorkBooksFromStreamToFile("source.xlsx","target.xlsx");

		// compare workbooks from streams without setting and saving to file
		// WorkbookDocumentComparison.CompareWorkBooksFromStream("source.xlsx","target.xlsx");

		// compare workbooks from files to file with settings
		// WorkbookDocumentComparison.CompareWorkBooksFromFilesToFileWithSettings("source.xlsx","target.xlsx");

		// compare workbooks from files with settings, without saving
		// WorkbookDocumentComparison.CompareWorkBooksFromFilesWithSettings("source.xlsx","target.xlsx");

		// compare workbooks from files to file without settings
		// WorkbookDocumentComparison.CompareWorkBooksFromFilesToFile("source.xlsx","target.xlsx");

		// compare workbooks from files without settings and saving
		// WorkbookDocumentComparison.CompareWorkBooksFromFiles("source.xlsx","target.xlsx");

		// End workbooks comparison__________________________________________________

		// Text document comparison

		// compare text from streams to file with settings
		// TextDocumentsComparision.CompareTextDcumentsFromStreamToFileWithSettings("source.txt","target.txt");

		// compare text from streams with settings, without saving
		// TextDocumentsComparision.CompareTextDcumentsFromStreamWithSettings("source.txt","target.txt");

		// compare text from streams to file without settings
		// TextDocumentsComparision.CompareTextDcumentsFromStreamToFile("source.txt","target.txt");

		// compare text from stream without saving and settings
		// TextDocumentsComparision.CompareTextDcumentsFromStream("source.txt","target.txt");

		// compare text from files to file with settings
		// TextDocumentsComparision.CompareTextDcumentsFromFileToFileWithSetting("source.txt","target.txt");

		// compare text from files with setting, without saving
		// TextDocumentsComparision.CompareTextDcumentsFromFileWithSetting("source.txt","target.txt");

		// compare text from file to file without saving
		// TextDocumentsComparision.CompareTextDcumentsFromFileToFile("source.txt","target.txt");

		// compare text from file without saving and settings
		// TextDocumentsComparision.CompareTextDcumentsFromFile("source.txt","target.txt");

		// End text document comparison__________________________________________________________

		// Presentations comparison

		// compare presentation streams and save output to a file
		// PresentationDocumentsComparision.ComparePresentationsFromStreamToFile("source.pptx","target.pptx");

		// compare presentations streams
		// PresentationDocumentsComparision.ComparePresentationsFromStreamWithSettings("source.pptx","target.pptx");

		// compare presentations streams without settings
		// PresentationDocumentsComparision.ComparePresentationsFromStreamToFileWitoutSettings("source.pptx","target.pptx");

		// compare presentations streams without settings and saving file
		// PresentationDocumentsComparision.ComparePresentationsFromStreamWithoutSettings("source.pptx","target.pptx");

		// compare presentations files with settings and saving file
		// PresentationDocumentsComparision.ComparePresentationsFromFileToFileWithSettings("source.pptx","target.pptx");

		// compare presentations files with settings
		// PresentationDocumentsComparision.ComparePresentationsFromFileWithSettings("source.pptx","target.pptx");

		// compare presentations files to file without settings
		// PresentationDocumentsComparision.ComparePresentationsFromFileToFileWithoutSettings("source.pptx","target.pptx");

		// compare presentations files without saving and settings
		// PresentationDocumentsComparision.ComparePresentationsFromFileWithoutSettings("source.pptx","target.pptx");

		// End presentations comparison_____________________________________________________________
		
		// PDF comparison

		// compare pdf documents streams and save output to a file
		// PdfDocumentsComparision.ComparePdfFromStreamToFile("source.pdf","target.pdf");

		// compare pdf documents streams
		// PdfDocumentsComparision.ComparePdfFromStreamWithSettings("source.pdf","target.pdf");

		// compare pdf documents streams without settings
		// PdfDocumentsComparision.ComparePdfFromStreamToFileWitoutSettings("source.pdf","target.pdf");

		// compare pdf documents streams without settings and saving file
		// PdfDocumentsComparision.ComparePdfFromStreamWithoutSettings("source.pdf","target.pdf");

		// compare pdf documents files with settings and saving file
		// PdfDocumentsComparision.ComparePdfFromFileToFileWithSettings("source.pdf","target.pdf");

		// compare pdf documents files with settings
		// PdfDocumentsComparision.ComparePdfFromFileWithSettings("source.pdf","target.pdf");

		// compare pdf documents files to file without settings
		// PdfDocumentsComparision.ComparePdfFromFileToFileWithoutSettings("source.pdf","target.pdf");

		// compare pdf documents files without saving and settings
		// PdfDocumentsComparision.ComparePdfFromFileWithoutSettings("source.pdf","target.pdf");

		// End pdf comparison_____________________________________________________________
		
		//HTML Comparison
		
		//compare two html documents
		//HTMLDocumentsComparision.CompareHtmlFromStreamToFile("source.html","target.html");
		
		//End HTML Comparison_____________________
		
		//other operations
		
		//Open words document from stream
		//OtherComparisonOperations.openWordDocsFromStream("source.docx");
		
		//Open words document from file.
		//OtherComparisonOperations.openWordDocsFromFile("source.docx");
		
		//Compare two documents with method compareWith
		//OtherComparisonOperations.compareWordDocsWithCompareWith("source.docx","target.docx");
		
		//Get document from WordsCompareResult with method getDocumet
		//OtherComparisonOperations.getWordDocumentFromGetDocument("source.docx","target.docx");
		
		//save document to file
		//OtherComparisonOperations.saveWordDocumentToFile("source.docx","target.docx");
		
		//save document to stream with method save
		//OtherComparisonOperations.saveWordDocumentToStream("source.docx","target.docx");
		
		//compare two paragraphs
		//OtherComparisonOperations.compareTwoParagraphs();
		
		//compare two cells
		//OtherComparisonOperations.compareTwoCells();
		
		//compare two columns
		//OtherComparisonOperations.compareTwoColums();
		
		//compare two rows
		//OtherComparisonOperations.compareTwoRows();
		
		//compare two tables
		//OtherComparisonOperations.compareTwoTables();
		
		
		//compare two workbooks
		//OtherComparisonOperations.compareTwoWorkboos("source.xlsx","target.xlsx");
		
		//compare two cells with compareWith method
		//OtherComparisonOperations.compareTwoCellsWithCompareWith("source.xlsx","target.xlsx");
		
		//compare two pdf with compareWith method
		//OtherComparisonOperations.comparePdfWithCompareWith("source.pdf","target.pdf");
		
		//compare two slides with compareWith method
		//OtherComparisonOperations.compareSlidesWithCompareWith("source.pptx","target.pptx");
		
		//compare documents from string with result path and target extension
		//OtherComparisonOperations.compareDocsFromStringWithTargetExtension("source.docx","target.docx");
		
		//compare encrypted documents from string
		//OtherComparisonOperations.compareEncryptedDocumentsFromStrings("source.docx","target.docx");
		
		//compare encrypted documents from string with result path setting target extension
		//OtherComparisonOperations.compareEncryptedDocumentsWithSettingsAndSaving("source.docx","target.docx");
		
		//End other options
		
		
	}
}
