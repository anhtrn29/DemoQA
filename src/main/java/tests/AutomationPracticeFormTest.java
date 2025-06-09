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
	String subjects = "Math, English, Computer Science";
	String hobbies = "Reading, Sports, Music";
	String picture = "C:\\01AutomationTest\\03Practices\\03Git\\DemoQA\\testcase\\testData\\logo.png";
	String currentAddress = "a";
	String state = "NCR";
	String city = "Delhi";
	
	HomePage homePage = new HomePage(testBase.driver);
	FormsPage formsPage = homePage.clickOnFormsPage();
	AutomationPracticeFormPage automationPracticeFormPage = formsPage.clickOnPracticeForm();
	automationPracticeFormPage.inputData(firstName, lastName, email, gender, mobile, dateOFBirth, subjects, hobbies, picture, currentAddress, state, city);
	
	
	
	
}
}
