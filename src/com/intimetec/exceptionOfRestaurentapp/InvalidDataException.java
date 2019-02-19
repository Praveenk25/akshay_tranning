package com.intimetec.exceptionOfRestaurentapp;

public class InvalidDataException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid Data";
	}

}
