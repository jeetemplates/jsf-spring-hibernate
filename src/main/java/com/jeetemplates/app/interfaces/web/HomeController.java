/**
 * 
 */
package com.jeetemplates.app.interfaces.web;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.application.HelloWorldService;

/**
 * @author jeetemplates
 */
@ManagedBean
public class HomeController {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldService}
     */
    @ManagedProperty(value = "#{helloWorldService}")
    private HelloWorldService helloWorldService;

    /**
     * {@link HelloWorldService}
     */
    @ManagedProperty(value = HelloWorldForm.EL_NAME)
    private HelloWorldForm helloWorldForm;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

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
}
