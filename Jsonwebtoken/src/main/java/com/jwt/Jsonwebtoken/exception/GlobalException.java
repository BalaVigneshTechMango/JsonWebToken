package com.jwt.Jsonwebtoken.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jwt.Jsonwebtoken.response.ApiResponse;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler
	public ResponseEntity handleAccessDeniedException(AccessDeniedException e) {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
