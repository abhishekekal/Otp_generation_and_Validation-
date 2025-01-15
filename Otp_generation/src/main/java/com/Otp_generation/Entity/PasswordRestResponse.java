package com.Otp_generation.Entity;




public class PasswordRestResponse {
private String  message;
private OtpStatus  status;
public PasswordRestResponse(OtpStatus status,String message ) {
	super();
	this.message = message;
	this.status = status;
}



public PasswordRestResponse() {
	super();
	// TODO Auto-generated constructor stub
}



public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public OtpStatus getStatus() {
	return status;
}
public void setStatus(OtpStatus status) {
	this.status = status;
}



}
