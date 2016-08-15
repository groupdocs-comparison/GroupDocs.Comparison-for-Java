package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.groupdocs.comparison.*;
import com.groupdocs.comparison.common.license.License;
//ExStart:commonutilitiesclass
public class Utilities {

	// ExStart:CommonProperties
	public final static String sourcePath = "./Data/SourceFiles/";
	public final static String targetPath = "./Data/TargetFiles/";
	public final static String licensePath = "D:/GroupDocs.Total.Java.lic";
	public final static String resultFile = "result";
	public final static String sourcePassword = "pass";
	public final static String targetPassword = "pass";
	public static String outputFileName(String extension) {
		String resultPath = "./Data/ResultFiles/" + resultFile + extension;
		return resultPath;
	}
	// ExEnd:CommonProperties

	/**
	 * This method applies product license from file
	 * 
	 */
	public static void applyLicenseFromFile(String filePath) {
		//ExStart:applyLicenseFromFile
		try {
			// Setup license
			License lic = new License();
			lic.setLicense(filePath);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		//ExEnd:applyLicenseFromFile
	}
	/**
	 * This method applies product license from stream
	 * 
	 */
	public static void applyLicenseFromStream(String filePath) {
		// ExStart:ApplyLicenseFromStreamObj
		try {
			// Obtain license stream
			FileInputStream licenseStream = new FileInputStream(filePath);

			// Setup license
			License lic = new License();
			lic.setLicense(licenseStream);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:ApplyLicenseFromStreamObj
	}
	public static InputStream sourceStream(String sourceFile) throws Throwable {
		String sourceFilePath = sourcePath + sourceFile;
		InputStream sourceStream = new FileInputStream(sourceFilePath);
		return sourceStream;
	}
	public static InputStream targetStream(String targetFile) throws Throwable {
		String targetFilePath = targetPath + targetFile;
		InputStream targetStream = new FileInputStream(targetFilePath);
		return targetStream;
	}
}
//ExEnd:commonutilitiesclass
