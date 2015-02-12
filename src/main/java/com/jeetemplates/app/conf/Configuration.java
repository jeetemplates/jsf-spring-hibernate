/**
 *
 */
package com.jeetemplates.app.conf;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author jeetemplates
 */
@org.springframework.context.annotation.Configuration
@PropertySources(value = {
    @PropertySource(value = "classpath:/conf.properties")})
@Import(value = BasicConfiguration.class)
public class Configuration {

}
