package SeleniumJavaProject;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import SeleniumJavaProject.pageObject.*;
public class Standalone {
public static void main(String[] args) throws InterruptedException {
	
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	//WebDriver driver =new ChromeDriver();
	WebDriver driver =new FirefoxDriver();
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	LoginPage lp =new LoginPage(driver);
	lp.url();
	lp.loginApplication("satyajeetsenapati02@gmail.com", "satyaPIKUL@123");
	ProductSelectionPage psp = new ProductSelectionPage(driver);
	psp.selectProduct();
	psp.clickOnCart();
	String a= "//h3[contains(text(),'')]";
	  List<WebElement> mycart = driver.findElements(By.xpath(a));
	  
	  for(int i=2;i<=mycart.size();i++) {  
		  String b="("+a+")["+(i)+"]";
		  System.out.println(driver.findElement(By.xpath(b)).getText());  
	  }  
	  CheckOutPage cop = new CheckOutPage(driver);
	  cop.CheckOut();
	  PaymentPage pp =new PaymentPage(driver);
	  pp.selectCountry();
	  pp.placeOrder();		
	}
}





