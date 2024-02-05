package SeleniumJavaProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SeleniumJavaProject.Utilities.UtilitiesClass;

public class CheckOutPage extends UtilitiesClass{
	public WebDriver driver;
	public CheckOutPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement btncheckout;
	
	public void CheckOut() throws InterruptedException {
		scrollByPixels(driver,0,2000);
		waitForFiveSeconds();
		btncheckout.click();
	}
}
