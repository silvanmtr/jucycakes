/**
 * 
 */
package com.jucycakes.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Silvan de Jesus
 *
 */
public class EmailUserAlreadyExistException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	public EmailUserAlreadyExistException() {
		super("email-user-already-exist", HttpStatus.BAD_REQUEST);
	}
}
