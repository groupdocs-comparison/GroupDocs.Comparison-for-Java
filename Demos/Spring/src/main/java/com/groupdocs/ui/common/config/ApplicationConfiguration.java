package com.groupdocs.ui.common.config;

import com.groupdocs.ui.common.Defaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ApplicationConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Value("${application.hostAddress}")
    private String hostAddress;
    @Value("${application.licensePath}")
    private String licensePath;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(hostAddress)) {
            try {
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                logger.error("Can not get host address ", e);
                hostAddress = "localhost";
            }
        }
    }

    public String getLicensePath() {
        return licensePath == null || org.apache.commons.lang3.StringUtils.isBlank(licensePath) ? Defaults.Application.DEFAULT_LICENSE_PATH : licensePath;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "hostAddress='" + getHostAddress() + '\'' +
                ", licensePath='" + getLicensePath() + '\'' +
                '}';
    }
}
