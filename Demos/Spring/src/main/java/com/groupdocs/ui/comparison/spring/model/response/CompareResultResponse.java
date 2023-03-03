package com.groupdocs.ui.comparison.spring.model.response;

import com.groupdocs.comparison.result.ChangeInfo;
import com.groupdocs.comparison.result.PageInfo;
import com.groupdocs.comparison.result.Rectangle;
import com.groupdocs.comparison.result.StyleChangeInfo;
import com.groupdocs.ui.comparison.spring.common.entity.web.PageDescriptionEntity;

import java.util.List;

public class CompareResultResponse {
    /**
     * List of change information
     */
    private Change[] changes;
    /**
     * List of images of pages with marked changes
     */
    private List<PageDescriptionEntity> pages;
    /**
     * Unique key of results
     */
    private String guid;
    /**
     * Extension of compared files, for saving total results
     */
    private String extension;

    public void setChanges(Change[] changes) {
        this.changes = changes;
    }

    public Change[] getChanges() {
        return changes;
    }

    public List<PageDescriptionEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageDescriptionEntity> pages) {
        this.pages = pages;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public static class Change {
        private final int _id;
        private final int _comparisonAction;
        private final PageInfo _pageInfo;
        private final Rectangle _box;
        private final String _text;
        private final List<StyleChangeInfo> _styleChanges;
        private final List<String> _authors;
        private final int _type;
        private final String _targetText;
        private final String _sourceText;
        private final String _componentType;

        public Change(ChangeInfo changeInfo) {
            this._id = changeInfo.getId();
            this._comparisonAction = changeInfo.getComparisonAction().toInt();
            this._pageInfo = changeInfo.getPageInfo();
            this._box = changeInfo.getBox();
            this._text = changeInfo.getText();
            this._styleChanges = changeInfo.getStyleChanges();
            this._authors = changeInfo.getAuthors();
            this._type = changeInfo.getType().toInt();
            this._targetText = changeInfo.getTargetText();
            this._sourceText = changeInfo.getSourceText();
            this._componentType = changeInfo.getComponentType();
        }

        public int getId() {
            return _id;
        }

        public int getComparisonAction() {
            return _comparisonAction;
        }

        public PageInfo getPageInfo() {
            return _pageInfo;
        }

        public Rectangle getBox() {
            return _box;
        }

        public String getText() {
            return _text;
        }

        public List<StyleChangeInfo> getStyleChanges() {
            return _styleChanges;
        }

        public List<String> getAuthors() {
            return _authors;
        }

        public int getType() {
            return _type;
        }

        public String getTargetText() {
            return _targetText;
        }

        public String getSourceText() {
            return _sourceText;
        }

        public String getComponentType() {
            return _componentType;
        }
    }
}
