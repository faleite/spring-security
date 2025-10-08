package com.faleite.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.faleite.security.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    // Coloque esta variável no properties ou no .env
    private String secret = "secret";

    public String generateToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        try {
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .build().verify(token);
            return Optional.of(JWTUserData.builder()
                    .userId(decodedJWT.getClaim("userId").asLong())
                    .email(decodedJWT.getSubject())
                    .build());
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }
}
