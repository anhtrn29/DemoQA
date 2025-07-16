package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
	public By lblElement = By.xpath("//h5[text()='Elements']");
	public By lblForms =By.xpath("//h5[text()='Forms']");
	

	public HomePage(WebDriver dr) {
		super(dr);
	}

	public ElementsPage clickOnElements() {
		testBase.scrollToElement(lblElement);
		testBase.clickOnElement(lblElement);
		return new ElementsPage(webDriver);
	}
	
	public FormsPage clickOnFormsPage() {
		testBase.scrollToElement(lblForms);
		testBase.clickOnElement(lblForms);
		return new FormsPage(webDriver);
	}

	
}
