package tests;
import org.testng.annotations.Test;

import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;
public class AutomationPracticeFormTest extends TestCase {
	@Test
public void submitDataSuccessfully() {
	HomePage homePage = new HomePage(testBase.driver);
	FormsPage formsPage = homePage.clickOnFormsPage();
	AutomationPracticeFormPage automationPracticeFormPage = formsPage.clickOnPracticeForm();
	
	
	
}
}
