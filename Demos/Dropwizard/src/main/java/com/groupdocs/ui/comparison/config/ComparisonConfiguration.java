package com.groupdocs.ui.comparison.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

import static com.groupdocs.ui.common.config.DefaultDirectories.defaultComparisonDirectory;
import static com.groupdocs.ui.common.config.DefaultDirectories.relativePathToAbsolute;

public class ComparisonConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String resultDirectory;

    @Valid
    @JsonProperty
    private Integer preloadResultPageCount;

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = StringUtils.isEmpty(filesDirectory) ? defaultComparisonDirectory() : relativePathToAbsolute(filesDirectory);
    }

    public String getResultDirectory() {
        return resultDirectory;
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = resultDirectory;
    }

    public Integer getPreloadResultPageCount() {
        return preloadResultPageCount;
    }

    public void setPreloadResultPageCount(Integer preloadResultPageCount) {
        this.preloadResultPageCount = preloadResultPageCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ComparisonConfiguration{" +
                "filesDirectory='" + filesDirectory + '\'' +
                ", resultDirectory='" + resultDirectory + '\'' +
                ", preloadResultPageCount=" + preloadResultPageCount +
                '}';
    }
}
