package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.storage.UserStorage;

public class UserStorageTest {

	@Test
	public void notContainsUserTest() {
		UserStorage x = UserStorage.getDefault();
		UserStorage storage = new UserStorage();
		assertFalse(storage.containsUser("notAvailable"));
	}

	@Test
	public void containsUserTest() {
		UserStorage storage = new UserStorage();
		storage.addUser(new User("x", "y"));
		assertTrue(storage.containsUser("x"));
	}
	
	@Test
	public void getUserTest() {
		UserStorage storage = new UserStorage();
		User user = new User("x", "y");
		storage.addUser(user);
		assertEquals(user, storage.getUser("x"));
	}
	
	@Test
	public void removeUserNotAvailableTest() {
		UserStorage storage = new UserStorage();
		assertFalse(storage.removeUser("x"));
	}
	
	@Test
	public void removeUserTest() {
		UserStorage storage = new UserStorage();
		storage.addUser(new User("x", "y"));
		assertTrue(storage.removeUser("x"));
	}
}
