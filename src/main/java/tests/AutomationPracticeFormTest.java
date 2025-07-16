package tests;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import common.Utils;
import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;
public class AutomationPracticeFormTest extends TestCase {
	@Test
public void submitDataSuccessfully() {
	Utils utils = new Utils();
	String fileName = "RegistrationData.xls";
	String sheetName = "Sheet1";
	String projectFolder = System.getProperty("user.dir");
	String excelFile = projectFolder + "\\testcase\\testdata\\" + fileName;
	String[][] registrationData = utils.getTableObject(excelFile, sheetName);
	
	StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
	studentRegistrationForm.firstName = registrationData[0][0];
//	String firstName = "anh";
//	String lastName ="tran"; 
	studentRegistrationForm.lastName = registrationData[0][1];
//	String email = "anh123@gmail.com";
	studentRegistrationForm.email = registrationData[0][3];
//	String gender = "Female";
	studentRegistrationForm.gender = registrationData[0][4];
//	String mobile = "0123456789";
	studentRegistrationForm.mobile = registrationData[0][5];
//	String dateOfBirth = "3 June 1999";
	studentRegistrationForm.dateOfBirth = registrationData[0][6];
//	String subjects = "Maths, English, Computer Science";
	studentRegistrationForm.subjects = registrationData[0][7];
//	String hobbies = "Reading, Sports, Music";
	studentRegistrationForm.hobbies = registrationData[0][8];
//	String picture = "C:\\01AutomationTest\\03Practices\\03Git\\DemoQA\\testcase\\testData\\logo.png";
	studentRegistrationForm.picture = projectFolder + "\\testcase\\testData\\" + registrationData[0][8];
//	String currentAddress = "a";
	studentRegistrationForm.currentAddress = registrationData[0][9];
//	String state = "NCR";
	studentRegistrationForm.state = registrationData[0][10];
//	String city = "Delhi";
	studentRegistrationForm.city = registrationData[0][11];
	
	HomePage homePage = new HomePage(testBase.driver);
	FormsPage formsPage = homePage.clickOnFormsPage();
	AutomationPracticeFormPage automationPracticeFormPage = formsPage.clickOnPracticeForm();	
	
	automationPracticeFormPage.inputData(
	studentRegistrationForm.firstName, 
	studentRegistrationForm.lastName, 
	studentRegistrationForm.email, 
	studentRegistrationForm.gender, 
	studentRegistrationForm.mobile, 
	studentRegistrationForm.dateOfBirth, 
	studentRegistrationForm.subjects, 
	studentRegistrationForm.hobbies, 
	studentRegistrationForm.picture, 
	studentRegistrationForm.currentAddress, 
	studentRegistrationForm.state, 
	studentRegistrationForm.city);
	
	String expectedStudentName = studentRegistrationForm.firstName +" "+studentRegistrationForm.lastName;
	String actualStudentName = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Student Name");
	assertEquals(actualStudentName, expectedStudentName);
	String actualStudentEmail = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Student Email");
	assertEquals(actualStudentEmail,studentRegistrationForm.email);
	String actualGender = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Gender");
	assertEquals(actualGender,studentRegistrationForm.gender);
	String actualMobile = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Mobile");
	assertEquals(actualMobile,studentRegistrationForm.mobile);
	String expectedDateOfBirth = automationPracticeFormPage.formatDate(studentRegistrationForm.dateOfBirth);
	String actualDateOfBirth = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Date of Birth");
	assertEquals(actualDateOfBirth, expectedDateOfBirth);
	String actualSubjects = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Subjects");
	assertEquals(actualSubjects,studentRegistrationForm.subjects);
	String actualHobbies = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Hobbies");
	assertEquals(actualHobbies,studentRegistrationForm.hobbies);
	int doubleSlashIndex =studentRegistrationForm.picture.lastIndexOf("\\");
	String expectedPicture =studentRegistrationForm.picture.substring(doubleSlashIndex + 1,studentRegistrationForm.picture.length());
	String actualPicture = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Picture");
	assertEquals(actualPicture, expectedPicture);
	String actualAddress = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "Address");
	assertEquals(actualAddress,studentRegistrationForm.currentAddress);
	String expectedStateAndCity =studentRegistrationForm.state + " " +studentRegistrationForm.city ;
	String actualStateAndCity = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr, "State and City");
	assertEquals(actualStateAndCity, expectedStateAndCity);
	
}
}
