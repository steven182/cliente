package com.prueba.cliente.exception;

public class AdvencedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdvencedException(String message) {
		super(message);
	}

	public AdvencedException(String message, Throwable cause) {
		super(message, cause);
	}

}
