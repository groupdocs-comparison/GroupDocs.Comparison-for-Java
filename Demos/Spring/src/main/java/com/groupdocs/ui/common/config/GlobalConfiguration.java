package com.groupdocs.ui.common.config;

import com.groupdocs.ui.comparison.config.ComparisonConfiguration;
import com.groupdocs.ui.comparison.config.GoogleProviderConfiguration;
import com.groupdocs.ui.comparison.config.LocalProviderConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public ServerConfiguration getServer() {
        return server;
    }

    public void setServer(ServerConfiguration server) {
        this.server = server;
    }

    public ApplicationConfiguration getApplication() {
        return application;
    }

    public void setApplication(ApplicationConfiguration application) {
        this.application = application;
    }

    public CommonConfiguration getCommon() {
        return common;
    }

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
     * Get local provider configuration
     *
     * @return local provider configuration
     */
    public LocalProviderConfiguration getLocal() {
        return local;
    }
}
