package com.DailyLog.retrieval.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .signWith(getKey())
                .compact();
    }
    public String extractEmail(String token){
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
