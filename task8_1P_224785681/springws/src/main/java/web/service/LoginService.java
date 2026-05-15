package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	private static final String VALID_USERNAME = "thisara";
    private static final String VALID_PASSWORD = "thisara_pass";
    private static final String VALID_DOB = "1995-02-16";
    
	public static boolean login(String username, String password, String dob) {
		// Reject null inputs
        if (username == null || password == null || dob == null) {
            return false;
        }
        
        username = username.trim();
        password = password.trim();
        dob = dob.trim();
 
        // Reject empty inputs
        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }
        
        // Reject invalid dob format (must be yyyy-mm-dd)
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }
        
        // Match a fixed user name and password.
		if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password) && VALID_DOB.equals(dob)) {
			return true;
		}
		
		return false;
	}
}
