package com.jwt.Jsonwebtoken.service;

import com.jwt.Jsonwebtoken.request.LoginRequest;
import com.jwt.Jsonwebtoken.request.SignUpRequest;
import com.jwt.Jsonwebtoken.response.ApiResponse;


public interface LoginService {

	public ApiResponse signup(SignUpRequest signUpRequest);

	public ApiResponse login(LoginRequest loginRequest);

}
