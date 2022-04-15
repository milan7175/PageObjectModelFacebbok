package facebookBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import facebookUtil.TestUtil;

public class BaseTest {
	
	public static WebDriver driver;

	public static Properties prop;
	
	
	
	public  BaseTest() throws Exception {
		
		FileInputStream f = new FileInputStream("C:\\Users\\Milan Thakkar\\Desktop\\Selenium Notes\\pageObjectmodel.properties");
	
		prop = new Properties();
		prop.load(f);
	}
//C:\Selenium_workspace\PractisePageObjectModel\src\main\java\facebookPropertiesFiles\config.properties
	
	public static void initialization() {
		//System.out.println("112234");

		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
			//System.out.println("*************************Firefox");

			}
		else {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			 driver = new ChromeDriver();
				//System.out.println("******************************Chrome");

			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

	
}
