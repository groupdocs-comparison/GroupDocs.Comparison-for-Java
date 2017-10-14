package com.groupdocs.comparison.examples;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.groupdocs.comparison.Comparison;
import com.groupdocs.comparison.common.ComparisonType;
import com.groupdocs.comparison.common.comparisonsettings.SlidesComparisonSettings;
import com.groupdocs.comparison.common.images.ComparisonSlidesImageSettings;
import com.groupdocs.comparison.slides.ComparisonPresentation;
import com.groupdocs.comparison.slides.contracts.comparison.ComparisonPresentationBase;

public class PresentationDocumentsComparision {
	// document extension
	private static String extension = ".pptx";

	/*
	 * Comparing two presentations from streams, with settings and saving output
	 * to a resultant file
	 */ 
	
	public static void ComparePresentationsFromStreamToFile(String sourceFile, String targetFile) throws Throwable {
		//ExStart:ComparePresentationsFromStreamToFile
		// Create two streams of textFiles
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension),
				ComparisonType.Slides, new SlidesComparisonSettings());
		//ExEnd:ComparePresentationsFromStreamToFile
	}

	
	/* Comparing two presentations from streams, with settings */
	 
	public static void ComparePresentationsFromStreamWithSettings(String sourceFile, String targetFile)
			throws Throwable {
		//ExStart:ComparePresentationsFromStreamWithSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Slides,
				new SlidesComparisonSettings());
		//ExEnd:ComparePresentationsFromStreamWithSettings
	}

	
	 /* Comparing two presentations from streams without settings and saving
	 * results to a file */
	 
	public static void ComparePresentationsFromStreamToFileWitoutSettings(String sourceFile, String targetFile)
			throws Throwable {
		//ExStart:ComparePresentationsFromStreamToFileWitoutSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, Utilities.outputFileName(extension),
				ComparisonType.Slides);
		//ExEnd:ComparePresentationsFromStreamToFileWitoutSettings
	}

	
	 /* Comparing two presentations from streams without settings and saving file*/
	 
	public static void ComparePresentationsFromStreamWithoutSettings(String sourceFile, String targetFile)
			throws Throwable {
		//ExStart:ComparePresentationsFromStreamWithoutSettings
		InputStream sourceStream = Utilities.sourceStream(sourceFile);
		InputStream targetStream = Utilities.targetStream(targetFile);
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourceStream, targetStream, ComparisonType.Slides);
		//ExEnd:ComparePresentationsFromStreamWithoutSettings
	}

	
	 /* Compare two presentations from files with saving file and settings*/
	 
	public static void ComparePresentationsFromFileToFileWithSettings(String sourceFile, String targetFile)
			throws Exception {
		//ExStart:ComparePresentationsFromFileToFileWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension),
				ComparisonType.Slides, new SlidesComparisonSettings());
		//ExEnd:ComparePresentationsFromFileToFileWithSettings
	}

	
	 /* Compare two presentations from files with settings*/
	 
	public static void ComparePresentationsFromFileWithSettings(String sourceFile, String targetFile) throws Exception {
		//ExStart:ComparePresentationsFromFileWithSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Slides,
				new SlidesComparisonSettings());
		//ExEnd:ComparePresentationsFromFileWithSettings
	}

	
	 /* Comparing two presentations from files to file without settings*/
	 
	public static void ComparePresentationsFromFileToFileWithoutSettings(String sourceFile, String targetFile)
			throws Exception {
		//ExStart:ComparePresentationsFromFileToFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, Utilities.outputFileName(extension),
				ComparisonType.Slides);
		//ExEnd:ComparePresentationsFromFileToFileWithoutSettings
	}

	
	 /* Comparing two presentations from files without settings*/
	 
	public static void ComparePresentationsFromFileWithoutSettings(String sourceFile, String targetFile)
			throws Exception {
		//ExStart:ComparePresentationsFromFileWithoutSettings
		String sourcePath = Utilities.sourcePath + sourceFile;
		String targetPath = Utilities.targetPath + targetFile;
		// Create instance of GroupDocs.Comparison.Comparison and call method
		// Compare.
		Comparison comparison = new Comparison();
		InputStream result = comparison.compare(sourcePath, targetPath, ComparisonType.Slides);
		//ExEnd:ComparePresentationsFromFileWithoutSettings
	}

	//Save presentation to image from file
	public static void savePresentationToImageFromFile(String sourceFile) throws Exception{
		//ExStart:savePresentationToImageFromFile
		String sourcePath = Utilities.sourcePath + sourceFile;
		//path to image folder
		String imageFolderPath = Utilities.resultFilePath.toString();		 
		//Open  document
		ComparisonPresentationBase presentation = new ComparisonPresentation(sourcePath);		 
		//Set settings
		ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();		 
		//Save as Image
		presentation.saveAsImages(imageFolderPath, settings);
		//ExEnd:savePresentationToImageFromFile
	}
	
	//Save presentation to image with stream
	public static void savePresentationToImageWithStream(String sourceFile) throws Exception{
		//ExStart:savePresentationToImageWithStream
		String sourcePath = Utilities.sourcePath + sourceFile;
		//stream
		ArrayList<ByteArrayOutputStream> imageStream = new ArrayList<ByteArrayOutputStream>();		 
		//Open  document
		ComparisonPresentationBase presentation = new ComparisonPresentation(sourcePath);		 
		//Set settings
		ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();		 
		//Save as Image
		presentation.saveAsImages(imageStream, settings);
		//ExEnd:savePresentationToImageWithStream
	}
	
	//Save slide to image from file
	public static void saveSlideToImageFromFile(String sourceFile) throws Exception{
		//ExStart:saveSlideToImageFromFile
		String sourcePath = Utilities.sourcePath + sourceFile;
		//path to image folder
		String imageFolderPath = Utilities.resultFilePath.toString();					 
		//Open  document
		ComparisonPresentationBase presentation = new ComparisonPresentation(sourcePath);		 
		//Set settings
		ComparisonSlidesImageSettings settings = new ComparisonSlidesImageSettings();	
		int slideIndex =1;
		//Save as Image
		presentation.saveSlideAsImage(imageFolderPath, settings,slideIndex);
		//ExEnd:saveSlideToImageFromFile
	}
	
}
