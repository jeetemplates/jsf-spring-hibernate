/**
 * 
 */
package com.jeetemplates.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.jeetemplates.helloworld.dto.HelloWorldDto;
import com.jeetemplates.helloworld.form.HelloWorldForm;
import com.jeetemplates.helloworld.model.HelloWorld;
import com.jeetemplates.helloworld.service.HelloWorldService;
import com.jeetemplates.util.LoggerUtils;
import com.jeetemplates.util.MapperUtils;

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
	private List<HelloWorldDto> listHellos;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	public String createHello() {
		helloWorldService.create(MapperUtils.getMapper().map(helloWorldForm, HelloWorld.class));
		return "welcome?faces-redirect=true";
	}

	/**
	 * Retrieve hello dto
	 * 
	 * @return list of hello dto
	 */
	public List<HelloWorldDto> retrieveList() {
		// Prevent multiple calls from JSF
		if (listHellos == null) {
			LoggerUtils.logDebug("Initialize hello world list for display");
			listHellos = new ArrayList<HelloWorldDto>();
			List<HelloWorld> listEntities = helloWorldService.retrieveAll();
			for (HelloWorld hello : listEntities) {
				listHellos.add(MapperUtils.getMapper().map(hello, HelloWorldDto.class));
			}
		}
		return listHellos;
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public void setHelloWorldForm(HelloWorldForm helloWorldForm) {
		this.helloWorldForm = helloWorldForm;
	}

	public HelloWorldService getHelloWorldService() {
		return helloWorldService;
	}

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

}
