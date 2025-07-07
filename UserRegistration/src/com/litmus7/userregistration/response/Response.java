package com.litmus7.userregistration.response;

import com.litmus7.userregistration.user.User;

public class Response {
	int statusCode;
	String errorMessage;
	String responseMessage;
	User data;
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
