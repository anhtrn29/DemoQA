package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeFormPage extends Page {

	public By txtFirstName=By.id("firstName");
	public By txtLastName=By.id("lastName");
	public By txtEmail=By.id("userEmail");
	public By txtGender=By.xpath("//label[text()='{@param}']");
	public By txtMobile=By.id("userNumber");
	public By txtDateOfBirth=By.id("dateOfBirthInput");
	public By txtSubject=By.className("subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3");
	public By txtHobbies=By.xpath("//label[text()='{@param}']");
	public By upLoadPic=By.id("uploadPicture");
	public By txtCurrentAddress=By.id("currentAddress");
	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);
	}
	
	public void inputData(String firstName, String lastName, String email, String gender, String mobile, String dateOFBirth, String subjects, String hobbies, String picture, String currentAddress, String stateAndCity ) {
		testBase.input(txtFirstName, firstName);
		testBase.input(txtLastName, lastName);
		testBase.input(txtEmail, email);
		testBase.input(txtGender, gender);
		testBase.input(txtMobile, mobile);
		testBase.input(txtDateOfBirth, dateOFBirth);
		testBase.input(txtSubject, subjects);
		testBase.input(txtHobbies, hobbies);
		testBase.input(txtCurrentAddress, currentAddress);
	}

}
