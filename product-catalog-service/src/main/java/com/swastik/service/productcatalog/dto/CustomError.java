package com.swastik.service.productcatalog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomError {
	private String code;
	private String message;
	private String type;
}
