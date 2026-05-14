package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    // -----------------------------------------------------------------------
    // TC-U01 : Valid credentials – all three fields correct
    // -----------------------------------------------------------------------
    @Test
    public void testValidLogin_AllCorrect() {
        boolean result = LoginService.login("thisara", "thisara_pass", "1995-02-16");
        Assert.assertTrue("Expected true for valid credentials", result);
    }

    // -----------------------------------------------------------------------
    // TC-U02 : Wrong username – valid password and dob
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_WrongUsername() {
        boolean result = LoginService.login("wronguser", "thisara_pass", "1995-02-16");
        Assert.assertFalse("Expected false for wrong username", result);
    }

    // -----------------------------------------------------------------------
    // TC-U03 : Wrong password – valid username and dob
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_WrongPassword() {
        boolean result = LoginService.login("thisara", "wrongpass", "1995-02-16");
        Assert.assertFalse("Expected false for wrong password", result);
    }

    // -----------------------------------------------------------------------
    // TC-U04 : Wrong dob – valid username and password
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_WrongDob() {
        boolean result = LoginService.login("thisara", "thisara_pass", "1999-12-31");
        Assert.assertFalse("Expected false for wrong date of birth", result);
    }

    // -----------------------------------------------------------------------
    // TC-U05 : Null username
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_NullUsername() {
        boolean result = LoginService.login(null, "thisara_pass", "1995-02-16");
        Assert.assertFalse("Expected false for null username", result);
    }

    // -----------------------------------------------------------------------
    // TC-U06 : Null password
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_NullPassword() {
        boolean result = LoginService.login("thisara", null, "1995-02-16");
        Assert.assertFalse("Expected false for null password", result);
    }

    // -----------------------------------------------------------------------
    // TC-U07 : Null dob
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_NullDob() {
        boolean result = LoginService.login("thisara", "thisara_pass", null);
        Assert.assertFalse("Expected false for null dob", result);
    }

    // -----------------------------------------------------------------------
    // TC-U08 : Empty username
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_EmptyUsername() {
        boolean result = LoginService.login("", "thisara_pass", "1995-02-16");
        Assert.assertFalse("Expected false for empty username", result);
    }

    // -----------------------------------------------------------------------
    // TC-U09 : Empty password
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_EmptyPassword() {
        boolean result = LoginService.login("thisara", "", "1995-02-16");
        Assert.assertFalse("Expected false for empty password", result);
    }

    // -----------------------------------------------------------------------
    // TC-U10 : Empty dob
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_EmptyDob() {
        boolean result = LoginService.login("thisara", "thisara_pass", "");
        Assert.assertFalse("Expected false for empty dob", result);
    }

    // -----------------------------------------------------------------------
    // TC-U11 : Invalid dob format (dd-mm-yyyy instead of yyyy-mm-dd)
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_WrongDobFormat_ddmmyyyy() {
        boolean result = LoginService.login("thisara", "thisara_pass", "16-02-1995");
        Assert.assertFalse("Expected false for dob in dd-mm-yyyy format", result);
    }

    // -----------------------------------------------------------------------
    // TC-U12 : Invalid dob format (plain text)
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_WrongDobFormat_text() {
        boolean result = LoginService.login("thisara", "thisara_pass", "February 16 1995");
        Assert.assertFalse("Expected false for dob as text", result);
    }

    // -----------------------------------------------------------------------
    // TC-U13 : All fields wrong
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_AllWrong() {
        boolean result = LoginService.login("x", "y", "z");
        Assert.assertFalse("Expected false when all fields are wrong", result);
    }

    // -----------------------------------------------------------------------
    // TC-U14 : All fields null
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_AllNull() {
        boolean result = LoginService.login(null, null, null);
        Assert.assertFalse("Expected false when all fields are null", result);
    }

    // -----------------------------------------------------------------------
    // TC-U15 : Case-sensitive username check (boundary: capitalised first letter)
    // -----------------------------------------------------------------------
    @Test
    public void testInvalidLogin_CaseSensitiveUsername() {
        boolean result = LoginService.login("Thisara", "thisara_pass", "1995-02-16");
        Assert.assertFalse("Expected false – username is case-sensitive", result);
    }
}