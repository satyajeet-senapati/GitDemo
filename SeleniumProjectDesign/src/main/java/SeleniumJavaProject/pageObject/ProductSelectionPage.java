package SeleniumJavaProject.pageObject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJavaProject.Utilities.UtilitiesClass;

public class ProductSelectionPage extends UtilitiesClass{
	public WebDriver driver;
	private String[] required ={"adidas original","zara coat 3"};
	public ProductSelectionPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]")
	WebElement btnCart;
	
	public void selectProduct() throws InterruptedException {
		for(String product :required) {
			String xpath  = "//b[contains(text(),'"+product+"')]//ancestor::div[1]/button[2]";
			waitForFiveSeconds();
			driver.findElement(By.xpath(xpath)).click();
		}
	}
	public void  clickOnCart( ) throws InterruptedException {
		waitForFiveSeconds();
		btnCart.click();
	}
}
