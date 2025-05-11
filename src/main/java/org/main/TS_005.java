package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TS_005 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Login page");
		System.out.println("Test Scenario no : TS_005");
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
		System.out.println("Starting of the Test Scenario - TS_005");
	}
//	@Ignore
	@Test
	public void tc_015() throws InterruptedException {
		try {
			// Locate the link by its visible text
			WebElement forgetPasswordLink = driver.findElement(By.linkText("I don't remember my password"));
			
			// Assert that the link is displayed
			Assert.assertTrue(forgetPasswordLink.isDisplayed(), "Forget password link is not visible on the page");
			System.out.println("TC_015");
			System.out.println("Test Passed: Forget password link is visible.");
		} catch (Exception e) {
			System.out.println("Test Failed: Exception occurred - " + e.getMessage());
			Assert.fail("Forget password link verification failed due to exception.");
		}
	}
//	@Ignore
    @Test
    public void tc_016()throws InterruptedException {
        try {
            // Locate the link element
            WebElement forgetPasswordLink = driver.findElement(By.linkText("I don't remember my password"));

            // Get the CSS 'color' property value
            String color = forgetPasswordLink.getCssValue("color");

            // Print out the color for logging
            System.out.println("TC_016");
            System.out.println("Link color: " + color);

            // Optionally convert to Hex (Selenium returns rgb or rgba)
            String expectedColor = "rgba(34, 69, 196, 1)"; // Adjust as per actual color
            Assert.assertEquals(color, expectedColor, "Forget password link color is as expected");
            System.out.println("Forget password link color is as expected");

        } catch (Exception e) {
            System.out.println("Test Failed: Exception occurred - " + e.getMessage());
            Assert.fail("Color verification failed due to exception.");
        }
    }
//	@Ignore
    @Test
    public void tc_017()throws InterruptedException {
        try {
            WebElement forgetPasswordLink = driver.findElement(By.linkText("I don't remember my password"));
            String actualText = forgetPasswordLink.getText();
            String expectedText = "I don't remember my password";
            System.out.println("TC_017");
            System.out.println("Actual Link Text: " + actualText);
            Assert.assertEquals(actualText, expectedText, "Link text does not match expected.");

        } catch (Exception e) {
            System.out.println("Test Failed: Exception occurred - " + e.getMessage());
            Assert.fail("Link text verification failed due to exception.");
        }
    }

	@AfterMethod
	public void Aftermethod() {
		System.out.println("End of The Test Scenario - TS_005");
		closeEntireBrowser();
	}

}
