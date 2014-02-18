/**
 * 
 */
package com.jeetemplates.app.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.service.HelloWorldService;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
@ManagedBean
public class WelcomeController {
    
    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldService}
     */
    @ManagedProperty(value = HelloWorldService.EL_NAME)
    private HelloWorldService helloWorldService;

    /* ************************************ */
    /* Attributes */
    /* ************************************ */

    /**
     * List of hellos
     */
    private List<HelloWorld> hellos;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        logger.debug("Initialize hello world list for display");
        hellos = helloWorldService.retrieveAll();
    }

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */
    /**
     * @return the helloWorldService
     */
    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    /**
     * @param helloWorldService
     *            the helloWorldService to set
     */
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    /**
     * @return the hellos
     */
    public List<HelloWorld> getHellos() {
        return hellos;
    }

    /**
     * @param hellos
     *            the hellos to set
     */
    public void setHellos(List<HelloWorld> hellos) {
        this.hellos = hellos;
    }

}
