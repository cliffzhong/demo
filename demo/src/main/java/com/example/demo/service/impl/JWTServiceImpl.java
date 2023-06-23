package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.service.JWTService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service("JWTServiceImpl")
public class JWTServiceImpl implements JWTService {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private final String SECRET_KEY = System.getProperty("secret_key");

//    private final String SECRET_KEY = System.getenv("secret_key");

    private final long EXPIRATION_TIME = 86400 * 1000;

    private final String ISSUER = "com.demo";

    @Override
    public String generateToken(UserDto userDto) {

        /*
         * 1. decide signature algorithm
         * 2. hard code secret key  -- later use VM option to pass in the key
         * 3. sign JWT with key
         * 4. organize our payload: Claims ---> map Claims have some predefined keys
         * 5. set Claims JWT api
         * 6. generate the token
         */
        logger.info("==========, retrieved SECRET_KEY = {}",SECRET_KEY);

        //decide JWT signature algorithm to be used to sign token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES512;

        //create and organize Claims
        Claims claims = Jwts.claims();
        claims.setId(String.valueOf(userDto.getId()));
        claims.setSubject(userDto.getName());
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        claims.setIssuer(ISSUER);
        claims.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));

//        //set claims and sign with plain secret key string
//        JwtBuilder jwtBuilder = Jwts.builder().setClaims(claims).signWith(signatureAlgorithm, SECRET_KEY);

        //set claims and sign with Key
        byte[] secretKeyStringBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyStringBytes,signatureAlgorithm.getJcaName());
        JwtBuilder jwtBuilder = Jwts.builder().setClaims(claims).signWith(signatureAlgorithm, signingKey);

        //build the JWT token and serialized the token to compact it
        String generatedToken = jwtBuilder.compact();

        return generatedToken;
    }

    @Override
    public Claims decryptJwtToken(String token) {
        byte[] secretKeyStringBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Claims claims = Jwts.parser()
                .setSigningKey(secretKeyStringBytes)
                .parseClaimsJws(token)
                .getBody();
        logger.info("==========parsed claims = {}", claims);
        return claims;
    }

    @Override
    public boolean hasTokenExpired(String token) {
        boolean hasTokenExpired = true;
        try{
            Claims claims = decryptJwtToken(token);
            Date tokenExpirationDate = claims.getExpiration();
            Date nowDate = new Date();

            hasTokenExpired = nowDate.after(tokenExpirationDate);
        }catch(ExpiredJwtException ex){
            logger.error("ExpiredJwtException is caught, error = {}", ex.getMessage());
        }
        return hasTokenExpired;
    }

    @Override
    public boolean validateAccessToken(String token) {
        boolean isTokenValid = false;
        try{
            byte[] secretKeyStringBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
            Jwts.parser()
                    .setSigningKey(secretKeyStringBytes)
                    .parseClaimsJws(token);
            isTokenValid = true;
        }catch(ExpiredJwtException ex){
            logger.error("JWT expired",ex.getMessage());
        }catch(IllegalArgumentException ex){
            logger.error("Token is  null, empty or only whitespace");
        }catch(MalformedJwtException ex){
            logger.error("JWT is invalid",ex);
        }catch(UnsupportedJwtException ex){
            logger.error("JWT is not supported", ex);
        }catch(SignatureException ex){
            logger.error("Signature validation failed");
        }
        return isTokenValid;
    }
}
