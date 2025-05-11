package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_009 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_009");
		System.out.println("Total Test Cases : 03");
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
//	@Ignore
	@Test
	public void tc_025() throws InterruptedException {
		
		try {
			// Locate the link by its visible text
			WebElement needHelp = driver.findElement(By.linkText("Need help logging in?"));
			scrollThePage(needHelp);
			
			// Assert that the link is displayed
			Assert.assertTrue(needHelp.isDisplayed(), "Need help for Login? link is not visible on the page");
			System.out.println("TC_025");
			System.out.println("Test Passed: Need help for Login? link is visible.");
		} catch (Exception e) {
			System.out.println("Test Failed: Exception occurred - " + e.getMessage());
			Assert.fail("Need help for Login? link verification failed due to exception.");
		}
	}
	
	
//	@Ignore
    @Test
    public void tc_026()throws InterruptedException {
        try {
            // Locate the link element
            WebElement needHelp = driver.findElement(By.linkText("Need help logging in?"));
            scrollThePage(needHelp);

            // Get the CSS 'color' property value
            String color = needHelp.getCssValue("color");

            // Print out the color for logging
            System.out.println("TC_026");
            System.out.println("Link color: " + color);

            // Optionally convert to Hex (Selenium returns rgb or rgba)
            String expectedColor = "rgba(34, 69, 196, 1)"; // Adjust as per actual color
            Assert.assertEquals(color, expectedColor, "Need help for Login? link color is as expected");
            System.out.println("Need help for Login? link color is as expected");

        } catch (Exception e) {
            System.out.println("Test Failed: Exception occurred - " + e.getMessage());
            Assert.fail("Color verification failed due to exception.");
        }
    }
    
    
    
    
//	@Ignore
    @Test
    public void tc_027()throws InterruptedException {
        try {
            WebElement needHelpLink = driver.findElement(By.linkText("Need help logging in?"));
            scrollThePage(needHelpLink);
            String actualText = needHelpLink.getText();
            String expectedText = "Need help logging in?";
            System.out.println("TC_027");
            System.out.println("Actual Link Text: " + actualText);
            Assert.assertEquals(actualText, expectedText, "Link text does not match expected.");

        } catch (Exception e) {
            System.out.println("Test Failed: Exception occurred - " + e.getMessage());
            Assert.fail("Link text verification failed due to exception.");
        }
    }
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}

}
