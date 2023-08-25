package com.comp.shop.util;


import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private final String jwtSecret = "Spring";
	private final long jwtExpiration = 24 * 60 * 60 * 60 * 1000;
	
	public String createToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}
	public boolean IsExpiredToken(String token) {
		Date expirationDate = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getExpiration();
//		System.out.println(new Date() + " " + expirationDate);
		return expirationDate.before(new Date());
	}
	public String getEmailFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	public boolean validateToken(String token, String email) {
//		System.out.println(!IsExpiredToken(token));
//		System.out.println(getEmailFromToken(token).equals(email));
		return !IsExpiredToken(token) && getEmailFromToken(token).equals(email);
	}
}
