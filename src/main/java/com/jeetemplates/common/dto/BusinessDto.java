/**
 * 
 */
package com.jeetemplates.common.dto;

import java.io.Serializable;

/**
 * Common business dto
 * 
 * @author jeetemplates
 */
public abstract class BusinessDto implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 3886269150595934285L;

	/**
	 * Id
	 */
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
