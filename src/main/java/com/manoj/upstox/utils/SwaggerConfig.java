package com.manoj.upstox.utils;

import com.google.common.base.Predicate;
import com.manoj.upstox.data.Constants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name="swagger.enabled", havingValue="true")
public class SwaggerConfig {

    private static final String STRING = "string";
    private static final String HEADER = "header";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .apiInfo(getApiInfo())
                .globalOperationParameters(getParameter());
    }

    private Predicate<String> paths() {
        return or(
                regex("/upstox.*")
        );
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Upstox backend",     // title
                "",                     // description
                "",                     // version
                "",                     // terms of service url
                new Contact("", "", ""), "",                     // licence
                ""                      // licence url
        );
    }

    private List<Parameter> getParameter() {
        List<Parameter> paramList = new ArrayList<>();

        paramList.add(
                new ParameterBuilder().name(Constants.AUTHORIZATION)
                        .description("Bearer accessToken")
                        .modelRef(new ModelRef(STRING))
                        .parameterType(HEADER)
                        .required(true)
                        .build());

        paramList.add(
                new ParameterBuilder().name(Constants.X_API_KEEY)
                        .description("apiKey")
                        .modelRef(new ModelRef(STRING))
                        .parameterType(HEADER)
                        .required(true)
                        .build());


        return paramList;

    }

}
