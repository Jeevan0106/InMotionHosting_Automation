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

public class TS_034 extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_034");
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
    @Test
    public void tc_109() {
    	
        try {
            WebElement loginButton = driver.findElement(By.xpath("//a[@aria-label=\"Login\"]"));
            softAssert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
            loginButton.click();

            Thread.sleep(2000); // Ideally use WebDriverWait instead

            String expectedUrl = "https://secure1.inmotionhosting.com/index/login"; // Replace with actual login page URL
            String actualUrl = driver.getCurrentUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, "Did not navigate to expected Login page");

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }
        softAssert.assertAll();
    }
//		@Ignore
	  @Test
	    public void tc_110() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            By loginBtnLocator = By.xpath("//a[@aria-label=\"Login\"]"); // Update locator if needed

	            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
	            softAssert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
	            softAssert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
	            loginButton.click(); // Optional: Just to confirm no exception on click

	        } catch (Exception e) {
	            softAssert.fail("Login button is not clickable or an exception occurred: " + e.getMessage());
	        }
	        softAssert.assertAll();
	    }
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
