/**
 * 
 */
package com.jucycakes.service.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Silvan de Jesus
 *
 */

@RequiredArgsConstructor
@Getter
public class BusinessException extends  RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	private final String code;
    private final HttpStatus status;
}