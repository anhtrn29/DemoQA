package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import common.Utils;
import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;
import tests.models.StudentRegistrationForm;

public class AutomationPracticeFormTest extends TestCase {
	@Test
	public void submitDataSuccessfully() {
		Utils utils = new Utils();
		String fileName = "RegistrationData.xls";
		String sheetName = "Sheet1";
		String projectFolder = System.getProperty("user.dir");
		String excelFile = projectFolder + "\\testcase\\testData\\" + fileName;
		String[][] registrationData = utils.getTableObject(excelFile, sheetName);

		StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
		studentRegistrationForm.firstName = registrationData[0][0];
		studentRegistrationForm.lastName = registrationData[0][1];
		studentRegistrationForm.email = registrationData[0][2];
		studentRegistrationForm.gender = registrationData[0][3];
		studentRegistrationForm.mobile = registrationData[0][4];
		studentRegistrationForm.dateOfBirth = registrationData[0][5];
		studentRegistrationForm.subjects = registrationData[0][6];
		studentRegistrationForm.hobbies = registrationData[0][7];
		studentRegistrationForm.picture = projectFolder + "\\testcase\\testData\\" + registrationData[0][8];
		studentRegistrationForm.currentAddress = registrationData[0][9];
		studentRegistrationForm.state = registrationData[0][10];
		studentRegistrationForm.city = registrationData[0][11];

		HomePage homePage = new HomePage(testBase.driver);
		FormsPage formsPage = homePage.clickOnFormsPage();
		AutomationPracticeFormPage automationPracticeFormPage = formsPage.clickOnPracticeForm();
		automationPracticeFormPage.inputData(studentRegistrationForm);
		validateThanksForForm(studentRegistrationForm, automationPracticeFormPage);
	}

	public void validateThanksForForm(StudentRegistrationForm studentRegistrationForm,
			AutomationPracticeFormPage automationPracticeFormPage) {
		String expectedStudentName = studentRegistrationForm.firstName + " " + studentRegistrationForm.lastName;
		String actualStudentName = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Student Name");
		assertEquals(actualStudentName, expectedStudentName);
		String actualStudentEmail = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Student Email");
		assertEquals(actualStudentEmail, studentRegistrationForm.email);
		String actualGender = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Gender");
		assertEquals(actualGender, studentRegistrationForm.gender);
		String actualMobile = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Mobile");
		assertEquals(actualMobile, studentRegistrationForm.mobile);
		String expectedDateOfBirth = automationPracticeFormPage.formatDate(studentRegistrationForm.dateOfBirth);
		String actualDateOfBirth = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Date of Birth");
		assertEquals(actualDateOfBirth, expectedDateOfBirth);
		String actualSubjects = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Subjects");
		assertEquals(actualSubjects, studentRegistrationForm.subjects);
		String actualHobbies = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Hobbies");
		assertEquals(actualHobbies, studentRegistrationForm.hobbies);
		int doubleSlashIndex = studentRegistrationForm.picture.lastIndexOf("\\");
		String expectedPicture = studentRegistrationForm.picture.substring(doubleSlashIndex + 1,
				studentRegistrationForm.picture.length());
		String actualPicture = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Picture");
		assertEquals(actualPicture, expectedPicture);
		String actualAddress = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"Address");
		assertEquals(actualAddress, studentRegistrationForm.currentAddress);
		String expectedStateAndCity = studentRegistrationForm.state + " " + studentRegistrationForm.city;
		String actualStateAndCity = automationPracticeFormPage.getValueByFieldName(automationPracticeFormPage.valueStr,
				"State and City");
		assertEquals(actualStateAndCity, expectedStateAndCity);
	}
}
