package com.litmus7.userregistration.model;

public class User {
	
	private String username;
	private int age;
	private String email;
	private String password;
	public User(String username,int age,String email,String password) {
		this.username=username;
		this.age=age;
		this.email=email;
		this.password=password;
	
	}		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "Name :"+username+"\nAge :"+age+"\nemail :"+email+"\npassword :"+password;
	}
	public String displayDetails() {
		return this.toString();
	}
}
	

