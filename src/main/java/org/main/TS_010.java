package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_010 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_010");
		System.out.println("Total Test Cases : 02");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement LoginBtn = driver.findElement(By.xpath("//a[@class=\"nav-link btn-secondary-alt btn-login\"]"));
		clickBtn(LoginBtn);

	}
//    @Ignore
	@Test
	public void tc_028() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Locate and click the "I don't remember my password" link
			WebElement needhelpLink = driver.findElement(By.linkText("Need help logging in?"));
			scrollThePage(needhelpLink);
			needhelpLink.click();

			// Wait for navigation (better to use WebDriverWait in real test cases)
			Thread.sleep(5000);
			setImplicitWait(driver, 30);
			// Check the current URL
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			softAssert.assertTrue(currentUrl.contains("login"),
					"Navigation to Need help page!");
			Thread.sleep(2000);
			System.out.println("TC_028");
			System.out.println("TC_028 is Passed");

		} catch (Exception e) {
			e.printStackTrace();
			softAssert.fail("Exception occurred during test execution: " + e.getMessage());
		}

		softAssert.assertAll(); // Required to report all soft assertion results
	}

//	@Ignore
	@Test
	public void tc_029() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		try {
			WebElement needhelpLink = driver.findElement(By.linkText("Need help logging in?"));

			softAssert.assertTrue(needhelpLink.isDisplayed(), "Link is not visible.");
			softAssert.assertTrue(needhelpLink.isEnabled(), "Link is not clickable.");
			scrollThePage(needhelpLink);
			needhelpLink.click();

			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			softAssert.assertTrue(currentUrl.contains("login"), "Navigation to needhelpLink page failed.");
		} catch (Exception e) {
			e.printStackTrace();
			softAssert.fail("Exception occurred during test execution: " + e.getMessage());
		}

		softAssert.assertAll();
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
