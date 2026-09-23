package com.example.tutoring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey key;
    private final long expirationMs;

    public JwtService (@Value ("${JWT.SECRET}") String secret, @Value ("${jwt.expiration-ms}") long expirationMs){
        this.key= Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.expirationMs=expirationMs;
    }

    public String generateToekn(Long userId, String role){
        Date now=new Date();
        return Jwts.builder().subject(userId.toString())
                .claim("role",role)
                .issuedAt(now)
                .expiration(new Date(now.getTime()+expirationMs))
                .signWith(key)
                .compact();
    }

    public Claims parseToken(String token){
        return Jwts.parser().verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
