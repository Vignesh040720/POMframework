package common.QA.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import common.QA.Util.Testutil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase()  {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\vigne\\eclipse-workspace\\PomFrameWorkDesign"
					+ "\\src\\main\\resources\\common\\QA\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}

	}

	public static void Initilization() {
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutil.Pageload));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutil.Implcitwait));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
}
