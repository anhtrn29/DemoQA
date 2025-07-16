package tests;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.RadioButtonPage;

public class RadioButtonTest extends TestCase {

	String selectValue ="Yes";
	@Test
	public void testClickRadioButton() {
		HomePage homePage = new HomePage(testBase.driver);
		ElementsPage elementsPage = homePage.clickOnElements();
		RadioButtonPage radioButtonPage = elementsPage.clickOnRadioButtonPage();
		radioButtonPage.selectRadioButton(selectValue);
		String actualResultRadioButton = radioButtonPage.getActualResult(radioButtonPage.resultText);
		assertTrue(actualResultRadioButton.contains("you have selected")&&
				   actualResultRadioButton.contains("yes"));
	}	
}

