package com.groupdocs.ui.comparison.service;

import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.model.request.CompareRequest;
import com.groupdocs.ui.comparison.model.response.CompareResultResponse;

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
     * Load the page of results
     *
     * @param loadDocumentPageRequest request with path to page result
     * @return page result data
     */
    PageDescriptionEntity loadResultPage(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Check format files for comparing
     *
     * @param request
     * @return true - formats of the both files are the same and format is supported, false - other
     */
    boolean checkFiles(CompareRequest request);

    LoadDocumentEntity loadDocument(LoadDocumentRequest loadDocumentRequest);
}
