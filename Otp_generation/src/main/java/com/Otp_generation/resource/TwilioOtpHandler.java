package com.Otp_generation.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.Otp_generation.Entity.PasswordRestRequest;
import com.Otp_generation.Service.Otp_services;

import reactor.core.publisher.Mono;

@Component
public class TwilioOtpHandler {

	@Autowired
	private Otp_services otp_services;
	
	
	public Mono<ServerResponse > sendOTP( ServerRequest serverRequest){
		
		return serverRequest.bodyToMono(PasswordRestRequest.class).flatMap(dto-> otp_services.sendOtpForPassword(dto)).flatMap(dto->ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(dto)));
		
	}
	
	
	public Mono<ServerResponse > ValidateOTP( ServerRequest serverRequest){
		
			return serverRequest.bodyToMono(PasswordRestRequest.class).flatMap(dto-> otp_services.validateOtp(dto.getOneTimePass(),dto.getUserName())).flatMap(dto->ServerResponse.status(HttpStatus.OK).bodyValue(dto));

	}
	
	
	
}
