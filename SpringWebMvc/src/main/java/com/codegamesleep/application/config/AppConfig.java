package com.codegamesleep.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

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
     * The Bean definition for a JavaTimeModule as we have enabled WRITES_DATES_AS_TIMESTAMPS for our ObjectMapper
     *
     * @return {@link JavaTimeModule} to be leveraged by ObjectMapper
     */
    @Bean
    JavaTimeModule javatimeModule() {
        return new JavaTimeModule();
    }

    /**
     * Configure the ObjectMapper leveraged by SpringMvc
     *
     * @return {@link ObjectMapper} leveraged by SpringMvc for serialization/deserialization
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        return mapper;
    }

}
