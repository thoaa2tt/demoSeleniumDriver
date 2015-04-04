package demoSeleniumDriver;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.http.util.Asserts;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.*;
import utility.constant;

// Import Package utility.*

import utility.ExcelUtils;

public class Search {
	private static WebDriver driver = null;
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(constant.Path_TestData1 + constant.File_TestData1,"Sheet1");
       // open URL http://amazon247.vn
		driver.get(constant.URL1);
		//nhap voi lenh switch 
		for (int i = 1; i <=5; i++) {

		switch(i){
		case 1:
		{
			String sKey = ExcelUtils.getCellData(1, 1);
			driver.findElement(By.name("field-keywords")).sendKeys(sKey);
			driver.findElement(By.name("field-keywords")).sendKeys(Keys.ENTER);
			Thread.sleep(20000);
			//driver.findElement(By.xpath(".//*[@id='searchBar']/div/div/form/input[2]")).click();
			String str = driver.findElement(By.xpath(".//*[@id='searchBar']/div/div/form/input[1]")).getText();
			boolean Issearch = driver.findElement(By.xpath(".//*[@id='searchDetail']")).getSize() == null;
			String str1 = driver.findElement(By.xpath(".//*[@id='searchDetail']")).getText();
			if(str.equalsIgnoreCase(str1) == true && Issearch == true ){
				System.out.println("Khong co ket qua tim kiem");
				ExcelUtils.setCellData1("Pass", 1, 2);
			
			}
			else
			{
				System.out.println("hien thi ket qua search khi khong nhap data");
				ExcelUtils.setCellData1("Fail", 1, 2);
				
			}
		//	driver.navigate().refresh();
			Thread.sleep(1000);
			break;
			
		}
		
		case 2:
		{
		
			String sKey = ExcelUtils.getCellData(2, 1);
			driver.findElement(By.name("field-keywords")).sendKeys(sKey);
			driver.findElement(By.name("field-keywords")).sendKeys(Keys.ENTER);
			Thread.sleep(40000);
			String str = driver.findElement(By.xpath(".//*[@id='searchBar']/div/div/form/input[1]")).getText();
			String str1 = driver.findElement(By.xpath(".//*[@id='noResultsTitle']")).getText();
			if(str.equals(str1) == true ){
				System.out.println("Please enter again, did not match any products.");
				ExcelUtils.setCellData("Pass", 2, 2);
			
			}
			else
			{
				System.out.println("display result diffrent keyword");
				ExcelUtils.setCellData("Fail", 2, 2);
				
			}
			driver.navigate().to("http://amazon247.vn");
			//Thread.sleep(3000);
			break;
			
		}
		
		case 3:
		{
			String sKey = ExcelUtils.getCellData(3, 1);
			driver.findElement(By.name("field-keywords")).sendKeys(sKey);
			driver.findElement(By.name("field-keywords")).sendKeys(Keys.ENTER);
			Thread.sleep(20000);
			String str = driver.findElement(By.xpath(".//*[@id='searchBar']/div/div/form/input[1]")).getText();
			boolean Issearch = driver.findElement(By.xpath(".//*[@id='searchDetail']")).getSize() == null;
			String str1 = driver.findElement(By.xpath(".//*[@id='searchDetail']")).getText();
			if(str.equals(str1) && Issearch != true ){
				System.out.println(Issearch);
				ExcelUtils.setCellData("Pass", 3, 2);
			//Thread.sleep(3000);
			}
			else
			{
				System.out.println("display result wrong ");
				ExcelUtils.setCellData("Fail", 3, 2);
				//Thread.sleep(3000);
			}
			//driver.navigate().refresh();
			//Thread.sleep(1000);
			break;
		}
		
		}
	
		}


		

		}

		
	}


