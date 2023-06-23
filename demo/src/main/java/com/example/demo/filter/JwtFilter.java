package com.example.demo.filter;

import com.example.demo.service.JWTService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.JWTServiceImpl;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "jwtFilter1", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class JwtFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    @Qualifier("JWTServiceImpl")
    private JWTService jwtService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

//    private String AUTH_URI = "/auth";
//
//    private String AUTH_URI_EXTERNAL = "/demo2023/auth";
    @Value("${AUTH_URI}")
    private String AUTH_URI;

    @Value("${EXTERNAL_AUTH_URI}")
    private String AUTH_URI_EXTERNAL;

//    @Override
//    public void initFilterBean() throws ServletException{
////        WebApplicationContext webApplicationContext=
////                WebApplicationContextUtils.getWebApplicationContext(getServletContext());
////        //reference to bean from app context
////        jwtService = webApplicationContext.getBean(JWTServiceImpl.class);
////        userService = webApplicationContext.getBean(UserService.class);
//
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
//
//        //do something with your bean
//        //propertyValue = yourBeanToInject.getValue("propertyName");
//    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        int statusCode = authorization(request);
        if(statusCode == HttpServletResponse.SC_ACCEPTED){
            filterChain.doFilter(request,response);
        }else{
            response.sendError(statusCode);
        }
    }

    private int authorization(HttpServletRequest request) {
        int statusCode = HttpServletResponse.SC_ACCEPTED;

        String incomingUri = request.getRequestURI();
        logger.info("============, within authorization(...), incomingUri = {}", incomingUri);
        if(incomingUriRequestForAuth(incomingUri)){
            return HttpServletResponse.SC_ACCEPTED;
        }

        try{
            String wholeTokenString = request.getHeader("Authorization");
            if(retrievedWholeTokenExist(wholeTokenString)){
                String token = wholeTokenString.split(" ")[1].trim();
                logger.info("=======, within authorization, token = {}",token);
                if(token == null || token.trim().isEmpty()){
                    return HttpServletResponse.SC_UNAUTHORIZED;
                }

                //validate token
                boolean isTokenValid = jwtService.validateAccessToken(token);
                if(isTokenValid){
                    statusCode = HttpServletResponse.SC_ACCEPTED;
                }

//                //parse the token and verify user info
//                Claims claims = jwtService.decryptJwtToken(token);
//                logger.info("======, within authorization(...), parsed claims = {}",claims);
            }
        }catch(Exception e){
            logger.error("Exception is thrown then parsing JWT token, error = {}",e.getMessage());
        }
        return statusCode;
    }

    private boolean incomingUriRequestForAuth(String incomingUri) {
        boolean isUriRequestForAuth = false;
        if(incomingUri.equalsIgnoreCase(AUTH_URI)||incomingUri.equalsIgnoreCase(AUTH_URI_EXTERNAL)){
            isUriRequestForAuth = true;
        }
        return isUriRequestForAuth;
    }

    private boolean retrievedWholeTokenExist(String wholeTokenString) {
        boolean isStringExist = false;
        if(wholeTokenString != null && !wholeTokenString.trim().isEmpty()) {
            isStringExist = true;
          }
        return isStringExist;
    }

}
