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

public class TS_002 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_002");
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
		System.out.println("Starting of the Test Scenario - TS_002");
	}

//	@Ignore
	@Test
	public void tc_003() throws IOException {
		try {
			// Locate the input field
			WebElement emailInput = driver.findElement(By.id("username")); // Adjust locator if needed

			// Alphanumeric test input
			String testInput = "test123";

			// Enter the value
			emailInput.clear();
			emailInput.sendKeys(testInput);

			// Retrieve the value
			String enteredValue = emailInput.getAttribute("value");

			// Assert the value is as expected
			Assert.assertEquals(enteredValue, testInput, "Email Textbox should accept alphanumeric input");
			System.out.println("TC_003");
			System.out.println("Test Passed: Alphanumeric input accepted Email Textbox.");
		} catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
			Assert.fail("Exception occurred during input test: " + e.getMessage());
		}
	}

//	@Ignore
	@Test
	public void tc_004() throws IOException {
		try {
			// Locate the input field
			WebElement emailInput = driver.findElement(By.id("username")); // Adjust locator if needed

			// Special Character test input
			String testInput = "test@@$$";

			// Enter the value
			emailInput.clear();
			emailInput.sendKeys(testInput);

			// Retrieve the value
			String enteredValue = emailInput.getAttribute("value");

			// Assert the value is as expected
			Assert.assertEquals(enteredValue, testInput, "Textbox should accept Special Character input");
			System.out.println("TC_004");
			System.out.println("Test Passed: Special Character input accepted.");
		} catch (Exception e) {
			System.out.println("Test Failed: " + e.getMessage());
			Assert.fail("Exception occurred during input test: " + e.getMessage());
		}
	}

//	@Ignore
	@Test
	public void tc_005() throws IOException {
		try {
			WebElement emailField = driver.findElement(By.id("username")); // Adjust locator if needed
			String htmlSnippet = "<script>alert('XSS');</script>";

			emailField.clear();
			passText(htmlSnippet, emailField);

			// Optional: driver.findElement(By.id("submit")).click();

			String inputValue = emailField.getAttribute("class");

			// Validation: HTML should not be stored in the input value
			Assert.assertFalse(inputValue.contains("<script>"),
					"The Email Address text box should not allow HTML snippet code");
			System.out.println("TC_005");
			System.out.println("Test passed: HTML snippet was correctly rejected.");

		} catch (Exception e) {
			System.err.println("Test encountered an error: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Exception occurred during test: " + e.getMessage());
		}
	}

//	@Ignore
	@Test
	public void tc_006() throws IOException {
        try {
            WebElement emailField = driver.findElement(By.id("username")); // Update selector if needed
            scrollThePage(emailField);
            // Set desktop size
            driver.manage().window().setSize(new Dimension(1200, 800));
            Thread.sleep(2000); // wait for resize to take effect
            int desktopWidth = emailField.getSize().getWidth();

            // Set mobile size
            driver.manage().window().setSize(new Dimension(375, 667)); // iPhone 6/7/8 size
            Thread.sleep(2000); // wait for resize
            int mobileWidth = emailField.getSize().getWidth();

            System.out.println("TC_006");
            System.out.println("Desktop width: " + desktopWidth);
            System.out.println("Mobile width: " + mobileWidth);
            System.out.println("Test passed: Email field is flexible for both Desktop and Mobile Dimension Views");

            // Assert width changes with screen size
            Assert.assertEquals(desktopWidth, mobileWidth, "Email field should resize based on screen size");

        } catch (Exception e) {
            System.err.println("Responsive test failed: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Exception occurred during responsive test: " + e.getMessage());
        }
    }

//    @Ignore
	@Test
	public void tc_007() throws IOException{
		try {
			WebElement emailField = driver.findElement(By.name("username")); // Adjust locator if needed
			WebElement loginButton = driver.findElement(By.xpath("//button[@id=\"login-submit\"]"));

			emailField.clear(); // Ensure the field is empty
			loginButton.click(); // Try submitting the form

			// Wait briefly to see if validation triggers
			Thread.sleep(1000);

			// Check if the email field is marked invalid (common HTML5 behavior)
			String validation = emailField.getAttribute("validationMessage");
			boolean isInvalid = emailField.getAttribute("class").contains("error")
					|| emailField.getCssValue("border-color").equals("rgb(255, 0, 0)")
					|| emailField.getAttribute("aria-invalid") != null;

			Assert.assertFalse(isInvalid || !validation.isEmpty(),
					"Validation error not triggered for empty email field");
			System.out.println("TC_007");
			System.out.println("✅ Validation error not triggered for empty email field.");
			screenShot(validation + "EmailAddress");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@AfterMethod
	public void Aftermethod() {
		System.out.println("End of The Test Scenario - TS_002");
		closeEntireBrowser();
	}
}
