package SeleniumJavaProject;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import SeleniumJavaProject.pageObject.*;
public class StandaloneOld {
public static void main(String[] args) throws InterruptedException {
	//WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	//WebDriver driver =new ChromeDriver();
	WebDriver driver =new FirefoxDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/client");
	
	/*
	 * LoginPage lp =new LoginPage(driver); lp.url();
	 * lp.loginApplication("satyajeetsenapati02@gmail.com", "satyaPIKUL@123");
	 */
	driver.findElement(By.id("userEmail")).sendKeys("satyajeetsenapati02@gmail.com");
    driver.findElement(By.id("userPassword")).sendKeys("satyaPIKUL@123");
	driver.findElement(By.id("login")).click();
	
	String[] required ={"adidas original","zara coat 3"};

	for(String product :required) {
		String xpath  = "//b[contains(text(),'"+product+"')]//ancestor::div[1]/button[2]";
		Thread.sleep(3000);
		driver.findElement(By.xpath(xpath)).click();
	}
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
	driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
	
	String a= "//h3[contains(text(),'')]";
	  List<WebElement> mycart = driver.findElements(By.xpath(a));
	  
	  for(int i=2;i<=mycart.size();i++) {  
		  String b="("+a+")["+(i)+"]";
		  System.out.println(driver.findElement(By.xpath(b)).getText());
		  
	  }
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),' India')])[2]"));
		Thread.sleep(3000);
		ac.moveToElement(element).click().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]")).click();

}
}



