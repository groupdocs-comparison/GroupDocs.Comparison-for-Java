package com.groupdocs.ui.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.config.DropboxProviderConfiguration;
import com.groupdocs.ui.comparison.config.GoogleProviderConfiguration;
import com.groupdocs.ui.comparison.config.LocalProviderConfiguration;
import io.dropwizard.Configuration;

import javax.validation.Valid;

/**
 * GlobalConfiguration
 * Object to hold all application's configurations from yml file
 *
 * @author Aspose Pty Ltd
 */
public class GlobalConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private ServerConfiguration server;

    @Valid
    @JsonProperty
    private ApplicationConfiguration application;

    @Valid
    @JsonProperty
    private CommonConfiguration common;

    @Valid
    @JsonProperty
    private ComparisonConfiguration comparison;

    @Valid
    @JsonProperty
    private LocalProviderConfiguration local;

    @Valid
    @JsonProperty
    private GoogleProviderConfiguration google;

    @Valid
    @JsonProperty
    private DropboxProviderConfiguration dropbox;

    /**
     * Constructor
     */
    public GlobalConfiguration() {
        server = new ServerConfiguration();
        application = new ApplicationConfiguration();
        common = new CommonConfiguration();
        comparison = new ComparisonConfiguration();
        local = new LocalProviderConfiguration();
        google = new GoogleProviderConfiguration();
        dropbox = new DropboxProviderConfiguration();
    }

    /**
     * Get server configuration
     *
     * @return server configuration
     */
    public ServerConfiguration getServer() {
        return server;
    }

    /**
     * Get application configuration
     *
     * @return application configuration
     */
    public ApplicationConfiguration getApplication() {
        return application;
    }

    /**
     * Get common configuration
     *
     * @return common configuration
     */
    public CommonConfiguration getCommon() {
        return common;
    }

    /**
     * Get common configuration
     *
     * @return comparison configuration
     */
    public ComparisonConfiguration getComparison() {
        return comparison;
    }

    /**
     * Get local provider configuration
     *
     * @return local provider configuration
     */
    public LocalProviderConfiguration getLocal() {
        return local;
    }

    /**
     * Get google provider configuration
     *
     * @return google provider configuration
     */
    public GoogleProviderConfiguration getGoogle() {
        return google;
    }

    /**
     * Get dropbox provider configuration
     *
     * @return dropbox provider configuration
     */
    public DropboxProviderConfiguration getDropbox() {
        return dropbox;
    }
}


