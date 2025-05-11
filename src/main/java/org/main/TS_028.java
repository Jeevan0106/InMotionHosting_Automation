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

public class TS_028 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_028");
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
	public void tc_084() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Locate the "Domain" link using XPath
			WebElement dominsLink = driver.findElement(By.xpath("//a[@aria-label=\"Domains\"]"));

			// Extract the visible text
			String actualText = dominsLink.getText().trim();
			String expectedText = "Domains";

			// Assert that text is present and correct
			softAssert.assertEquals(actualText, expectedText, "Domins link text mismatch!");

		} catch (Exception e) {
			softAssert.fail("Exception occurred while verifying Domains link: " + e.getMessage());
		}

		// Final soft assert report
		softAssert.assertAll();
	}

//	 @Ignore
	@Test(priority = 2)
	public void tc_085() {
		SoftAssert softAssert = new SoftAssert();

		try {

			// Click "Domains"
			WebElement dominsLink = driver.findElement(By.xpath("//a[@aria-label=\"Domains\"]"));
			clickBtn(dominsLink);

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("domains")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "domains"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("domain"),
					"Expected heading to contain 'DOMAIN NAME SEARCH AND REGISTRATION', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	   @Ignore
	   @Test(priority = 3)
	    public void tc_086() {
		   SoftAssert softAssert = new SoftAssert();
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	            
	            // Locate the Domains link using XPath
	            WebElement dominsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label=\"Domains\"]")));

	            // Assert it's displayed and enabled
	            softAssert.assertTrue(dominsLink.isDisplayed(), "Domains link is not displayed.");
	            softAssert.assertTrue(dominsLink.isEnabled(), "Domains link is not enabled/clickable.");

	        } catch (Exception e) {
	            softAssert.fail("Exception while checking if Domains link is clickable: " + e.getMessage());
	        }

	        softAssert.assertAll();
	    }

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}

