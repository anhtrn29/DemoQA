package tests;
import org.testng.annotations.Test;

import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;
public class AutomationPracticeFormTest extends TestCase {
	@Test
public void submitDataSuccessfully() {
	String firstName = "anh";
	String lastName ="tran"; 
	String email = "anh123@gmail.com";
	String gender = "Female";
	String mobile = "123";
	String dateOFBirth = "3 June 1999";
	String subjects = "selenium java";
	String hobbies = "listening to music";
	String picture = "";
	String currentAddress = "a";
	String stateAndCity = "ho chi minh city";
	
	HomePage homePage = new HomePage(testBase.driver);
	FormsPage formsPage = homePage.clickOnFormsPage();
	AutomationPracticeFormPage automationPracticeFormPage = formsPage.clickOnPracticeForm();
	automationPracticeFormPage.inputData(firstName, lastName, email, gender, mobile, dateOFBirth, subjects, hobbies, picture, currentAddress, stateAndCity);
	
	
	
	
}
}
