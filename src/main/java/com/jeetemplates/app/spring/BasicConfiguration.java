/**
 * 
 */
package com.jeetemplates.app.spring;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Spring configuration.
 * 
 * @author jeetemplates
 */
@org.springframework.context.annotation.Configuration
@ComponentScan(value = "com.jeetemplates.app", excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.jeetemplates.app.spring.Configuration"))
@EnableTransactionManagement
public class BasicConfiguration {

    @Autowired
    private Environment environment;

    /**
     * Configure properties to use @Value and ${...} placeholders.
     * 
     * @return placeholder
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholder = new PropertySourcesPlaceholderConfigurer();
        return placeholder;
    }

    /**
     * Hibernate jpa vendor adapter.
     * 
     * @return jpa vendor adapter
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    /**
     * Configure datasource.
     * 
     * @return datasource
     * @throws PropertyVetoException
     */
    @Bean(destroyMethod = "close")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("jdbc.driverClass"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setMinPoolSize(environment.getProperty("hibernate.c3p0.min_size", Integer.class));
        dataSource.setMaxPoolSize(environment.getProperty("hibernate.c3p0.max_size", Integer.class));
        dataSource.setMaxStatements(environment.getProperty("hibernate.c3p0.max_statements", Integer.class));
        dataSource.setIdleConnectionTestPeriod(environment.getProperty("hibernate.c3p0.idle_test_period", Integer.class));
        return dataSource;
    }

    /**
     * Spring entity manager factory.
     * 
     * @return entity manager factory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean springEMF = new LocalContainerEntityManagerFactoryBean();
        springEMF.setDataSource(dataSource);
        springEMF.setPackagesToScan("com.jeetemplates.app.domain");
        springEMF.setJpaVendorAdapter(jpaVendorAdapter);
        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        jpaProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        jpaProperties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        jpaProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", environment.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        springEMF.setJpaPropertyMap(jpaProperties);
        return springEMF;
    }

    /**
     * Transaction manager.
     * 
     * @return transaction manager
     */
    @Bean(name = "txManager")
    public JpaTransactionManager jpaTransactionManager(DataSource dataSource, EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setDataSource(dataSource);
        tm.setEntityManagerFactory(entityManagerFactory);
        return tm;
    }

}
