package com.revature.controller;


import com.auth0.jwt.exceptions.JWTVerificationException;
import com.revature.model.User;
import com.revature.service.AuthService;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public static Handler authenticate = context -> {

        User user = context.bodyAsClass(User.class);
        String token = AuthService.authenticateUser(user);

        if(token != null){
            context.status(200).result("Bearer " + token);
        } else{
            context.status(401).result("Bad credentials.");
        }
    };

    // design the handler so that every other handler must first go through this one
    public static Handler withAuth = context -> {
        // check for the authorization header

        try{
            String token = context.header("Authorization").replace("Bearer ", "");
            // I need a way to verify that the token is valid
            AuthService.isValidToken(token);

        } catch(NullPointerException | JWTVerificationException e){
            logger.warn(e.getMessage());
            throw new ForbiddenResponse("You must add a valid Bearer token");
        }
    };

    public static Handler validEmployee = context->{
        try{
            String token = context.header("Authorization").replace("Bearer ", "");
            // I need a way to verify that the token is valid
            if(!AuthService.isValidEmployee(token))
                throw new ForbiddenResponse("Access Not High enough");

        } catch(NullPointerException | JWTVerificationException e){
            logger.warn(e.getMessage());
            throw new ForbiddenResponse("You must add a valid Bearer token");
        }
    };

}