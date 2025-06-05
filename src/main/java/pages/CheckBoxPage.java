package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page {
	public By lblCheckBox = By.xpath("//span[text()='Check Box']");
	public By lblHome = By.cssSelector("label[for='tree-node-home'] span.rct-checkbox");
	public By exaExpandAll = By.xpath("//button[@title='Expand all']/*[name()='svg']");
	public By resultText= By.id("result");
	public CheckBoxPage(WebDriver dr) {
		super(dr);
	}
	public void expandAllCheckBox() {
		testBase.driver.findElement(exaExpandAll).click();

	}
	public void selectHomeCheckBox() {
		testBase.driver.findElement(lblHome).click();
		
	}
		
	public String getActualResult(By resultText) {
		String result = testBase.driver.findElement(resultText).getText().toLowerCase();
		return result;
	}
}
