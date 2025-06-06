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
	public By drDate = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--selected']");
	public By txtSubject=By.className("subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3");
	public String txtHobbies="//label[text()='{@param}']";
	public By upLoadPic=By.id("uploadPicture");
	public By txtCurrentAddress=By.id("currentAddress");
	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(String firstName, String lastName, String email, String gender, String mobile, String dateOFBirth, String subjects, String hobbies, String picture, String currentAddress, String stateAndCity ) {
		testBase.input(txtFirstName, firstName);
		testBase.input(txtLastName, lastName);
		testBase.input(txtEmail, email);
		By rdGenderLocator = testBase.getXpathByParam(rdGenderStr, gender);
		testBase.clickOnElement(rdGenderLocator);
		testBase.input(txtMobile, mobile);
		testBase.input(txtDateOfBirth, dateOFBirth);
		testBase.input(txtSubject, subjects);
//		testBase.input(txtHobbies, hobbies);
		testBase.input(txtCurrentAddress, currentAddress);
	}
	
	public void inputDate(String dateOfBirth) {
		String[] dateOfBirths = dateOfBirth.split(" ");
		testBase.clickOnElement(txtDateOfBirth);
		testBase.selectDropDownBoxByVisibleText(drYear,dateOfBirths[2].trim());
		testBase.selectDropDownBoxByVisibleText(drMonth, dateOfBirths[1].trim());
		testBase.selectDropDownBoxByVisibleText(drDate, dateOfBirths[0].trim());
	}

}
