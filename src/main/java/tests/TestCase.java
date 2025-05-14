package tests;

import org.testng.annotations.BeforeMethod;

import common.TestBase;

public class TestCase {
	public TestBase testBase = new TestBase();

	@BeforeMethod
	public void setUp() {
		testBase.openWeb("https://demoqa.com","chrome");
	}
	
//	@AfterMethod
	public void tearDown() {
		testBase.driver.quit();
	}
	
}
