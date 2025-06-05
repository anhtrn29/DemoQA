package tests;

import static org.testng.Assert.assertEquals;

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
		RadioButtonPage radioButtonPage = elementsPage.clickOnRadioButton();
		radioButtonPage.selectRadioButton(selectValue);
		assertEquals(radioButtonPage.getResultText(), selectValue, "Radio selection failed");
	}	
}

