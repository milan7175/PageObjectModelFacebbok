package facebookTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import facebookBaseClass.BaseTest;
import facebookPages.LoginPage;
import junit.framework.Assert;

public class LoginTest extends BaseTest {
	LoginPage loginPage;

	public LoginTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		 loginPage= new LoginPage();
		
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.pageTitle();
		Assert.assertEquals(title, "Facebook - Log In or Sign Up");
	}
	
	@Test(priority=2)
	public void loginPageLogoTest() {
		boolean flag = loginPage.pageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginCredentialTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String errmess = loginPage.errMess();
		String experr = "The email or mobile number you entered isn’t connected to an account. ";
		Assert.assertTrue((errmess).contains(experr));
		//System.out.println((errmess).contains(experr));
		
	}
	
	@Test(priority=4)
	public void verifySignUpTest() {
		 loginPage.newAccountLink();
		 String title = loginPage.signUpText();
		 String exp = "Sign Up";
		 Assert.assertTrue((title).equals(exp));
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
