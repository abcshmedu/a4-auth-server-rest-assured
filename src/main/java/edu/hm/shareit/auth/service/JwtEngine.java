/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.service;

import edu.hm.shareit.auth.storage.TokenStorage;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.util.Date;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 29.05.17
 */
public class JwtEngine {

    private static final JwtEngine INSTANCE = new JwtEngine();
    private static final String SECRET = "this-is-a-very-easy-secret";
    private static final long EXPIRATION_DURATION = 60 * 30 * 1000;

    public static JwtEngine getDefault() {
        return INSTANCE;
    }
    private final TokenStorage tokenStorage = TokenStorage.getDefault();

    public String generateJwt(String username) {
        final long expiration = (new Date().getTime()) + EXPIRATION_DURATION;
        final String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        tokenStorage.UpdateToken(username, jwt);
        return jwt;
    }

    public void invalidateJwt(String jwt) {
        try {
            final String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody().getSubject();
            tokenStorage.removeToken(user);
        } catch (Exception e) {

        }
    }

    public boolean checkValidity(String token) {
        try {
            final String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
            return tokenStorage.getToken(user) != null;
        } catch (SignatureException | ExpiredJwtException e) {
            return false;
        }
    }
}
