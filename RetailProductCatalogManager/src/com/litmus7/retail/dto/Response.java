package com.litmus7.retail.dto;
public class Response<T> {

	int statusCode;
	String errorMessage;
	String responseMessage;
	T product;
	public T getData() {
		return product;
	}
	public void setData(T product) {
		this.product = product;
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


