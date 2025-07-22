package pages;


import org.openqa.selenium.WebDriver;

import common.TestBase;

public class Page {
	public WebDriver webDriver;
	public TestBase  testBase = new TestBase();

	public Page(WebDriver dr) {
		testBase.driver = dr;
		this.webDriver = testBase.driver;
		
		
		}
	
	
}
