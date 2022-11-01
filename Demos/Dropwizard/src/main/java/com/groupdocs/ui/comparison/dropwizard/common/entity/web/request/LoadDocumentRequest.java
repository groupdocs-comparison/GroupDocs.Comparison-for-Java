package com.groupdocs.ui.comparison.dropwizard.common.entity.web.request;

import org.apache.commons.lang3.StringUtils;

public class LoadDocumentRequest {

    private String guid;
    private String password;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPassword() {
        return StringUtils.isEmpty(password) || StringUtils.isBlank(password) ? null : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
