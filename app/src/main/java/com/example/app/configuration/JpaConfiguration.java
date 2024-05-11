package com.example.app.configuration;

import org.example.repositories.Jpa.JpaCatRepository;
import org.example.repositories.Jpa.JpaOwnerRepository;
import org.example.services.JpaCatService;
import org.example.services.JpaOwnerService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApplicationConfiguration.class)
@ComponentScan(basePackages = {"org.example"})
@ConditionalOnProperty(prefix = "app", name = "data-access-type", havingValue = "jpa")
public class JpaConfiguration {
    @Bean
    public JpaCatService getCatService(JpaCatRepository repository) {
        return new JpaCatService(repository);
    }

    @Bean
    public JpaOwnerService getOwnerService(JpaOwnerRepository repository) {
        return new JpaOwnerService(repository);
    }
}
