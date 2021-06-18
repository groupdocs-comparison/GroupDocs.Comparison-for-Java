package com.groupdocs.ui.comparison.model.request;

import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;

import java.util.List;

public class CompareRequest {
    private List<LoadDocumentRequest> guids;

    public List<LoadDocumentRequest> getGuids() {
        return guids;
    }

    public void setGuids(List<LoadDocumentRequest> guids) {
        this.guids = guids;
    }
}
