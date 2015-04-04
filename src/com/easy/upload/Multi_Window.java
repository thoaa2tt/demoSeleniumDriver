package com.easy.upload;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
public class Multi_Window {
	WebDriver driver = new FirefoxDriver();
	 @Before
	 public void beforetest()
	 {
	  driver.manage().window().maximize();
	//  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	  driver.get("http://clip.vn/");
	 }
	 @After
	 public void aftertest()
	 {
	  driver.quit();	
	 }
	 @Test
	 public void Test () throws InterruptedException, IOException 
	  {
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Đăng nhập")).click();
		// Multiwindow popup 
	    driver.findElement(By.xpath(".//*[@id='myModal']/div[3]/div[2]/a[1]")).click(); //=> trả về kết quả pass trên file exel  mở ra giao diện 
	    Set<String> windowhandles=driver.getWindowHandles();
	    
		String  mainWindown=(String)windowhandles.toArray()[0];
		System.out.print("\nwindow2 handle code = "+windowhandles.toArray()[0]);
		
		String fbWindow=(String)windowhandles.toArray()[1];
		System.out.print("\nwindow2 handle code = "+windowhandles.toArray()[1]);
		
		driver.switchTo().window(fbWindow);
		// Tìm hiểu phần này đọc ra từ file excel như nào để làm theo hướng data driven để xét nhiều trường hợp và trả về kết quả theo từng trường hợp 
		driver.findElement(By.id("email")).sendKeys("thoaa2tt@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("beongoc");
		//To verify element is present on page or not.
		/* Boolean iselementpresent = driver.findElements(By.xpath("//div[@id='post-body-4292417847084983089']/div/button[1]")).size()!= 0;
		   if (iselementpresent == true)
		   {
		    System.out.println("\nTargeted element Is Present On The Page");
		   }
		   else
		   {
		    System.out.print("\nTargeted element Is Not Present On The Page");
		   => Câu hỏi: cách verify này sẽ dựa vào các kiểu dữ liệu của các trường. Ví dụ như với nghiệp vụ có logic phức phạp thì phải xét từng trường hợp hay là chỉ là dựa vào xem thuộc tính của trường đó nó là? 
		   }*/
		
		driver.findElement(By.id("u_0_2")).click();
		driver.switchTo().window(mainWindown);
		HighlightMyElement(driver.findElement(By.xpath(".//*[@id='search-bar']/form/div/input[1]")));
		driver.findElement(By.xpath(".//*[@id='search-bar']/form/div/input[1]")).sendKeys("hero");
		driver.findElement(By.xpath(".//*[@id='search-bar']/form/div/button")).click();
		 Thread.sleep(5000);
		// with multi window 
		 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		 Set<String> windowhandles1=driver.getWindowHandles();
		 String  mainWindown1=(String)windowhandles1.toArray()[0];
		 String newWindow=(String)windowhandles1.toArray()[1];
		  driver.switchTo().window(newWindow);
		  driver.get("http://clip.vn/watch/Dung-ngu-gat-khi-dang-lam-viec,R9GD/");
		 //Locate text string element to read It's font properties.
		  WebElement text = driver.findElement(By.xpath(".//*[@id='watch-content']/div[3]/h1"));
		 		  
		  //Read font-size property and print It In console.
		 String fontSize = text.getCssValue("font-size");
		 System.out.println("\n Font Size -> "+fontSize);
		  
		  //Read color property and print It In console.
		  String fontColor = text.getCssValue("color");
		  System.out.println("\n Font Color -> "+fontColor); 
		  // kết quả trả về in vào file excel thì như thế nào:
		  //Read font-family property and print It In console.
		  String fontFamily = text.getCssValue("font-family");
		  System.out.println("\n Font Family -> "+fontFamily);
		  //Read text-align property and print It In console.
		  String fonttxtAlign = text.getCssValue("text-align");
		  System.out.println("\n Font Text Alignment -> "+fonttxtAlign);
		  Thread.sleep(3000);
		  driver.close();
		  driver.switchTo().window(mainWindown1);
		  try{   
			   driver.switchTo().alert().dismiss();  
			  }catch(Exception e)
		      { 
			   System.out.println("unexpected alert not present");   
			  }
		 driver.findElement(By.xpath(".//*[@id='control-bar']/a")).click();
		 WebElement element = driver.findElement(By.name("file_upload"));
		 element.click();
//		Runtime.getRuntime().exec("/Home/Downloads/autoit-v3-setup.exe");
		//  element.sendKeys("/home/framgiavn/Desktop/Selenium .pdf");
	// Runtime.getRuntime().exec("/Home/Downloads/autoit-v3-setup.exe");
		 WinWaitActive("file_upload");
		 Send("/home/framgiavn/Downloads/abetteray.wav");   
		 Send("{ENTER}");
	      Thread.sleep(5000);
	  }
	 private void Send(String string) {
		// TODO Auto-generated method stub
		
	}
	private void WinWaitActive(String string) {
		// TODO Auto-generated method stub
		
	}
	public void HighlightMyElement(WebElement element) 
	 { 
		//  for (int i = 0; i < 10; i++) 
		//  { 
		   JavascriptExecutor javascript = (JavascriptExecutor) driver;
		   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: orange; border: 4px solid orange;");
		 //  javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: pink; border: 4px solid pink;");
		  // javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 4px solid yellow;");
		 //  javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, ""); 
		 //  } 
	 } 
}
