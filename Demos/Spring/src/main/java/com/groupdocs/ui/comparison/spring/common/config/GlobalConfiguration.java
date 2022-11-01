package com.groupdocs.ui.comparison.spring.common.config;

import com.groupdocs.ui.comparison.spring.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.spring.config.DropboxProviderConfiguration;
import com.groupdocs.ui.comparison.spring.config.GoogleProviderConfiguration;
import com.groupdocs.ui.comparison.spring.config.LocalProviderConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type Global configuration.
 */
@Component
public class GlobalConfiguration {

    @Autowired
    private ServerConfiguration server;

    @Autowired
    private ApplicationConfiguration application;

    @Autowired
    private CommonConfiguration common;

    @Autowired
    private ComparisonConfiguration comparison;

    @Autowired
    private LocalProviderConfiguration local;

    @Autowired
    private GoogleProviderConfiguration google;
    @Autowired
    private DropboxProviderConfiguration dropbox;

    /**
     * Gets server configuration
     *
     * @return the server configuration
     */
    public ServerConfiguration getServer() {
        return server;
    }

    /**
     * Sets server configuration
     *
     * @param server the server configuration
     */
    public void setServer(ServerConfiguration server) {
        this.server = server;
    }

    /**
     * Gets application configuration
     *
     * @return the application configuration
     */
    public ApplicationConfiguration getApplication() {
        return application;
    }

    /**
     * Sets application configuration
     *
     * @param application the application configuration
     */
    public void setApplication(ApplicationConfiguration application) {
        this.application = application;
    }

    /**
     * Gets common configuration
     *
     * @return the common configuration
     */
    public CommonConfiguration getCommon() {
        return common;
    }

    /**
     * Gets comparison configuration
     *
     * @return the comparison configuration
     */
    public ComparisonConfiguration getComparison() {
        return comparison;
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
     * Gets dropbox provider configuration
     *
     * @return the dropbox provider configuration
     */
    public DropboxProviderConfiguration getDropbox() {
        return dropbox;
    }

    /**
     * Get local provider configuration
     *
     * @return local provider configuration
     */
    public LocalProviderConfiguration getLocal() {
        return local;
    }
}
