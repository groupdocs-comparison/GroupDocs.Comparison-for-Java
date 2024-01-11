package com.groupdocs.ui.comparison.demosapitests;

import java.util.Objects;

public class LoadConfigResponse {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadConfigResponse that = (LoadConfigResponse) o;
        return preloadResultPageCount == that.preloadResultPageCount && download == that.download && upload == that.upload && print == that.print && browse == that.browse && rewrite == that.rewrite && enableRightClick == that.enableRightClick && pageSelector == that.pageSelector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(preloadResultPageCount, download, upload, print, browse, rewrite, enableRightClick, pageSelector);
    }

    @Override
    public String toString() {
        return "LoadConfigResponse{" +
                "preloadResultPageCount=" + preloadResultPageCount +
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
