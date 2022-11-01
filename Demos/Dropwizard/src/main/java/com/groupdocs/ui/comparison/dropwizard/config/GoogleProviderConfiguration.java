package com.groupdocs.ui.comparison.dropwizard.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.comparison.dropwizard.common.Defaults;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

public class GoogleProviderConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private Boolean useCredentialsPath;

    @Valid
    @JsonProperty
    private String credentialsPath;

    @Valid
    @JsonProperty
    private String tokensDirectoryPath;

    @Valid
    @JsonProperty
    private String applicationName;

    @Valid
    @JsonProperty
    private String accessType;

    @Valid
    @JsonProperty
    private Integer localServerReceiverPort;

    @Valid
    @JsonProperty
    private String authorizationUserId;

    public boolean isUseCredentialsPath() {
        return useCredentialsPath != null && useCredentialsPath;
    }

    /**
     * If false, {@link #getCredentialsPath()} returns path to resources file
     */
    public boolean isCredentialsPathPresent() {
        return StringUtils.isNotBlank(credentialsPath);
    }

    /**
     * Use {@link #isCredentialsPathPresent()} to check if path points to resources files (false)
     */
    public String getCredentialsPath() {
        return isCredentialsPathPresent() ? credentialsPath : Defaults.Google.DEFAULT_CREDENTIALS_PATH;
    }

    public String getTokensDirectoryPath() {
        return StringUtils.isBlank(tokensDirectoryPath) ? null : tokensDirectoryPath;
    }

    public String getApplicationName() {
        return applicationName == null || applicationName.trim().isEmpty() ? "GroupDocs.Comparison for Java Dropwizard sample" : applicationName;
    }

    public Defaults.Google.AccessType getAccessType() {
        if (accessType == null) {
            return Defaults.Google.DEFAULT_ACCESS_TYPE;
        }
        try {
            return Defaults.Google.AccessType.valueOf(accessType);
        } catch (IllegalArgumentException e) {
            return Defaults.Google.DEFAULT_ACCESS_TYPE;
        }
    }

    public int getLocalServerReceiverPort() {
        return localServerReceiverPort == null ? Defaults.Google.DEFAULT_LOCAL_SERVER_RECEIVER_PORT : localServerReceiverPort;
    }

    public String getAuthorizationUserId() {
        return StringUtils.isBlank(authorizationUserId) ? null : authorizationUserId;
    }

    @Override
    public String toString() {
        return "GoogleProviderConfiguration{" +
                "useCredentialsPath=" + isUseCredentialsPath() +
                ", credentialsPath='" + getCredentialsPath() + '\'' +
                ", tokensDirectoryPath='" + getTokensDirectoryPath() + '\'' +
                ", applicationName='" + getApplicationName() + '\'' +
                ", accessType='" + getAccessType() + '\'' +
                ", localServerReceiverPort=" + getLocalServerReceiverPort() +
                ", authorizationUserId='" + getAuthorizationUserId() + '\'' +
                ", credentialsPathPresent=" + isCredentialsPathPresent() +
                '}';
    }
}
