package com.jwt.Jsonwebtoken.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.Jsonwebtoken.entity.UserEntity;
import com.jwt.Jsonwebtoken.repository.UserRepository;
import com.jwt.Jsonwebtoken.request.LoginRequest;
import com.jwt.Jsonwebtoken.request.SignUpRequest;
import com.jwt.Jsonwebtoken.request.TokenRefreshRequest;
import com.jwt.Jsonwebtoken.response.ApiResponse;
import com.jwt.Jsonwebtoken.response.TokenRefreshResponse;
import com.jwt.Jsonwebtoken.service.LoginService;
import com.jwt.Jsonwebtoken.util.JwtUtils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public ApiResponse signup(SignUpRequest signUpRequest) {
		ApiResponse apiResponse = new ApiResponse();
		UserEntity userEntity = new UserEntity();
		userEntity.setFullName(signUpRequest.getFullName());
		userEntity.setGender(signUpRequest.getGender());
		userEntity.setEmailId(signUpRequest.getEmailId());
		userEntity.setPassword(signUpRequest.getPassword());
		userEntity.setPhoneNumber(signUpRequest.getPhoneNumber());
		userRepository.save(userEntity);
		return apiResponse;
	}

	@Override
	public ApiResponse login(LoginRequest loginRequest) {
		ApiResponse apiResponse = new ApiResponse();
		UserEntity userEntity = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequest.getEmailId(),
				loginRequest.getPassword());
		if (userEntity == null) {
			apiResponse.setData("User login failed");
			return apiResponse;
		}
		String token = jwtUtils.generateJwt(userEntity);
		apiResponse.setData(token);
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);

		apiResponse.setData(data);

		return apiResponse;
	}

	@Override
	public TokenRefreshResponse getNewAccessToken(TokenRefreshRequest request) {
		String newAccessToken=jwtUtils.getNewAccessToken(request);
		return new TokenRefreshResponse(newAccessToken);	
	}

}
