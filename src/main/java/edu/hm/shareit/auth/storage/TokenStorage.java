package edu.hm.shareit.auth.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * TokenStorage.
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @author Andrea Limmer, limmer@hm.edu
 * @since 28.05.17
 */
public class TokenStorage {

    private static final TokenStorage INSTANCE = new TokenStorage();

    /**
     * Get the default TokenStorage.
     * @return TokenStorage.
     */
    public static TokenStorage getDefault() {
        return INSTANCE;
    }

    private final Map<String, String> tokens;

    /**
     * Constructor.
     */
    public TokenStorage() {
        this.tokens = new HashMap<>();
    }

    /**
     * Update a token.
     * @param username Username.
     * @param token new Token.
     */
    public void updateToken(String username, String token) {
        tokens.put(username, token);
    }

    /**
     * Get token for a specified user.
     * @param username Username.
     * @return String with the token.
     */
    public String getToken(String username) {
        return tokens.get(username);
    }

    /**
     * Remove token for user.
     * @param username username.
     */
    public void removeToken(String username) {
        tokens.remove(username);
    }
    
    /**
     * Get Map with all tokens.
     * @return All tokens.
     */
    public Map<String, String> getTokens() {
        return tokens;
    }
}
