package com.litmus7.vehicleservice.dto;
public class Response<T> {
	private int statusCode;
	private String errorMessage;
	private T data;
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
	public void setData(T data) {
		this.data=data;
		
	}
	public T getData() {
		return data;
	}
	
}


	

