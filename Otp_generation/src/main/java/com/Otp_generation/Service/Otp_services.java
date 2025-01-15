package com.Otp_generation.Service;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Otp_generation.Entity.OtpStatus;
import com.Otp_generation.Entity.PasswordRestRequest;
import com.Otp_generation.Entity.PasswordRestResponse;
import com.Otp_generation.Otp_generation.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;

import reactor.core.publisher.Mono;

  @Service
  public class Otp_services {

   @Autowired	
	private TwilioConfig twilioConfig; 
 
	
    Map<String, String> otpmap= new HashMap<>();

public Mono<PasswordRestResponse> sendOtpForPassword(PasswordRestRequest passwordRestRequest ) {
		
		
		PasswordRestResponse passwordRestResponse=null;
		
		
		try {
			
			PhoneNumber to = new PhoneNumber(passwordRestRequest.getPhoneNo());
			PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
			String otp=GenrateOtp();
			String otpmessage =" Dear Customer, youer Otp is "+otp+" complete yoyer trastion Thank you";
			
			
		Message message=Message.creator(to, from, otpmessage).create();
		otpmap.put(passwordRestRequest.getUserName(), otp);
		passwordRestResponse=new PasswordRestResponse(OtpStatus.DELIVERED,otpmessage);
		
			
		} catch (Exception e) {
			passwordRestResponse=new PasswordRestResponse(OtpStatus.FAILED,e.getMessage());
		}
		
		
		return Mono.just(passwordRestResponse);
	}
	
	
	
	//6 digit otp 
	
	
	private String GenrateOtp() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
		
	}
	
	
	
	// varification 
	
	
//	public Mono<String>  validateOtp(String userInputotp ,String userName){
//		
//		if(userInputotp.equals(otpmap.get(userName))) {
//			
//			otpmap.remove(userName,userInputotp);
//			return Mono.just("Valid OTP  Please  proceed with your Transaction ! ");
//			
//		}else {
//			
//			return Mono.error(new IllegalArgumentException(" InValid OTP please retry ! "));
//		}
//		
//	}
	
	public Mono<String> validateOtp(String userInputOtp, String userName) {
	    // Check if the username exists in the OTP map
	    if (!otpmap.containsKey(userName)) {
	        return Mono.error(new IllegalArgumentException("No OTP found for the given username. Please request a new OTP."));
	    }

	    // Check if the OTP matches
	    if (otpmap.get(userName).equals(userInputOtp)) {
	        otpmap.remove(userName); // Remove the OTP after successful validation
	        return Mono.just("Valid OTP. Please proceed with your transaction!");
	    } else {
	        return Mono.error(new IllegalArgumentException("Invalid OTP. Please retry!"));
	    }
	}

	
	
	
	
	
}
