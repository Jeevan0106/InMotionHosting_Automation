package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_012 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_012");
		System.out.println("Total Test Cases : 02");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
	}
//	  @Ignore
	  @Test
	    public void tc_033() {
		  SoftAssert softAssert = new SoftAssert();
	        try {
	            String expectedHomeUrl = "https://www.inmotionhosting.com/"; 
	            driver.get("https://www.inmotionhosting.com/contact");

	            WebElement logo = driver.findElement(By.xpath("//img[@class=\"lazy loaded\" and @alt=\"InMotion Hosting Logo\" ]"));
	            clickBtn(logo);

	            Thread.sleep(2000); // Wait for redirection; use WebDriverWait in real projects
	            String actualUrl = driver.getCurrentUrl();

	            softAssert.assertTrue(actualUrl.contains(expectedHomeUrl),
	                    "Clicking on logo did not redirect to home page. Actual URL: " + actualUrl);
	        } catch (Exception e) {
	            softAssert.fail("Test failed due to exception: " + e.getMessage());
	        }
	        softAssert.assertAll();
	    }
//	  	@Ignore
	    @Test
	    public void tc_034() {
	    	SoftAssert softAssert = new SoftAssert();
	        try {
	            driver.get("https://www.inmotionhosting.com/"); // Replace with actual URL

	            WebElement logoImage = driver.findElement(By.xpath("//img[@class=\"lazy loaded\" and @alt=\"InMotion Hosting Logo\" ]")); // Adjust src accordingly
	            String altText = logoImage.getAttribute("alt");

	            softAssert.assertNotNull(altText, "Alt text is missing from logo image.");
	            softAssert.assertFalse(altText.trim().isEmpty(), "Alt text is empty.");
	            softAssert.assertTrue(altText.toLowerCase().contains("inmotion"), "Alt text does not seem descriptive: " + altText);

	        } catch (Exception e) {
	            softAssert.fail("Test failed due to exception: " + e.getMessage());
	        }
	        softAssert.assertAll();
	    }
	
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
