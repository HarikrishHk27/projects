package com.example.demo.exception;

public class CustomerFieldError {
	String message;
	String fielderror;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFielderror() {
		return fielderror;
	}
	public void setFielderror(String fielderror) {
		this.fielderror = fielderror;
	}
	public CustomerFieldError(String message, String fielderror) {
		super();
		this.message = message;
		this.fielderror = fielderror;
	}
	@Override
	public String toString() {
		return "CustomerFieldError [message=" + message + ", fielderror=" + fielderror + "]";
	}
	
	
	
	
	
}
