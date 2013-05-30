/**
 * 
 */
package com.jeetemplates.business.persistence.hibernate;

import javax.inject.Named;

import com.jeetemplates.business.model.HelloWorld;
import com.jeetemplates.business.persistence.HelloWorldDao;
import com.jeetemplates.common.persistence.hibernate.BusinessHibernateDao;

/**
 * Hibernate implementation of {@link HelloWorldDao}
 * 
 * @author jeetemplates
 */
@Named
public class HelloWorldHibernateDao extends BusinessHibernateDao<HelloWorld> implements HelloWorldDao {

}
