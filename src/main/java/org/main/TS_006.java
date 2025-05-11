package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

public class TS_006 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_006");
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
		System.out.println("Starting of the Test Scenario - TS_006");
	}
	
	@Test
	public void tc_018() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		try {
			// Locate and click the "I don't remember my password" link
			WebElement forgotPasswordLink = driver.findElement(By.linkText("I don't remember my password"));
			forgotPasswordLink.click();

			// Wait for navigation (better to use WebDriverWait in real test cases)
			Thread.sleep(2000);

			// Check the current URL
			String currentUrl = driver.getCurrentUrl();
			softAssert.assertTrue(currentUrl.contains("forgot"), "Navigation to forgot password page!");
			System.out.println("TC_018");
			System.out.println("TC_018 is Passed");

		} catch (Exception e) {
			e.printStackTrace();
			softAssert.fail("Exception occurred during test execution: " + e.getMessage());
		}

		softAssert.assertAll(); // Required to report all soft assertion results
	}

    @Test
    public void tc_019() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();

        try {
            WebElement forgotPasswordLink = driver.findElement(By.linkText("I don't remember my password"));

            softAssert.assertTrue(forgotPasswordLink.isDisplayed(), "Link is not visible.");
            softAssert.assertTrue(forgotPasswordLink.isEnabled(), "Link is not clickable.");

            forgotPasswordLink.click();

            String currentUrl = driver.getCurrentUrl();
            softAssert.assertTrue(currentUrl.contains("forgot"), "Navigation to forgot password page failed.");
        } catch (Exception e) {
            e.printStackTrace();
            softAssert.fail("Exception occurred during test execution: " + e.getMessage());
        }

        softAssert.assertAll();
    }

	@AfterMethod
	public void Aftermethod() {
		System.out.println("End of The Test Scenario - TS_006");
		closeEntireBrowser();

	}
}
