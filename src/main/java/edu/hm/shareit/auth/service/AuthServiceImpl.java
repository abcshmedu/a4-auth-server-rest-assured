package edu.hm.shareit.auth.service;

import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.storage.UserStorage;

/**
 * AuthServiceImpl.
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @author Andrea Limmer, limmer@hm.edu
 * @since 18.05.17
 */
public class AuthServiceImpl implements AuthService {

    private final UserStorage userStorage;
    
    private final JwtEngine jwtEngine;

    /**
     * Constructor.
     */
    public AuthServiceImpl() {
        this(UserStorage.getDefault());
    }
    
    /**
     * Constructor.
     * @param userStorage custom UserStorage.
     */
    public AuthServiceImpl(UserStorage userStorage) {
        this(userStorage, JwtEngine.getDefault());
    }

    /**
     * Constructor.
     * @param userStorage custom UserStorage.
     * @param jwtEngine custom JwtEngine.
     */
    public AuthServiceImpl(UserStorage userStorage, JwtEngine jwtEngine) {
        this.userStorage = userStorage;
        this.jwtEngine = jwtEngine;
    }

    @Override
    public AuthServiceResult login(User user) {
        final User dbUser = userStorage.getUser(user.getUsername());
        if (dbUser == null || !user.getPassword().equals(dbUser.getPassword())) {
            return AuthServiceResult.UNAUTHORIZED;
        }
        final String jwt = jwtEngine.generateJwt(user.getUsername());
        return new AuthServiceResult(AuthServiceResult.OK.getCode(), "OK", jwt);
    }

    @Override
    public AuthServiceResult logout(String username, String jwtToken) {
        return jwtEngine.invalidateJwt(username, jwtToken) ? AuthServiceResult.OK : AuthServiceResult.UNAUTHORIZED;
    }

    @Override
    public AuthServiceResult validate(String jwtToken) {
        return jwtEngine.checkValidity(jwtToken) ? AuthServiceResult.OK : AuthServiceResult.UNAUTHORIZED;
    }
}
