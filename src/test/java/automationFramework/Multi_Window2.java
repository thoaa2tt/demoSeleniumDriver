package automationFramework;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.BadLocationException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class Multi_Window2 {
/*	WebDriver driver = new FirefoxDriver();
	 @Before
	 public void beforetest() {
	  driver.manage().window().maximize();
	  driver.get("http://only-testing-blog.blogspot.in/p/mouse-hover.html");
	 }
	 
	 @After
	 public void aftertest() {
	  //driver.quit();
	  
	 }
	 
	 @Test
	 public void test () throws InterruptedException, IOException 
	 { 
	  //Generate mouse hover event on main menu to click on sub menu
	  Actions actions = new Actions(driver);
	  WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
	  actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.titleContains("Google"));*/
	/*WebDriver driver = new FirefoxDriver();
	 
	 @Before
	 public void beforetest() {
	  driver.manage().window().maximize();
	  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }
	 
	 @After
	 public void aftertest() {
	  driver.quit();
	  
	 }
	 
	 @Test
	 public void test () throws BadLocationException, IOException, InterruptedException 
	  {
	  boolean fbefore = driver.findElement(By.xpath("//input[@name='fname']")).isEnabled();
	  System.out.print("\nBefore : First Name Text box enabled status is : "+fbefore);
	  boolean lbefore = driver.findElement(By.xpath("//input[@name='lname']")).isEnabled();
	  System.out.print("\nBefore : Last Name Text box enabled status is : "+lbefore);
	  
	  Thread.sleep(2000);
	  
	  //To disable First Name text box
	  JavascriptExecutor javascript = (JavascriptExecutor) driver;
	  String todisable = "document.getElementsByName('fname')[0].setAttribute('disabled', '');";
	  javascript.executeScript(todisable);
	  Thread.sleep(2000);
	  
	  //To enable Last Name text box
	  String toenable = "document.getElementsByName('lname')[0].removeAttribute('disabled');";
	  javascript.executeScript(toenable);
	  Thread.sleep(3000);
	 
	  boolean fafter = driver.findElement(By.xpath("//input[@name='fname']")).isEnabled(); 
	  System.out.print("\nAfter : First Name Text box enabled status is : "+fafter);
	  boolean lafter = driver.findElement(By.xpath("//input[@name='lname']")).isEnabled();
	  System.out.println("\nAfter : Last Name Text box enabled status is : "+lafter);
	  Thread.sleep(5000);
	  }*/
	static WebDriver driver;
	String URL = "http://clip.vn/upload";
	@Test
	public void testUpload() throws InterruptedException, IOException
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		WebElement element = driver.findElement(By.name("file_upload"));
		element.click();
		Runtime.getRuntime().exec("/Home/Downloads/autoit-v3-setup.exe");
	}	
	 }
