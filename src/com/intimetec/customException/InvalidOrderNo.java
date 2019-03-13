package com.intimetec.customException;

public class InvalidOrderNo extends Exception {
	private static final long serialVersionUID = 42L;

	public String getMessage() {
		return "Please enter the valid sr no.";
	}
}
