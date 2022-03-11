package com.groupdocs.ui.comparison.model.request;

import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;

import java.util.List;

public class CompareRequest {
    private List<LoadDocumentRequest> guids;

    public LoadDocumentRequest getSourceDocumentRequest() {
        if (guids.size() < 1) {
            throw new IllegalStateException("Request does not contain source document information");
        }
        return guids.get(0);
    }

    public LoadDocumentRequest getTargetDocumentRequest() {
        if (guids.size() < 2) {
            throw new IllegalStateException("Request does not contain target document information");
        }
        return guids.get(1);
    }

    public List<LoadDocumentRequest> getGuids() {
        return guids;
    }

    public void setGuids(List<LoadDocumentRequest> guids) {
        this.guids = guids;
    }
}
