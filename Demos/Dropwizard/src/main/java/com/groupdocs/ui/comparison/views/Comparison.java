package com.groupdocs.ui.comparison.views;

import com.groupdocs.ui.common.config.GlobalConfiguration;
import io.dropwizard.views.View;

import java.nio.charset.Charset;

public class Comparison extends View {
    private GlobalConfiguration globalConfiguration;

    /**
     * Constructor
     * @param globalConfiguration total configuration
     * @param charset charset
     */
    public Comparison(GlobalConfiguration globalConfiguration, String charset){
        super("comparison.ftl", Charset.forName(charset));
        this.globalConfiguration = globalConfiguration;
    }

    /**
     * Get total config
     * @return total config
     */
    public GlobalConfiguration getGlobalConfiguration() {
        return globalConfiguration;
    }

    /**
     * Set total config
     * @param globalConfiguration total config
     */
    public void setGlobalConfiguration(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
    }

}
