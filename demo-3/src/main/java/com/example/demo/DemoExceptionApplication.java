package com.example.demo;

public class DemoExceptionApplication {
	public static void main(String[] args) {
		int i, j = 1, k = 0;

		try {
			i = j / k;
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			System.out.println("siddi");
		}

	}

	public class Exception1 extends RuntimeException{
		String reason;

		public Exception1(String reason) {
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

	public class StaticException extends Exception {

	}
}
