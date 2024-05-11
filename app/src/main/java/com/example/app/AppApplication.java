package com.example.app;

import com.example.app.configuration.ApplicationConfiguration;
import org.example.services.JpaCatService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class AppApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(AppApplication.class, args);

        System.out.println(context.getBeansOfType(JpaCatService.class));
    }

}
