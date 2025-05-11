package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_007 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_007");
		System.out.println("Total Test Cases : 03");
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

    //@Ignore
	@Test
	public void tc_020() {

		SoftAssert softAssert = new SoftAssert();

		try {

			// Locate the login button
			WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"login-submit\"]"));

			// Check visibility
			boolean isDisplayed = loginButton.isDisplayed();

			// Soft assert for visibility
			softAssert.assertTrue(isDisplayed, "Login button should be visible on the page.");

		} catch (Exception e) {
			// Catch any exceptions during element interaction
			softAssert.fail("Exception occurred while verifying login button: " + e.getMessage());
		}
		softAssert.assertAll();
	}

    //@Ignore
	@Test
	public void tc_021() {
		SoftAssert softAssert = new SoftAssert();

		try {

			// Locate Email field and Login Button
			WebElement emailInput = driver.findElement(By.name("username")); // Adjust locator as needed
			WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"login-submit\"]"));

			// Get X-coordinates and widths
			int emailX = emailInput.getLocation().getX();
			int buttonX = loginButton.getLocation().getX();

			int emailWidth = emailInput.getSize().getWidth();
			int buttonWidth = loginButton.getSize().getWidth();

			int emailCenter = emailX + emailWidth / 2;
			int buttonCenter = buttonX + buttonWidth / 2;

			// Compare centers within 5 pixels
			int tolerance = 5;
			softAssert.assertTrue(Math.abs(emailCenter - buttonCenter) <= tolerance,
					"Login button should be horizontally aligned with the email field.");

		} catch (Exception e) {
			softAssert.fail("Exception during login button alignment check: " + e.getMessage());
		}
		softAssert.assertAll();
	}
	//@Ignore
	 @Test
	    public void tc_022() {
	        SoftAssert softAssert = new SoftAssert();

	        try {

	            // Locate the Login button
	            WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"login-submit\"]"));

	            // Get the button text
	            String buttonText = loginButton.getText().trim();

	            // Assert the button text is not empty
	            softAssert.assertFalse(buttonText.isEmpty(), "Login button should have text.");

	            // Optionally, check exact text
	            softAssert.assertEquals(buttonText, "LOG IN", "Login button text should be 'LOG IN'.");

	        } catch (Exception e) {
	            softAssert.fail("Exception while checking login button text: " + e.getMessage());
	        }
	        softAssert.assertAll();
	 }

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
