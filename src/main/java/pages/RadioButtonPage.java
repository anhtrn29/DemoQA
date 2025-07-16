package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends Page {
	public By rdSelectValue = By.id("yesRadio");
	public By resultText = By.xpath("//span[@class='text-success']");
	public RadioButtonPage(WebDriver dr) {
		super(dr);
	}

	public void selectRadioButton(String labelText) {
		testBase.driver.findElement(rdSelectValue).click();
	}
		
	public String getActualResult(By resultText) {
		testBase.driver.findElement(resultText).getText().toLowerCase();
		return getActualResult(resultText);
	}
	
}
