package com.groupdocs.ui.comparison;

import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.model.response.LoadDocumentEntity;
import com.groupdocs.ui.model.response.PageDescriptionEntity;

import java.util.List;

public interface ComparisonService {

    /**
     * Get configuration
     *
     * @return configuration
     */
    ComparisonConfiguration getComparisonConfiguration();

    /**
     * Load list of elements from directory
     *
     * @param fileTreeRequest request with path to directory
     * @return list of files and folders
     */
    List<FileDescriptionEntity> loadFiles(FileTreeRequest fileTreeRequest);

    /**
     * Compare two documents, save results in files,
     * return result descriptions and paths to result files
     *
     * @param compareRequest request with paths to documents to compare
     * @return comparing results
     */
    CompareResultResponse compare(CompareRequest compareRequest);

    /**
     * Load the description of the page
     *
     * @param loadDocumentPageRequest request with parameters
     * @return the description of the page
     */
    LoadDocumentEntity loadDocumentDescription(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Load the page of results
     *
     * @param loadDocumentPageRequest request with path to page result
     * @return page result data
     */
    PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Check format files for comparing
     *
     * @param request
     * @return true - formats of the both files are the same and format is supported, false - other
     */
    boolean checkFiles(CompareRequest request);
}
