package com.premiumminds.challenge;

public class InvalidDirectionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDirectionException() {
	}

	public InvalidDirectionException(String msg) {
		super(msg);
	}

}
