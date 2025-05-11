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

public class TS_046 extends BaseClass {
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_046");
		System.out.println("Total Test Cases : 03");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement scrolling = driver.findElement(By.xpath("//h2[@class=\"component-title\" and text()=\"At InMotion Hosting, we understand what it’s like to start small and scale up. We have designed our website hosting services to help you do the same.\"]"));
		scroll(scrolling);
	}
//	@Ignore
    @Test
    public void tc_145() {
        try {
            WebElement chatButton = driver.findElement(By.xpath("//a[@aria-label=\"Chat with us 1\"]"));
            String actualText = chatButton.getText().trim();
            String expectedText = "Chat With Us";
            
            System.out.println("Actual Button Text: " + actualText);
            softAssert.assertEquals(actualText, expectedText, "Chat button text does not match!");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            softAssert.fail("Exception occurred while verifying the chat button");
        } finally {
            softAssert.assertAll(); // Required to trigger all assertions
        }
    }
//	 @Ignore
	 @Test
	 public void tc_146() {
	        try {
	            WebElement chatButton = driver.findElement(By.xpath("//a[@aria-label=\"Chat with us 1\"]"));
	            chatButton.click();

	            // Add a wait to allow page navigation (replace with explicit wait if needed)
	            Thread.sleep(5000);

	            // Example: Verify URL or heading or any element on the "Chat With Us" page
	            String currentUrl = driver.getCurrentUrl();
	            String expectedUrlSubstring = "inmotionhosting"; // Adjust to actual expected pattern in URL
	            softAssert.assertTrue(currentUrl.contains(expectedUrlSubstring),
	                    "URL did not navigate to Chat With Us page. Current URL: " + currentUrl);

	            // Example: Verify if page contains specific heading
	            WebElement pageHeading = driver.findElement(By.tagName("h1")); // Adjust selector
	            String actualHeading = pageHeading.getText().trim();
	            String expectedHeading = "WEB HOSTING & ENTERPRISE SERVER SOLUTIONS"; // Adjust based on actual page text
	            softAssert.assertEquals(actualHeading, expectedHeading,
	                    "Page heading does not match after navigation.");

	        } catch (Exception e) {
	            System.out.println("Exception during test: " + e.getMessage());
	            softAssert.fail("Exception occurred: " + e.getMessage());
	        } finally {
	            softAssert.assertAll();
	        }
	    }
	 
	 
	    @Test
	    public void tc_147() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement chatButton = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//a[@aria-label=\"Chat with us 1\"]")
	            ));

	            boolean isDisplayed = chatButton.isDisplayed();
	            boolean isEnabled = chatButton.isEnabled();

	            softAssert.assertTrue(isDisplayed, "Chat button is not displayed.");
	            softAssert.assertTrue(isEnabled, "Chat button is not enabled (clickable).");

	            // Attempt a click (optional for confirmation)
	            chatButton.click();

	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            softAssert.fail("Exception while verifying button clickability: " + e.getMessage());
	        } finally {
	            softAssert.assertAll();
	        }
	    }
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
