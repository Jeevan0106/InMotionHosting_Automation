package org.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_008 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_008");
		System.out.println("Total Test Cases : 02");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement LoginBtn = driver.findElement(By.xpath("//a[@class=\"nav-link btn-secondary-alt btn-login\"]"));
		clickBtn(LoginBtn);
	}

//	@Ignore
	@Test(enabled = false)
	public void tc_023() {
		SoftAssert softAssert = new SoftAssert();
		try {

			// Fill in login credentials
			driver.findElement(By.id("username")).sendKeys("valid@example.com");
			driver.findElement(By.id("password")).sendKeys("validPassword");

			// Wait for CAPTCHA to be completed manually (if present)
			Thread.sleep(15000); // optional pause for manual CAPTCHA

			// Click login button
			driver.findElement(By.id("loginButton")).click();

			// Wait for navigation
			Thread.sleep(5000);

			// Verify navigation
			String currentUrl = driver.getCurrentUrl();
			boolean isNavigated = currentUrl.contains("/home") || currentUrl.contains("dashboard");

			softAssert.assertTrue(isNavigated,
					"Login button should navigate to the Home page, but landed on: " + currentUrl);

		} catch (Exception e) {
			softAssert.fail("Exception occurred during login navigation test: " + e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void tc_024() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Step 1: Verify Login Button Text
			WebElement loginButton = driver.findElement(By.id("loginButton")); // Replace with actual locator
			String buttonText = loginButton.getText();
			softAssert.assertEquals(buttonText, "LOG IN", "Login button text should be 'LOG IN'.");

			// Step 2: Verify Clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(loginButton));
			softAssert.assertTrue(loginButton.isEnabled(), "Login button should be clickable.");

			// Step 3: Click the button and verify navigation
			loginButton.click();
			Thread.sleep(3000); // Optional: wait for navigation, use explicit wait if possible
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://www.inmotionhosting.com/home"; // Replace with actual expected URL
			softAssert.assertEquals(actualUrl, expectedUrl, "User should be navigated to home page.");

		} catch (Exception e) {
			softAssert.fail("Exception occurred during login test: " + e.getMessage());
		}

		// Step 4: Assert All
		softAssert.assertAll();
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
