package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import edu.hm.shareit.auth.api.Api;
import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.service.AuthServiceResult;
import edu.hm.shareit.auth.service.JwtEngine;
import edu.hm.shareit.auth.storage.TokenStorage;

/**
 * Tests for Api class.
 * @author Andrea Limmer, limmer@hm.edu
 */
public class ApiTest {

    /**
     * Test login for nonexisting user.
     */
    @Test
    public void incorrectUserLoginTest() {
        assertEquals(AuthServiceResult.UNAUTHORIZED.getCode(), new Api().login(new User("horst", "pwd")).getStatus());
    }
    
    /**
     * Test login.
     */
    @Test
    public void loginTest() {
        assertEquals(AuthServiceResult.OK.getCode(), new Api().login(new User("bob", "42")).getStatus());
    }
    
    /**
     * Test logout.
     */
    @Test
    public void logoutTest() {
        Api api = new Api();
        Response resp = api.login(new User("bob", "42"));
        resp = api.logout("bob", resp.getEntity().toString());
        assertEquals(AuthServiceResult.OK.getCode(), resp.getStatus());
    }
    
    /**
     * Test logout with wrong user.
     */
    @Test
    public void logoutWrongUserTest() {
        Api api = new Api();
        Response resp = api.login(new User("bob", "42"));
        resp = api.logout("user", resp.getEntity().toString());
        assertEquals(AuthServiceResult.UNAUTHORIZED.getCode(), resp.getStatus());
    }
    
    /**
     * Test logout with wrong token.
     */
    @Test
    public void logoutWrongJwtTest() {
        Api api = new Api();
        String jwt = new JwtEngine(new TokenStorage()).generateJwt("horst");
        Response resp = api.logout("bob", jwt);
        assertEquals(AuthServiceResult.UNAUTHORIZED.getCode(), resp.getStatus());
    }
    
    /**
     * Test validate.
     */
    @Test
    public void validateTest() {
        Api api = new Api();
        Response resp = api.login(new User("bob", "42"));
        assertEquals(AuthServiceResult.OK.getCode(), api.validate(resp.getEntity().toString()).getStatus());
    }
    
    /**
     * Test validate for invalid token.
     */
    @Test
    public void notValidTest() {
        Api api = new Api();
        String jwt = new JwtEngine(new TokenStorage()).generateJwt("horst");
        assertEquals(AuthServiceResult.UNAUTHORIZED.getCode(), api.validate(jwt).getStatus());
    }
}
