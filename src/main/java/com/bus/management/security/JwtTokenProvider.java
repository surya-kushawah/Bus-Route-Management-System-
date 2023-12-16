package com.bus.management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {


    private final Key secretKey;
    @Value("${app.jwtExpirationInMs}")
    private int validityInMilliseconds;


    public JwtTokenProvider() {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public SecretKey getSecretKey() {
        return (SecretKey) secretKey;
    }

    // Other methods for token validation, etc.
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Check expiration
            if (claims.getExpiration().before(new Date())) {
                return false; // Token is expired
            }

            // Additional checks on claims (issuer, audience, etc.) if needed

            return true; // Token is valid
        } catch (Exception e) {
            return false; // Invalid token or parsing error
        }
    }

}
