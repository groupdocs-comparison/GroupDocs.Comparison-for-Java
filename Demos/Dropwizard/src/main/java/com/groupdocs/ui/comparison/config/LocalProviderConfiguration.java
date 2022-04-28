package com.groupdocs.ui.comparison.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.common.Defaults;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

public class LocalProviderConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String resultDirectory;

    public String getFilesDirectory() {
        return filesDirectory == null || StringUtils.isBlank(filesDirectory) ? Defaults.Local.DEFAULT_FILES_DIRECTORY : filesDirectory;
    }

    public String getResultDirectory() {
        return resultDirectory == null || StringUtils.isBlank(resultDirectory) ? Defaults.Local.DEFAULT_RESULT_DIRECTORY : resultDirectory;
    }

    @Override
    public String toString() {
        return "LocalProviderConfiguration{" +
                "filesDirectory='" + getFilesDirectory() + '\'' +
                ", resultDirectory='" + getResultDirectory() + '\'' +
                '}';
    }
}
