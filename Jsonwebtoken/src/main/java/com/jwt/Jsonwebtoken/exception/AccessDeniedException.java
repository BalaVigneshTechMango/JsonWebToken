package com.jwt.Jsonwebtoken.exception;

public class AccessDeniedException extends RuntimeException {

	public AccessDeniedException(String message){
        super(message);
    }
}
