/**
 * 
 */
package com.jucycakes.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Silvan de Jesus
 *
 */
public class ImpossibleDeleteImpossible extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	public ImpossibleDeleteImpossible() {
		super("beers-6", HttpStatus.NOT_FOUND);
	}
}
