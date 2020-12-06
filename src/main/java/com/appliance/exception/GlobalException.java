package com.appliance.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends Exception {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String messageInfo;

	public GlobalException(String responseMessage, HttpStatus status) {
		super(responseMessage);
		this.status = status;
		this.messageInfo = responseMessage;
	}

	public GlobalException() {
	}

	public HttpStatus getStatusInfo() {
		return this.status;
	}

	public String getMessageInfo() {
		return this.messageInfo;

	}

}
