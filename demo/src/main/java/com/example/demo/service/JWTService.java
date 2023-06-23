package com.example.demo.service;

import com.example.demo.dto.UserDto;
import io.jsonwebtoken.Claims;

public interface JWTService {

    String generateToken(UserDto userDto);

    Claims decryptJwtToken(String token);

    boolean hasTokenExpired(String token);

    boolean validateAccessToken(String token);
}
