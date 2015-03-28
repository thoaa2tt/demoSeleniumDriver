package automationFramework;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;

public class WebDriverTutorials1 {
	// creating new Instance of Firefox Driver
	WebDriver driver = new FirefoxDriver();
	@Before
	 public void beforetest() {

	 //To Maximize Browser Window
	  driver.manage().window().maximize();

	 //To Open URL In browser
//	  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	  driver.get("file:///home/framgiavn/Desktop/Only%20Testing:%20New%20Test.html");
	
	 	 }
	@After
	 public void aftertest() {
	  driver.quit();
	 }
	
	 @Test
	 public void test() throws InterruptedException 
	  {
	////Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	   // enter text in FistName
	   driver.findElement(By.name("fname")).sendKeys("This is test");
	   // 
	   String dropdown = driver.findElement(By.tagName("select")).getText();
	   // cach chon mot gia tri trong mot doi tuong la dropdown 
	   Select oSelection = new Select(driver.findElement(By.tagName("select")));
	   oSelection.selectByVisibleText("Opel");
	   System.out.print("Drop down list values are as bellow :\n"+dropdown);
	   Thread.sleep(5000);
	   // locate button by id ande click on it 
	   //driver.findElement(By.id("submitButton")).click(); 
	//   String  datentime = driver.findElement(By.className("date-header")).getText();//Locating element by className and store its text to variable datentime.
	   System.out.print("\nTét tét");
	  }
}
