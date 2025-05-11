package org.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_020 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_020");
		System.out.println("Total Test Cases : 03");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
	}
//	@Ignore
    @Test(priority=1)
    public void tc_059() {
        SoftAssert softAssert = new SoftAssert();

        try {
            // Hover over "Web Hosting" tab
            Actions actions = new Actions(driver);
            WebElement webHostingTab = driver.findElement(By.xpath("//a[@title=\"Web Hosting\"]"));
            actions.moveToElement(webHostingTab).perform();

            // Click "Shared Hosting"
            WebElement sharedHostingLink = driver.findElement(By.xpath("//a[@title=\"Shared Hosting\"]"));
            sharedHostingLink.click();

            // Wait for redirection
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("shared-hosting"));  // Update keyword as needed

            // Validate URL
            String actualUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "shared";  // Replace or extend as necessary
            softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
                    "Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

            // (Optional) Validate page title or heading
            WebElement heading = driver.findElement(By.tagName("h1"));  // Adjust if needed
            softAssert.assertTrue(heading.getText().toLowerCase().contains("shared"),
                    "Expected heading to contain 'shared', but got: " + heading.getText());

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Report all soft assertion results
        softAssert.assertAll();
    }
//	@Ignore
    @Test(priority=2)
    public void tc_060() {
        SoftAssert softAssert = new SoftAssert();

        try {
            // Hover over "Web Hosting" tab
            Actions actions = new Actions(driver);
            WebElement webHostingTab = driver.findElement(By.xpath("//a[@title=\"Web Hosting\"]"));
            actions.moveToElement(webHostingTab).perform();

            // Click "Reseller Hosting"
            WebElement resellerHostingLink = driver.findElement(By.xpath("//a[@title=\"Reseller Hosting\"]"));
            resellerHostingLink.click();

            // Wait for redirection
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("reseller-hosting"));  // Update keyword as needed

            // Validate URL
            String actualUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "reseller";  // Replace or extend as necessary
            softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
                    "Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

            // (Optional) Validate page title or heading
            WebElement heading = driver.findElement(By.tagName("h1"));  // Adjust if needed
            softAssert.assertTrue(heading.getText().toLowerCase().contains("reseller"),
                    "Expected heading to contain 'reseller', but got: " + heading.getText());

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Report all soft assertion results
        softAssert.assertAll();
    }
//	@Ignore
    @Test(priority=3)
    public void tc_061() {
        SoftAssert softAssert = new SoftAssert();

        try {
            // Hover over "Web Hosting" tab
            Actions actions = new Actions(driver);
            WebElement webHostingTab = driver.findElement(By.xpath("//a[@title=\"Web Hosting\"]"));
            actions.moveToElement(webHostingTab).perform();

            // Click "All Web Hosting plans"
            WebElement allWebHostingPlans = driver.findElement(By.xpath("//a[@title=\"All Web Hosting Plans\"]"));
            allWebHostingPlans.click();

            // Wait for redirection
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("web-hosting"));  // Update keyword as needed

            // Validate URL
            String actualUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "web";  // Replace or extend as necessary
            softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
                    "Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

            // (Optional) Validate page title or heading
            WebElement heading = driver.findElement(By.tagName("h1"));  // Adjust if needed
            softAssert.assertTrue(heading.getText().toLowerCase().contains("web"),
                    "Expected heading to contain 'web', but got: " + heading.getText());

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Report all soft assertion results
        softAssert.assertAll();
    }

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
