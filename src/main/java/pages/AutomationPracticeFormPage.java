package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AutomationPracticeFormPage extends Page {

	public By txtFirstName=By.id("firstName");
	public By txtLastName=By.id("lastName");
	public By txtEmail=By.id("userEmail");	
	public String rdGenderStr="//label[text()='{@param}']";
	public By txtMobile=By.id("userNumber");
	public By txtDateOfBirth=By.id("dateOfBirthInput");
	public By drYear = By.xpath("//select[@class='react-datepicker__year-select']");
	public By drMonth = By.xpath("//select[@class='react-datepicker__month-select']");
	public String lbDate ="(//div[text()='{@param}'])[1]" ;
	public By txtSubject=By.id("subjectsInput");
	public String rdHobbiesStr="//label[text()='{@param}']";
	public By upLoadPic=By.id("uploadPicture");
	public By txtCurrentAddress=By.id("currentAddress");
	public By cbState = By.id("state");
	public By cbStateInput = By.id("react-select-3-input");
	public By cbCity = By.id("city");
	public By cbtCityInput = By.id("react-select-4-input");		
	public By btnSubmit =By.id("submit");
	public String valueStr = "//td[text()='{@param}']/following-sibling::td";
	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(String firstName, String lastName, String email, String gender, String mobile, String dateOFBirth, String subjects, String hobbies, String picture, String currentAddress, String state, String city ) {
		testBase.zoomOut("70%");
		testBase.input(txtFirstName, firstName);
		testBase.input(txtLastName, lastName);
		testBase.input(txtEmail, email);
		By rdGenderLocator = testBase.getXpathByParam(rdGenderStr, gender);
		testBase.clickOnElement(rdGenderLocator);
		testBase.input(txtMobile, mobile);
		inputDate(dateOFBirth);	
		testBase.findAndSelectComboBox(txtSubject, subjects);
		testBase.selectCheckBox(rdHobbiesStr, hobbies);
		testBase.input(upLoadPic, picture);
		testBase.input(txtCurrentAddress, currentAddress);
		testBase.findAndSelectComboBoxWithSingleValue(cbState, cbStateInput, state);
		testBase.findAndSelectComboBoxWithSingleValue(cbCity, cbtCityInput, city);
		testBase.clickOnElement(btnSubmit);
		
	}
	
	
	public void inputDate(String dateOfBirth) {
		String[] dateOfBirths = dateOfBirth.split(" ");
		testBase.clickOnElement(txtDateOfBirth);
		testBase.selectDropDownBoxByVisibleText(drYear,dateOfBirths[2].trim());
		testBase.selectDropDownBoxByVisibleText(drMonth, dateOfBirths[1].trim());
		By lbDateXpath = testBase.getXpathByParam(lbDate, dateOfBirths[0].trim());
		testBase.clickOnElement(lbDateXpath);
	}
	
	
	public String getValueByFieldName(String originalXpath, String fieldName) {
		By studentNameLocator = testBase.getXpathByParam(valueStr,fieldName);
		String fullText = testBase.driver.findElement(studentNameLocator).getText();
		return fullText;
	}

	public String formatDate(String originalDate) {
		String result ="";
		String[] originalDates = originalDate.split(" ");
		String originalDay = originalDates[0].trim();
		int convertedDate =Integer.parseInt(originalDay);
		if(convertedDate<10) {
			result="0" + originalDay + " " + originalDates[1].trim() + "," + originalDates[2].trim(); 
		} else {
			result = originalDay + " " + originalDates[1].trim() + "," + originalDates[2].trim();
		}
		return result;
	}
}
