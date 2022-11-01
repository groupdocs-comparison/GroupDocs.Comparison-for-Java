package com.groupdocs.ui.comparison.spring.model;

import com.groupdocs.ui.comparison.spring.common.config.CommonConfiguration;
import com.groupdocs.ui.comparison.spring.config.ComparisonConfiguration;

public class ComparisonConfigurationModel {

    private int preloadResultPageCount;

    private boolean download;

    private boolean upload;

    private boolean print;

    private boolean browse;

    private boolean rewrite;

    private boolean enableRightClick;

    private boolean pageSelector;

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
