package com.jwt.Jsonwebtoken.util;

import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.jwt.Jsonwebtoken.entity.UserEntity;
import com.jwt.Jsonwebtoken.request.TokenRefreshRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static String secret = "This_is_secret";
	private static long expiryDuration = 60 * 60; // sec and mins

	public String generateJwt(UserEntity userEntity) {
		int id = userEntity.getUserid();
		String idString = String.valueOf(id);

		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;

		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);

		Claims claims = Jwts.claims().setIssuer(idString).setIssuedAt(issuedAt).setExpiration(expiryAt);
		// optional claims
		claims.put("name", userEntity.getFullName());
		claims.put("emailId", userEntity.getEmailId());

		// generate jwt using claims // claims set panitu compact vachu string ah
		// convert panitan
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Claims verify(String auth) throws Exception {

		try {
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(auth).getBody();
			return claims;
		} catch (Exception e) {
			throw new com.jwt.Jsonwebtoken.exception.AccessDeniedException("Access Denied");
		}

	}

	private static String decode(String encodedString) {
		return new String(Base64.getUrlDecoder().decode(encodedString));
	}

	public String getNewAccessToken(TokenRefreshRequest request) {
		String refreshToken = request.getRefreshToken();
		Map<String, Object> claims = new HashMap<>();
		String[] parts = refreshToken.split("\\.");
		JSONObject payload = new JSONObject(decode(parts[1]));   
		String subject = payload.getString("sub");																
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() * expiryDuration))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}
}
