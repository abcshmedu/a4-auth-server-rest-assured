package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import edu.hm.shareit.auth.storage.TokenStorage;

public class TokenStorageTest {

	@Test
	public void updateTokenTest() {
		TokenStorage defaultSt = TokenStorage.getDefault();
		TokenStorage storage = new TokenStorage();
		storage.updateToken("user", "token");
		Map<String, String> expected = new HashMap<>();
		expected.put("user", "token");
		assertEquals(expected, storage.getTokens());
	}
	
	@Test
	public void updateTokenTest2() {
		TokenStorage storage = new TokenStorage();
		storage.updateToken("user", "token");
		storage.updateToken("user", "new");
		Map<String, String> expected = new HashMap<>();
		expected.put("user", "new");
		assertEquals(expected, storage.getTokens());
	}
	
	@Test
	public void getTokenTest() {
		TokenStorage storage = new TokenStorage();
		storage.updateToken("user", "token");
		assertEquals("token", storage.getToken("user"));
	}
	
	@Test
	public void getTokenNotAvailableTest() {
		TokenStorage storage = new TokenStorage();
		assertEquals(null, storage.getToken("user"));
	}
	
	@Test
	public void removeTokenNotAvailableTest() {
		TokenStorage storage = new TokenStorage();
		storage.removeToken("user");
		Map<String, String> expected = new HashMap<>();
		assertEquals(expected, storage.getTokens());
	}
	
	@Test
	public void removeTokenTest() {
		TokenStorage storage = new TokenStorage();
		storage.updateToken("user", "token");
		storage.updateToken("user2", "token2");
		storage.removeToken("user2");
		Map<String, String> expected = new HashMap<>();
		expected.put("user", "token");
		assertEquals(expected, storage.getTokens());
	}

}
