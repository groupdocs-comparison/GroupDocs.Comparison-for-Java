package com.groupdocs.ui.comparison.spring.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * CommonConfiguration
 *
 * @author Aspose Pty Ltd
 */
@Component
public class CommonConfiguration {

    @Value("${common.pageSelector}")
    private Boolean pageSelector;

    @Value("${common.download}")
    private Boolean download;

    @Value("${common.upload}")
    private Boolean upload;

    @Value("${common.print}")
    private Boolean print;

    @Value("${common.browse}")
    private Boolean browse;

    @Value("${common.rewrite}")
    private Boolean rewrite;

    @Value("${common.enableRightClick}")
    private Boolean enableRightClick;

    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isBrowse() {
        return browse;
    }

    public void setBrowse(boolean browse) {
        this.browse = browse;
    }

    public boolean isRewrite() {
        return rewrite;
    }

    public void setRewrite(boolean rewrite) {
        this.rewrite = rewrite;
    }

    public Boolean isEnableRightClick() {
        return enableRightClick;
    }

    public void setEnableRightClick(Boolean enableRightClick) {
        this.enableRightClick = enableRightClick;
    }

    @Override
    public String toString() {
        return "CommonConfiguration{" +
                "pageSelector=" + isPageSelector() +
                ", download=" + isDownload() +
                ", upload=" + isUpload() +
                ", print=" + isPrint() +
                ", browse=" + isBrowse() +
                ", rewrite=" + isRewrite() +
                ", enableRightClick=" + isEnableRightClick() +
                '}';
    }
}
