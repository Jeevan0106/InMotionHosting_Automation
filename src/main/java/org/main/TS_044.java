package org.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_044 extends BaseClass {
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_044");
		System.out.println("Total Test Cases : 03");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
		WebElement scrolling = driver.findElement(By.xpath("//h2[text()=\"Your Global Partner in Business\"]"));
		scroll(scrolling);
	}

//	@Ignore
	@Test
	public void tc_140() {
		String[][] centers = {
				{ "Los Angeles", "(//a[text()='Learn More'])[1]",
						"https://www.inmotionhosting.com/about-us/data-centers/los-angeles-california" },
				{ "Ashburn", "(//a[text()='Learn More'])[2]",
						"https://www.inmotionhosting.com/about-us/data-centers/ashburn-virginia" },
				{ "Amsterdam", "(//a[text()='Learn More'])[3]",
						"https://www.inmotionhosting.com/about-us/data-centers/amsterdam-netherlands" } };

		for (String[] center : centers) {
			String name = center[0];
			String xpath = center[1];
			String expectedUrl = center[2];

			try {
				WebElement learnMoreButton = driver.findElement(By.xpath(xpath));
				learnMoreButton.click();

				Thread.sleep(2000); // Consider WebDriverWait in real tests

				String currentUrl = driver.getCurrentUrl();
				softAssert.assertTrue(currentUrl.contains(expectedUrl), name + " redirect failed. URL: " + currentUrl);

				driver.navigate().back();
				Thread.sleep(1000);
			} catch (Exception e) {
				softAssert.fail(name + " test failed due to exception: " + e.getMessage());
			}
		}

		softAssert.assertAll();
	}

//	@Ignore
	@Test
	public void tc_141() {
		String[] xpaths = { "(//a[text()='Learn More'])[1]", "(//a[text()='Learn More'])[2]",
				"(//a[text()='Learn More'])[3]" };

		Actions actions = new Actions(driver);

		for (int i = 0; i < xpaths.length; i++) {
			try {
				WebElement button = driver.findElement(By.xpath(xpaths[i]));
				String bgColorBefore = button.getCssValue("background-color");

				actions.moveToElement(button).perform();
				Thread.sleep(1000); // Optional: wait for hover effect

				String bgColorAfter = button.getCssValue("background-color");

				softAssert.assertNotEquals(bgColorBefore, bgColorAfter,
						"Hover effect not applied for button " + (i + 1));

			} catch (Exception e) {
				softAssert.fail("Hover test failed for button " + (i + 1) + " due to: " + e.getMessage());
			}
		}

		softAssert.assertAll();
	} 
//	 @Ignore
	 @Test
	    public void tc_142() {
	        String[][] images = {
	            {"Los Angeles", "(//img[@class=\"alignnone size-medium wp-image-11992 lazy loaded\"])", "https://www.inmotionhosting.com/about-us/data-centers/los-angeles-california"},
	            {"Ashburn", "(//img[@class=\"alignnone size-medium wp-image-11979 lazy loaded\"])", "https://www.inmotionhosting.com/about-us/data-centers/ashburn-virginia"},
	            {"Amsterdam", "(//img[@class=\"alignnone size-medium wp-image-10871 lazy loaded\"])", "https://www.inmotionhosting.com/about-us/data-centers/amsterdam-netherlands"}
	        };

	        for (String[] image : images) {
	            String name = image[0];
	            String xpath = image[1];
	            String expectedUrl = image[2];

	            try {
	                WebElement img = driver.findElement(By.xpath(xpath));
	                img.click();

	                Thread.sleep(2000); // Wait for redirect

	                String currentUrl = driver.getCurrentUrl();
	                softAssert.assertTrue(currentUrl.contains(expectedUrl),
	                    name + " image click did not redirect properly. Got: " + currentUrl);

	                driver.navigate().back();
	                Thread.sleep(1000);
	            } catch (Exception e) {
	                softAssert.fail(name + " image click failed due to exception: " + e.getMessage());
	            }
	        }

	        softAssert.assertAll();
	    }

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
