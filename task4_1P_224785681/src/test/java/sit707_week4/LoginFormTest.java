package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224785681";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Thisara Jayamuni";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	  // T1: Empty username, Empty password, Don't care validation code
    @Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Empty Username"));
    }

    // T2: Empty username, Wrong password, Don't care validation code
    @Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Empty Username"));
    }

    // T3: Empty username, Correct password, Don't care validation code
    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Empty Username"));
    }

    // T4: Wrong username, Empty password, Don't care validation code
    @Test
    public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Empty Password"));
    }

    // T5: Wrong username, Wrong password, Don't care validation code
    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Credential mismatch"));
    }

    // T6: Wrong username, Correct password, Don't care validation code
    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Credential mismatch"));
    }

    // T7: Correct username, Empty password, Don't care validation code
    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Empty Password"));
    }

    // T8: Correct username, Wrong password, Don't care validation code
    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertTrue(status.isLoginSuccess() == false);
        Assert.assertTrue(status.getErrorMsg().equals("Credential mismatch"));
    }

    // T9: Correct username, Correct password, Empty validation code
    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndEmptyValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess() == true);
        Assert.assertTrue(LoginForm.validateCode(null) == false);
    }

    // T10: Correct username, Correct password, Wrong validation code
    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndWrongValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess() == true);
        Assert.assertTrue(LoginForm.validateCode("abcd") == false);
    }

    // T11: Correct username, Correct password, Correct validation code
    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess() == true);
        Assert.assertTrue(LoginForm.validateCode("123456") == true);
    }
}
