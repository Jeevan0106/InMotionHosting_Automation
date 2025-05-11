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

public class TS_036 extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_036");
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
    public void tc_114() {
    	
        try {
            WebElement getStartedButton = driver.findElement(By.xpath("//a[text()=\"Get Started\"]"));
            WebElement h1 = driver.findElement(By.xpath("//h1[@class=\"hero-small-heading\"]"));
            scroll(h1);
            softAssert.assertTrue(getStartedButton.isDisplayed(), "Getstarted button is not displayed");
            clickBtn(getStartedButton);
          //h1[@class="hero-small-heading"]
            Thread.sleep(2000); // Ideally use WebDriverWait instead

            String expectedUrl = "https://www.inmotionhosting.com/shared-hosting"; // Replace with actual login page URL
            String actualUrl = driver.getCurrentUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, "Did not navigate to expected Login page");

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }
        softAssert.assertAll();
    }
//	@Ignore
  @Test
    public void tc_115() {
        try {
        	WebElement h1 = driver.findElement(By.xpath("//h1[@class=\"hero-small-heading\"]"));
            scroll(h1);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By getStartedBtnLocator = By.xpath("//a[text()=\"Get Started\"]"); // Update locator if needed
            
            WebElement getStartedButton = wait.until(ExpectedConditions.elementToBeClickable(getStartedBtnLocator));
            softAssert.assertTrue(getStartedButton.isDisplayed(), "Login button is not displayed");
            softAssert.assertTrue(getStartedButton.isEnabled(), "Login button is not enabled");
            getStartedButton.click(); // Optional: Just to confirm no exception on click

        } catch (Exception e) {
            softAssert.fail("GetStarted button is not clickable or an exception occurred: " + e.getMessage());
        }
        softAssert.assertAll();
    }
	
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
