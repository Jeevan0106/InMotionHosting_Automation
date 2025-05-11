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

public class TS_032 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_032");
		System.out.println("Total Test Cases : 03");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
	}
//	@Ignore
	@Test(priority = 1)
	public void tc_103() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Locate the "SupportCenter" link using XPath
			WebElement dominsLink = driver.findElement(By.xpath("//a[@aria-label=\"Support\"]"));

			// Extract the visible text
			String actualText = dominsLink.getText().trim();
			String expectedText = "Support Center";

			// Assert that text is present and correct
			softAssert.assertEquals(actualText, expectedText, "Support Center text mismatch!");

		} catch (Exception e) {
			softAssert.fail("Exception occurred while verifying Domains link: " + e.getMessage());
		}

		// Final soft assert report
		softAssert.assertAll();
	}

//	 @Ignore
	@Test(priority = 2)
	public void tc_104() {
		SoftAssert softAssert = new SoftAssert();

		try {

			// Click "Support Center"
			WebElement dominsLink = driver.findElement(By.xpath("//a[@aria-label=\"Support\"]"));
			clickBtn(dominsLink);

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("support")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "support"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);
			

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	   @Ignore
	   @Test(priority = 3)
	    public void tc_105() {
		   SoftAssert softAssert = new SoftAssert();
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	            
	            // Locate the supportCenterLink using XPath
	            WebElement supportCenterLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label=\"Support\"]")));

	            // Assert it's displayed and enabled
	            softAssert.assertTrue(supportCenterLink.isDisplayed(), "supportCenterLink is not displayed.");
	            softAssert.assertTrue(supportCenterLink.isEnabled(), "supportCenterLink is not enabled/clickable.");

	        } catch (Exception e) {
	            softAssert.fail("Exception while checking if supportCenterLink is clickable: " + e.getMessage());
	        }

	        softAssert.assertAll();
	    }
	
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
