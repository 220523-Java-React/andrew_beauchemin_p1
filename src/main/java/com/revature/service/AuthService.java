package com.revature.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AuthService {
    private static final String SECRET = "secret";
    private static final String ISSUER = "auth0";

    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final JWTVerifier JWT_VERIFIER = JWT.require(ALGORITHM).withIssuer(ISSUER).build();

    private static final UserRepository userRepository = new UserRepository();
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public static String authenticateUser(User user){
        // Get the user from the repository by its username
        User dbUser = userRepository.getByUsername(user.getUsername());
        if(dbUser != null){
            // check that the passwords match
            if(user.getPassword().equals(dbUser.getPassword())){
                return generateToken(dbUser);
            }
        }

        return null;
    }

    public static void isValidToken(String token) throws JWTVerificationException {
        // need to verify with our verifier
        DecodedJWT jwt = JWT_VERIFIER.verify(token);

        Claim claim = jwt.getClaim("role");
        Role role = Role.valueOf(claim.as(String.class));

        //System.out.println(role);
    }

    public static boolean isValidEmployee(String token) throws JWTVerificationException {
        DecodedJWT jwt = JWT_VERIFIER.verify(token);

        Claim claim = jwt.getClaim("role");
        Role role = Role.valueOf(claim.as(String.class));

        if(role == Role.EMPLOYEE) {
            System.out.println("test");
            return true;

        }else
            return false;
    }

    private static String generateToken(User user){
        String token = null;

        try{
            token = JWT.create()
                    .withIssuer(ISSUER)
                    // Set the token to expire in 1 week
                    .withExpiresAt(Date.from(LocalDateTime.now().plusWeeks(1).atZone(ZoneId.systemDefault()).toInstant()))
                    .withClaim("role", user.getRole().toString())
                    .sign(ALGORITHM);
        } catch(JWTCreationException e){
            logger.warn(e.getMessage());
        }
        return token;
    }

}
