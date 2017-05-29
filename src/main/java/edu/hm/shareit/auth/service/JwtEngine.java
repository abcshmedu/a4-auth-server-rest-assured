package edu.hm.shareit.auth.service;

import edu.hm.shareit.auth.storage.TokenStorage;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.util.Date;

/**
 * JWT Engine.
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @author Andrea Limmer, limmer@hm.edu
 * @since 29.05.17
 */
public class JwtEngine {

    private static final JwtEngine INSTANCE = new JwtEngine();
    private static final String SECRET = "this-is-a-very-easy-secret";
    private static final long EXPIRATION_DURATION = 60 * 30 * 1000;

    /**
     * Get the default JwtEngine.
     * @return default JWT Engine.
     */
    public static JwtEngine getDefault() {
        return INSTANCE;
    }
    
    /**
     * Constructor.
     */
    public JwtEngine() {
        this.tokenStorage = TokenStorage.getDefault();
    }
    
    /**
     * Constructor.
     * @param tokenStorage custom TokenStorage.
     */
    public JwtEngine(TokenStorage tokenStorage) {
        this.tokenStorage = tokenStorage;
    }

    private final TokenStorage tokenStorage;

    /**
     * Generate a new JWT token based on the username.
     * @param username Username.
     * @return String with the JWT token.
     */
    public String generateJwt(String username) {
        final long expiration = (new Date().getTime()) + EXPIRATION_DURATION;
        final String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        tokenStorage.updateToken(username, jwt);
        return jwt;
    }

    /**
     * Invalidate an existing JWT token.
     * @param username Username.
     * @param jwt JWT token.
     * @return Boolean if token was invalidated.
     */
    public boolean invalidateJwt(String username, String jwt) {
        try {
            final String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody().getSubject();
            if (user.equals(username)) {
                tokenStorage.removeToken(username);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check validity of a JWT token.
     * @param token JWT token.
     * @return Boolean if token is valid.
     */
    public boolean checkValidity(String token) {
        try {
            final String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
            return tokenStorage.getToken(user) != null;
        } catch (SignatureException | ExpiredJwtException e) {
            return false;
        }
    }
}
