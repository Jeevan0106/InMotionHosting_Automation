package org.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_024 extends BaseClass {

	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_024");
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
	public void tc_072() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Locate the "VPS Hosting" link using XPath
			WebElement vpsLink = driver.findElement(By.xpath("//a[@title=\"VPS Hosting\"]"));

			// Extract the visible text
			String actualText = vpsLink.getText().trim();
			String expectedText = "VPS Hosting";

			// Assert that text is present and correct
			softAssert.assertEquals(actualText, expectedText, "VPS Hosting link text mismatch!");

		} catch (Exception e) {
			softAssert.fail("Exception occurred while verifying VPS Hosting link: " + e.getMessage());
		}

		// Final soft assert report
		softAssert.assertAll();
	}

//	 @Ignore
	@Test(priority = 2)
	public void tc_073() {
		SoftAssert softAssert = new SoftAssert();

		try {

			// Click "managed for WordPress"
			WebElement vpnHostingLink = driver.findElement(By.xpath("//a[@title=\"VPS Hosting\"]"));
			clickBtn(vpnHostingLink);

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("vps-hosting")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "vps"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("vps"),
					"Expected heading to contain 'vps', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	   @Ignore
	   @Test(priority = 3)
	    public void tc_074() {
		   SoftAssert softAssert = new SoftAssert();
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	            
	            // Locate the VPS Hosting link using XPath
	            WebElement vpsHostingLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=\"VPS Hosting\"]")));

	            // Assert it's displayed and enabled
	            softAssert.assertTrue(vpsHostingLink.isDisplayed(), "VPS Hosting link is not displayed.");
	            softAssert.assertTrue(vpsHostingLink.isEnabled(), "VPS Hosting link is not enabled/clickable.");

	        } catch (Exception e) {
	            softAssert.fail("Exception while checking if VPS Hosting link is clickable: " + e.getMessage());
	        }

	        softAssert.assertAll();
	    }

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
