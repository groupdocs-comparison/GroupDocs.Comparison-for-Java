package com.groupdocs.comparison.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.groupdocs.comparison.common.license.License;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		// Setup license
		// Utilities.applyLicenseFromFile();

		// Word documents comparison_______________________________________

		// compare word document streams and save output to a file
		//WordDocumentComparison.CompareWordDocumentsFromStreamToFile("source.docx", "target.docx");

		// compare word document streams
		//WordDocumentComparison.CompareWordDocumentsFromStreamWithSettings("source.docx", "target.docx");

		// compare word document streams without settings
		//WordDocumentComparison.CompareWordDocumentsFromStreamToFileWitoutSettings("source.docx", "target.docx");

		// compare word document streams without settings and saving file
		//WordDocumentComparison.CompareWordDocumentsFromStreamWithoutSettings("source.docx", "target.docx");

		// compare word document files with settings and saving file
		//WordDocumentComparison.CompareWordDocumentsFromFileToFileWithSettings("source.docx", "target.docx");

		// compare word document files with settings
		//WordDocumentComparison.CompareWordDocumentsFromFileWithSettings("source.docx", "target.docx");

		// compare word document files to file without settings
		//WordDocumentComparison.CompareWordDocumentsFromFileToFileWithoutSettings("source.docx", "target.docx");

		// compare word document files without saving and settings
		//WordDocumentComparison.CompareWordDocumentsFromFileWithoutSettings("source.docx", "target.docx");

		// Compare word documents from file using setting properties
		//WordDocumentComparison.compareWordDocumentsFromFileWithSettingsProperties("source.docx", "target.docx");

		// Comparison settings when comparing files
		//WordDocumentComparison.comparisonSettingsWhenComparingFiles("source.docx", "target.docx");

		// Comparer for comparing two documents from file
		//WordDocumentComparison.comparerForDocsFromFiles("source.docx", "target.docx");

		// Comparer for comparing two encrypted documents from file
		//WordDocumentComparison.comparerForEncryptedDocsFromFiles("source.docx", "target.docx");

		// Comparer for comparing two documents from stream
		//WordDocumentComparison.comparerForDocsFromStream("source.docx", "target.docx");

		// Comparer for comparing two encrypted documents from stream
		//WordDocumentComparison.comparerForEncryptedDocsFromStream("source.docx", "target.docx");

		// Multi comparer for comparing more than two documents from file
		//WordDocumentComparison.multiComparerForDocsFromFiles("source.docx", "target.docx", "target_2.docx","target_3.docx");

		// Multi comparer for comparing more than two documents from stream
		//WordDocumentComparison.multiComparerForDocsFromStream("source.docx", "target.docx", "target_2.docx","target_3.docx");

		// Multi comparer for comparing more than two encrypted documents from
		// file
		//WordDocumentComparison.multiComparerForEncryptedDocsFromFiles("source.docx", "target.docx", "target_2.docx","target_3.docx");

		// Multi comparer for comparing more than two encrypted documents from
		// stream
		//WordDocumentComparison.multiComparerForEncryptedDocsFromStream("source.docx", "target.docx", "target_2.docx","target_3.docx");

		// Properties of ICompareResult
		//WordDocumentComparison.propertiesOfICompareResult("source.docx", "target.docx");

		// End word documents
		// comparison___________________________________________________

		// Workbooks comparison

		// compare workbooks from streams and save output to a file
		//WorkbookDocumentComparison.CompareWorkBooksFromStreamToFileWithSettings("source.xlsx", "target.xlsx");

		// compare workbooks from streams with settings
		//WorkbookDocumentComparison.CompareWorkBooksFromStreamWithSettings("source.xlsx", "target.xlsx");

		// compare workbooks from streams to file without settings
		//WorkbookDocumentComparison.CompareWorkBooksFromStreamToFile("source.xlsx", "target.xlsx");

		// compare workbooks from streams without setting and saving to file
		//WorkbookDocumentComparison.CompareWorkBooksFromStream("source.xlsx", "target.xlsx");

		// compare workbooks from files to file with settings
		//WorkbookDocumentComparison.CompareWorkBooksFromFilesToFileWithSettings("source.xlsx", "target.xlsx");

		// compare workbooks from files with settings, without saving
		//WorkbookDocumentComparison.CompareWorkBooksFromFilesWithSettings("source.xlsx", "target.xlsx");

		// compare workbooks from files to file without settings
		//WorkbookDocumentComparison.CompareWorkBooksFromFilesToFile("source.xlsx", "target.xlsx");

		// compare workbooks from files without settings and saving
		//WorkbookDocumentComparison.CompareWorkBooksFromFiles("source.xlsx", "target.xlsx");

		// End workbooks
		// comparison__________________________________________________

		// Text document comparison

		// compare text from streams to file with settings
		//TextDocumentsComparision.CompareTextDcumentsFromStreamToFileWithSettings("source.txt", "target.txt");

		// compare text from streams with settings, without saving
		//TextDocumentsComparision.CompareTextDcumentsFromStreamWithSettings("source.txt", "target.txt");

		// compare text from streams to file without settings
		//TextDocumentsComparision.CompareTextDcumentsFromStreamToFile("source.txt", "target.txt");

		// compare text from stream without saving and settings
		//TextDocumentsComparision.CompareTextDcumentsFromStream("source.txt", "target.txt");

		// compare text from files to file with settings
		//TextDocumentsComparision.CompareTextDcumentsFromFileToFileWithSetting("source.txt", "target.txt");

		// compare text from files with setting, without saving
		//TextDocumentsComparision.CompareTextDcumentsFromFileWithSetting("source.txt", "target.txt");

		// compare text from file to file without saving
		//TextDocumentsComparision.CompareTextDcumentsFromFileToFile("source.txt", "target.txt");

		// compare text from file without saving and settings
		//TextDocumentsComparision.CompareTextDcumentsFromFile("source.txt", "target.txt");

		// End text document
		// comparison__________________________________________________________

		// Presentations comparison

		// compare presentation streams and save output to a file
		//PresentationDocumentsComparision.ComparePresentationsFromStreamToFile("source.pptx", "target.pptx");

		// compare presentations streams
		//PresentationDocumentsComparision.ComparePresentationsFromStreamWithSettings("source.pptx", "target.pptx");

		// compare presentations streams without settings
		//PresentationDocumentsComparision.ComparePresentationsFromStreamToFileWitoutSettings("source.pptx","target.pptx");

		// compare presentations streams without settings and saving file
		//PresentationDocumentsComparision.ComparePresentationsFromStreamWithoutSettings("source.pptx", "target.pptx");

		// compare presentations files with settings and saving file
		//PresentationDocumentsComparision.ComparePresentationsFromFileToFileWithSettings("source.pptx", "target.pptx");

		// compare presentations files with settings
		//PresentationDocumentsComparision.ComparePresentationsFromFileWithSettings("source.pptx", "target.pptx");

		// compare presentations files to file without settings
		//PresentationDocumentsComparision.ComparePresentationsFromFileToFileWithoutSettings("source.pptx","target.pptx");

		// compare presentations files without saving and settings
		//PresentationDocumentsComparision.ComparePresentationsFromFileWithoutSettings("source.pptx", "target.pptx");

		// End presentations
		// comparison_____________________________________________________________

		// PDF comparison

		// compare pdf documents streams and save output to a file
		//PdfDocumentsComparision.ComparePdfFromStreamToFile("source.pdf", "target.pdf");

		// compare pdf documents streams
		//PdfDocumentsComparision.ComparePdfFromStreamWithSettings("source.pdf", "target.pdf");

		// compare pdf documents streams without settings
		//PdfDocumentsComparision.ComparePdfFromStreamToFileWitoutSettings("source.pdf", "target.pdf");

		// compare pdf documents streams without settings and saving file
		//PdfDocumentsComparision.ComparePdfFromStreamWithoutSettings("source.pdf", "target.pdf");

		// compare pdf documents files with settings and saving file
		//PdfDocumentsComparision.ComparePdfFromFileToFileWithSettings("source.pdf", "target.pdf");

		// compare pdf documents files with settings
		//PdfDocumentsComparision.ComparePdfFromFileWithSettings("source.pdf", "target.pdf");

		// compare pdf documents files to file without settings
		//PdfDocumentsComparision.ComparePdfFromFileToFileWithoutSettings("source.pdf", "target.pdf");

		// compare pdf documents files without saving and settings
		//PdfDocumentsComparision.ComparePdfFromFileWithoutSettings("source.pdf", "target.pdf");

		// End pdf
		// comparison_____________________________________________________________

		// HTML Comparison

		// compare two html documents
		//HTMLDocumentsComparision.CompareHtmlFromStreamToFile("source.html", "target.html");

		// End HTML Comparison_____________________
	}
}
