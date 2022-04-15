package facebookPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import facebookBaseClass.BaseTest;

public class LoginPage extends BaseTest {
	
	public LoginPage() throws Exception {
		super();

	PageFactory.initElements(driver, this);
	}

	//PageFactory - object repository
	
	

	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Create new account']")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class,'fb_logo')]")
	WebElement fbLogo;
	
	@FindBy(xpath="//div[contains(text(),'The email or mobile number you entered isn’t connected to an account. ')]")
	WebElement error;
	
	@FindBy(linkText="Create new account")
	WebElement createNewAccount;
	
	@FindBy(xpath="//div[text()='Sign Up']")
	WebElement signUpTitle;
	
	
	
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public boolean pageLogo() {
		return fbLogo.isDisplayed();
	}
	
	public void login(String a, String b) {
		email.sendKeys(a);
		password.sendKeys(b);
		loginButton.click();
	}
	
	public String errMess() {
		return error.getText();
		
	}
	
	public SignUpPage newAccountLink() {
		createNewAccount.click();
		return new SignUpPage();
	}

	public String signUpText() {
	return	signUpTitle.getText();
		
		
	}
	
}
