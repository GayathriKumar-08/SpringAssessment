package com.myapp.myapp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class Sawggerconfig {

    @Bean
    public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.myapp"))
                .build()
                .apiInfo(apiInfo());
    }
   
    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Swagger Employee API Service", //Title
            "The Api handles the Employee Management services, which contains details of the employees", //Description
            "Version 1.1",//Version
            "My Terms of Service",
            new Contact("Mr Kumaresan","www.Employee","kumaresan@gmail.com"),
            "License of API",
            "Api Licene url",
            Collections.emptyList());
        
    }
    
}
