package demoSeleniumDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;

public  class FirsTestCase {
	private static  WebDriver a = null;
	
	 public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		 a = new ChromeDriver();
              
		// a = new FirefoxDriver();
           //a= new ChromeDriver();
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
         a.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          
        //Launch the Online Store Website
           a.get("http://www.store.demoqa.com");

        // Find the element that's ID attribute is 'account'(My Account) 
          a.findElement(By.xpath(".//*[@id='account']/a")).click();

        // Find the element that's ID attribute is 'log' (Username)

        // Enter Username on the element found by above desc.

        a.findElement(By.id("log")).sendKeys("testuser_1"); 

        // Find the element that's ID attribute is 'pwd' (Password)

        // Enter Password on the element found by the above desc.

        a.findElement(By.id("pwd")).sendKeys("Test@123");

        // Now submit the form. WebDriver will find the form for us from the element 

        a.findElement(By.id("login")).click();

        // Print a Log In message to the screen

        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

        // Find the element that's ID attribute is 'account_logout' (Log Out)

        a.findElement (By.xpath(".//*[@id='account_logout']/a")).click();

        // Close the driver

        a.quit();

            }

    }
