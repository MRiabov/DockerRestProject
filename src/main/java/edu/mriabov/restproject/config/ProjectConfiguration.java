package edu.mriabov.restproject.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin@gmail.com", "admin123");
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().basicAuthentication("admin@gmail.com","admin").build();
    }
}
