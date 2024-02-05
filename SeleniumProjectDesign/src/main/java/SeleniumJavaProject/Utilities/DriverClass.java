package SeleniumJavaProject.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {
	public void Driver() {
	   //WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		//WebDriver driver =new ChromeDriver();
		WebDriver driver =new FirefoxDriver();
		driver.manage().window().maximize();
}
}