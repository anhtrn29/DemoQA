package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
	@Test
	public void submitSuccessfully() {
		String fullName ="anh";
		String email = "anh123@gmail.com";
		String currentAddress = "a";
		String permanentAddress = "a";
		HomePage homePage = new HomePage(testBase.driver);
		ElementsPage elementsPage = homePage.clickOnElements();
		TextBoxPage textBoxPage = elementsPage.clickOnTextBoxPage();
		textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
		String actualName = textBoxPage.getActualResult(textBoxPage.lblName);
		String actualEmail = textBoxPage.getActualResult(textBoxPage.lblEmail);
		String actualCurrentAddress = textBoxPage.getActualResult(textBoxPage.lblCurrentAddress);
		String actualPermanentAddress = textBoxPage.getActualResult(textBoxPage.lblPermanentAddress);
		assertEquals(actualName, fullName);
		assertEquals(actualEmail, email);
		assertEquals(actualCurrentAddress, currentAddress);
		assertEquals(actualPermanentAddress, permanentAddress);
	
	}
	
	public void validateEmails() {
		String fullName ="anh";
		String email = "anh123@123";
		String currentAddress ="a";
		String permanentAddress ="a";
		HomePage homePage = new HomePage(testBase.driver);
		ElementsPage elementsPage = homePage.clickOnElements();
		TextBoxPage textBoxPage = elementsPage.clickOnTextBoxPage();
		textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
		String actualResult = textBoxPage.getActualResult(textBoxPage.txtEmail);
		assertTrue(actualResult.contains("field-error"));
	}

@DataProvider(name="dataEmails")
	public Object [][] createEmails(){
		String [][] testData=new String[2][4];
		testData [0][0] ="anh";
		testData [0][1]="anh123gmail.com";
		testData [0][2]="a";
		testData [0][3]="a";
		testData [1][0]="anh";
		testData [1][1]="anh123@123";
		testData [1][2]="a";
		testData [1][3]="a";
		return testData;
	}
}
