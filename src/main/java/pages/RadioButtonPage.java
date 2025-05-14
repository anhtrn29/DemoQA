package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends Page {
	public By lblRadioButton = By.xpath("//label[text()='replace']");
	public RadioButtonPage(WebDriver dr) {
		super(dr);
	}

	public void selectRadioButton(String labelText) {
		testBase.driver.findElement(lblRadioButton);
		
		
	}
	
	public String getResultText() {
		return testBase.driver.findElement(By.className("text-success")).getText();
	}
	
}
