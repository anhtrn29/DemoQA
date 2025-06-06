package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TextBoxPage extends Page {
	public By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtCurrentAddress = By.id("currentAddress");
	public By txtPermanentAddress = By.id("permanentAddress");
	public By buttonSubmit = By.xpath("//button[@id='submit']");
	public By lblName = By.id("name");
	public By lblEmail = By.id("email");
	public By lblCurrentAddress = By.xpath("//p[@id='currentAddress']");
	public By lblPermanentAddress = By.xpath("//p[@id='permanentAddress']");
	
	public TextBoxPage(WebDriver dr) {
		super(dr);
	}

	public void inputData(String fullName, String email, String currentAddress, String permanentAddress) {
		testBase.input(txtFullName, fullName);
		testBase.input(txtEmail, email);
		testBase.input(txtCurrentAddress, currentAddress);
		testBase.input(txtPermanentAddress, permanentAddress);
		testBase.scrollToEndPage();
		testBase.clickOnElement(buttonSubmit);		
	}
	
	public String getActualResult(By locator) {
		String result = "";
		String fullText = webDriver.findElement(locator).getText();
		String[] values = fullText.split(":");
		result = values[1].trim();
		return result;

	}
	
	public String getElementAttribute(By locator) {
		String result ="";
		WebElement e = webDriver.findElement(locator);
		result = e.getAttribute("class");
		return result;
	}
	
}

	
