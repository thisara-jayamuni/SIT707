package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
    private static final String CHROME_DRIVER_PATH =
            "C:/Users/thisa/Downloads/Compressed/chromedriver-win64/chromedriver-win64/chromedriver.exe";
 
    private static final String LOGIN_HTML_PATH =
            "file:///D:/Acedemic/MSC%20-%20Deakin/2026%20-%20T1/SIT707%20-%20Software%20Quality%20and%20Testing/Projects/SIT707/task7_1P_224785681/pages/login.html"; 
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Open Chrome, navigate to login.html, and return the driver. */
    private WebDriver openLoginPage() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(LOGIN_HTML_PATH);
        sleep(3);
        return driver;
    }
 
    /** Fill the login form fields and submit. dob format: mm/dd/yyyy */
    private void fillAndSubmit(WebDriver driver, String username,
                               String password, String dob) {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys(username);
 
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys(password);
 
        if (dob != null && !dob.isEmpty()) {
            ele = driver.findElement(By.id("dob"));
            ele.clear();
            ele.sendKeys(dob);          // HTML date input accepts yyyy-mm-dd
        }
 
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        sleep(2);
    }
 
    // -----------------------------------------------------------------------
    // TC-F01 : Valid credentials -> expect page title "success"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginSuccess_ValidCredentials() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "thisara", "thisara_pass", "1995-02-16");
 
            String title = driver.getTitle();
            System.out.println("[TC-F01] Title: " + title);
            Assert.assertEquals("success", title);
        } finally {
            driver.close();
        }
    }
 
    // -----------------------------------------------------------------------
    // TC-F02 : Wrong password -> expect "fail"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginFail_WrongPassword() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "thisara", "wrong_password", "1995-02-16");
 
            String title = driver.getTitle();
            System.out.println("[TC-F02] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally {
            driver.close();
        }
    }
 
    // -----------------------------------------------------------------------
    // TC-F03 : Wrong username -> expect "fail"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginFail_WrongUsername() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "wronguser", "thisara_pass", "1995-02-16");
 
            String title = driver.getTitle();
            System.out.println("[TC-F03] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally {
            driver.close();
        }
    }
 
    // -----------------------------------------------------------------------
    // TC-F04 : Wrong date of birth -> expect "fail"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginFail_WrongDob() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "thisara", "thisara_pass", "1994-12-31");
 
            String title = driver.getTitle();
            System.out.println("[TC-F04] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally {
            driver.close();
        }
    }
 
    // -----------------------------------------------------------------------
    // TC-F05 : All fields empty -> expect "fail"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginFail_EmptyFields() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "", "", "");
 
            String title = driver.getTitle();
            System.out.println("[TC-F05] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally {
            driver.close();
        }
    }
 
    // -----------------------------------------------------------------------
    // TC-F06 : Correct username and dob but wrong password -> expect "fail"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginFail_CorrectUsernameAndDob_WrongPassword() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "thisara", "badpass", "1995-02-16");
 
            String title = driver.getTitle();
            System.out.println("[TC-F06] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally {
            driver.close();
        }
    }
 
    // -----------------------------------------------------------------------
    // TC-F07 : Invalid dob format (dd-mm-yyyy instead of yyyy-mm-dd) -> expect "fail"
    // -----------------------------------------------------------------------
    @Test
    public void testLoginFail_InvalidDobFormat() {
        WebDriver driver = openLoginPage();
        try {
            fillAndSubmit(driver, "thisara", "thisara_pass", "16-02-1995");
 
            String title = driver.getTitle();
            System.out.println("[TC-F07] Title: " + title);
            Assert.assertEquals("fail", title);
        } finally {
            driver.close();
        }
    }
}
