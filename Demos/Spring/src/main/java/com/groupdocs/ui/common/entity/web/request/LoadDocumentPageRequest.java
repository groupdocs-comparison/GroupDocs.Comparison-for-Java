package com.groupdocs.ui.common.entity.web.request;

public class LoadDocumentPageRequest extends LoadDocumentRequest {
    private Integer page;
    private boolean loadAllPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public boolean isLoadAllPages() {
        return loadAllPages;
    }

    public void setLoadAllPages(boolean loadAllPages) {
        this.loadAllPages = loadAllPages;
    }
}
