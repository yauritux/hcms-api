package com.abminvestama.hcms.core.exception;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * This class is a standard exception that will be thrown by the system whenever database insert is failed.
 *
 */
public class CannotPersistException extends RuntimeException {

	private static final long serialVersionUID = 9191695747695542507L;

	public CannotPersistException(String message) {
		super(message);
	}
	
	public CannotPersistException(String message, Throwable e) {
		super(message, e);
	}
}