package SeleniumJavaProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilitiesClass {
	//WebDriver driver;
	
public void waitForFiveSeconds() throws InterruptedException {
	Thread.sleep(5000);
}
public void waitForTwoSeconds() throws InterruptedException {
	Thread.sleep(2000);
}
public void waitForThreeSeconds() throws InterruptedException {
	Thread.sleep(3000);
}


public void scrollByPixels(WebDriver driver,int a,int b) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String param = "window.scrollBy("+a+","+b+")";
	  js.executeScript(param);
}

}
