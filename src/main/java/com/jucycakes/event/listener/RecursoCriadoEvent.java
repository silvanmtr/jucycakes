/**
 * 
 */
package com.jucycakes.event.listener;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;
/**
 * @author Silvan de Jesus
 *
 */
public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}