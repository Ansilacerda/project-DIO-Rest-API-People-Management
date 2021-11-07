package com.ansi.personapi.swagger;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
        @Bean
        public Docket apiAdmin() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.ansi.personapi"))
                    .paths(PathSelectors.ant("/**"))
                    .build()
                    .apiInfo(apiInfo())
                    .globalOperationParameters(
                            Collections.singletonList(
                                    new ParameterBuilder()
                                            .name("Rest API People Management")
                                            .description("Developing a REST API people management system with Spring Boot")
                                            .modelRef(new ModelRef("string"))
                                            .parameterType("header")
                                            .required(false)
                                            .build()));
        }

        @Bean
        public ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("API-REST")
                    .description("DIO - Bootcamp Santander Full Stack - Developing a REST API people management system with Spring Boot")
                    .version("1.0.0")
                    .license("Apache License Version 2.0")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .contact(new Contact("Anselmo", "https://github.com/Ansilacerda", "https://github.com/Ansilacerda"))
                    .build();
        }

        @Override
        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");

            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

