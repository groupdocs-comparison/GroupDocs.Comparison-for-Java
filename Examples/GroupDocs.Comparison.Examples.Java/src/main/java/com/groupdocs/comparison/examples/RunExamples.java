package com.groupdocs.comparison.examples;

import com.groupdocs.comparison.examples.advanced_usage.comparison.*;
import com.groupdocs.comparison.examples.advanced_usage.generate_page_previews.*;
import com.groupdocs.comparison.examples.advanced_usage.loading.LoadDocumentFromLocalDisc;
import com.groupdocs.comparison.examples.advanced_usage.loading.LoadDocumentFromStream;
import com.groupdocs.comparison.examples.advanced_usage.saving.SetDocumentMetadataSource;
import com.groupdocs.comparison.examples.advanced_usage.saving.SetDocumentMetadataTarget;
import com.groupdocs.comparison.examples.advanced_usage.saving.SetDocumentMetadataUserDefined;
import com.groupdocs.comparison.examples.advanced_usage.saving.SetPasswordForResultantDocument;
import com.groupdocs.comparison.examples.basic_usage.*;
import com.groupdocs.comparison.examples.quick_start.HelloWorld;
import com.groupdocs.comparison.examples.quick_start.SetLicenseFromFile;

public class RunExamples {

    /**
     * The main method.
     */

    public static void main(String[] args) throws Exception {

        System.out.println("Uncomment the example(s) that you want to run in RunExamples.java file.");
        System.out.println("=======================================================================");
        // Clean output
        Utils.deleteOutputDirectory();

        //NOTE: Please uncomment the example you want to try out
        // region Quick Start
        SetLicenseFromFile.run();
        //SetLicenseFromStream.run();
        //SetMeteredLicense.run();
        HelloWorld.run();
        // endregion

        // region Get supported file formats
        GetSupportedFormats.run();
        // endregion

        // region Get document info
        GetDocumentInfoPath.run();
        // endregion

        // region Get document info
        GetDocumentInfoStream.run();
        // endregion

        // region Compare cells files from path
        CompareCellsFromPath.run();
        // endregion

        // region Compare cells files from stream
        CompareCellsFromStream.run();
        // endregion

        // region Compare documents from path
        CompareDocumentsFromPath.run();
        // endregion

        // region Compare documents from stream
        CompareDocumentsFromStream.run();
        // endregion

        // region Compare documents from path with customized change styles from path
        UseCompareOptions.customizeChangesStylesPath();
        // endregion

        // region Compare documents from path with customized change styles from stream
        UseCompareOptions.customizeChangesStylesStream();
        // endregion

        // region Compare documents from stream with some settings
        CompareDocumentsSettingsStream.run();
        // endregion

        // region Compare documents with passwords from path
        CompareDocumentsProtectedPath.run();
        // endregion

        // region Compare documents with passwords from stream
        CompareDocumentsProtectedStream.run();
        // endregion

        // region Get list of changes from path
        GetChanges.getListOfChangesPath();
        // endregion

        // region Get list of changes from stream
        GetChanges.getListOfChangesStream();
        // endregion

        // region Update changes from path
        AcceptRejectDetectedChangesPath.run();
        // endregion

        // region Update changes from stream
        AcceptRejectDetectedChangesStream.run();
        // endregion

        // region Multicompare documents from path
        CompareMultipleDocumentsPath.compareMultipleWordsDocuments();
        // endregion

        // region Multicompare documents from stream
        CompareMultipleDocumentsStream.run();
        // endregion

        // region Multicompare protected documents from path
        CompareMultipleDocumentsProtectedPath.run();
        // endregion

        // region Multicompare protected documents from stream
        CompareMultipleDocumentsProtectedStream.run();
        // endregion

        // region Multicompare documents with settings from stream
        CompareMultipleDocumentsSettingsStream.run();
        // endregion

        // region Multicompare documents with settings from path
        CompareMultipleDocumentsSettingsPath.run();
        // endregion

        // region Preview document pages for source document
        GetPagePreviewsForSourceDocument.run();
        // endregion

        // region Preview document pages for target document
        GetPagePreviewsForTargetDocument.run();
        // endregion

        // region Preview document pages for resultant document
        GetPagePreviewsForResultantDocument.run();
        // endregion

        // region Preview document page specific image size
        SetSpecificImagesSize.run();
        // endregion

        // region Calculate coordinates
        GetChanges.getChangesCoordinates();
        // endregion

        // region Metered credits
        //GetMeteredCreditsLimit.run();
        // endregion

        // region Using page preview release stream delegate
        GetPagePreviewsResouresCleaning.run();
        // endregion

        // region Using sensitivity option
        UseCompareOptions.adjustComparisonSensitivity();
        // endregion

        // region Using SaveOptions target metadata
        SetDocumentMetadataTarget.run();
        // endregion

        // region Using SaveOptions source metadata
        SetDocumentMetadataSource.run();
        // endregion

        // region Using SaveOptions user metadata
        SetDocumentMetadataUserDefined.run();
        // endregion

        // region Protect result document
        SetPasswordForResultantDocument.run();
        // endregion

        // region Load documents from stream
        LoadDocumentFromLocalDisc.run();
        // endregion

        // region Load documents from path
        LoadDocumentFromStream.run();
        // endregion

        // region Multi compare for txt
        CompareMultipleDocumentsPath.compareMultipleTxtDocuments();
        // endregion

        // region Multi compare for email
        CompareMultipleDocumentsPath.compareMultipleEmailDocuments();
        // endregion

        // region Multi compare for pdf
        CompareMultipleDocumentsPath.compareMultiplePdfDocuments();
        // endregion

        // region Multi compare for diagram
        CompareMultipleDocumentsPath.compareMultipleDiagramDocuments();
        // endregion

        // region Ignore Header/Footer
        UseCompareOptions.ignoreHeaderFooter();
        // endregion

        // region Set output paper size
        UseCompareOptions.setOutputPaperSize();
        // endregion

        // region Get target text from changed range
        GetChanges.getTargetText();
        // endregion

        System.out.println();
        System.out.println("All done.");
    }
}
