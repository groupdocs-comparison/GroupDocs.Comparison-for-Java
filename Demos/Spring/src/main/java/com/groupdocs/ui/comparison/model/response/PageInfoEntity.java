package com.groupdocs.ui.comparison.model.response;

import com.groupdocs.comparison.result.PageInfo;

public class PageInfoEntity {
    private int height;
    private int id;
    private int width;

    public PageInfoEntity() {
    }

    public PageInfoEntity(PageInfo pageInfo) {
        setHeight(pageInfo.getHeight());
        setId(pageInfo.getPageNumber() - 1);
        setWidth(pageInfo.getWidth());
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
