package com.swastik.service.productcatalog.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.swastik.service.productcatalog.config.AppConfig;

@Component
public class RestUtil {

	private static final Logger log = LoggerFactory.getLogger(RestUtil.class);
	
	private final WebClient webClient;
	
	@Autowired
	AppConfig appConfig;
	
	
	
	public RestUtil(WebClient webClient) {
        this.webClient = webClient;
    }	
	
	public boolean validateToken(String token){
		
		boolean isTokenValid = false;
		
		log.info("[Validate-Token] entered {} ",token);
		
		try {
			
			 String response = webClient.get()
                     .uri(appConfig.getTokenValidateUrl())
                     .header("Authorization", token)
                     .retrieve()
                     .bodyToMono(String.class)
                     .block();
			 
			 
			 log.info("Response from customer service validate token : {}", response);
		    
		     if(response.equalsIgnoreCase("valid")) {
		    	 isTokenValid = true; 
		     }
		   
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("Encountered exception in method-restExchangeValidateToken of class-RestUtil : {}", e.getMessage());
			
		}
		return isTokenValid;
	}
	
	private HttpHeaders getHeaders(String  token) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setBearerAuth(token);
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return requestHeaders;
	}



}
