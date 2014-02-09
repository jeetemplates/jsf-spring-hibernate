/**
 * 
 */
package com.jeetemplates.app.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.service.HelloWorldService;
import com.jeetemplates.app.util.LoggerUtils;
import com.jeetemplates.app.web.form.HelloWorldForm;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
@ManagedBean
public class WelcomeController {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldService}
     */
    @ManagedProperty(value = HelloWorldService.EL_NAME)
    private HelloWorldService helloWorldService;

    /**
     * {@link HelloWorldService}
     */
    @ManagedProperty(value = HelloWorldForm.EL_NAME)
    private HelloWorldForm helloWorldForm;

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
        LoggerUtils.logDebug("Initialize hello world list for display");
        hellos = helloWorldService.retrieveAll();
    }

    /**
     * Create hello.
     * 
     * @return welcome page
     */
    public String createHello() {
        HelloWorld entity = new HelloWorld();
        entity.setFirstName(helloWorldForm.getFirstName());
        entity.setLastName(helloWorldForm.getLastName());
        helloWorldService.create(entity);
        return "welcome?faces-redirect=true";
    }

    /**
     * Throw {@link FacesException}.
     * 
     * @return outcome "welcome"
     */
    public String throwException() {
        throw new FacesException();
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
     * @return the helloWorldForm
     */
    public HelloWorldForm getHelloWorldForm() {
        return helloWorldForm;
    }

    /**
     * @param helloWorldForm
     *            the helloWorldForm to set
     */
    public void setHelloWorldForm(HelloWorldForm helloWorldForm) {
        this.helloWorldForm = helloWorldForm;
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
