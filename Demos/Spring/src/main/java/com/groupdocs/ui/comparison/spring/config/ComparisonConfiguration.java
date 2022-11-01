package com.groupdocs.ui.comparison.spring.config;

import com.groupdocs.ui.comparison.spring.common.Defaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ComparisonConfiguration {

    @Value("${comparison.filesProviderType}")
    private String filesProviderType;

    @Value("${comparison.preloadResultPageCount}")
    private Integer preloadResultPageCount;

    @Value("${comparison.previewPageWidth}")
    private Integer previewPageWidth;

    @Value("${comparison.previewPageRatio}")
    private Float previewPageRatio;

    @Value("${comparison.cacheDirectory}")
    private String cacheDirectory;

    @Value("${comparison.tempDirectory}")
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