/*
 * Wolfgang Gabler
 *
 * Software: Mac OS X 10.12, Oracle Java 1.8.0_111 SE
 * System: Intel Core i7-4850HQ, 16 GByte RAM
 */
package edu.hm.shareit.auth.service;

import edu.hm.shareit.auth.model.User;

/**
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 18.05.17
 */
public interface AuthService {

    AuthServiceResult login(User user);

    AuthServiceResult logout(String username, String jwtToken);

    AuthServiceResult validate(String jwtToken);
}
