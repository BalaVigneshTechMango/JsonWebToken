package com.jwt.Jsonwebtoken.JwtInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jwt.Jsonwebtoken.util.JwtUtils;

import io.jsonwebtoken.Claims;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String auth = request.getHeader("authorization");
		if (!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))) {
			Claims claims = jwtUtils.verify(auth);
		}

		return super.preHandle(request, response, handler);
	}
}
