package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_011 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_011");
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
	@Test
	public void tc_030() {
		SoftAssert softAssert = new SoftAssert();
		try {
			WebElement logo = driver
					.findElement(By.xpath("//img[@class=\"lazy loaded\" and @alt=\"InMotion Hosting Logo\" ]"));
			boolean isDisplayed = logo.isDisplayed();
			softAssert.assertTrue(isDisplayed, "Logo should be displayed on the homepage.");
		} catch (Exception e) {
			softAssert.fail("Exception occurred while checking the logo: " + e.getMessage());
		}
		softAssert.assertAll(); // Report all soft assertion results
	}
//	@Ignore
	@Test
	public void tc_031() {
		SoftAssert softAssert = new SoftAssert();
		try {
			WebElement logo = driver
					.findElement(By.xpath("//img[@class=\"lazy loaded\" and @alt=\"InMotion Hosting Logo\" ]"));

			softAssert.assertTrue(logo.isDisplayed(), "Logo should be displayed.");
			softAssert.assertTrue(logo.getRect().getWidth() > 0 && logo.getRect().getHeight() > 0,
					"Logo should have non-zero size.");
			softAssert.assertEquals(logo.getCssValue("visibility"), "visible", "Logo should be visible via CSS.");
			softAssert.assertNotEquals(logo.getCssValue("display"), "none", "Logo should not be hidden via CSS.");

		} catch (NoSuchElementException e) {
			softAssert.fail("Logo element not found: " + e.getMessage());
		} catch (Exception e) {
			softAssert.fail("Unexpected exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}
//	@Ignore
	@Test
	public void tc_032() {
		SoftAssert softAssert = new SoftAssert();
		String[] pages = { "https://www.inmotionhosting.com/home", "https://www.inmotionhosting.com/about-us", "https://www.inmotionhosting.com/contact",
				"https://www.inmotionhosting.com/press" };

		for (String page : pages) {
			try {
				driver.get(page);
				WebElement logo = driver.findElement(By.xpath("//img[@class=\"lazy loaded\" and @alt=\"InMotion Hosting Logo\" ]"));
				softAssert.assertTrue(logo.isDisplayed(), "Logo is not displayed on: " + page);
			} catch (Exception e) {
				softAssert.fail("Error checking logo on " + page + ": " + e.getMessage());
			}
			softAssert.assertAll();
		}
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
