package GreenCartProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import greencartproject.pageobjects.AddProduct;

public class standAlone {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	
	
	String[] vegies= {"Brocolli","Beans","Potato","Banana","Musk Melon"};
	AddProduct addproduct = new AddProduct(driver);
	addproduct.addToCart(vegies);
	/*
	 * for(String selectVegies : vegies) { String xpath =
	 * "//h4[contains(text(),'"+selectVegies+"')]//parent::div/div[3]/button";
	 * driver.findElement(By.xpath(xpath)).click(); }
	 */
	
	
	
	driver.findElement(By.className("cart-icon")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	
	
	driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
	
	driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	
	Select sc = new Select(driver.findElement(By.xpath("//option[contains(text(),'Select')]//parent::select")));
	sc.selectByVisibleText("India");
	
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
}
}
