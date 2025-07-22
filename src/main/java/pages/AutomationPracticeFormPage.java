package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.models.StudentRegistrationForm;
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
	
	public void inputData(StudentRegistrationForm st) {
		testBase.zoomOut("70%");
		testBase.input(txtFirstName, st.firstName);
		testBase.input(txtLastName, st.lastName);
		testBase.input(txtEmail, st.email);
		By rdGenderLocator = testBase.getXpathByParam(rdGenderStr, st.gender);
		testBase.clickOnElement(rdGenderLocator);
		testBase.input(txtMobile, st.mobile);
		inputDate(st.dateOfBirth);	
		testBase.findAndSelectComboBox(txtSubject, st.subjects);
		testBase.selectCheckBox(rdHobbiesStr, st.hobbies);
		testBase.input(upLoadPic, st.picture);
		testBase.input(txtCurrentAddress, st.currentAddress);
		testBase.findAndSelectComboBoxWithSingleValue(cbState, cbStateInput, st.state);
		testBase.findAndSelectComboBoxWithSingleValue(cbCity, cbtCityInput, st.city);
		testBase.clickOnElement(btnSubmit);
		
	}
	
	/**
	 * 
	 * @param dateOfBirth:DD MMM YYYY
	 */
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
