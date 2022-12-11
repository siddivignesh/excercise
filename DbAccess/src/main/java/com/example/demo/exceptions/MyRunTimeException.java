package com.example.demo.exceptions;

public class MyRunTimeException extends RuntimeException {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	String reason;
	int code;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
