package common.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.QA.Baseclass.TestBase;

public class Loginpage extends TestBase {

	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement logo;

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement LoginButton;

	public Loginpage() {

		PageFactory.initElements(driver, this);
	}

	// Actions

	public boolean Logo() {

		return logo.isDisplayed();
	}

	public void Credentilas(String UserName, String Password) {

		username.sendKeys(UserName);
		password.sendKeys(Password);
		LoginButton.click();
	}

}
