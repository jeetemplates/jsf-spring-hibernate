/**
 * 
 */
package com.jeetemplates.common.service;

import java.util.List;

import com.jeetemplates.common.model.BusinessEntity;

/**
 * Business service.
 * 
 * @author jeetemplates
 */
public interface BusinessService<BE extends BusinessEntity> {

	/**
	 * Creates and persists an element
	 * 
	 * @param e
	 *            Element
	 */
	public void create(final BE e);

	/**
	 * Retrieves the list of all elements
	 * 
	 * @return list of elements
	 */
	public List<BE> retrieveAll();

	/**
	 * Retrieves an element
	 * 
	 * @param id
	 *            Element id
	 * @return element
	 */
	public BE retrieveById(Long id);

}
