package com.groupdocs.ui.comparison.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.common.config.CommonConfiguration;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;

import javax.validation.Valid;

public class ComparisonConfigurationModel {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String resultDirectory;

    @Valid
    @JsonProperty
    private int preloadResultPageCount;

    @Valid
    @JsonProperty
    private boolean download;

    @Valid
    @JsonProperty
    private boolean upload;

    @Valid
    @JsonProperty
    private boolean print;

    @Valid
    @JsonProperty
    private boolean browse;

    @Valid
    @JsonProperty
    private boolean rewrite;

    @Valid
    @JsonProperty
    private boolean enableRightClick;

    @Valid
    @JsonProperty
    private boolean pageSelector;

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getResultDirectory() {
        return resultDirectory;
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = resultDirectory;
    }

    public int getPreloadResultPageCount() {
        return preloadResultPageCount;
    }

    public void setPreloadResultPageCount(int preloadResultPageCount) {
        this.preloadResultPageCount = preloadResultPageCount;
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

    public boolean isEnableRightClick() {
        return enableRightClick;
    }

    public void setEnableRightClick(boolean enableRightClick) {
        this.enableRightClick = enableRightClick;
    }

    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public static ComparisonConfigurationModel createComparisonConfiguration(ComparisonConfiguration comparison, CommonConfiguration common) {
        ComparisonConfigurationModel model = new ComparisonConfigurationModel();
        model.setFilesDirectory(comparison.getFilesDirectory());
        model.setResultDirectory(comparison.getResultDirectory());
        model.setPreloadResultPageCount(comparison.getPreloadResultPageCount());
        model.setPageSelector(common.isPageSelector());
        model.setDownload(common.isDownload());
        model.setUpload(common.isUpload());
        model.setPrint(common.isPrint());
        model.setBrowse(common.isBrowse());
        model.setRewrite(common.isRewrite());
        model.setEnableRightClick(common.isEnableRightClick());
        return model;
    }

    @Override
    public String toString() {
        return "ComparisonConfigurationModel{" +
                "filesDirectory='" + filesDirectory + '\'' +
                ", resultDirectory='" + resultDirectory + '\'' +
                ", preloadResultPageCount=" + preloadResultPageCount +
                ", download=" + download +
                ", upload=" + upload +
                ", print=" + print +
                ", browse=" + browse +
                ", rewrite=" + rewrite +
                ", enableRightClick=" + enableRightClick +
                ", pageSelector=" + pageSelector +
                '}';
    }
}
