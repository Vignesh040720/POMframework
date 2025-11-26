package common.Qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.QA.Baseclass.TestBase;
import common.QA.pages.Loginpage;

public class LoginPageTest extends TestBase {

	static Loginpage loginpage;

	public LoginPageTest() {

		super();

	}

	@BeforeMethod
	public static void Setup() {

		Initilization();

		loginpage = new Loginpage();
	}

	@Test(priority = 1)
	public void LogoTest() {

		Boolean flag = loginpage.Logo();

		Assert.assertTrue(flag);
	}

	@Test(priority =  2)
	public void CredTest() {
		loginpage.Credentilas(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
