package automationFramework;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverTutorials1 {
	// creating new Instance of Firefox Driver
	WebDriver driver = new FirefoxDriver();
	@Before
	 public void beforetest() {

	 //To Maximize Browser Window
	  driver.manage().window().maximize();

	 //To Open URL In browser
	//driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
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
	   // enter text in FistNa me
	   driver.findElement(By.name("fname")).sendKeys("This is test");
	   // doc cac gia tri cua phan tu dropdown trong 
	   String dropdown = driver.findElement(By.tagName("select")).getText();
	   System.out.print("Drop down list values are as bellow :\n"+dropdown);
	   // Selecting value from drop down using visible text 
	   Select oSelection = new Select(driver.findElement(By.tagName("select")));
	   oSelection.selectByVisibleText("Opel");
	 
	   // locate button by id and click on it 
	 //  driver.findElement(By.id("submitButton")).click(); 
	   // listbox -  select box is multiselects
	   String olistbox = driver.findElement(By.xpath("//select[@name='FromLB']")).getText();
	   System.out.print("Drop down list values are as bellow :\n"+olistbox);
	   Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
	   
	   //To verify that specific select box supports multiple select or not.
	   if(listbox.isMultiple())
	   {
	    System.out.print("\n Multiple selections is supported");
	    listbox.selectByVisibleText("USA");
	    listbox.selectByValue("Russia");
	    listbox.selectByIndex(5);
	    Thread.sleep(3000);
	    }
	   else
	   {
	    System.out.print("\n Not supported multiple selections");
	   }
	   driver.findElement(By.id("submitButton")).click(); 
	   // Navigate to URL or Back or Forward in Selenium Webdriver
	   driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	 //To navigate back (Same as clicking on browser back button)
	   driver.navigate().back();
	 //To navigate forward (Same as clicking on browser forward button)
	   driver.navigate().forward();
	   // Switch Window Commands
	   driver.findElement(By.xpath("//b[contains(.,'Open New Page')]")).click();
	// wait commands - condition that might reasonably be expected to eventually evaluate to something that is neither null nor false
	//WebDriverWait wait = new WebDriverWait(driver, 5);
// wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));
	  Thread.sleep(5000);	  
	  for (int i = 0; i<=20; i++)
	  {
	   WebElement  btn = driver.findElement(By.id("submitButton"));//Locating element by id
	   if (btn.isEnabled()) 
	   {
	    //if webelement's attribute found enabled then this code will be executed.
	    System.out.print("\nCongr8s... Button is enabled and webdriver is clicking on it now" );

	   //Locating button by id and then clicking on it.
	    driver.findElement(By.id("submitButton")).click(); 
	    i=20;
	    
	   }
	   else
	   {
	    //if webelement's attribute found disabled then this code will be executed.
	    System.out.print("\nSorry but Button is disabled right now.." +btn);
	   }
	   try {
	    Thread.sleep(500);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	  }
	  // Get and store both window handles in arraybfSECONDS);
	 /*  Set<String> AllWindowHandles = driver.getWindowHandles();
	   String window1 = (String) AllWindowHandles.toArray()[0];
	   System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	   String window2 = (String) AllWindowHandles.toArray()[1];
	   System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
	   //Switch to window2(child window) and performing actions on it.
	   driver.switchTo().window(window2);
	   driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
	   driver.findElement(By.xpath("//input[@value='Bike']")).click();
	   driver.findElement(By.xpath("//input[@value='Car']")).click();
	   driver.findElement(By.xpath("//input[@value='Boat']")).click();
	   driver.findElement(By.xpath("//input[@value='male']")).click();
	   Thread.sleep(5000);
	 //Switch to window1(parent window) and performing actions on it.
	   driver.switchTo().window(window1);
	   driver.findElement(By.xpath("//option[@id='country6']")).click();
	   driver.findElement(By.xpath("//input[@value='female']")).click();
	   driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
	   driver.switchTo().alert().accept();
	   Thread.sleep(5000);
	   //Once Again switch to window2(child window) and performing actions on it.
	   driver.switchTo().window(window2);
	   driver.findElement(By.xpath("//input[@name='fname']")).clear();
	   driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Name Changed");
	   Thread.sleep(5000);
	   driver.close();
	 //Once Again switch to window1(parent window) and performing actions on it.
	   driver.switchTo().window(window1);
	   driver.findElement(By.xpath("//input[@value='male']")).click();
	   Thread.sleep(5000);
	   
	 	//   String  datentime = driver.findElement(By.className("date-header")).getText();//Locating element by className and store its text to variable datentime.
	 //  System.out.print("\nTét dhihf");*/ 
	   
	  }
}
}