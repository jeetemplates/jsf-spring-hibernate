/**
 * 
 */
package com.jeetemplates.persistence.hibernate;

import javax.inject.Named;

import com.jeetemplates.common.persistence.hibernate.BusinessHibernateDao;
import com.jeetemplates.domain.model.HelloWorld;
import com.jeetemplates.persistence.HelloWorldDao;

/**
 * Hibernate implementation of {@link HelloWorldDao}
 * 
 * @author jeetemplates
 */
@Named
public class HelloWorldHibernateDao extends BusinessHibernateDao<HelloWorld> implements HelloWorldDao {

}
