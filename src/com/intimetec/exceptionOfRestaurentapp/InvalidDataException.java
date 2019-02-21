package com.intimetec.exceptionOfRestaurentapp;

public class InvalidDataException extends Exception {
	private static final long serialVersionUID = 42L;

	public String getMessage() {
		return "Please enter the valid sr no.";
	}

}
