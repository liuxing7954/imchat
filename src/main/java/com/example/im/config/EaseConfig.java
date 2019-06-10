package com.example.im.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ease.im")
@Data
public class EaseConfig {
    private String orgname;
    private String appname;
    private String client_iD;
    private String client_secret;
}
