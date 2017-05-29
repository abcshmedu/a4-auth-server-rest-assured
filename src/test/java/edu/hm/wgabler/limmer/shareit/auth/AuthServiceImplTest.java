package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.service.AuthService;
import edu.hm.shareit.auth.service.AuthServiceImpl;
import edu.hm.shareit.auth.service.AuthServiceResult;
import edu.hm.shareit.auth.service.JwtEngine;
import edu.hm.shareit.auth.storage.TokenStorage;
import edu.hm.shareit.auth.storage.UserStorage;

public class AuthServiceImplTest {

	@Test
	public void loginNotAvailableTest() {
		AuthService service = new AuthServiceImpl(new UserStorage());
		assertEquals(AuthServiceResult.UNAUTHORIZED, service.login(new User("user", "pwd")));
	}
	
	@Test
	public void loginWrongPwdTest() {
		UserStorage users = new UserStorage();
		users.addUser(new User("user", "password"));
		AuthService service = new AuthServiceImpl(users);
		assertEquals(AuthServiceResult.UNAUTHORIZED, service.login(new User("user", "pwd")));
	}
	
	@Test
	public void loginTest() {
		AuthServiceImpl def = new AuthServiceImpl();
		UserStorage users = new UserStorage();
		User user = new User("user", "pwd");
		users.addUser(user);
		AuthService service = new AuthServiceImpl(users);
		AuthServiceResult res = service.login(user);
		assertEquals(200, res.getCode());
		assertEquals("OK", res.getMsg());
	}
	
	@Test
	public void logoutTest() {
		UserStorage users = new UserStorage();
		User user = new User("user", "pwd");
		users.addUser(user);
		AuthService service = new AuthServiceImpl(users);
		AuthServiceResult res = service.login(user);
		assertEquals(AuthServiceResult.OK, service.logout("user", res.getContent()));
	}
	
	@Test
	public void logoutUnauthorizedTest() {
		UserStorage users = new UserStorage();
		User user = new User("user", "pwd");
		users.addUser(user);
		AuthService service = new AuthServiceImpl(users);
		AuthServiceResult res = service.login(user);
		assertEquals(AuthServiceResult.UNAUTHORIZED, service.logout("userr", res.getContent()));
	}
	
	@Test
	public void logoutUnauthorized2Test() {
		UserStorage users = new UserStorage();
		User user = new User("user", "pwd");
		users.addUser(user);
		AuthService service = new AuthServiceImpl(users);
		AuthServiceResult res = service.login(user);
		assertEquals(AuthServiceResult.UNAUTHORIZED, service.logout("user", null));
	}
	
	@Test
	public void validateTest() {
		UserStorage users = new UserStorage();
		User user = new User("user", "pwd");
		users.addUser(user);
		AuthService service = new AuthServiceImpl(users);
		AuthServiceResult res = service.login(user);
		assertEquals(AuthServiceResult.OK, service.validate(res.getContent()));
	}
	
	@Test
	public void notValidTest() {
		AuthService service = new AuthServiceImpl(new UserStorage(), new JwtEngine(new TokenStorage()));
		String jwt = new JwtEngine().generateJwt("user");
		assertEquals(AuthServiceResult.UNAUTHORIZED, service.validate(jwt));
	}

}
