package com.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management System API")
                        .version("1.0.0")
                        .description("Spring Boot REST API for managing employees")
                        .contact(new Contact()
                                .name("Aditya Wadkar")
                                .email("adityawadkar10@gmail.com")
                                .url("https://github.com/adityaff10"))
                        .license(new License()
                        		.name("Apache 2.0")
                        		.url("http://springdoc.org")));
    }
    
}