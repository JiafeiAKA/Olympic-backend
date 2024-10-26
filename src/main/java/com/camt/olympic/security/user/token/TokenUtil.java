package com.camt.olympic.security.user.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.config.annotation.web.oauth2.resourceserver.JwtDsl;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;


@Component
public class TokenUtil {
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // สร้าง secret key ที่มีขนาดปลอดภัย
    private final String base64EncodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getEncoded()); // เข้ารหัส Base64
    private final long expirationTime = 86400000; // อายุของ token (1 วันในหน่วยมิลลิวินาที)


    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token){
        Date expiration = getClaimsFromToken(token).getExpiration();
        return expiration.before(new Date());
    }

    public String getUserNameFromToken(String token){
        return getClaimsFromToken(token).getSubject();
    }
}
