package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.shareit.auth.service.JwtEngine;
import edu.hm.shareit.auth.storage.TokenStorage;

public class JwtEngineTest {

	@Test
	public void invalidateNonExistingUserTest() {
		JwtEngine engine = new JwtEngine();
		String jwt = engine.generateJwt("user");
		assertFalse(engine.invalidateJwt("username", jwt));
	}
	
	@Test
	public void invalidateTest() {
		JwtEngine engine = new JwtEngine();
		String jwt = engine.generateJwt("user");
		assertTrue(engine.invalidateJwt("user", jwt));
	}
	
	@Test
	public void checkValidityWrongUserTest() {
		JwtEngine engine = new JwtEngine();
		String jwt = engine.generateJwt("user");
		engine.invalidateJwt("user", jwt);
		assertFalse(engine.checkValidity(jwt));
	}
	
	@Test
	public void checkValidity2Test() {
		JwtEngine engine = new JwtEngine();
		String jwt = engine.generateJwt("user");
		assertFalse(new JwtEngine(new TokenStorage()).checkValidity(jwt));
	}
	
	@Test
	public void checkValidityTest() {
		JwtEngine def = JwtEngine.getDefault();
		JwtEngine engine = new JwtEngine();
		String jwt = engine.generateJwt("user");
		assertTrue(engine.checkValidity(jwt));
	}

}
