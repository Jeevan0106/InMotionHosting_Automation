package org.main;


import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
public class TS_001 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_001");
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
		System.out.println("Starting of the Test Scenario - TS_001");
	}

//	@Ignore
	@Test
	public void tc_001() throws IOException {
		System.out.println("TC_001 ");
		try {
			WebElement emailInput = driver.findElement(By.id("username")); // Adjust locator
			Assert.assertTrue(emailInput.isDisplayed(), "Email address field is not visible");
			System.out.println("TC_001");
			System.out.println("Test Passed: Email address field is visible.");
		} catch (Exception e) {
			System.out.println("Test Failed: Exception occurred - " + e.getMessage());
			Assert.fail("Exception occurred during test: " + e.getMessage()); // Fails the test
		}
	}

//	@Ignore
	@Test
	public void tc_002() throws IOException {
		try {
			// Locate the input field
			WebElement emailField = driver.findElement(By.id("username")); // Adjust locator if needed

			// Check if it is horizontally centered (example logic)
			int fieldX = emailField.getLocation().getX();
			int fieldWidth = emailField.getSize().getWidth();
			int windowWidth = driver.manage().window().getSize().getWidth();

			int fieldCenter = fieldX + fieldWidth / 2;
			int windowCenter = windowWidth / 2;

			int tolerance = 50; // pixels of tolerance for minor variations
			System.out.println("TC_002");
			System.out.println("Field Center: " + fieldCenter + ", Window Center: " + windowCenter);

			Assert.assertTrue(Math.abs(fieldCenter - windowCenter) <= tolerance,
					"Email field is not horizontally centered within tolerance.");

			System.out.println("Test Passed: Email field is centered horizontally.");

		} catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
			Assert.fail("Exception occurred during test: " + e.getMessage()); // Correct TestNG failure
		}
	}

	
	@AfterMethod
	public void Aftermethod() {
		System.out.println("End of The Test Scenario - TS_001");
		closeEntireBrowser();
	}

}
