package com.groupdocs.ui.comparison.model.response;

import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.Rectangle;
import com.groupdocs.comparison.result.StyleChangeInfo;

import java.util.ArrayList;
import java.util.List;

public class ChangeInfoEntity {
    private int action;
    private List<String> authors = new ArrayList<>();
    private Rectangle box = new Rectangle();
    private int id;
    private PageInfoEntity pageInfo = new PageInfoEntity();
    private List<StyleChangeInfo> styleChanges = new ArrayList<>();
    private String text;
    private int type;

    public ChangeInfoEntity() {
    }

    public ChangeInfoEntity(ChangeInfo changeInfo) {
        setAction(changeInfo.getComparisonAction());
        setAuthors(changeInfo.getAuthors());
        setBox(changeInfo.getBox());
        setId(changeInfo.getId());
        setPageInfo(new PageInfoEntity(changeInfo.getPageInfo()));
        getStyleChanges().addAll(changeInfo.getStyleChanges());
        setText(changeInfo.getText());
        setType(changeInfo.getType());
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Rectangle getBox() {
        return box;
    }

    public void setBox(Rectangle box) {
        this.box = box;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PageInfoEntity getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoEntity pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<StyleChangeInfo> getStyleChanges() {
        return styleChanges;
    }

    public void setStyleChanges(List<StyleChangeInfo> styleChanges) {
        this.styleChanges = styleChanges;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
