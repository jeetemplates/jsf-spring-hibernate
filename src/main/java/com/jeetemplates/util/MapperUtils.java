/**
 * 
 */
package com.jeetemplates.util;

import com.jeetemplates.mapper.OrikaMapper;

import ma.glasnost.orika.MapperFacade;

/**
 * @author Paolo
 * 
 */
public final class MapperUtils {

	/* ************************************************************** */
	/* Dependencies */
	/* ************************************************************** */

	/**
	 * Mapper.
	 */
	private static MapperFacade mapper;

	/**
	 * @return the mapper
	 */
	public static MapperFacade getMapper() {
		if (mapper == null) {
			mapper = new OrikaMapper();
		}
		return mapper;
	}

}
