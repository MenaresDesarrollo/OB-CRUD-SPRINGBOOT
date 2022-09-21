package com.ejercicio.DemoOBSB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración Swagger para la generación de documentación de la API REST
 *
 * HTML: http://localhost:8090/swagger-ui/
 * JSON: http://localhost:8090/v2/api-docs
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring boot laptrops API REST",
                "Shop api rest computers",
                "1.0",
                "http://www.google.com",
                new Contact("Carlos", "http://www.google.com", "menaresdesarrollo@gmail.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}
