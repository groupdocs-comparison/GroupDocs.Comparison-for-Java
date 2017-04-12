package com.groupdocs.comparison.examples;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.cells.contracts.ICellsCompareResult;
import com.groupdocs.comparison.cells.contracts.enums.ComparisonSaveFormat;
import com.groupdocs.comparison.cells.contracts.nodes.ComparisonParagraphBase;
import com.groupdocs.comparison.cells.nodes.ComparisonCell;
import com.groupdocs.comparison.cells.nodes.ComparisonWorkbook;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.FileType;
import com.groupdocs.comparison.common.comparisonsettings.CellsComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.PdfComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.SlidesComparisonSettings;
import com.groupdocs.comparison.common.comparisonsettings.WordsComparisonSettings;
import com.groupdocs.comparison.pdf.ComparisonPdfDocument;
import com.groupdocs.comparison.pdf.contracts.comparedresult.IPdfComparedResult;
import com.groupdocs.comparison.slides.ComparisonColumn;
import com.groupdocs.comparison.slides.ComparisonPresentation;
import com.groupdocs.comparison.slides.ComparisonRow;
import com.groupdocs.comparison.slides.ComparisonSlide;
import com.groupdocs.comparison.slides.ComparisonTable;
import com.groupdocs.comparison.slides.contracts.ISlidesCompareResult;
import com.groupdocs.comparison.slides.contracts.comparison.ComparisonAutoShapeBase;
import com.groupdocs.comparison.slides.contracts.comparison.ComparisonSlideBase;
import com.groupdocs.comparison.slides.contracts.enums.ComparisonShapeType;
import com.groupdocs.comparison.text.contracts.IComparisonParagraph;
import com.groupdocs.comparison.text.contracts.IComparisonTextComponent;
import com.groupdocs.comparison.words.contracts.IWordsCompareResult;
import com.groupdocs.comparison.words.contracts.nodes.IComparisonCell;
import com.groupdocs.comparison.words.contracts.nodes.IComparisonColumn;
import com.groupdocs.comparison.words.contracts.nodes.IComparisonDocument;
import com.groupdocs.comparison.words.contracts.nodes.IComparisonRow;
import com.groupdocs.comparison.words.contracts.nodes.IComparisonTable;
import com.groupdocs.comparison.words.nodes.ComparisonDocument;
import com.groupdocs.comparison.words.nodes.ComparisonParagraph;

public class OtherComparisonOperations {

	public static void openWordDocsFromStream(String sourceFile) throws Throwable {
		//ExStart:openWordDocsFromStream
		// Create stream of document
		InputStream sourceStream = new FileInputStream(sourceFile);
		// Open ComparisonDocument.
		ComparisonDocument document = new ComparisonDocument(sourceStream);
		//ExEnd:openWordDocsFromStream
	}

	public static void openWordDocsFromFile(String sourceFile) throws Throwable {
		//ExStart:openWordDocsFromFile
		String sourcePath = Utilities.sourcePath + sourceFile;
		// Open *ComparisonDocument*.
		ComparisonDocument document = new ComparisonDocument(sourcePath);
		//ExEnd:openWordDocsFromFile
	}

	public static void compareWordDocsWithCompareWith(String sourceFile, String targetFile) throws Throwable {
		//ExStart:compareWordDocsWithCompareWith
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.sourcePath + targetFile;
		ComparisonDocument source = new ComparisonDocument(sourcePath);
		ComparisonDocument target = new ComparisonDocument(targetPath);
		// Call method *CompareWith()*
		IWordsCompareResult result = source.compareWith(target, new WordsComparisonSettings());
		//ExEnd:compareWordDocsWithCompareWith
	}

	public static void getWordDocumentFromGetDocument(String sourceFile, String targetFile) throws Throwable {
		//ExStart:getWordDocumentFromGetDocument
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.sourcePath + targetFile;
		ComparisonDocument source = new ComparisonDocument(sourcePath);
		ComparisonDocument target = new ComparisonDocument(targetPath);
		// Call method *CompareWith()*
		IWordsCompareResult result = source.compareWith(target, new WordsComparisonSettings());
		// Call *GetDocument()* method
		IComparisonDocument resultDocument = result.getDocument();
		//ExEnd:getWordDocumentFromGetDocument
	}

