package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {

	private static final String CHROME_DRIVER_PATH =
			"C:/Users/thisa/Downloads/Compressed/New/chromedriver-win64/chromedriver-win64/chromedriver.exe";

	private static final String BASE = "http://127.0.0.1:8080";

	WebDriver driver;

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	// -----------------------------------------------------------------------
	// Helper: perform login with your valid credentials
	// -----------------------------------------------------------------------
	private void doLogin() {
		driver.get(BASE + "/login");
		sleep(2);
		driver.findElement(By.name("username")).sendKeys("thisara");
		driver.findElement(By.name("passwd")).sendKeys("thisara_pass");
		driver.findElement(By.name("dob")).sendKeys("1995-02-16");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
	}

	// Helper: pass Q1 with correct answer (3 + 4 = 7)
	private void passQ1() {
		driver.findElement(By.name("number1")).sendKeys("3");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("7");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
	}

	// Helper: pass Q2 with correct answer (10 - 3 = 7)
	private void passQ2() {
		driver.findElement(By.name("number1")).sendKeys("10");
		driver.findElement(By.name("number2")).sendKeys("3");
		driver.findElement(By.name("result")).sendKeys("7");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
	}

	// -----------------------------------------------------------------------
	// TC-F01: Valid login navigates to Q1
	// -----------------------------------------------------------------------
	@Test
	public void testValidLoginNavigatesToQ1() {
		doLogin();
		System.out.println("[TC-F01] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/q1")
				: "Expected /q1 but got: " + driver.getCurrentUrl();
	}

	// -----------------------------------------------------------------------
	// TC-F02: Invalid credentials stay on login with error message
	// -----------------------------------------------------------------------
	@Test
	public void testInvalidLoginShowsError() {
		driver.get(BASE + "/login");
		sleep(2);
		driver.findElement(By.name("username")).sendKeys("wronguser");
		driver.findElement(By.name("passwd")).sendKeys("wrongpass");
		driver.findElement(By.name("dob")).sendKeys("1990-01-01");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
		System.out.println("[TC-F02] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/login")
				: "Expected to stay on /login";
		assert driver.getPageSource().contains("Incorrect credentials.")
				: "Expected error message";
	}

	// -----------------------------------------------------------------------
	// TC-F03: Empty login fields stay on login page
	// -----------------------------------------------------------------------
	@Test
	public void testEmptyLoginFieldsShowsError() {
		driver.get(BASE + "/login");
		sleep(2);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
		System.out.println("[TC-F03] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/login")
				: "Expected to stay on /login";
	}

	// -----------------------------------------------------------------------
	// TC-F04: Correct Q1 answer (3+4=7) navigates to Q2
	// -----------------------------------------------------------------------
	@Test
	public void testCorrectQ1NavigatesToQ2() {
		doLogin();
		passQ1();
		System.out.println("[TC-F04] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/q2")
				: "Expected /q2 but got: " + driver.getCurrentUrl();
	}

	// -----------------------------------------------------------------------
	// TC-F05: Wrong Q1 answer stays on Q1 with error message
	// -----------------------------------------------------------------------
	@Test
	public void testWrongQ1ShowsError() {
		doLogin();
		driver.findElement(By.name("number1")).sendKeys("3");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("99");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
		System.out.println("[TC-F05] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/q1")
				: "Expected to stay on /q1";
		assert driver.getPageSource().contains("Wrong answer, try again.")
				: "Expected error message";
	}

	// -----------------------------------------------------------------------
	// TC-F06: Correct Q2 answer (10-3=7) navigates to Q3
	// -----------------------------------------------------------------------
	@Test
	public void testCorrectQ2NavigatesToQ3() {
		doLogin();
		passQ1();
		passQ2();
		System.out.println("[TC-F06] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/q3")
				: "Expected /q3 but got: " + driver.getCurrentUrl();
	}

	// -----------------------------------------------------------------------
	// TC-F07: Wrong Q2 answer stays on Q2 with error message
	// -----------------------------------------------------------------------
	@Test
	public void testWrongQ2ShowsError() {
		doLogin();
		passQ1();
		driver.findElement(By.name("number1")).sendKeys("10");
		driver.findElement(By.name("number2")).sendKeys("3");
		driver.findElement(By.name("result")).sendKeys("99");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
		System.out.println("[TC-F07] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/q2")
				: "Expected to stay on /q2";
		assert driver.getPageSource().contains("Wrong answer, try again.")
				: "Expected error message";
	}

	// -----------------------------------------------------------------------
	// TC-F08: Correct Q3 answer (4x5=20) shows congratulations
	// -----------------------------------------------------------------------
	@Test
	public void testCorrectQ3ShowsSuccess() {
		doLogin();
		passQ1();
		passQ2();
		driver.findElement(By.name("number1")).sendKeys("4");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("20");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
		System.out.println("[TC-F08] Page: " + driver.getPageSource());
		assert driver.getPageSource().contains("Congratulations")
				: "Expected success message";
	}

	// -----------------------------------------------------------------------
	// TC-F09: Wrong Q3 answer stays on Q3 with error message
	// -----------------------------------------------------------------------
	@Test
	public void testWrongQ3ShowsError() {
		doLogin();
		passQ1();
		passQ2();
		driver.findElement(By.name("number1")).sendKeys("4");
		driver.findElement(By.name("number2")).sendKeys("5");
		driver.findElement(By.name("result")).sendKeys("99");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		sleep(2);
		System.out.println("[TC-F09] URL: " + driver.getCurrentUrl());
		assert driver.getCurrentUrl().contains("/q3")
				: "Expected to stay on /q3";
		assert driver.getPageSource().contains("Wrong answer, try again.")
				: "Expected error message";
	}
}