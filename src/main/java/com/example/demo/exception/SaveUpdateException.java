package com.example.demo.exception;

public class SaveUpdateException extends RuntimeException {

	private static final long serialVersionUID = 7025870880098466550L;

	public SaveUpdateException(String message) {
		super(message);
	}
}