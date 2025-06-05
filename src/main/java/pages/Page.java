package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.TestBase;

public class Page {
	public WebDriver webDriver;
	public WebDriverWait wait;
	public TestBase  testBase = new TestBase();

	public Page(WebDriver dr) {
		testBase.driver = dr;
		this.webDriver = testBase.driver;
		this.wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		
		
		}
	
	
}
