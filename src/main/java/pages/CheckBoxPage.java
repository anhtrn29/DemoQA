package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page {
	public By lblCheckBox = By.xpath("//span[text()='Check Box']");
	public By lblHome = By.xpath("label[for='tree-node-home']");
	public By exaExpactAll = By.xpath("//button[@title='Expand all']/*[name()='svg']");
	public By resultText= By.id("result");
	public CheckBoxPage(WebDriver dr) {
		super(dr);
	}
	public void expactAllCheckBox() {
		testBase.driver.findElements(exaExpactAll);

	}
	public void selectHomeCheckBox() {
		testBase.driver.findElements(lblHome);
		
	}
	
	public String getActualResult() {
		String result = webDriver.findElement(resultText).getText();
		return result;
	}
}
