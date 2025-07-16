package tests;

import org.openqa.selenium.WebDriver;

import pages.Page;

public class StudentRegistrationForm extends Page {
	public static WebDriver dr;
	public String firstName;
	public String lastName;
	public String email;
	public String gender;
	public String mobile;
	public String dateOfBirth;
	public String subjects;
	public String hobbies;
	public String picture;
	public String currentAddress;
	public String state;
	public String city;

	public StudentRegistrationForm() {
		super(dr);
	}

}
