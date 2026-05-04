package edu.deakin;

import org.junit.Assert;
import org.junit.Test;

public class SimpleLoginFormTest {

    // TC1: Valid username + valid password → success
    @Test
    public void testValidUsernameValidPassword_ReturnsSuccess() {
        String result = SimpleLoginForm.login("testuser", "testpass");
        Assert.assertEquals("success", result);
    }

    // TC2: Wrong username + valid password → username mismatch
    @Test
    public void testInvalidUsernameValidPassword_ReturnsUsernameMismatch() {
        String result = SimpleLoginForm.login("wronguser", "testpass");
        Assert.assertEquals("username mismatch", result);
    }

    // TC3: Valid username + wrong password → password mismatch
    @Test
    public void testValidUsernameInvalidPassword_ReturnsPasswordMismatch() {
        String result = SimpleLoginForm.login("testuser", "wrongpass");
        Assert.assertEquals("password mismatch", result);
    }

    // TC4: Wrong username + wrong password → username mismatch (checked first)
    @Test
    public void testInvalidUsernameInvalidPassword_ReturnsUsernameMismatch() {
        String result = SimpleLoginForm.login("wronguser", "wrongpass");
        Assert.assertEquals("username mismatch", result);
    }

    // TC5: Null username → expect NullPointerException
    @Test(expected = NullPointerException.class)
    public void testNullUsername_ThrowsException() {
        SimpleLoginForm.login(null, "testpass");
    }

    // TC6: Null password → expect NullPointerException
    @Test(expected = NullPointerException.class)
    public void testNullPassword_ThrowsException() {
        SimpleLoginForm.login("testuser", null);
    }

    // TC7: Empty strings → username mismatch
    @Test
    public void testEmptyCredentials_ReturnsUsernameMismatch() {
        String result = SimpleLoginForm.login("", "");
        Assert.assertEquals("username mismatch", result);
    }
}