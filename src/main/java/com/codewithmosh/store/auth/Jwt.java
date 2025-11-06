package com.codewithmosh.store.auth;

import com.codewithmosh.store.users.Role;
import io.jsonwebtoken.*;
import lombok.*;

import javax.crypto.SecretKey;
import java.util.Date;

@Data
@AllArgsConstructor
public class Jwt {

    private final Claims claims;
    private final SecretKey secretKey;


    public boolean isExpired() {
        return claims.getExpiration().before(new Date());
    }

    public Long getUserId() {
        return Long.valueOf(claims.getSubject());
    }

    public Role getRole(String token) {
        return Role.valueOf(claims.get("role", String.class));
    }

    public String toString() {
        return Jwts.builder()
                .claims(claims)
                .signWith(secretKey)
                .compact();
    }

}
