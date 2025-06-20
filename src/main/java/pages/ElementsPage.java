package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page {
	public By lblTextBox = By.xpath("//span[text()='Text Box']");
	public By lblCheckBox = By.xpath("//span[text()='Check Box']");
	public By lblRadioButton=By.xpath("//span[text()='Radio Button']");
	public ElementsPage(WebDriver dr) {
		super(dr);
	}
	
	public TextBoxPage  clickOnTextBox() {
		testBase.clickOnElement(lblTextBox);
		return new TextBoxPage(webDriver);
	}
	
	public CheckBoxPage clickOnCheckBox() {
		testBase.clickOnElement(lblCheckBox);
		return new CheckBoxPage(webDriver);
	}
	
	public RadioButtonPage clickOnRadioButton() {
		testBase.driver.findElement(lblRadioButton);
		return new RadioButtonPage(webDriver);
	}

}
