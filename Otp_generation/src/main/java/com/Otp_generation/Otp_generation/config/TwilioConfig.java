package com.Otp_generation.Otp_generation.config;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;

@Configuration
public  class TwilioConfig {
	 @Value("${twilio.account.sid}")
	private String accountsid;
	 @Value("${twilio.auth.token}")
	private String authToken;
	 @Value("${twilio.phone.number}")
	private String trialNumber;
	
	
	public TwilioConfig(String accountsid, String authToken, String trialNumber) {
		super();
		this.accountsid = accountsid;
		this.authToken = authToken;
		this.trialNumber = trialNumber;
	}
	
	
	public TwilioConfig() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAccountsid() {
		return accountsid;
	}
	public void setAccountsid(String accountsid) {
		this.accountsid = accountsid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getTrialNumber() {
		return trialNumber;
	}
	public void setTrialNumber(String trialNumber) {
		this.trialNumber = trialNumber;
	}
	
	
	
	
}
