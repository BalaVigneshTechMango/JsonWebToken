package com.jwt.Jsonwebtoken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.Jsonwebtoken.request.LoginRequest;
import com.jwt.Jsonwebtoken.request.SignUpRequest;
import com.jwt.Jsonwebtoken.request.TokenRefreshRequest;
import com.jwt.Jsonwebtoken.response.ApiResponse;
import com.jwt.Jsonwebtoken.response.TokenRefreshResponse;
import com.jwt.Jsonwebtoken.service.LoginService;
import com.jwt.Jsonwebtoken.util.JwtUtils;

@RestController
@RequestMapping("/register")
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/signup")
	public ApiResponse signup(@RequestBody SignUpRequest signUpRequest) {
		ApiResponse apiResponse = loginService.signup(signUpRequest);
		return apiResponse;
	}

	@PostMapping("/login")
	public ApiResponse login(@RequestBody LoginRequest loginRequest) {
		ApiResponse apiResponse = loginService.login(loginRequest);
		return apiResponse;
	}

	@GetMapping("/refreshtoken")
	public TokenRefreshResponse geRefreshResponse(@RequestBody TokenRefreshRequest request) {
		return loginService.getNewAccessToken(request);
	}

	@GetMapping("/privateApi")
	public ResponseEntity<ApiResponse> privateApi(
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {
		ApiResponse apiResponse = new ApiResponse();
		System.out.println(auth);
		jwtUtils.verify(auth);

		apiResponse.setData("this is private api");
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("/testmethod")
	public String testMethod() {
		return "this test-method-is-running";
	}

}