package com.swastik.service.productcatalog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.service.productcatalog.service.TokenService;
import com.swastik.service.productcatalog.util.RestUtil;

@Service
public class TokenServiceImpl implements TokenService{
	
	private static final Logger log = LoggerFactory.getLogger(TokenServiceImpl.class);
	
	@Autowired
	RestUtil restUtil;
	
	
	@Override
	public boolean validateToken(String token) {
		// TODO Auto-generated method stub
		log.info("[Validate-Token] entered {} ",token);
		boolean isTokenValid = restUtil.validateToken(token);
		log.info("[Validate-Token] Response from restUtil : {}", isTokenValid);
		return isTokenValid;
	}

}
