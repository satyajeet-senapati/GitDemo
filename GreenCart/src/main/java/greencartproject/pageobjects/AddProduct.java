package greencartproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	public WebDriver driver;
	public AddProduct(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	public void addToCart(String[] vegies) {
		for(String selectVegies : vegies) {
			String xpath = "//h4[contains(text(),'"+selectVegies+"')]//parent::div/div[3]/button";
			driver.findElement(By.xpath(xpath)).click();
		}
	}
}
