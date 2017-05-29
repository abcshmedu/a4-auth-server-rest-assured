/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.service;

import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.storage.UserStorage;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 18.05.17
 */
public class AuthServiceImpl implements AuthService {

    private final UserStorage userStorage;

    public AuthServiceImpl() {
        this.userStorage = UserStorage.getDefault();
    }

    public AuthServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public AuthServiceResult login(User user) {
        final User dbUser = userStorage.getUser(user.getUsername());
        if (!user.getPassword().equals(dbUser.getPassword())) {
            return AuthServiceResult.UNAUTHORIZED;
        }
        final String jwt = JwtEngine.getDefault().generateJwt(user.getUsername());
        return new AuthServiceResult(200, "OK", jwt);
    }

    @Override
    public AuthServiceResult logout(String username, String jwtToken) {
        return JwtEngine.getDefault().invalidateJwt(username, jwtToken) ? AuthServiceResult.OK : AuthServiceResult.UNAUTHORIZED;
    }

    @Override
    public AuthServiceResult validate(String jwtToken) {
        return JwtEngine.getDefault().checkValidity(jwtToken) ? AuthServiceResult.OK : AuthServiceResult.UNAUTHORIZED;
    }
}
