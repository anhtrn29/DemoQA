package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage extends Page {
	public By lblRadioButton = By.xpath("//span[text()='Radio Button']");
	public By clickYes=By.xpath("//label[for='yesRadio']");
	public By resultText = By.className("text-success");
	public WebDriverWait wait;
	public RadioButtonPage(WebDriver dr) {
		super(dr);
	}

	public void open() {
		WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(lblRadioButton));
		tab.click();
	}
	public void selectRadioButton(String labelText) {
		
	}
	
	public void clickYesRadio() {
		testBase.driver.findElement(clickYes).click();
		
	}
	
	public String getResultText() {
		return testBase.driver.findElement(By.className("text-success")).getText();
	}
	
}
