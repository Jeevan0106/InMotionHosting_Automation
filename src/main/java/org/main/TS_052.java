package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_052 extends BaseClass {
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_052");
		System.out.println("Total Test Cases : 01");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement scrolling = driver.findElement(By.xpath("//p[@class=\"imh-footer-description\"]"));
		scroll(scrolling);
	}
	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
    @Test
    public void tc_171() {

        String[][] linksToTest = {
                {"Shared Hosting", "https://www.inmotionhosting.com/shared-hosting"},
                {"Hosting for WordPress", "https://www.inmotionhosting.com/wordpress-hosting"},
                {"Contact Us", "https://www.inmotionhosting.com/contact"}
        };

        for (String[] link : linksToTest) {
            try {
                WebElement footerLink = driver.findElement(By.linkText(link[0]));
                footerLink.click();
                Thread.sleep(2000); // Replace with WebDriverWait in production

                String actualURL = driver.getCurrentUrl();
                softAssert.assertTrue(actualURL.contains(link[1]), "Redirection failed for: " + link[0]);

                driver.navigate().back();
                Thread.sleep(2000);

            } catch (Exception e) {
                softAssert.fail("Exception on link: " + link[0] + " - " + e.getMessage());
            }
            softAssert.assertAll();
        }
    }
}
