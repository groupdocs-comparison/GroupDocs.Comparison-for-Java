package com.groupdocs.ui.comparison.spring.common.entity.web.request;

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
        return org.apache.commons.lang3.StringUtils.isNotBlank(password) ? password : null;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
