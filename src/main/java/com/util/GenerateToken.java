package com.util;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerateToken {

    public static void main(String[] args) {
        generateManagementToken();
    }

    public static String generateManagementToken() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("access_key", "65a69ad3672616331ebab0ac");
        payload.put("type", "management");
        payload.put("version", 2);
        String token = Jwts.builder().setClaims(payload).setId(UUID.randomUUID().toString())
                .setExpiration(new Date(System.currentTimeMillis() + 86400 * 1000))
                .setIssuedAt(Date.from(Instant.ofEpochMilli(System.currentTimeMillis() - 60000)))
                .setNotBefore(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, "x_cK1qiT0zwtadL1E5h5lQPr-hlmjMac5hQ3nZ7y2NLLXLGs_FGNbDrzondVM8IuHrfo0jLJTi0zWwHu1EW_LWdRPFvRifLSR56sGxVWILP4wfFrNpZG5T0kfE9oVAqsMVAvMpYkMpHhOqpqqCgWE56HBSlpndpBXzE9YId4cMA=".getBytes()).compact();
        return  token;
    }
}