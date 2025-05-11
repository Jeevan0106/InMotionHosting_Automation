package org.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_014 extends BaseClass {
	@BeforeClass
	private void moduleDetails() {
		System.out.println("Project Name : InMotion Hosting");
		System.out.println("Module Name : Home Page");
		System.out.println("Test Scenario no : TS_014");
		System.out.println("Total Test Cases : 03");
	}

	@BeforeMethod
	public void BeforeMethod() {
		launchBrowser();
		windowMaximize();
		setImplicitWait(driver, 30);
		launchUrl("https://www.inmotionhosting.com/");
	}

	// @Ignore
	@Test(priority = 1)

	public void tc_038() {
		SoftAssert softAssert = new SoftAssert();
		try {
			// Locate the language dropdown and click it
			WebElement languageDropdown = driver
					.findElement(By.xpath("//aside[@aria-label=\"Language selected: English\" ]")); // Update XPath
			languageDropdown.click();
			System.out.println("Clicked the language dropdown successfully.");

			// Wait briefly for the options to appear (can replace with explicit wait)
			Thread.sleep(1000);

			// Capture all language options
			List<WebElement> languageOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li/a")); // Update
																											// XPath

			// Expected number of languages (based on your screenshot): 16
			int expectedLanguages = 30;
			int actualLanguages = languageOptions.size();

			// Assert number of options
			softAssert.assertEquals(actualLanguages, expectedLanguages, "Mismatch in number of language options.");

			// Optional: Print out the languages for verification
			for (WebElement option : languageOptions) {
				System.out.println("Language option found: " + option.getText());
			}

		} catch (Exception e) {
			softAssert.fail("Exception occurred during test execution: " + e.getMessage());
		}

		// Assert all soft asserts
		softAssert.assertAll();

	}

	// @Ignore
	@Test(priority = 2)
	public void tc_040() {
		SoftAssert softAssert = new SoftAssert();
		try {
			// Click to open the language dropdown
			WebElement dropdown = driver.findElement(By.cssSelector(".wgcurrent"));
			dropdown.click();

			// Verify the default selected language
			WebElement defaultSelected = driver.findElement(By.cssSelector(".wgcurrent span.wglanguage-name"));
			String defaultLanguage = defaultSelected.getText().trim();
			System.out.println("Default selected language: " + defaultLanguage);
			softAssert.assertEquals(defaultLanguage, "English", "Default selected language mismatch");

			// Get all language options (excluding default if it's not listed)
			List<WebElement> languageOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li/a"));

			// Expected order from your screenshot (adjust if necessary)
			String[] expectedOrder = { "Español", "Nederlands", "Deutsch", "Italiano", "Français", "中文 (简体)", "中文 (繁體)",
					"Türkçe", "Ελληνικά", "हिंदी", "Українська", "Português (Brasil)", "Português", "Polski", "Русский",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };

			// Verify the number of options
			softAssert.assertEquals(languageOptions.size(), expectedOrder.length,
					"Number of language options mismatch");

			// Check the order and text of each option
			for (int i = 0; i < expectedOrder.length; i++) {
				String actualText = languageOptions.get(i).getText().trim();
				System.out.println("Checking option " + i + ": " + actualText);
				softAssert.assertEquals(actualText, expectedOrder[i], "Mismatch at index " + i);
			}

		} catch (Exception e) {
			e.printStackTrace();
			softAssert.fail("Exception during dropdown test: " + e.getMessage());
		}

		softAssert.assertAll();
	}

//Ignore
	@Test(priority = 3)
	public void tc_041() {

		SoftAssert softAssert = new SoftAssert();

		try {

			// Locate and click the language dropdown
			WebElement dropdown = driver.findElement(By.xpath("//span[contains(@class, 'wglanguage-name')]"));
			dropdown.click();

			// Get all language options
			List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			softAssert.assertTrue(options.size() > 0, "Dropdown options should be present");

			// Check if any <input> fields are inside dropdown (should not be editable)
			List<WebElement> inputFields = driver.findElements(By.xpath("//ul[@role='listbox']//input"));
			softAssert.assertTrue(inputFields.isEmpty(), "Dropdown should not be editable");

			// Select first language
			WebElement firstOption = options.get(0);
			firstOption.click();

			// Reopen dropdown
			dropdown = driver.findElement(By.xpath("//span[contains(@class, 'wglanguage-name')]"));
			dropdown.click();

			// Re-fetch options and select second language
			options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			WebElement secondOption = options.get(1);
			secondOption.click();

			// Verify that only one language is selected (no multi-selection)
			dropdown = driver.findElement(By.xpath("//span[contains(@class, 'wglanguage-name')]"));
			String currentText = dropdown.getText();
			softAssert.assertFalse(currentText.contains(","),
					"Only one language should be selected (no multi-selection)");

		} catch (Exception e) {
			e.printStackTrace();
			softAssert.fail("Test failed due to exception: " + e.getMessage());
		}
		softAssert.assertAll();
	}

	@AfterMethod
	public void Aftermethod() {
		closeEntireBrowser();

	}
}
