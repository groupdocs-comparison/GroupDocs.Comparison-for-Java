package com.groupdocs.ui.comparison.spring.config;

import com.groupdocs.ui.comparison.spring.common.Defaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleProviderConfiguration {

    @Value("${google.useCredentialsPath}")
    private Boolean useCredentialsPath;

    @Value("${google.credentialsPath}")
    private String credentialsPath;

    @Value("${google.tokensDirectoryPath}")
    private String tokensDirectoryPath;

    @Value("${google.applicationName}")
    private String applicationName;

    @Value("${google.accessType}")
    private String accessType;

    @Value("${google.localServerReceiverPort}")
    private Integer localServerReceiverPort;

    @Value("${google.authorizationUserId}")
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
        return applicationName == null || applicationName.trim().isEmpty() ? "GroupDocs.Comparison for Java Spring sample" : applicationName;
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
