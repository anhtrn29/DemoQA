package tests;

import static org.testng.Assert.assertTrue;

import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;

public class CheckBoxTest extends TestCase {

	public void testSelectHomeCheckBox() {
	HomePage homePage = new HomePage(testBase.driver);
	ElementsPage elementsPage = homePage.clickOnElements();
	CheckBoxPage checkBoxPage = elementsPage.clickOnCheckBox();
	checkBoxPage.selectHomeCheckBox();
	checkBoxPage.expactAllCheckBox();
	String actualResult = checkBoxPage.getActualResult();
	assertTrue(actualResult.contains("Home"));
	}
}
