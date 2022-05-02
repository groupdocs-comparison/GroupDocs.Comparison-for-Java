package com.groupdocs.ui.comparison.config;

import com.groupdocs.ui.common.Defaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LocalProviderConfiguration {

    @Value("${local.filesDirectory}")
    private String filesDirectory;

    @Value("${local.resultDirectory}")
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
