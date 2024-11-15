package com.groupdocs.examples.comparison;

import com.groupdocs.examples.comparison.advanced_usage.PrintSupportedFileTypes;
import com.groupdocs.examples.comparison.advanced_usage.comparison.*;
import com.groupdocs.examples.comparison.advanced_usage.loading.LoadDocumentFromLocalDisc;
import com.groupdocs.examples.comparison.advanced_usage.loading.LoadDocumentFromStream;
import com.groupdocs.examples.comparison.advanced_usage.previews.*;
import com.groupdocs.examples.comparison.advanced_usage.saving.SetDocumentMetadata;
import com.groupdocs.examples.comparison.advanced_usage.saving.SetPasswordForResultantDocument;
import com.groupdocs.examples.comparison.basic_usage.*;
import com.groupdocs.examples.comparison.quick_start.HelloWorld;
import com.groupdocs.examples.comparison.quick_start.licensing.SetLicenseFromStream;
import com.groupdocs.examples.comparison.utils.FailureRegister;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/comparison/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        final boolean printFailedSamplesStacktrace = System.getenv("PRINT_FAILED_SAMPLES_STACKTRACE") != null;
        FailureRegister.getInstance().printFailedSamples(printFailedSamplesStacktrace);

        System.out.println("\nAll done.");
        System.exit(FailureRegister.getInstance().getFailedSamplesCount());
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
//            SetLicenseFromFile.run();
            SetLicenseFromStream.run();
//            SetMeteredLicense.run();
        }
        { // Quick start
            HelloWorld.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
        }
        { // Basic usage
            CompareCellsFromPath.run(SampleFiles.SOURCE_XLSX, SampleFiles.TARGET_XLSX);
            CompareCellsFromStream.run(SampleFiles.SOURCE_XLSX, SampleFiles.TARGET_XLSX);
            CompareDirectoriesFromPath.run(SampleFiles.SOURCE_DIRECTORY, SampleFiles.TARGET_DIRECTORY);
            CompareProtectedWordFromPath.run(SampleFiles.SOURCE_DOCX_PROTECTED, SampleFiles.TARGET_DOCX_PROTECTED);
            CompareProtectedWordFromStream.run(SampleFiles.SOURCE_DOCX_PROTECTED, SampleFiles.TARGET_DOCX_PROTECTED);
            CompareWordFromPath.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
            CompareWordFromStream.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
        }
        { // Advanced usage
//            GetMeteredCreditsLimit.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC); // You should set metered key firstly.
            PrintSupportedFileTypes.run();

            { // Comparison
                AcceptRejectDetectedChangesPath.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
                AcceptRejectDetectedChangesStream.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
                CompareDocumentsSettingsStream.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
                MultipleCompareDocumentsPath.compareMultipleWordsDocuments(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX, SampleFiles.TARGET2_DOCX, SampleFiles.TARGET3_DOCX);
                MultipleCompareDocumentsPath.compareMultipleTxtDocuments(SampleFiles.SOURCE_TXT, SampleFiles.TARGET1_TXT, SampleFiles.TARGET2_TXT, SampleFiles.TARGET3_TXT);
                MultipleCompareDocumentsPath.compareMultipleEmailDocuments(SampleFiles.SOURCE_EML, SampleFiles.TARGET1_EML, SampleFiles.TARGET2_EML, SampleFiles.TARGET3_EML);
                MultipleCompareDocumentsPath.compareMultiplePdfDocuments(SampleFiles.SOURCE_PDF, SampleFiles.TARGET1_PDF, SampleFiles.TARGET2_PDF, SampleFiles.TARGET3_PDF);
                MultipleCompareDocumentsPath.compareMultipleDiagramDocuments(SampleFiles.SOURCE_VSDX, SampleFiles.TARGET1_VSDX, SampleFiles.TARGET2_VSDX, SampleFiles.TARGET3_VSDX, SampleFiles.DIAGRAM_MASTER);
                MultipleCompareProtectedDocumentsPath.run(SampleFiles.SOURCE_DOCX_PROTECTED, SampleFiles.TARGET1_DOCX_PROTECTED, SampleFiles.TARGET2_DOCX_PROTECTED, SampleFiles.TARGET3_DOCX_PROTECTED);
                MultipleCompareProtectedDocumentsStream.run(SampleFiles.SOURCE_DOCX_PROTECTED, SampleFiles.TARGET1_DOCX_PROTECTED, SampleFiles.TARGET2_DOCX_PROTECTED, SampleFiles.TARGET3_DOCX_PROTECTED);
                MultipleCompareDocumentsSettingsPath.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX, SampleFiles.TARGET2_DOCX, SampleFiles.TARGET3_DOCX);
                MultipleCompareDocumentsSettingsStream.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX, SampleFiles.TARGET2_DOCX, SampleFiles.TARGET3_DOCX);
                MultipleCompareDocumentsStream.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX, SampleFiles.TARGET2_DOCX, SampleFiles.TARGET3_DOCX);
                GetChanges.getChangesCoordinates(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                GetChanges.getListOfChangesPath(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                GetChanges.getListOfChangesStream(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                GetChanges.getTargetText(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                UseCompareOptions.ignoreHeaderFooter(SampleFiles.SOURCE_DOCX_WITH_FOOTER, SampleFiles.TARGET_DOCX_WITH_FOOTER);
                UseCompareOptions.setOutputPaperSize(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                UseCompareOptions.adjustComparisonSensitivity(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                UseCompareOptions.customizeChangesStylesStream(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                UseCompareOptions.customizeChangesStylesPath(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
            }
            { // Previews
                PreviewResultantDocument.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
                PreviewResultantDocumentWithMemoryClean.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                PreviewResultantDocumentWithMemoryClean.run(SampleFiles.SOURCE_VSDX, SampleFiles.TARGET1_VSDX);
                PreviewSourceDocument.run(SampleFiles.SOURCE_DOC);
                PreviewTargetDocument.run(SampleFiles.SOURCE_DOC, SampleFiles.TARGET_DOC);
                PreviewWithSpecificImagesSize.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                PreviewWithSpecificImagesSize.run(SampleFiles.SOURCE_VSDX, SampleFiles.TARGET1_VSDX);
            }
            { // Loading
                LoadDocumentFromLocalDisc.run(SampleFiles.SOURCE_PDF, SampleFiles.TARGET1_PDF);
                LoadDocumentFromStream.run(SampleFiles.SOURCE_PDF, SampleFiles.TARGET1_PDF);
            }
            { // Saving
                SetDocumentMetadata.cloneSource(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                SetDocumentMetadata.cloneTarget(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                SetDocumentMetadata.cloneUserDefined(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
                SetPasswordForResultantDocument.run(SampleFiles.SOURCE_DOCX, SampleFiles.TARGET1_DOCX);
            }
        }

    }
}
