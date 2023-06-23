package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.JWTService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    @Qualifier("JWTServiceImpl")
    private JWTService jwtService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;



    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> authenticate(@RequestBody UserDto userDto){
        //1. validate username/password
        //400 bad request
        //2. generate token
        //200 or 500

        String token = "";
        Map<String, String> resultMap = new HashMap<>();
        try{
            UserDto retrievedUserDto = userService.getUserByCredentials(userDto.getEmail(), userDto.getPassword());
            if(retrievedUserDto == null){
                resultMap.put("msg", "The input user email and password are incorrect");
                return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(resultMap);
            }

            token = jwtService.generateToken(retrievedUserDto);
            resultMap.put("token", token);

        }catch(Exception e){
            logger.error("Authenticate user failed, error = {}", e.getMessage());
            String errorMsg = e.getMessage();
            resultMap.put("mes", errorMsg);
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body(resultMap);
        }

        return ResponseEntity.status(HttpServletResponse.SC_OK).body(resultMap);
    }
}
