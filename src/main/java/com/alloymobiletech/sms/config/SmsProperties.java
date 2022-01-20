package com.alloymobiletech.sms.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("sms")
public class SmsProperties {
    private String twilloAccountId;
    private String twilloAuthToken;
    private String twilloNumber;
}
