package com.codegamesleep.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class AppConfig {
    /**
     * Spring PropertyPlaceholderConfiguration for application.properties
     *
     * @return {@link PropertyPlaceholderConfigurer}
     */
    @Bean
    public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return propertyPlaceholderConfigurer;
    }

    /**
     *  Customize and configure various portions of WebFlux
     *
     * @param encoder Configured Jackson2JsonEncoder for JSON serialization
     * @param decoder Configured Jackson2JsonDecoder for JSON deserialization
     *
     * @return {@link WebFluxConfigurer} including all customizations
     */
    @Bean
    WebFluxConfigurer webFluxConfigurer(Jackson2JsonEncoder encoder, Jackson2JsonDecoder decoder) {
        return new WebFluxConfigurer() {
            @Override
            public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
                configurer.defaultCodecs().jackson2JsonEncoder(encoder);
                configurer.defaultCodecs().jackson2JsonDecoder(decoder);
            }
        };
    }

    /**
     * The Bean definition for a JavaTimeModule as we have enabled WRITES_DATES_AS_TIMESTAMPS for our Jackson2ObjectMapper
     *
     * @return {@link JavaTimeModule} to be leveraged by Jackson2ObjectMapper
     */
    @Bean
    JavaTimeModule javatimeModule() {
        return new JavaTimeModule();
    }

    /**
     * Customized the Jackson2ObjectMapper leveraged by WebFlux
     *
     * @return {@link Jackson2ObjectMapperBuilderCustomizer} custom Jackson2ObjectMapper
     */
    @Bean
    Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    /**
     * Customize the Jackson2JsonEncoder leveraged by WebFlux
     *
     * @param mapper {@link Jackson2JsonEncoder} custom Jackson2JsonEncoder configuration
     *
     * @return {@link Jackson2JsonEncoder} custom Jackson2JsonEncoder
     */
    @Bean
    Jackson2JsonEncoder jackson2JsonEncoder(ObjectMapper mapper) {
        return new Jackson2JsonEncoder(mapper);
    }

    /**
     * Customize the Jackson2JsonDecoder leveraged by WebFlux
     *
     * @param mapper {@link Jackson2JsonDecoder} custom Jackson2JsonDecoder configuration
     *
     * @return {@link Jackson2JsonDecoder} custom Jackson2JsonDecoder
     */
    @Bean
    Jackson2JsonDecoder jackson2JsonDecoder(ObjectMapper mapper) {
        return new Jackson2JsonDecoder(mapper);
    }

}
