package com.test.demomark.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTUtil {
    private static final String KEY = "olixito";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extract(token)) && !isTokenExpired(token);
    }

    public String extract(String token){
        return getClams(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        return getClams(token).getExpiration().before(new Date());
    }

    private Claims getClams(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
