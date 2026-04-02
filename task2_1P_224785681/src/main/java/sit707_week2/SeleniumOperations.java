package sit707_week2;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/thisa/Downloads/Compressed/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Thisara");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Jayamuni");
		
		WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
		phoneNumber.sendKeys("0425123456");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("thisara@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		confirmPassword.sendKeys("123456");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement createAccountBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	    System.out.println("Found 'Create account' button: " + createAccountBtn);
	    createAccountBtn.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("D:/Acedemic/MSC - Deakin/2026 - T1/SIT707 - Software Quality and Testing/SIT707-2.1P/Screenshots/officeworks_registration.png");
            destFile.getParentFile().mkdirs();
            Files.copy(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
	public static void github_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/thisa/Downloads/Compressed/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("thisara@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement username = driver.findElement(By.id("login"));
		username.sendKeys("thisara-test");
		

        // ------------------------------------------------------------------
        // Country/Region Select
        //
        // Step 1: Click the dropdown button using its exact id from the HTML.
        // ------------------------------------------------------------------
        WebElement countryButton = driver.findElement(By.id("country-dropdown-panel-button"));
        System.out.println("Found country dropdown button: " + countryButton);
        countryButton.click();

 
        // Step 2: Type "Australia" into the filter input inside the dialog.
        WebElement countryFilter = driver.findElement(By.id("country-dropdown-panel-filter"));
        System.out.println("Found country filter input: " + countryFilter);
        countryFilter.sendKeys("Australia");
    
 
        // Step 3: Click the Australia button using its data-value="AU" attribute.
        WebElement australiaOption = driver.findElement(By.xpath("//button[@data-value='AU']"));
        System.out.println("Found Australia option: " + australiaOption);
        australiaOption.click();

        WebElement emailPrefCheckbox = driver.findElement(By.id("user_signup[marketing_consent]"));
        System.out.println("Found email preference checkbox: " + emailPrefCheckbox);
        if (!emailPrefCheckbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailPrefCheckbox);
        }
        
        WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-target='signup-form.SignupButton']"));
        System.out.println("Found 'Create account' button: " + createAccountBtn);
        createAccountBtn.click();
	
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("D:/Acedemic/MSC - Deakin/2026 - T1/SIT707 - Software Quality and Testing/SIT707-2.1P/Screenshots/github_registration.png");
            destFile.getParentFile().mkdirs();
            Files.copy(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
}
