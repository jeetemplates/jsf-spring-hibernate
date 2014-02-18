/**
 * 
 */
package com.jeetemplates.app.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.jeetemplates.app.common.persistence.jpa.JpaBusinessDao;
import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.persistence.HelloWorldDao;

/**
 * Hibernate implementation of {@link HelloWorldDao}
 * 
 * @author jeetemplates
 */
@Repository
public class JpaHelloWorldDao extends JpaBusinessDao<Long, HelloWorld> implements HelloWorldDao {

}
