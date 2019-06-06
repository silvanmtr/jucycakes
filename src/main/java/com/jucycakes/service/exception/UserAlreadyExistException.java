/**
 * 
 */
package com.jucycakes.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Silvan de Jesus
 *
 */
public class UserAlreadyExistException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException() {
		super("user-already-exist", HttpStatus.BAD_REQUEST);
	}
}
