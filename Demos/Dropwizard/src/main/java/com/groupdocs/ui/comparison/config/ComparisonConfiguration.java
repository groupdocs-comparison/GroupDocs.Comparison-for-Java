package com.groupdocs.ui.comparison.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.common.Defaults;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import java.util.Locale;

public class ComparisonConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String filesProviderType;

    @Valid
    @JsonProperty
    private Integer preloadResultPageCount;

    @Valid
    @JsonProperty
    private Integer previewPageWidth;

    @Valid
    @JsonProperty
    private Float previewPageRatio;

    @Valid
    @JsonProperty
    private String cacheDirectory;

    @Valid
    @JsonProperty
    private String tempDirectory;

    public Defaults.Comparison.FilesProviderType getFilesProviderType() {
        if (filesProviderType == null) {
            return Defaults.Comparison.DEFAULT_FILES_PROVIDER_TYPE;
        }
        try {
            return Defaults.Comparison.FilesProviderType.valueOf(filesProviderType.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            return Defaults.Comparison.DEFAULT_FILES_PROVIDER_TYPE;
        }
    }

    public Integer getPreloadResultPageCount() {
        return preloadResultPageCount == null ? Defaults.Comparison.DEFAULT_PRELOAD_RESULT_PAGE_COUNT : preloadResultPageCount;
    }

    public Integer getPreviewPageWidth() {
        return previewPageWidth == null || previewPageWidth == 0 ? Defaults.Comparison.DEFAULT_PREVIEW_PAGE_WIDTH : previewPageWidth;
    }

    public Float getPreviewPageRatio() {
        return previewPageRatio == null || previewPageRatio == 0 ? Defaults.Comparison.DEFAULT_PREVIEW_PAGE_RATIO : previewPageRatio;
    }

    public String getCacheDirectory() {
        return cacheDirectory == null || StringUtils.isBlank(cacheDirectory) ? Defaults.Local.DEFAULT_CACHE_DIRECTORY : cacheDirectory;
    }

    public String getTempDirectory() {
        return tempDirectory == null || StringUtils.isBlank(tempDirectory) ? Defaults.Local.DEFAULT_TEMP_DIRECTORY : tempDirectory;
    }

    @Override
    public String toString() {
        return "ComparisonConfiguration{" +
                "filesProviderType='" + getFilesProviderType() + '\'' +
                ", preloadResultPageCount=" + getPreloadResultPageCount() +
                ", previewPageWidth=" + getPreviewPageWidth() +
                ", previewPageRatio=" + getPreviewPageRatio() +
                ", cacheDirectory='" + getCacheDirectory() + '\'' +
                ", tempDirectory='" + getTempDirectory() + '\'' +
                '}';
    }
}
