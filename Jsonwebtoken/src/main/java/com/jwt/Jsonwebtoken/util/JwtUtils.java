package com.jwt.Jsonwebtoken.util;

import java.nio.file.AccessDeniedException;
import java.sql.Date;
import org.springframework.stereotype.Component;
import com.jwt.Jsonwebtoken.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static String secret = "This_is_secret";
	private static long expiryDuration = 60 * 60; //sec and mins
    
	public String generateJwt(UserEntity userEntity) {
		int id = userEntity.getUserid();
		String idString = String.valueOf(id);
		
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;

		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);
		// claims
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
			throw new AccessDeniedException("Access Denied");
		}

	}
}
