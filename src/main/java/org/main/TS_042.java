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

public class TS_042 extends BaseClass{
	SoftAssert softAssert = new SoftAssert();
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_042");
		System.out.println("Total Test Cases : 02");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement scrolling = driver.findElement(By.xpath("//h3[@class=\"features-v6-heading\"and text()=\"Managed Hosting for Enterprise-Level Business\" ]"));
        scroll(scrolling);
	}
//	@Ignore
    @Test
    public void tc_133() {
    	
        try {
        	
            WebElement seeManagementServiceButton = driver.findElement(By.xpath("//a[text()=\"See Managed Hosting Services\"]"));
            
            softAssert.assertTrue(seeManagementServiceButton.isDisplayed(), "seeManagementServiceButton is not displayed");
            clickBtn(seeManagementServiceButton);
            Thread.sleep(2000); // Ideally use WebDriverWait instead

            String expectedUrl = "https://www.inmotionhosting.com/managed-hosting"; // Replace with actual page URL
            String actualUrl = driver.getCurrentUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, "Did not navigate to expected Page");

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }
        softAssert.assertAll();
    }
//	@Ignore
  @Test
    public void tc_134() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By seeManagementServiceButtonLocator = By.xpath("//a[text()=\"See Managed Hosting Services\"]"); // Update locator if needed
            
            WebElement seeManagementServiceButton = wait.until(ExpectedConditions.elementToBeClickable(seeManagementServiceButtonLocator));
            softAssert.assertTrue(seeManagementServiceButton.isDisplayed(), "Login button is not displayed");
            softAssert.assertTrue(seeManagementServiceButton.isEnabled(), "Login button is not enabled");
            seeManagementServiceButton.click(); // Optional: Just to confirm no exception on click

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
