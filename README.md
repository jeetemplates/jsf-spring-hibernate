jsf-spring-hibernate
====================

Template for building JEE app with JSF, Spring and Hibernate
- Simple form
- Persistence
- Internationalization
- JSF handling exception

Frameworks
- JDK 7
- Tomcat 7 / JBoss 7
- JSF 2.1
- Spring 3.2
- Hibernate 4.2

JSF 2.2 works (out of the box) with Tomcat 7 but not with JBoss 7.1.
Spring 3.2 doesn't work with Wildfly Alpha 4 : https://issues.jboss.org/browse/WELD-1489
Configuring JSF 2.2 
- update version in pom.xml
- edit faces-config.xml to change namespace and version
- edit all namespaces in *.xhtml (with http://xmlns.jcp.org/jsf/core, http://xmlns.jcp.org/jsf/html, http://xmlns.jcp.org/jsf/facelets)
