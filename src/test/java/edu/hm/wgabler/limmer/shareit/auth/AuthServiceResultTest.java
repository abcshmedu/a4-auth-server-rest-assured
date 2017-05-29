package edu.hm.wgabler.limmer.shareit.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.shareit.auth.service.AuthServiceResult;

/**
 * Tests for AuthServiceResult class.
 * @author Andrea Limmer, limmer@hm.edu
 */
public class AuthServiceResultTest {

    private final int ok = 200;
    
    /**
     * Test getters.
     */
    @Test
    public void gettersTest() {
        assertEquals(ok, AuthServiceResult.OK.getCode());
        assertEquals("OK", AuthServiceResult.OK.getMsg());
        assertEquals(null, AuthServiceResult.OK.getContent());
    }
    
    /**
     * Test hashCode.
     */
    @Test
    public void hashCodeTest() {
        assertEquals(AuthServiceResult.OK.hashCode(), new AuthServiceResult(ok, "OK", null).hashCode());
    }
    
    /**
     * Test toString.
     */
    @Test 
    public void toStringTest() {
        assertEquals(
                "AuthServiceResult {code=200, msg=OK, content=null}",
                AuthServiceResult.OK.toString()
        );
    }
    
    /**
     * Not equals null test.
     */
    @Test
    public void notEqualsNullTest() {
        assertFalse(AuthServiceResult.OK.equals(null));
    }
    
    /**
     * Not equals object of other class test.
     */
    @Test
    public void notEqualsOtherClassTest() {
        assertFalse(AuthServiceResult.OK.equals(new String("...")));
    }
    
    /**
     * Equals itself test.
     */
    @Test
    public void equalsItselfTest() {
        assertTrue(AuthServiceResult.OK.equals(AuthServiceResult.OK));
    }
    
    /**
     * Equals test.
     */
    @Test
    public void equalsTest() {
        assertTrue(AuthServiceResult.OK.equals(new AuthServiceResult(ok, "OK", null)));
    }
    
    /**
     * Not equals because of code mismatch.
     */
    @Test
    public void notEqualsCodeTest() {
        assertFalse(AuthServiceResult.OK.equals(new AuthServiceResult(ok + 1, "OK", null)));
    }
    
    /**
     * Not equals due to wrong msg.
     */
    @Test
    public void notEqualsMsgTest() {
        assertFalse(AuthServiceResult.OK.equals(new AuthServiceResult(ok, "OKK", null)));
    }

    /**
     * Not equals because of different contents.
     */
    @Test
    public void notEqualsContentTest() {
        assertFalse(AuthServiceResult.OK.equals(new AuthServiceResult(ok, "OK", "content")));
    }
}
