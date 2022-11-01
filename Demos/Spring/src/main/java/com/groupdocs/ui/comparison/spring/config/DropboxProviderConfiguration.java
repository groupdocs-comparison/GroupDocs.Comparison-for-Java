package com.groupdocs.ui.comparison.spring.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The type Dropbox provider configuration.
 */
@Component
public class DropboxProviderConfiguration {

    @Value("${dropbox.clientIdentifier}")
    private String clientIdentifier;

    @Value("${dropbox.accessToken}")
    private String accessToken;

    @Value("${dropbox.resultDirectory}")
    private String resultDirectory;

    /**
     * The identifier that will be used as User-Agent in API requests
     *
     * @return The identifier
     */
    public String getClientIdentifier() {
        return StringUtils.isBlank(clientIdentifier) ? "groupdocs/comparison-java" : clientIdentifier;
    }

    /**
     * The identifier that will be used as User-Agent in API requests
     *
     * @param clientIdentifier The identifier
     */
    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    /**
     * Dropbox access token
     *
     * @return access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Dropbox access token
     *
     * @param accessToken access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Directory in which result files will be uploaded via Dropbox API, default value is `ResultFiles`.
     *
     * @return the result directory
     */
    public String getResultDirectory() {
        return StringUtils.isBlank(resultDirectory) ? "ResultFiles" : resultDirectory;
    }

    /**
     * Directory in which result files will be uploaded via Dropbox API, default value is `ResultFiles`.
     *
     * @param resultDirectory the result directory
     */
    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = resultDirectory;
    }

    @Override
    public String toString() {
        return "DropboxProviderConfiguration{" +
                "clientIdentifier='" + getClientIdentifier() + '\'' +
                ", accessToken='" + getAccessToken() + '\'' +
                ", resultDirectory='" + getResultDirectory() + '\'' +
                '}';
    }
}
