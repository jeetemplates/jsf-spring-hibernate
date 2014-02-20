/**
 * 
 */
package com.jeetemplates.app.spring;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author jeetemplates
 */
@org.springframework.context.annotation.Configuration
@PropertySources(value = { @PropertySource(value = "classpath:/persistence/datasource.properties"), @PropertySource(value = "classpath:/persistence/hibernate.properties") })
@Import(value = BasicConfiguration.class)
public class Configuration {

}
