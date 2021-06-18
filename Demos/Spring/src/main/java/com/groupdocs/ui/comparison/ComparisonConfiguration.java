package com.groupdocs.ui.comparison;

import com.groupdocs.ui.config.CommonConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

import static com.groupdocs.ui.config.DefaultDirectories.defaultComparisonDirectory;
import static com.groupdocs.ui.config.DefaultDirectories.relativePathToAbsolute;

@Component
public class ComparisonConfiguration extends CommonConfiguration {

    @Value("${comparison.filesDirectory}")
    private String filesDirectory;

    @Value("${comparison.resultDirectory}")
    private String resultDirectory;

    @Value("#{new Integer('${comparison.preloadResultPageCount}')}")
    private Integer preloadResultPageCount;

    @PostConstruct
    public void init() {
        this.filesDirectory = StringUtils.isEmpty(this.filesDirectory) ? defaultComparisonDirectory() : relativePathToAbsolute(this.filesDirectory);
    }

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
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
