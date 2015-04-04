package utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


public class HighlightElement {
	WebDriver driver = new FirefoxDriver();
	 
	 @Before
	 public void beforetest() {
	  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }
	 
	 @After
	 public void aftertest() {
	  driver.quit();
	  
	 }
	 
	 @Test
	  public void HighlightElement () {  
	    
		 HighlightMyElement(driver.findElement(By.xpath("//input[@name='fname']")));
		 driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
		 HighlightMyElement(driver.findElement(By.xpath("//button[@onclick='myFunction()']")));
		 WebDriverWait wait = new WebDriverWait(driver, 15);
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submitButton")));
		 HighlightMyElement(driver.findElement(By.cssSelector("#submitButton")));
		 driver.findElement(By.cssSelector("#submitButton")).click();			  
	   }
	 
	 public void HighlightMyElement(WebElement element) { 
	  for (int i = 0; i < 10; i++) 
	  { 
	   JavascriptExecutor javascript = (JavascriptExecutor) driver;
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: orange; border: 4px solid orange;");
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: pink; border: 4px solid pink;");
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 4px solid yellow;");
	   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, ""); 
	   } 
	  } 
}
