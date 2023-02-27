package com.jwt.Jsonwebtoken.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jwt.Jsonwebtoken.JwtInterceptor.JwtInterceptor;
import com.jwt.Jsonwebtoken.util.JwtUtils;
@Configuration
public class CustomWebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor);
	}
	
}
