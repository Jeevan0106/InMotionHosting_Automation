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

public class TS_022 extends BaseClass{
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_022");
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
    public void tc_067() {
        SoftAssert softAssert = new SoftAssert();

        try {
            // Hover over "WordPress" tab
            Actions actions = new Actions(driver);
            WebElement wordPressTab = driver.findElement(By.xpath("//a[@title=\"WordPress\"]"));
            actions.moveToElement(wordPressTab).perform();

            // Click "Hosting for WordPress"
            WebElement hostingWordPressLink = driver.findElement(By.xpath("//a[@title=\"Hosting for WordPress\"]"));
            hostingWordPressLink.click();

            // Wait for redirection
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("wordpress-hosting"));  // Update keyword as needed

            // Validate URL
            String actualUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "wordpress";  // Replace or extend as necessary
            softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
                    "Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

            // (Optional) Validate page title or heading
            WebElement heading = driver.findElement(By.tagName("h1"));  // Adjust if needed
            softAssert.assertTrue(heading.getText().toLowerCase().contains("wordpress"),
                    "Expected heading to contain 'wordpress', but got: " + heading.getText());

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Report all soft assertion results
        softAssert.assertAll();
    }
//	@Ignore
	@Test(priority=2)
    public void tc_068() {
        SoftAssert softAssert = new SoftAssert();

        try {
            // Hover over "WordPress" tab
            Actions actions = new Actions(driver);
            WebElement wordPressTab = driver.findElement(By.xpath("//a[@title=\"WordPress\"]"));
            actions.moveToElement(wordPressTab).perform();

            // Click "managed for WordPress"
            WebElement managedWordPressLink = driver.findElement(By.xpath("//a[@title=\"Managed Services for WordPress\"]"));
            managedWordPressLink.click();

            // Wait for redirection
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("managed-wordpress"));  // Update keyword as needed

            // Validate URL
            String actualUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "managed";  // Replace or extend as necessary
            softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
                    "Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

            // (Optional) Validate page title or heading
            WebElement heading = driver.findElement(By.tagName("h1"));  // Adjust if needed
            softAssert.assertTrue(heading.getText().toLowerCase().contains("managed"),
                    "Expected heading to contain 'managed', but got: " + heading.getText());

        } catch (Exception e) {
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        }

        // Report all soft assertion results
        softAssert.assertAll();
    }
	
	//@Ignore
	@Test(priority=3)
    public void tc_069() {
        SoftAssert softAssert = new SoftAssert();

        try {
            // Hover over "WordPress" tab
            Actions actions = new Actions(driver);
            WebElement wordPressTab = driver.findElement(By.xpath("//a[@title=\"WordPress\"]"));
            actions.moveToElement(wordPressTab).perform();

            // Click "managed for WordPress"
            WebElement wooCommerceLink = driver.findElement(By.xpath("//a[@title=\"WooCommerce Hosting\"]"));
            wooCommerceLink.click();

            // Wait for redirection
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.urlContains("woocommerce"));  // Update keyword as needed

            // Validate URL
            String actualUrl = driver.getCurrentUrl();
            String expectedUrlFragment = "woocommerce";  // Replace or extend as necessary
            softAssert.assertTrue(actualUrl.contains(expectedUrlFragment),
                    "Expected URL to contain '" + expectedUrlFragment + "', but got: " + actualUrl);

            // (Optional) Validate page title or heading
            WebElement heading = driver.findElement(By.tagName("h1"));  // Adjust if needed
            softAssert.assertTrue(heading.getText().toLowerCase().contains("woocommerce"),
                    "Expected heading to contain 'woocommerce', but got: " + heading.getText());

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
