package com.groupdocs.ui.comparison.spring.service;

import com.groupdocs.ui.comparison.spring.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.comparison.spring.common.util.SessionCache;
import com.groupdocs.ui.comparison.spring.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.spring.model.request.CompareRequest;
import com.groupdocs.ui.comparison.spring.model.response.CompareResultResponse;
import com.groupdocs.ui.comparison.spring.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.comparison.spring.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.comparison.spring.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.comparison.spring.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.comparison.spring.common.entity.web.PageDescriptionEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
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
    List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest) throws IOException;

    /**
     * Loads document
     *
     * @param loadDocumentRequest request with paths to documents to load
     * @return document loading result
     */
    LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest, SessionCache sessionCache) throws Exception;

    /**
     * Load the page of results
     *
     * @param loadDocumentPageRequest request with path to page result
     * @return page result data
     */
    PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest, SessionCache sessionCache) throws Exception;

    /**
     * Compare two documents, save results in files,
     * return result descriptions and paths to result files
     *
     * @param compareRequest request with paths to documents to compare
     * @return comparing results
     */
    CompareResultResponse compare(CompareRequest compareRequest, SessionCache sessionCache) throws Exception;

    /**
     * Check format files for comparing
     *
     * @return true - formats of the both files are the same and format is supported, false - other
     */
    boolean checkFiles(CompareRequest request);

    String uploadFile(InputStream inputStream, String fileName, boolean isRewrite) throws Exception;

    @FunctionalInterface
    interface DownloadFileCallback {
        void call(long length, InputStream inputStream) throws IOException;
    }

    void downloadFile(String fileGuid, DownloadFileCallback callback) throws IOException;
}
