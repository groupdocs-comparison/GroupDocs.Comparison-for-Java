package com.groupdocs.ui.comparison.model.response;

import com.groupdocs.comparison.common.changes.ChangeInfo;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;

import java.util.List;

public class CompareResultResponse {
    /**
     * List of change information
     */
    private ChangeInfo[] changes;
    /**
     * List of images of pages with marked changes
     */
    private List<PageDescriptionEntity> pages;
    /**
     * Unique key of results
     */
    private String guid;
    /**
     * Extension of compared files, for saving total results
     */
    private String extension;

    public void setChanges(ChangeInfo[] changes) {
        this.changes = changes;
    }

    public ChangeInfo[] getChanges() {
        return changes;
    }

    public List<PageDescriptionEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageDescriptionEntity> pages) {
        this.pages = pages;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
