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

public class TS_040 extends BaseClass{
	SoftAssert softAssert = new SoftAssert();
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_040");
		System.out.println("Total Test Cases : 02");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement scrolling = driver.findElement(By.xpath("//p[text()=\"We Use the Best Web Hosting Servers and Application Software\"]"));
        scroll(scrolling);
	}
//	@Ignore
    @Test
    public void tc_128() {
    	
        try {
        	
            WebElement webhostingPlanButton = driver.findElement(By.xpath("//a[@href='/web-hosting' and normalize-space(text())='Web Hosting Plans']"));
            
            softAssert.assertTrue(webhostingPlanButton.isDisplayed(), "webhostingPlanButton is not displayed");
            clickBtn(webhostingPlanButton);
            Thread.sleep(2000); // Ideally use WebDriverWait instead

            String expectedUrl = "https://www.inmotionhosting.com/web-hosting"; // Replace with actual page URL
            String actualUrl = driver.getCurrentUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, "Did not navigate to expected Page");

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }
        softAssert.assertAll();
    }
//	@Ignore
  @Test
    public void tc_129() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By webhostingPlanButtonLocator = By.xpath("//a[@href='/web-hosting' and normalize-space(text())='Web Hosting Plans']"); // Update locator if needed
            
            WebElement webhostingPlanButton = wait.until(ExpectedConditions.elementToBeClickable(webhostingPlanButtonLocator));
            softAssert.assertTrue(webhostingPlanButton .isDisplayed(), "Login button is not displayed");
            softAssert.assertTrue(webhostingPlanButton .isEnabled(), "Login button is not enabled");
            webhostingPlanButton .click(); // Optional: Just to confirm no exception on click

        } catch (Exception e) {
            softAssert.fail("seeManagementService Button is not clickable or an exception occurred: " + e.getMessage());
        }
        softAssert.assertAll();
    }
	
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
