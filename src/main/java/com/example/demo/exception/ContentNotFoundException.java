package com.example.demo.exception;

public class ContentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8529178989998142712L;

	public ContentNotFoundException(String message) {
		super(message);
	}
}