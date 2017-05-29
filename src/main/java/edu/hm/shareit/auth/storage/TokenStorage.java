/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 28.05.17
 */
public class TokenStorage {

    private static final TokenStorage INSTANCE = new TokenStorage();

    public static TokenStorage getDefault() {
        return INSTANCE;
    }

    private final Map<String, String> tokens;

    public TokenStorage() {
        this.tokens = new HashMap<>();
    }

    public void updateToken(String username, String token) {
        tokens.put(username, token);
    }

    public String getToken(String username) {
        return tokens.get(username);
    }

    public void removeToken(String username) {
        tokens.remove(username);
    }
    
    public Map<String, String> getTokens() {
    	return tokens;
    }
}