	public static void saveWordDocumentToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:saveWordDocumentToFile
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.sourcePath + targetFile;
		ComparisonDocument source = new ComparisonDocument(sourcePath);
		ComparisonDocument target = new ComparisonDocument(targetPath);
		// Call method *CompareWith()*
		IWordsCompareResult result = source.compareWith(target, new WordsComparisonSettings());
		// Call *GetDocument()* method
		IComparisonDocument resultDocument = result.getDocument();
		// Call *Save()* method
		resultDocument.save("result.docx", ComparisonSaveFormat.Auto);
		//ExEnd:saveWordDocumentToFile
	}

	public static void saveWordDocumentToStream(String sourceFile, String targetFile) throws Throwable {
		//ExStart:saveWordDocumentToStream
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.sourcePath + targetFile;
		ComparisonDocument source = new ComparisonDocument(sourcePath);
		ComparisonDocument target = new ComparisonDocument(targetPath);
		// Call method *CompareWith()*
		IWordsCompareResult result = source.compareWith(target, new WordsComparisonSettings());
		// Call *GetDocument()* method
		IComparisonDocument resultDocument = result.getDocument();
		// Call *Save()* method
		resultDocument.save("result.docx", ComparisonSaveFormat.Auto);
		// Create stream
		OutputStream stream = new ByteArrayOutputStream();

		// Call *save()* method
		resultDocument.save(stream, ComparisonSaveFormat.Auto);
		//ExEnd:saveWordDocumentToStream
	}

	public static void compareTwoParagraphs() throws Throwable {
		//ExStart:compareTwoParagraphs
		// Creating Paragraphs
		IComparisonParagraph sourceParagraph = (IComparisonParagraph) new ComparisonParagraph();
		sourceParagraph.addRun("This is source Paragraph.");

		IComparisonParagraph targetParagraph = (IComparisonParagraph) new ComparisonParagraph();
		targetParagraph.addRun("This is target Paragraph.");

		// Creating settings for comparison of Paragraphs
		WordsComparisonSettings settings = new WordsComparisonSettings();
		// Comparing Paragraphs
		IWordsCompareResult compareResult = ((IComparisonDocument) sourceParagraph)
				.compareWith((IComparisonDocument) targetParagraph, settings);
		//ExEnd:compareTwoParagraphs
	}

	public static void compareTwoCells() {
		//ExStart:compareTwoCells
		// Creating Cells
		IComparisonCell sourceCell = (IComparisonCell) new ComparisonCell();
		IComparisonParagraph paragraph = (IComparisonParagraph) sourceCell.addParagraph();
		paragraph.addRun("This is Cell of source table.");

		IComparisonCell targetCell = (IComparisonCell) new ComparisonCell();
		paragraph = (IComparisonParagraph) targetCell.addParagraph();
		paragraph.addRun("This is Cell of target table.");

		// Creating settings for comparison of Cells
		WordsComparisonSettings settings = new WordsComparisonSettings();
		// Comparing Cells
		IWordsCompareResult compareResult = sourceCell.compareWith(targetCell, settings);
		//ExEnd:compareTwoCells
	}

	public static void compareTwoColums() {
		//ExStart:compareTwoColums
		// Creating Columns
		IComparisonColumn sourceColumn = (IComparisonColumn) new ComparisonColumn(new double[] { 20, 20 }, 100);
		IComparisonParagraph paragraph = (IComparisonParagraph) sourceColumn.getCells()[0].addParagraph();
		paragraph.addRun("This is cell.");
		paragraph = (IComparisonParagraph) sourceColumn.getCells()[1].addParagraph();
		paragraph.addRun("This is Cell of source table.");

		IComparisonColumn targetColumn = (IComparisonColumn) new ComparisonColumn(new double[] { 20, 20 }, 100);
		paragraph = (IComparisonParagraph) targetColumn.getCells()[0].addParagraph();
		paragraph.addRun("This is cell.");
		paragraph = (IComparisonParagraph) targetColumn.getCells()[1].addParagraph();
		paragraph.addRun("This is Cell of target table.");

		// Creating settings for comparison of Columns
		WordsComparisonSettings settings = new WordsComparisonSettings();
		// Comparing Columns
		IWordsCompareResult compareResult = sourceColumn.compareWith(targetColumn, settings);
		//ExEnd:compareTwoColums
	}

	public static void compareTwoRows() {
		//ExStart:compareTwoRows
		// Creating Rows
		IComparisonRow sourceRow = (IComparisonRow) new ComparisonRow(new double[] { 100, 100 }, 20);
		IComparisonParagraph paragraph = (IComparisonParagraph) sourceRow.getCells()[0].addParagraph();
		paragraph.addRun("This is cell.");
		paragraph = (IComparisonParagraph) sourceRow.getCells()[1].addParagraph();
		paragraph.addRun("This is Cell of source table.");

		IComparisonRow targetRow = (IComparisonRow) new ComparisonRow(new double[] { 100, 100 }, 20);
		paragraph = (IComparisonParagraph) targetRow.getCells()[0].addParagraph();
		paragraph.addRun("This is cell.");
		paragraph = (IComparisonParagraph) targetRow.getCells()[1].addParagraph();
		paragraph.addRun("This is Cell of target table.");

		// Creating settings for comparison of Rows
		WordsComparisonSettings settings = new WordsComparisonSettings();
		// Comparing Rows
		IWordsCompareResult compareResult = sourceRow.compareWith(targetRow, settings);
		//ExEnd:compareTwoRows
	}

	/*
	 * compare two tables
	 */
	public static void compareTwoTables() {
		//ExStart:compareTwoTables
		// Creating Tables
		IComparisonTable sourceTable = (IComparisonTable) new ComparisonTable(0, 0, new double[] { 100, 100 },
				new double[] { 20, 20 });
		IComparisonParagraph paragraph = (IComparisonParagraph) sourceTable.getRows()[0].getCells()[0].addParagraph();
		paragraph.addRun("This is cell.");
		paragraph = (IComparisonParagraph) sourceTable.getRows()[0].getCells()[1].addParagraph();
		paragraph.addRun("This is Cell of source table.");
		paragraph = (IComparisonParagraph) sourceTable.getRows()[1].getCells()[0].addParagraph();
		paragraph.addRun("This is Cel of tble.");

		IComparisonTable targetTable = (IComparisonTable) new ComparisonTable(0, 0, new double[] { 100, 100 },
				new double[] { 20, 20 });
		paragraph = (IComparisonParagraph) targetTable.getRows()[0].getCells()[0].addParagraph();
		paragraph.addRun("This is cell.");
		paragraph = (IComparisonParagraph) targetTable.getRows()[0].getCells()[1].addParagraph();
		paragraph.addRun("This is Cell of target table.");
		paragraph = (IComparisonParagraph) targetTable.getRows()[1].getCells()[0].addParagraph();
		paragraph.addRun("This is Cell of table.");

		// Creating settings for comparison of Tables
		WordsComparisonSettings settings = new WordsComparisonSettings();
		// Comparing Tables
		IWordsCompareResult compareResult = sourceTable.compareWith(targetTable, settings);
		//ExEnd:compareTwoTables
	}

	/*
	 * compare two workbooks
	 */
	public static void compareTwoWorkboos(String sourceFile, String targetFile) throws Throwable {
		//ExStart:compareTwoWorkboos
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;

		// Open two workbooks
		ComparisonWorkbook source = new ComparisonWorkbook(sourcePath);
		ComparisonWorkbook target = new ComparisonWorkbook(targetPath);

		// Call method CompareWith.
		ICellsCompareResult result = source.compareWith(target, new CellsComparisonSettings());
		//ExEnd:compareTwoWorkboos
	}

	/*
	 * compare two cells with method compareWith
	 */
	public static void compareTwoCellsWithCompareWith(String sourceFile, String targetFile) throws Throwable {
		//ExStart:compareTwoCellsWithCompareWith
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;

		// Open two workbooks
		ComparisonWorkbook source = new ComparisonWorkbook(sourcePath);
		ComparisonWorkbook target = new ComparisonWorkbook(targetPath);

		// Compare cells
		CellsComparisonSettings settings = new CellsComparisonSettings();
		final ICellsCompareResult result = source.getWorksheets()[0].getCellRange().getItem("A6")
				.compareWith(target.getWorksheets()[0].getCellRange().getItem("A6"), settings);
		//ExEnd:compareTwoCellsWithCompareWith
	}

	/*
	 * Compare PDF documents with compareWith method
	 */
	public static void comparePdfWithCompareWith(String sourceFile, String targetFile) throws Throwable {
		//ExStart:comparePdfWithCompareWith
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Open two documents
		ComparisonPdfDocument source = new ComparisonPdfDocument(sourcePath);
		ComparisonPdfDocument target = new ComparisonPdfDocument(targetPath);

		// Call method CompareWith.
		IPdfComparedResult result = source.compareWith(target, new PdfComparisonSettings());
		//ExEnd:comparePdfWithCompareWith
	}

	/*
	 * Compare two slides with compareWith method
	 */
	public static void compareSlidesWithCompareWith(String sourceFile, String targetFile) throws Throwable {
		//ExStart:compareSlidesWithCompareWith
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Open two presentations
		ComparisonPresentation source = new ComparisonPresentation(sourcePath);
		ComparisonPresentation target = new ComparisonPresentation(targetPath);

		// Call method CompareWith.
		ISlidesCompareResult result = source.compareWith(target, new SlidesComparisonSettings());
		//ExEnd:compareSlidesWithCompareWith
	}
	/*
	 * Compare documents from strings
	 */
	public static void compareDocsFromStrings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareDocsFromStrings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath);
		//ExEnd:compareDocsFromStrings
	}
	/*
	 * Compare documents from string with result path and target extension
	 */
	public static void compareDocsFromStringWithTargetExtension(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareDocsFromStringWithTargetExtension
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(".docx"), FileType.Docx);
		//ExEnd:compareDocsFromStringWithTargetExtension
	}
	
	/*
	 * Compare documents from string with result path and settings
	 */
	public static void compareDocsFromStringWithSettings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareDocsFromStringWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, new WordsComparisonSettings());
		//ExEnd:compareDocsFromStringWithSettings
	}
	
	/*
	 * Compare documents from strings with result path and target extension
	 */
	public static void compareDocsFromStringWithSettingsAndFileExtension(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareDocsFromStringWithSettingsAndFileExtension
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(".docx") , new WordsComparisonSettings(), FileType.Docx);
		//ExEnd:compareDocsFromStringWithSettingsAndFileExtension
	}
	
	/*
	 * Compare documents from strings with result path and type.
	 */
	public static void compareDocsWithResultAndType(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareDocsWithResultAndType
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(".docx") , ComparisonType.Words);
		//ExEnd:compareDocsWithResultAndType
	}
	
	/*
	 * Compare documents from strings with result path type and target extension
	 */
	public static void compareDocsWithResultAndTargetExtension(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareDocsWithResultAndTargetExtension
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(".docx"),ComparisonType.Words, FileType.Docx);
		//ExEnd:compareDocsWithResultAndTargetExtension
	}
	
	/*
	 * Compare encrypted documents from strings.
	 */
	public static void compareEncryptedDocumentsFromStrings(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareEncryptedDocumentsFromStrings
		Comparison comparison = new Comparison();
		String sourcePass = Utilities.sourcePassword;
		String targetPass = Utilities.targetPassword;
		InputStream result = comparison.compare(sourceFile, sourcePass, targetFile, targetPass);
		System.out.println(result.available());
		//ExEnd:compareEncryptedDocumentsFromStrings
	}
	
	/*
	 * Compare encrypted documents from strings with result path and target extension.
	 */
	public static void compareEncryptedDocsWithResultAndTargetExtension(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareEncryptedDocsWithResultAndTargetExtension
		Comparison comparison = new Comparison();
		String sourcePass = Utilities.sourcePassword;
		String targetPass = Utilities.targetPassword;
		InputStream result = comparison.compare(sourceFile, sourcePass, targetFile, targetPass, Utilities.outputFileName(".docx"), FileType.Docx);
		System.out.println(result.available());
		//ExEnd:compareEncryptedDocsWithResultAndTargetExtension
	}
	
	/*
	 * Compare encrypted documents from strings with result path settings and target extension
	 */
	public static void compareEncryptedDocumentsWithSettingsAndSaving(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareEncryptedDocumentsWithSettingsAndSaving
		Comparison comparison = new Comparison();
		String sourcePass = Utilities.sourcePassword;
		String targetPass = Utilities.targetPassword;
		InputStream result = comparison.compare(sourceFile, sourcePass, targetFile, targetPass, Utilities.outputFileName(".docx"), new WordsComparisonSettings(), FileType.Docx);
		System.out.println(result.available());
		//ExEnd:compareEncryptedDocumentsWithSettingsAndSaving
	}
	
	/*
	 * Compare encrypted documents from strings with result path and type
	 */
	public static void compareEncryptedDocsWithResultAndType(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareEncryptedDocsWithResultAndType
		Comparison comparison = new Comparison();
		String sourcePass = Utilities.sourcePassword;
		String targetPass = Utilities.targetPassword;
		InputStream result = comparison.compare(sourceFile, sourcePass, targetFile, targetPass, Utilities.outputFileName(".docx"), ComparisonType.Words);
		System.out.println(result.available());
		//ExEnd:compareEncryptedDocsWithResultAndType
	}
	
	/*
	 * Compare encrypted documents from strings with result path type and target extension
	 */
	public static void compareEncryptedDocsWithResultTypeAndTargetExtension(String sourceFile, String targetFile) throws Throwable{
		//ExStart:compareEncryptedDocsWithResultTypeAndTargetExtension
		Comparison comparison = new Comparison();
		String sourcePass = Utilities.sourcePassword;
		String targetPass = Utilities.targetPassword;
		InputStream result = comparison.compare(sourceFile, sourcePass, targetFile, targetPass, Utilities.outputFileName(".docx"), ComparisonType.Words, FileType.Docx);
		System.out.println(result.available());
		//ExEnd:compareEncryptedDocsWithResultTypeAndTargetExtension
	}
	
	/*
	 * Compare encrypted documents from strings with type.
	 */
	public static void compareEncryptedDocsFromStringsWithType(String sourceFile, String targetFile) throws Exception{
		//ExStart:compareEncryptedDocsFromStringsWithType
		Comparison comparison = new Comparison();
		String sourcePass = Utilities.sourcePassword;
		String targetPass = Utilities.targetPassword;
		InputStream result = comparison.compare(sourceFile, sourcePass, targetFile, targetPass, ComparisonType.Words);
		System.out.println(result.available());
		//ExEnd:compareEncryptedDocsFromStringsWithType
	}
	
	
}
