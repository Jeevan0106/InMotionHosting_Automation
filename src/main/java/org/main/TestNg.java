package org.main;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNg extends BaseClass {

	@Test(invocationCount = 3,priority=-1)
	private void tc001() {
		System.out.println("Testcase 001");

	}


	@Test()
	private void tc009() {
		System.out.println("Testcase 009");

	}

	@Test(priority=-2)
	private void tc005() {
		System.out.println("Testcase 005");

	}

	@BeforeMethod
	private void startDate() {
		System.out.println("Start Date of Test Case");

	}

	@AfterMethod
	private void endDate() {
		System.out.println("End Date of Test Case");

	}
}
