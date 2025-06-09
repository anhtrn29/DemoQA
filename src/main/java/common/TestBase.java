package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {
	public WebDriver driver;

	public void openWeb(String url, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\01AutomationTest\\03Practices\\03Git\\DemoQA\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\01AutomationTest\\03Practices\\03Git\\DemoQA\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.get(url);
		driver.manage().window().maximize();
	}

	public void scrollToEndPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollToElement(By locator) {
		WebElement element =driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void zoomOut(String percentage) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='"+percentage+"'");
	}
	
	public void clickOnElement(By locator) {
		WebElement element =driver.findElement(locator);
		element.click();
	}
	
	public void input(By locator, CharSequence text) {
		WebElement element =driver.findElement(locator);
		scrollToElement(locator);
		element.sendKeys(text);
		
	}
	
	public By getXpathByParam(String xpath, String text) {
		String newXpath = xpath.replace("{@param}", text);
		By rdLocator = By.xpath(newXpath);	
		return rdLocator;	
	}
	
	public void selectDropDownBoxByVisibleText(By dropDownLocator, String visibleText) {
		WebElement dropDownElement = driver.findElement(dropDownLocator);
		Select dropDownBox = new Select(dropDownElement);
		dropDownBox.selectByVisibleText(visibleText);
	}
	
	public void findAndSelectComboBox(By locator, String multipleValue) {
		String[] multipleValues = multipleValue.split(",");
		WebElement element = driver.findElement(locator);
		element.click();
		for(int i = 0;i<multipleValues.length;i++) {
			element.sendKeys(multipleValues[i].trim());
			element.sendKeys(Keys.ENTER);		
	
		}
	}
	
	public void selectCheckBox(String xpath, String multipleValue) {
		String[] multipleValues = multipleValue.split(",");
		for(int i = 0;i<multipleValues.length;i++) {
		By chklocator = getXpathByParam(xpath, multipleValues[i].trim());
		clickOnElement(chklocator);
		}
	}
	
	public void findAndSelectComboBoxWithSingleValue(By cbSelect, By cbSelectInput, String text) {
		scrollToElement(cbSelect);
		clickOnElement(cbSelect);
		input(cbSelectInput, text);
		input(cbSelectInput, Keys.ENTER);
	}
	

}
