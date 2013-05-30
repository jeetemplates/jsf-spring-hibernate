/**
 * 
 */
package com.jeetemplates.helloworld.service;

import com.jeetemplates.common.service.BusinessService;
import com.jeetemplates.helloworld.model.HelloWorld;

/**
 * Hello world business service
 * 
 * @author jeetemplates
 */
public interface HelloWorldService extends BusinessService<HelloWorld> {

	/**
	 * Bean name.
	 */
	static String BEAN_NAME = "helloWorldService";

	/**
	 * El name.
	 */
	static String EL_NAME = "#{helloWorldService}";
}
