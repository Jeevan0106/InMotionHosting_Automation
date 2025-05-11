package org.main;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_050 extends BaseClass {
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_050");
		System.out.println("Total Test Cases : 05");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement scrolling = driver.findElement(By.xpath("//p[@class=\"imh-footer-description\"]"));
		scroll(scrolling);
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}

//	@Ignore
	@Test
	public void tc_160() {
		try {

			// Locate and click on the Facebook icon
			WebElement fbIcon = driver.findElement(By.xpath("//span[@class=\"fa fa-facebook\"]"));
			fbIcon.click();

			// Switch to the new tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://www.facebook.com/inmotionhosting"; // Replace with actual expected URL

			softAssert.assertTrue(currentURL.contains("facebook.com"), "Facebook URL does not contain 'facebook.com'");
			softAssert.assertEquals(currentURL, expectedURL, "Facebook page URL mismatch");

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}

//	@Ignore
	@Test
	public void tc_161() {
		try {

			// Locate and click on the GitHub icon
			WebElement ghIcon = driver.findElement(By.xpath("//span[@class=\"fa fa-github\"]"));
			ghIcon.click();

			// Switch to the new tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://github.com/inmotionhosting"; // Replace with actual expected URL

			softAssert.assertTrue(currentURL.contains("github.com"), "gitHub URL does not contain 'gitHub'");
			softAssert.assertEquals(currentURL, expectedURL, "gitHub page URL mismatch");

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}

//	  @Ignore
	@Test
	public void tc_162() {
		try {

			// Locate and click on the LinkedIn icon
			WebElement liIcon = driver.findElement(By.xpath("//a[@aria-label=\"linkedin\"]"));
			liIcon.click();

			// Switch to the new tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(5000);
			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://www.linkedin.com/company/inmotion-hosting/"; // Replace with actual expected
																						// URL

			softAssert.assertTrue(currentURL.contains("linkedin.com"), "linkedin URL does not contain 'linkedin'");
			softAssert.assertEquals(currentURL, expectedURL, "linkedin page URL mismatch");

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}

//	@Ignore
	@Test
	public void tc_163() {
		try {

			// Locate and click on the TwitterX icon
			WebElement TxIcon = driver.findElement(By.xpath("//span[@class=\"x-twitter\"]"));
			TxIcon.click();

			// Switch to the new tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://x.com/inmotionhosting"; // Replace with actual expected URL

			softAssert.assertTrue(currentURL.contains("x.com"), "TwiterX URL does not contain 'x.com'");
			softAssert.assertEquals(currentURL, expectedURL, "TwiterX  page URL mismatch");

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}

//	@Ignore
	@Test
	public void tc_164() {
		try {

			// Locate and click on the Youtube icon
			WebElement YoutubeIcon = driver.findElement(By.xpath("//span[@class=\"fa fa-youtube-play\"]"));
			YoutubeIcon.click();

			// Switch to the new tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			String currentURL = driver.getCurrentUrl();
			String expectedURL = "https://www.youtube.com/@inmotionhosting"; // Replace with actual expected URL

			softAssert.assertTrue(currentURL.contains("youtube.com"), "youtube URL does not contain 'youtube'");
			softAssert.assertEquals(currentURL, expectedURL, "youtube page URL mismatch");

		} catch (Exception e) {
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}
}
