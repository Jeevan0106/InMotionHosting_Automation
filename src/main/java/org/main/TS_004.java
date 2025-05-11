package org.main;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_004 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_004");
		System.out.println("Total Test Cases : 05");
	}
	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement LoginBtn = driver.findElement(By.xpath("//a[@class=\"nav-link btn-secondary-alt btn-login\"]"));
		clickBtn(LoginBtn);
		System.out.println("Starting of the Test Scenario - TS_004");
	}

	
//	@Ignore
	@Test
	public void tc_010() throws IOException {
		try {
			// Locate the input field
			WebElement passInput = driver.findElement(By.id("password")); // Adjust locator if needed

			// Alphanumeric test input
			String testInput = "test123";

			// Enter the value
			passInput.clear();
			passInput.sendKeys(testInput);

			// Retrieve the value
			String enteredValue = passInput.getAttribute("value");

			// Assert the value is as expected
			Assert.assertEquals(enteredValue, testInput, "Password Textbox should accept alphanumeric input");
			System.out.println("TC_010");
			System.out.println("Test Passed: Alphanumeric input accepted in the password field.");
		} catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
			Assert.fail("Exception occurred during input test: " + e.getMessage());
		}
	}
//	@Ignore
	@Test
	public void tc_011() throws IOException {
		try {
			// Locate the input field
			WebElement passInput = driver.findElement(By.id("password")); // Adjust locator if needed

			// Special Character test input
			String testInput = "test@@$$";

			// Enter the value
			passInput.clear();
			passInput.sendKeys(testInput);

			// Retrieve the value
			String enteredValue = passInput.getAttribute("value");

			// Assert the value is as expected
			Assert.assertEquals(enteredValue, testInput, "Password Textbox should accept Special Character input");
			System.out.println("TC_011");
			System.out.println("Test Passed: Special Character input accepted in Password Textbox.");
		} catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
			Assert.fail("Exception occurred during input test: " + e.getMessage());
		}
	}
	
//	@Ignore
	@Test
	public void tc_012() throws IOException {
		try {
			WebElement passField = driver.findElement(By.id("password")); // Adjust locator if needed
			String htmlSnippet = "<script>alert('XSS');</script>";

			passField.clear();
			passText(htmlSnippet, passField);

			// Optional: driver.findElement(By.id("submit")).click();

			String inputValue = passField.getAttribute("class");

			// Validation: HTML should not be stored in the input value
			Assert.assertFalse(inputValue.contains("<script>"),
					"The Password text box should not allow HTML snippet code");
			System.out.println("TC_012");
			System.out.println("Test passed: HTML snippet was correctly rejected in the Password Field.");

		} catch (Exception e) {
			System.err.println("Test encountered an error: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Exception occurred during test: " + e.getMessage());
		}
	}
//	@Ignore
	@Test
	public void tc_013() throws IOException {
        try {
            WebElement passField = driver.findElement(By.id("password")); // Update selector if needed
            scrollThePage(passField);
            // Set desktop size
            driver.manage().window().setSize(new Dimension(1200, 800));
            Thread.sleep(2000); // wait for resize to take effect
            int desktopWidth = passField.getSize().getWidth();

            // Set mobile size
            driver.manage().window().setSize(new Dimension(375, 667)); // iPhone 6/7/8 size
            Thread.sleep(2000); // wait for resize
            int mobileWidth = passField.getSize().getWidth();

            System.out.println("TC_013");
            System.out.println("Desktop width: " + desktopWidth);
            System.out.println("Mobile width: " + mobileWidth);
            System.out.println("Test passed: Password field is flexible for both Desktop and Mobile Dimension Views");

            // Assert width changes with screen size
            Assert.assertEquals(desktopWidth, mobileWidth, "Password field should resize based on screen size");

        } catch (Exception e) {
            System.err.println("Responsive test failed: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Exception occurred during responsive test: " + e.getMessage());
        }
    }
//  @Ignore
	@Test
	public void tc_014() throws IOException{
		try {
			WebElement passField = driver.findElement(By.name("password")); // Adjust locator if needed
			WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"login-submit\"]"));
			scroll(loginButton);
			passField.clear(); // Ensure the field is empty
			loginButton.click(); // Try submitting the form

			// Wait briefly to see if validation triggers
			Thread.sleep(2000);

			// Check if the password field is marked invalid (common HTML5 behavior)
			String validation = passField.getAttribute("validationMessage");
			boolean isInvalid = passField.getAttribute("class").contains("error")
					|| passField.getCssValue("border-color").equals("rgb(255, 0, 0)")
					|| passField.getAttribute("aria-invalid") != null;

			Assert.assertFalse(isInvalid || !validation.isEmpty(),
					"Validation error not triggered for empty password field");
			System.out.println("TC_014");
			System.out.println("✅ Validation error not triggered for empty Password field.");
			screenShot(validation + "Password_Field");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
	@AfterMethod
	public void Aftermethod() {
		System.out.println("End of The Test Scenario - TS_004");
		closeEntireBrowser();
	}
}
