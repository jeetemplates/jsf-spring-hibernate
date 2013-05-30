/**
 * 
 */
package com.jeetemplates.helloworld.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.jeetemplates.common.persistence.BusinessDao;
import com.jeetemplates.common.service.impl.BusinessServiceImpl;
import com.jeetemplates.helloworld.model.HelloWorld;
import com.jeetemplates.helloworld.persistence.HelloWorldDao;
import com.jeetemplates.helloworld.service.HelloWorldService;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author jeetemplates
 */
@Named(HelloWorldService.BEAN_NAME)
public class HelloWorldServiceImpl extends BusinessServiceImpl<HelloWorld> implements HelloWorldService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link HelloWorldDao}
	 */
	@Inject
	private HelloWorldDao helloWorldDao;

	@Override
	protected BusinessDao<HelloWorld> getDao() {
		return helloWorldDao;
	}

	/* ************************************ */
	/* Methods */
	/* ************************************ */

}
