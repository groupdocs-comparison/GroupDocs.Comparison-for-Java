package com.groupdocs.ui.comparison.dropwizard.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.comparison.dropwizard.common.Defaults;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

/**
 * ApplicationConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class ApplicationConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String licensePath;
    @Valid
    @JsonProperty
    private String hostAddress;

    public String getLicensePath() {
        return licensePath == null || StringUtils.isBlank(licensePath) ? Defaults.Application.DEFAULT_LICENSE_PATH : licensePath;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }
}