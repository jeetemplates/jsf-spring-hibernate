/**
 * 
 */
package com.jeetemplates.app.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Spring configuration.
 * 
 * @author jeetemplates
 */
@org.springframework.context.annotation.Configuration
@ImportResource(value = { "classpath:spring/spring-beans.xml",
        "classpath:spring/spring-persistence.xml" })
public class Configuration {

    /**
     * Configure properties.
     * 
     * @return placeholder
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholder = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new Resource[] {
                new ClassPathResource("/persistence/datasource.properties"),
                new ClassPathResource("/persistence/hibernate.properties") };
        placeholder.setLocations(resources);
        placeholder.setIgnoreResourceNotFound(false);
        placeholder.setIgnoreUnresolvablePlaceholders(false);
        return placeholder;
    }
}
