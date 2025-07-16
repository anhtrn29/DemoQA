package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends Page {
	public By lblPracticeFormPage = By.xpath("//span[text()='Practice Form']");
	public FormsPage(WebDriver dr) {
		super(dr);
	}

	public AutomationPracticeFormPage clickOnPracticeForm() {
		testBase.clickOnElement(lblPracticeFormPage);
		return new AutomationPracticeFormPage(webDriver);
	}
}
