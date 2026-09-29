package com.groupdocs.comparison.examples.advanced_usage;

import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;
import com.groupdocs.comparison.result.FileType;
import com.groupdocs.comparison.words.revision.ApplyRevisionOptions;
import com.groupdocs.comparison.words.revision.RevisionAction;
import com.groupdocs.comparison.words.revision.RevisionHandler;
import com.groupdocs.comparison.words.revision.RevisionInfo;
import com.groupdocs.comparison.words.revision.RevisionType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * This class demonstrates how to get revisions from a document, process and save the result
 */
public class AcceptRejectRevisions {

    /**
     * This example demonstrates how to get revisions from document path
     */
    public static void acceptRejectRevisionsFromPath() throws IOException {
        String outputFileNameAccepted = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "AcceptRevisionsFromPath");
        String outputFileNameRejected = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "RejectRevisionsFromPath");

        // Example of accepting some changes
        try (RevisionHandler revisionHandler = new RevisionHandler(SampleFiles.SOURCE_REVISIONS)) {
            List<RevisionInfo> revisionListForAccepted = revisionHandler.getRevisions();
            for (RevisionInfo revision : revisionListForAccepted) {
                if (revision.getType() == RevisionType.INSERTION) {
                    revision.setAction(RevisionAction.ACCEPT);
                }
            }
            revisionHandler.applyRevisionChanges(outputFileNameAccepted, new ApplyRevisionOptions(revisionListForAccepted));
        }

        // Example of rejecting some changes
        try (RevisionHandler revisionHandler = new RevisionHandler(SampleFiles.SOURCE_REVISIONS)) {
            List<RevisionInfo> revisionListForRejected = revisionHandler.getRevisions();
            for (RevisionInfo revision : revisionListForRejected) {
                if (revision.getType() == RevisionType.INSERTION) {
                    revision.setAction(RevisionAction.REJECT);
                }
            }
            revisionHandler.applyRevisionChanges(outputFileNameRejected, new ApplyRevisionOptions(revisionListForRejected));
        }
        System.out.println("\nRevisions processed successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to get revisions from document stream
     */
    public static void acceptRejectRevisionsFromStream() throws IOException {
        String outputFileNameAccepted = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "AcceptRevisionsFromStream");
        String outputFileNameRejected = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "RejectRevisionsFromStream");

        // Example of accepting some changes
        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_REVISIONS);
             OutputStream resultStream = new FileOutputStream(outputFileNameAccepted);
             RevisionHandler revisionHandler = new RevisionHandler(sourceStream, FileType.DOCX)) {
            List<RevisionInfo> revisionListForAccepted = revisionHandler.getRevisions();
            for (RevisionInfo revision : revisionListForAccepted) {
                if (revision.getType() == RevisionType.INSERTION) {
                    revision.setAction(RevisionAction.ACCEPT);
                }
            }
            revisionHandler.applyRevisionChanges(resultStream, new ApplyRevisionOptions(revisionListForAccepted));
        }

        // Example of rejecting some changes
        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_REVISIONS);
             OutputStream resultStream = new FileOutputStream(outputFileNameRejected);
             RevisionHandler revisionHandler = new RevisionHandler(sourceStream, FileType.DOCX)) {
            List<RevisionInfo> revisionListForRejected = revisionHandler.getRevisions();
            for (RevisionInfo revision : revisionListForRejected) {
                if (revision.getType() == RevisionType.INSERTION) {
                    revision.setAction(RevisionAction.REJECT);
                }
            }
            revisionHandler.applyRevisionChanges(resultStream, new ApplyRevisionOptions(revisionListForRejected));
        }
        System.out.println("\nRevisions processed successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }

    /**
     * This example demonstrates how to optimally handle all revisions
     */
    public static void acceptRejectAllRevisions() throws IOException {
        String outputFileNameAccepted = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "AcceptAllRevisions");
        String outputFileNameRejected = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "RejectAllRevisions");

        // Example of accepting all changes
        try (RevisionHandler revisionHandler = new RevisionHandler(SampleFiles.SOURCE_REVISIONS)) {
            revisionHandler.applyRevisionChanges(outputFileNameAccepted, new ApplyRevisionOptions(RevisionAction.ACCEPT));
        }

        // Example of rejecting all changes
        try (RevisionHandler revisionHandler = new RevisionHandler(SampleFiles.SOURCE_REVISIONS)) {
            revisionHandler.applyRevisionChanges(outputFileNameRejected, new ApplyRevisionOptions(RevisionAction.REJECT));
        }
        System.out.println("\nRevisions processed successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}
