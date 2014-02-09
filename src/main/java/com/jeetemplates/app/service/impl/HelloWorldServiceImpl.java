/**
 * 
 */
package com.jeetemplates.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.persistence.HelloWorldDao;
import com.jeetemplates.app.service.HelloWorldService;
import com.jeetemplates.app.util.LoggerUtils;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author jeetemplates
 */
@Service(HelloWorldService.BEAN_NAME)
public class HelloWorldServiceImpl implements HelloWorldService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link HelloWorldDao}
	 */
    @Autowired
	private HelloWorldDao helloWorldDao;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void create(HelloWorld entity) {
		LoggerUtils.logStartMethod("create");
		helloWorldDao.create(entity);
		LoggerUtils.logEndMethod("create");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<HelloWorld> retrieveAll() {
		LoggerUtils.logStartMethod("retrieveAll");
		List<HelloWorld> listEntities = helloWorldDao.retrieveAll();
		LoggerUtils.logEndMethod("retrieveAll");
		return listEntities;
	}

}
