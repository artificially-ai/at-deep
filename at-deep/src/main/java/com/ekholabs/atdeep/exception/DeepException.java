package com.ekholabs.atdeep.exception;

/**
 * @author Wilder Rodrigues (wilder.rodrigues@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class DeepException extends Exception {

	private static final long serialVersionUID = -4314001529888943344L;

	public DeepException() {
		super();
	}

	public DeepException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeepException(String message) {
		super(message);
	}

	public DeepException(Throwable cause) {
		super(cause);
	}
}