package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public TextBoxPage clickOnTextboxPage() {
		WebElement textbox = testBase.driver.findElement(By.xpath("//span[text()='Text Box']"));
		textbox.click();
		return new TextBoxPage(webDriver);
	}
	
	public CheckBoxPage clickOnCheckBoxPage() {
		WebElement checkBox = testBase.driver.findElement(By.xpath("//span[text()='Check Box']"));
		checkBox.click();
		return new CheckBoxPage(webDriver);
	}
	
	public RadioButtonPage clickOnRadioButtonPage() {
		WebElement radioButton = testBase.driver.findElement(By.xpath("//span[text()='Radio Button']"));
		radioButton.click();
		return new RadioButtonPage(webDriver);
	}
	
	public FormsPage clickOnFormsPage() {
		testBase.scrollToElement(lblForms);
		testBase.clickOnElement(lblForms);
		return new FormsPage(webDriver);
	}

	
}
