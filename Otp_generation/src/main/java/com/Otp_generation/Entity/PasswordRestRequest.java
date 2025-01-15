package com.Otp_generation.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordRestRequest {
	
	 @JsonProperty("PhoneNo")
  private  String PhoneNo;
	 @JsonProperty("UserName")
 private  String UserName;
	 @JsonProperty("OneTimePass")
private String OneTimePass ;

public PasswordRestRequest(String phoneNo, String userName, String oneTimePass) {

	PhoneNo = phoneNo;
	UserName = userName;
	OneTimePass = oneTimePass;
}

public PasswordRestRequest() {
	super();
	// TODO Auto-generated constructor stub
}

public String getPhoneNo() {
	return PhoneNo;
}

public void setPhoneNo(String phoneNo) {
	PhoneNo = phoneNo;
}

public String getUserName() {
	return UserName;
}

public void setUserName(String userName) {
	UserName = userName;
}

public String getOneTimePass() {
	return OneTimePass;
}

public void setOneTimePass(String oneTimePass) {
	OneTimePass = oneTimePass;
}












}
