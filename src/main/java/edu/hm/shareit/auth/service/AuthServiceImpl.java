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
    public AuthServiceResult signUp(User user) {
        return null;
    }

    @Override
    public AuthServiceResult login(User user) {
        return null;
    }

    @Override
    public AuthServiceResult logout(String username) {
        return null;
    }

    @Override
    public AuthServiceResult validate(String jwtToken) {
        return null;
    }
}
