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

public class TS_030 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_030");
		System.out.println("Total Test Cases : 09");
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
	public void tc_092() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "About us"
			WebElement managedDedicatedLink = driver
					.findElement(By.xpath("//a[@aria-label=\"About Us\"]"));
			managedDedicatedLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("about-us")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "about"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("we are"),
					"Expected heading to contain 'we are', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	@Ignore
	@Test(priority = 2)
	public void tc_093() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "Data Center"
			WebElement dataCenterLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Data Centers\"]"));
			dataCenterLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("data-centers")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "data"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("data"),
					"Expected heading to contain 'data', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
	
//	@Ignore
	@Test(priority = 3)
	public void tc_094() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "premier-support"
			WebElement premiersupportLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Premier Support\"]"));
			premiersupportLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("premier-support")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "premier"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("premier"),
					"Expected heading to contain 'premier', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	@Ignore
	@Test(priority = 4)
	public void tc_095() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "In-MotionSolution"
			WebElement premiersupportLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Solutions\"]"));
			premiersupportLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("solution")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "solution"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("inmotion"),
					"Expected heading to contain 'inmotion', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	@Ignore
	@Test(priority = 5)
	public void tc_096() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "In-MotionSolution"
			WebElement managedHostingLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Managed Hosting\"]"));
			managedHostingLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("managed-hosting")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "managed"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("managed"),
					"Expected heading to contain 'managed', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
	
//	@Ignore
	@Test(priority = 6)
	public void tc_097() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "In-MotionSolution"
			WebElement hostingAffiliateLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Hosting Affiliate Program\"]"));
			hostingAffiliateLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("affiliates")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "affiliates"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("affiliate"),
					"Expected heading to contain 'affiliate', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
//	@Ignore
	@Test(priority = 7)
	public void tc_098() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "ContactUs"
			WebElement contactUsLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Contact Us\"]"));
			contactUsLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("contact")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "contact"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h1")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("contact"),
					"Expected heading to contain 'contact', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
	}
	
//	@Ignore
	@Test(priority = 8)
	public void tc_099() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "Resource"
			WebElement resourceLink = driver
					.findElement(By.xpath("//a[@aria-label=\"Resources\"]"));
			resourceLink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("resources")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "resources"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

			// (Optional) Validate page title or heading
			WebElement heading = driver.findElement(By.tagName("h2")); // Adjust if needed
			softAssert.assertTrue(heading.getText().toLowerCase().contains("amacor"),
					"Expected heading to contain 'Amacor', but got: " + heading.getText());

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
		
	}
	
//	@Ignore
	@Test(priority = 9)
	public void tc_100() {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Hover over "Company" tab
			Actions actions = new Actions(driver);
			WebElement companyTab = driver.findElement(By.xpath("//a[@aria-label=\"Company\"]"));
			actions.moveToElement(companyTab).perform();

			// Click "Blog"
			WebElement bloglink = driver
					.findElement(By.xpath("//a[@aria-label=\"Blog\"]"));
			bloglink.click();

			// Wait for redirection
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains("blog/")); // Update keyword as needed

			// Validate URL
			String actualUrl = driver.getCurrentUrl();
			String expectedUrlFragment = "blog"; // Replace or extend as necessary
			softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
					"Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);


		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}

		// Report all soft assertion results
		softAssert.assertAll();
		//a[@aria-label="Blog"]
	}


	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
