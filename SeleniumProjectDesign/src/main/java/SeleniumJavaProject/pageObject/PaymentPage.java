package SeleniumJavaProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJavaProject.Utilities.UtilitiesClass;

public class PaymentPage extends UtilitiesClass{
	public WebDriver driver;
	public PaymentPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement textbox;
	
	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement placeorder;
	
	@FindBy(xpath="(//*[contains(text(),' India')])[2]")
	String selectCountry;

	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement btnPlaceOrder;
	
	public void selectCountry() throws InterruptedException {
		textbox.sendKeys("India");
		waitForTwoSeconds();
		Actions ac = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(selectCountry));
		ac.moveToElement(element).click().perform();
	}
	
	public void placeOrder() {
		btnPlaceOrder.click();
	}
}
