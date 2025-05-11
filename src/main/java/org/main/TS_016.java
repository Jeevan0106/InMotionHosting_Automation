package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_016 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_016");
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
    public void tc_045() {
    	SoftAssert softAssert = new SoftAssert();
        try {

           // Click on the Chat Now link/button
            WebElement chatNowBtn = driver.findElement(By.xpath("//a[@title=\"Chat Now\"]"));
            chatNowBtn.click();

            // Wait and verify the next page or element
            Thread.sleep(3000); // Use WebDriverWait in real tests

            // Validate presence of "Chat With Us" or URL change
            String pageSource = driver.getPageSource();
            softAssert.assertTrue(pageSource.contains("Chat With us") || pageSource.contains("Chat With Us"),
                    "Chat With Us text is not displayed on the page.");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            softAssert.assertAll();
        }
    }
    @Test(priority = 2)
    public void tc_046() {
    	SoftAssert softAssert = new SoftAssert();
        try {

            //Locate the Chat Now link/button
            WebElement chatNowLink = driver.findElement(By.xpath("//a[@title=\"Chat Now\"]"));

            //Check if it's displayed and enabled (clickable)
            boolean isDisplayed = chatNowLink.isDisplayed();
            boolean isEnabled = chatNowLink.isEnabled();

            //Perform soft assertions
            softAssert.assertTrue(isDisplayed, "Chat Now link is not displayed.");
            softAssert.assertTrue(isEnabled, "Chat Now link is not enabled/clickable.");

            //Attempt to click
            if (isDisplayed && isEnabled) {
                chatNowLink.click();
            }

        } catch (Exception e) {
            System.out.println("Exception during click test: " + e.getMessage());
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        } finally {

            softAssert.assertAll();
        }
    }
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
