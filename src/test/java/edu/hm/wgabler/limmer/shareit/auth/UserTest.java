package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.hm.shareit.auth.model.User;

public class UserTest {

	@Test
	public void toStringTest() {
		assertEquals(
				"User{username='testUser', password='pwd'}",
				new User("testUser", "pwd").toString()
		);
	}
	
	@Test
	public void gettersTest() {
		User user = new User("user", "password");
		assertEquals("user", user.getUsername());
		assertEquals("password", user.getPassword());
	}
	
	@Test
	public void notEqualsNullTest() {
		assertFalse(new User("x", "y").equals(null));
	}

	@Test
	public void equalItselfTest() {
		User user = new User("x", "y");
		assertTrue(user.equals(user));
	}
	
	@Test
	public void notEqalsOtherClassTest() {
		User user = new User("x", "y");
		assertFalse(user.equals(new String("x")));
	}
	
	@Test
	public void equalsTest() {
		User user = new User("x", "y");
		User other = new User("x", "y");
		assertTrue(user.equals(other));
	}
	
	@Test
	public void notEqualsOtherUsernameTest() {
		User user = new User("x", "y");
		User other = new User("xx", "y");
		assertFalse(user.equals(other));
	}
	
	@Test
	public void notEqualsOtherPwdTest() {
		User user = new User("x", "y");
		User other = new User("x", "yy");
		assertFalse(user.equals(other));
	}
	
	@Test
	public void hashCodeTest() {
		User user = new User("x", "y");
		User other = new User("x", "y");
		assertEquals(user.hashCode(), other.hashCode());
	}
}
