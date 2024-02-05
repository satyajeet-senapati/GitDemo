package SeleniumJavaProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement usermails;
	
	@FindBy(id="userPassword")
	WebElement passwords;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void url() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loginApplication(String mail,String pass ) {
		usermails.sendKeys(mail);
		passwords.sendKeys(pass);
		submit.click();
	}
}
