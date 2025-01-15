package com.Otp_generation.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class RouterConfig {

	
	@Autowired
	private TwilioOtpHandler twilioOtpHandler;
	
	@Bean
	public RouterFunction<ServerResponse> HandleSMS(){
		 return RouterFunctions.route()
		            .POST("/sendotp", twilioOtpHandler::sendOTP)
		            .POST("/validateotp", twilioOtpHandler::ValidateOTP)
		            .GET("/sendotp", request -> ServerResponse.ok()
		                    .contentType(MediaType.TEXT_HTML)
		                    .render("sendotp")) // Correct rendering method
		            .build();
	}
	
	
	//.GET("/sendotp", request -> RenderingResponse.create("sendotp")
//	@Bean
//	public RouterFunction<ServerResponse> HandleSMS() {
//	    return RouterFunctions.route()
//	        .POST("/sendotp", request -> {
//	            System.out.println("Received request for /sendotp");
//	            return twilioOtpHandler.sendOTP(request);
//	        })
//	        .POST("/validateotp", request -> {
//	            System.out.println("Received request for /validateotp");
//	            return twilioOtpHandler.ValidateOTP(request);
//	        })
//	        .build();
//	}
	
	
}
