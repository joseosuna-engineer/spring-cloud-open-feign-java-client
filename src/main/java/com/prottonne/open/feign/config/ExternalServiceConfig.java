package com.prottonne.open.feign.config;

import feign.Request.Options;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalServiceConfig {

    @Value("${read.timeup}")
    private int readTimeup;

    @Value("${connection.timeup}")
    private int connectionTimeup;

    public ExternalServiceConfig() {
        super();
    }

    @Bean
    public Options requestOptions() {
        return new Options(connectionTimeup, readTimeup);
    }

}
