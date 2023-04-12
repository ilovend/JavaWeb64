package com.itheima.day06.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
public class JWTTest {

    @Test
    public void createJwt() {
        HashMap<String, Object> s1 = new HashMap<>();
        s1.put("name", "zhangsan");
        s1.put("age", 18);
        String jwt = Jwts.builder()
                .setClaims(s1)
                .signWith(SignatureAlgorithm.HS256, "itheima")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .compact();
        System.out.println(jwt);

    }

    @Test
    public void parseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJleHAiOjE2ODExMTYwOTEsImFnZSI6MTh9.I9c4v31nevxuRny2tyd63zco3Xmr5TaRib2s5vcDlZg")
                .getBody();
        System.out.println(claims);
    }

}
