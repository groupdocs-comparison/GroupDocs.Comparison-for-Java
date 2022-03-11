package com.groupdocs.ui.common.entity.web.request;

import org.apache.commons.lang3.StringUtils;

public class FileTreeRequest {
    private String path;

    public boolean isNotEmpty() {
        return StringUtils.isNotEmpty(path) && StringUtils.isNotBlank(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
