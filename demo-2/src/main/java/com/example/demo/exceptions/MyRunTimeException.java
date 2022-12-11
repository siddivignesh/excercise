package com.example.demo.exceptions;

public class MyRunTimeException extends RuntimeException {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	String reason;

	public MyRunTimeException(String reason) {
		super();
		this.reason = reason;

	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
