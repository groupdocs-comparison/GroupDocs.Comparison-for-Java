package com.groupdocs.ui.viewer.demosapitests.cases;

import java.util.List;

public class Compare {
    private String extension;
    private List<Compare.Page> pages;
    private List<Change> changes;
    private String guid;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String value) {
        this.extension = value;
    }

    public List<Compare.Page> getPages() {
        return pages;
    }

    public void setPages(List<Compare.Page> value) {
        this.pages = value;
    }

    public List<Compare.Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Compare.Change> value) {
        this.changes = value;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String value) {
        this.guid = value;
    }


    public static class Change {
        private String componentType;
        private String sourceText;
        private String targetText;
        private PageInfo pageInfo;
        private long comparisonAction;
        private Box box;
        private String text;
        private long id;
        private long type;
        private List<Object> authors;
        private List<Object> styleChanges;

        public String getTargetText() {
            return targetText;
        }

        public void setTargetText(String targetText) {
            this.targetText = targetText;
        }

        public List<Object> getStyleChanges() {
            return styleChanges;
        }

        public void setStyleChanges(List<Object> styleChanges) {
            this.styleChanges = styleChanges;
        }

        public String getSourceText() {
            return sourceText;
        }

        public void setSourceText(String sourceText) {
            this.sourceText = sourceText;
        }

        public String getComponentType() {
            return componentType;
        }

        public void setComponentType(String value) {
            this.componentType = value;
        }

        public PageInfo getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfo value) {
            this.pageInfo = value;
        }

        public long getComparisonAction() {
            return comparisonAction;
        }

        public void setComparisonAction(long value) {
            this.comparisonAction = value;
        }

        public Box getBox() {
            return box;
        }

        public void setBox(Box value) {
            this.box = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String value) {
            this.text = value;
        }

        public long getId() {
            return id;
        }

        public void setId(long value) {
            this.id = value;
        }

        public long getType() {
            return type;
        }

        public void setType(long value) {
            this.type = value;
        }

        public List<Object> getAuthors() {
            return authors;
        }

        public void setAuthors(List<Object> value) {
            this.authors = value;
        }
    }

    public static class Box {
        private long x;
        private long width;
        private long y;
        private long height;

        public long getX() {
            return x;
        }

        public void setX(long value) {
            this.x = value;
        }

        public long getWidth() {
            return width;
        }

        public void setWidth(long value) {
            this.width = value;
        }

        public long getY() {
            return y;
        }

        public void setY(long value) {
            this.y = value;
        }

        public long getHeight() {
            return height;
        }

        public void setHeight(long value) {
            this.height = value;
        }
    }

    public static class PageInfo {
        private long pageNumber;
        private long width;
        private long height;

        public long getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(long value) {
            this.pageNumber = value;
        }

        public long getWidth() {
            return width;
        }

        public void setWidth(long value) {
            this.width = value;
        }

        public long getHeight() {
            return height;
        }

        public void setHeight(long value) {
            this.height = value;
        }
    }

    public static class Page {
        private long number;
        private String data;
        private long width;
        private long angle;
        private long height;

        public long getNumber() {
            return number;
        }

        public void setNumber(long value) {
            this.number = value;
        }

        public String getData() {
            return data;
        }

        public void setData(String value) {
            this.data = value;
        }

        public long getWidth() {
            return width;
        }

        public void setWidth(long value) {
            this.width = value;
        }

        public long getAngle() {
            return angle;
        }

        public void setAngle(long value) {
            this.angle = value;
        }

        public long getHeight() {
            return height;
        }

        public void setHeight(long value) {
            this.height = value;
        }
    }
}


