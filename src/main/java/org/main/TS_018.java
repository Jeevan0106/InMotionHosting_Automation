package org.main;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_018 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_018");
		System.out.println("Total Test Cases : 02");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
	}

//	@Ignore
	@Test(priority=1)
	public void tc_050() {
		SoftAssert softAssert = new SoftAssert();
		try {

			// Locate the "Call Us" dropdown toggle
			WebElement callUsButton = driver.findElement(By.xpath("//a[@id=\"phoneDropDown\"]"));
			softAssert.assertTrue(callUsButton.isDisplayed(), "Call Us button is not visible.");
			softAssert.assertTrue(callUsButton.isEnabled(), "Call Us button is not clickable.");

			// Click to expand dropdown
			callUsButton.click();

			// Wait for dropdown options to load (replace with WebDriverWait if needed)
			Thread.sleep(2000);

			// Locate dropdown options (phone numbers)
			List<WebElement> phoneOptions = driver
					.findElements(By.xpath("//div[@class=\"dropdown-menu phone-numbers-submenu show\"]"));

			// Assert dropdown options are visible
			softAssert.assertTrue(phoneOptions.size() > 0, "No phone options are displayed in the dropdown.");
			for (WebElement option : phoneOptions) {
				softAssert.assertTrue(option.isDisplayed(), "A phone option is not visible: " + option.getText());
			}

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}

//	@Ignore
	@Test(priority=2)
	public void tc_051() {
		SoftAssert softAssert = new SoftAssert();
		try {

			// Step 1: Click on Call Us dropdown
			WebElement callUsButton = driver.findElement(By.xpath("//a[@id=\"phoneDropDown\"]"));
			callUsButton.click();

			Thread.sleep(2000); // Replace with WebDriverWait for production

			// Step 2: Get all dropdown options (phone numbers)
			List<WebElement> phoneOptions = driver
					.findElements(By.xpath("//div[@class=\"dropdown-menu phone-numbers-submenu show\"]"));

			softAssert.assertTrue(phoneOptions.size() > 0, "No phone options found in dropdown.");

			// Step 3: Click the first option (simulate user clicking a phone number)
			WebElement firstOption = phoneOptions.get(0);
			firstOption.click();

		} catch (NoAlertPresentException e) {
			softAssert.fail("Expected alert was not displayed after clicking phone option.");
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			softAssert.assertAll();
		}
	}
	@Ignore
	@Test(priority=3)
	
	public void testCallUsDropdownOptions() {
		SoftAssert softAssert = new SoftAssert();
	    try {
	        WebElement callUsButton = driver.findElement(By.xpath("//a[@id='phoneDropDown']"));
	        callUsButton.click();

	        List<WebElement> phoneOptions = driver.findElements(By.xpath("//div[@class=\"dropdown-menu phone-numbers-submenu show\"]"));

	        // Log what was found
	        System.out.println("Found options:");
	        for (WebElement option : phoneOptions) {
	            System.out.println("- " + option.getText().trim());
	        }

	        // Expected values
	        String[] expectedOrder = {"+1 757 416 6575", "+44 2045 763722"};
	        System.out.println(expectedOrder);

	        // Assert size match FIRST before accessing indices
	        softAssert.assertEquals(phoneOptions.size(), expectedOrder.length, "Mismatch in number of dropdown options.");

	        // Compare values only if sizes match
	        if (phoneOptions.size() == expectedOrder.length) {
	            for (int i = 0; i < expectedOrder.length; i++) {
	                String actual = phoneOptions.get(i).getText().trim();
	                softAssert.assertEquals(actual, expectedOrder[i], "Mismatch at index " + i);
	            }
	        }

	        // Optional: verify clickability
	        for (WebElement option : phoneOptions) {
	        	
	            try {
	                option.click();
	                softAssert.assertTrue(true, "Clickable: " + option.getText());
	                callUsButton.click(); // reopen dropdown if needed
	            } catch (Exception e) {
	                softAssert.fail("Not clickable: " + option.getText());
	            }
	        }

	    } catch (Exception e) {
	        softAssert.fail("Test failed due to exception: " + e.getMessage());
	    }

	    softAssert.assertAll();
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
