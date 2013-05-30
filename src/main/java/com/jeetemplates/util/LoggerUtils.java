/**
 * 
 */
package com.jeetemplates.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger class.
 * 
 * @author jeetemplates
 */
public final class LoggerUtils {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

	/**
	 * Log debug.
	 * 
	 * @param message
	 *            : message to display
	 */
	public static void logDebug(String message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	/**
	 * Log info.
	 * 
	 * @param message
	 *            : message to display
	 */
	public static void logInfo(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

}
