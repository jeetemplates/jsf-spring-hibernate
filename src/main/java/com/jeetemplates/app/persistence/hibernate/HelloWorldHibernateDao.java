/**
 * 
 */
package com.jeetemplates.app.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.jeetemplates.app.common.persistence.hibernate.BusinessHibernateDao;
import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.persistence.HelloWorldDao;

/**
 * Hibernate implementation of {@link HelloWorldDao}
 * 
 * @author jeetemplates
 */
@Repository
public class HelloWorldHibernateDao extends BusinessHibernateDao<HelloWorld> implements HelloWorldDao {

}
