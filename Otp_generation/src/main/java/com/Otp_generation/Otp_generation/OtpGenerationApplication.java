package com.Otp_generation.Otp_generation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.Otp_generation.Otp_generation.config.TwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages="com.Otp_generation")
@ComponentScan("com")

public class OtpGenerationApplication {
 @Autowired
	private TwilioConfig  twilioconfig;
 

 
	@PostConstruct
 public void initTwilio() {
	Twilio.init(twilioconfig.getAccountsid(),twilioconfig.getAuthToken()); 
 }
	
	public static void main(String[] args) {
		SpringApplication.run(OtpGenerationApplication.class, args);
		
		System.out.println("run");
	}

}
