package com.swastik.service.productcatalog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class AppConfig {

	@Value("${token.validate.url}")
	private String tokenValidateUrl;
	
	
}
