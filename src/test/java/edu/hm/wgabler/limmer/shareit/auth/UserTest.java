package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.hm.shareit.auth.model.User;

/**
 * Tests for User.
 * @author Andrea Limmer, limmer@hm.edu
 */
public class UserTest {

    /**
     * Test toString.
     */
    @Test
    public void toStringTest() {
        assertEquals(
                "User{username='testUser', password='pwd'}",
                new User("testUser", "pwd").toString()
        );
    }
    
    /**
     * Test toString for empty User.
     */
    @Test
    public void toStringTestEmptyUser() {
        assertEquals(
                "User{username='', password=''}",
                new User().toString()
        );
    }
        
    /**
     * Test getters.
     */
    @Test
    public void gettersTest() {
        User user = new User("user", "password");
        assertEquals("user", user.getUsername());
        assertEquals("password", user.getPassword());
    }
    
    /**
     * Not equals null.
     */
    @Test
    public void notEqualsNullTest() {
        assertFalse(new User("x", "y").equals(null));
    }

    /**
     * Equals itself.
     */
    @Test
    public void equalItselfTest() {
        User user = new User("x", "y");
        assertTrue(user.equals(user));
    }
    
    /**
     * Not equals object of other class.
     */
    @Test
    public void notEqalsOtherClassTest() {
        User user = new User("x", "y");
        assertFalse(user.equals(new String("x")));
    }
    
    /**
     * Equals test.
     */
    @Test
    public void equalsTest() {
        User user = new User("x", "y");
        User other = new User("x", "y");
        assertTrue(user.equals(other));
    }
    
    /**
     * Not equals User with other username.
     */
    @Test
    public void notEqualsOtherUsernameTest() {
        User user = new User("x", "y");
        User other = new User("xx", "y");
        assertFalse(user.equals(other));
    }
    
    /**
     * Not equals User with other pwd.
     */
    @Test
    public void notEqualsOtherPwdTest() {
        User user = new User("x", "y");
        User other = new User("x", "yy");
        assertFalse(user.equals(other));
    }
    
    /**
     * Test hashCode.
     */
    @Test
    public void hashCodeTest() {
        User user = new User("x", "y");
        User other = new User("x", "y");
        assertEquals(user.hashCode(), other.hashCode());
    }
}
