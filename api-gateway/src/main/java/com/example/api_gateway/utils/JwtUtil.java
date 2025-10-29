package com.example.api_gateway.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;


@Component
public class JwtUtil {

    private String jwtSecret ="VGhpcyBpcyB0aGUgSldUIHNlY3JldCBrZXkgZm9yIGltcGxlbWVudGluZyBqd3QgdG9rZW4gc3lzdGVtIGluIGF1dGggc2VydmljZQ==";
//    private long jwtExpirationInMs = 3600000; //1 hour
    private Long jwtExpirationInMs = 86400000L; //1 day


    public void validateToken(final String token){
        Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token); //0.11.5 way of doing this, auth-service is on 0.12.5
    }

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
