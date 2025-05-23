package com.swastik.service.productcatalog.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseResponse {
	private boolean success;
	private List<CustomError> errors;

}
