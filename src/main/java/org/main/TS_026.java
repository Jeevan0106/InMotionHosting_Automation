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

public class TS_026 extends BaseClass {

	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_026");
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
	@Test(priority = 1)
	public void tc_080() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "WordPress" tab
			Actions actions = new Actions(driver);
			WebElement dedicatedServerTab = driver.findElement(By.xpath("//a[@data-text=\"Dedicated Servers\"]"));
			actions.moveToElement(dedicatedServerTab).perform();

			// Click "managedDedicated"
			WebElement managedDedicatedLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Managed Dedicated Servers\"]"));
			managedDedicatedLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("dedicated-servers")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "dedicated"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("dedicated"),
					"Expected heading to contain 'dedicated', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}

//	@Ignore
	@Test(priority = 2)
	public void tc_081() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "WordPress" tab
			Actions actions = new Actions(driver);
			WebElement dedicatedServerTab = driver.findElement(By.xpath("//a[@data-text=\"Dedicated Servers\"]"));
			actions.moveToElement(dedicatedServerTab).perform();

			// Click "managed for WordPress"
			WebElement enterpriseLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Enterprise Hosting Solutions\"]"));
			enterpriseLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("enterprise-hosting-solutions")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "enterprise"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("enterprise"),
					"Expected heading to contain 'enterprise', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
