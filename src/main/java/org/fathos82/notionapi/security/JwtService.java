package org.fathos82.notionapi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JwtService {

    String SECRET = "isso-e-apenas-uma-chave-teste";
    private final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public String generateToken(String userName) {
        return JWT.create()
                .withSubject(userName)
                .withIssuedAt(new Date())
                .withExpiresAt(generateExpiresDate())
                .sign(algorithm);
    }

    private Date generateExpiresDate() {
        return new Date(new Date().getTime() + 1000 * 60 * 60 * 6);
    }

    public String getUsernameFromToken(String token) {
        DecodedJWT decodedJWT = getVerifier().verify(token);
        return decodedJWT.getSubject();
    }

    private JWTVerifier getVerifier() {
        return JWT.require(algorithm).build();
    }
}
