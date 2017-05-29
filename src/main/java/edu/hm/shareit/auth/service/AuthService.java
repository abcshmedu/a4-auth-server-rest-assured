package edu.hm.shareit.auth.service;

import edu.hm.shareit.auth.model.User;

/**
 * Interface AuthService.
 * @author Wolfgang Gabler, wgabler@hm.edu
 * @since 18.05.17
 */
public interface AuthService {

    /**
     * User Login.
     * @param user User to be logged in.
     * @return AuthServiceResult.
     */
    AuthServiceResult login(User user);

    /**
     * User logout.
     * @param username Username.
     * @param jwtToken JWT Token of the user.
     * @return AuthServiceResult.
     */
    AuthServiceResult logout(String username, String jwtToken);

    /**
     * Validate user token.
     * @param jwtToken Token.
     * @return AuthServiceResult.
     */
    AuthServiceResult validate(String jwtToken);
}
