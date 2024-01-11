package com.groupdocs.ui.viewer.demosapitests.cases;

import java.util.HashMap;
import java.util.Map;

public class CompareCase {
    private String sourceGuid;
    private String targetGuid;
    private String sourcePassword;
    private String targetPassword;
    private Compare expectedObject;
    private Map<Integer, Map<String, String>> externalData = new HashMap<>();

    public String getSourceGuid() {
        return sourceGuid;
    }

    public void setSourceGuid(String sourceGuid) {
        this.sourceGuid = sourceGuid;
    }

    public String getTargetGuid() {
        return targetGuid;
    }

    public void setTargetGuid(String targetGuid) {
        this.targetGuid = targetGuid;
    }

    public String getSourcePassword() {
        return sourcePassword;
    }

    public void setSourcePassword(String sourcePassword) {
        this.sourcePassword = sourcePassword;
    }

    public String getTargetPassword() {
        return targetPassword;
    }

    public void setTargetPassword(String targetPassword) {
        this.targetPassword = targetPassword;
    }

    public Compare getExpectedObject() {
        return expectedObject;
    }

    public void setExpectedObject(Compare expectedObject) {
        this.expectedObject = expectedObject;
    }

    /**
     * page number to map of external relative link to it's content (or content length in string format for png resources)
     */
    public Map<Integer, Map<String, String>> getExternalData() {
        return externalData;
    }

    public void setExternalData(Map<Integer, Map<String, String>> externalData) {
        this.externalData = externalData;
    }
}
