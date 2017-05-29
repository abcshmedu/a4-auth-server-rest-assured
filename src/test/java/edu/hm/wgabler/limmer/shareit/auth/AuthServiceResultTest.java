package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.shareit.auth.service.AuthServiceResult;

public class AuthServiceResultTest {

	@Test
	public void gettersTest() {
		assertEquals(200, AuthServiceResult.OK.getCode());
		assertEquals("OK", AuthServiceResult.OK.getMsg());
		assertEquals(null, AuthServiceResult.OK.getContent());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(AuthServiceResult.OK.hashCode(), new AuthServiceResult(200, "OK", null).hashCode());
	}
	
	@Test 
	public void toStringTest() {
		assertEquals(
				"AuthServiceResult {code=200, msg=OK, content=null}",
				AuthServiceResult.OK.toString()
		);
	}
	
	@Test
	public void notEqualsNullTest() {
		assertFalse(AuthServiceResult.OK.equals(null));
	}
	
	@Test
	public void notEqualsOtherClassTest() {
		assertFalse(AuthServiceResult.OK.equals(new String("...")));
	}
	
	@Test
	public void equalsItselfTest() {
		assertTrue(AuthServiceResult.OK.equals(AuthServiceResult.OK));
	}
	
	@Test
	public void equalsTest() {
		assertTrue(AuthServiceResult.OK.equals(new AuthServiceResult(200, "OK", null)));
	}
	
	@Test
	public void notEqualsCodeTest() {
		assertFalse(AuthServiceResult.OK.equals(new AuthServiceResult(300, "OK", null)));
	}
	
	@Test
	public void notEqualsMsgTest() {
		assertFalse(AuthServiceResult.OK.equals(new AuthServiceResult(200, "OKK", null)));
	}

	@Test
	public void notEqualsContentTest() {
		assertFalse(AuthServiceResult.OK.equals(new AuthServiceResult(200, "OK", "content")));
	}
}
