/**
 *
 */
package com.jeetemplates.app.domain;

import javax.persistence.Entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Hello entity.
 *
 * @author jeetemplates
 */
@Entity
public class HelloWorld implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Last name.
     */
    private String lastName;

    /**
     * First name.
     */
    private String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
