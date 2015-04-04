package automationFramework;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.*;
import utility.constant;

// Import Package utility.*

import utility.ExcelUtils;
import appModules.SignIn_Action;

public class Apache_POI_TC {

    private static WebDriver driver = null;

public static void main(String[] args) throws Exception {

//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method

ExcelUtils.setExcelFile(constant.Path_TestData2 + "QTL_Sample_data.xls","Sheet1");

//driver = new FirefoxDriver();
System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get(constant.URL);
driver.findElement(By.xpath(".//*[@id='account']/a/span[1]")).click();
//nhap voi lenh switch 
for (int i = 1; i <=5; i++) {

switch(i){
case 1:
{
	String sUserName = ExcelUtils.getCellData(1, 1);
	String sPassword = ExcelUtils.getCellData(1, 2);
	driver.findElement(By.id("log")).sendKeys(sUserName);
	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	driver.findElement(By.id("login")).click();
	String str = driver.findElement(By.xpath(".//*[@id='ajax_loginform']/p[1]")).getText();
	if(str.equals("Please enter your username and password.") == true){
		System.out.println("Please enter your username and password.");
		ExcelUtils.setCellData2("Pass", 1, 3);
	Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message testcase1 display wrong");
		ExcelUtils.setCellData2("Fail", 1, 3);
		Thread.sleep(3000);
	}
	driver.navigate().refresh();
	break;
	
}
case 2:
{
	String sUserName = ExcelUtils.getCellData(2, 1);
	String sPassword = ExcelUtils.getCellData(2, 2);
	driver.findElement(By.id("log")).sendKeys(sUserName);
	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	driver.findElement(By.id("login")).click();
	String str = driver.findElement(By.xpath(".//*[@id='ajax_loginform']/p[1]")).getText();
	if(str.equals("ERROR: The username field is empty.") == true){
		System.out.println("Please enter your username");
		ExcelUtils.setCellData2("Pass", 2, 3);
		driver.findElement(By.id("pwd")).sendKeys("");
		Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message testcase2 display wrong");
		ExcelUtils.setCellData2("Fail", 2, 3);
		Thread.sleep(3000);
	}
	driver.navigate().refresh();
	break;
	
}
case 3:
{
	String sUserName = ExcelUtils.getCellData(3, 1);
	String sPassword = ExcelUtils.getCellData(3, 2);
	driver.findElement(By.id("log")).sendKeys(sUserName);
	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	driver.findElement(By.id("login")).click();
	String str = driver.findElement(By.xpath(".//*[@id='ajax_loginform']/p[1]")).getText();
	if(str.equals("ERROR: The password field is empty.") == true){
		System.out.println("Please enter your password.");
		ExcelUtils.setCellData2("Pass", 3, 3);
		driver.findElement(By.id("log")).sendKeys("");
		Thread.sleep(3000);
		
	}
	else
	{
		System.out.println("Message testcase3 display wrong");
		ExcelUtils.setCellData2("Fail", 3, 3);
		Thread.sleep(3000);
	}
	driver.navigate().refresh();
	break;
	
}
case 4:
{
	String sUserName = ExcelUtils.getCellData(4, 1);
	String sPassword = ExcelUtils.getCellData(4, 2);
	driver.findElement(By.id("log")).sendKeys(sUserName);
	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	driver.findElement(By.id("login")).click();
	String str = driver.findElement(By.xpath(".//*[@id='ajax_loginform']/p[1]")).getText();
	if(str.equals("ERROR: Invalid login credentials.") == true){
		System.out.println("Please enter your username and password vaid.");
		ExcelUtils.setCellData2("Pass", 4, 3);
		driver.findElement(By.id("log")).sendKeys("");
		driver.findElement(By.id("pwd")).sendKeys("");
		Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message testcase4 display wrong");
		ExcelUtils.setCellData2("Fail", 4, 3);
		Thread.sleep(3000);
	}
	driver.navigate().refresh();
	break;
}
case 5:
{
	String sUserName = ExcelUtils.getCellData(5, 1);
	String sPassword = ExcelUtils.getCellData(5, 2);
	driver.findElement(By.id("log")).sendKeys(sUserName);
	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	driver.findElement(By.id("login")).click();
	String str = driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).getText();
	if(str.equals("(Logout)") == true){
		System.out.println("Login success");
		ExcelUtils.setCellData2("Pass", 5, 3);
	}
	else
	{
		System.out.println("Message testcase5 display wrong");
		ExcelUtils.setCellData2("Fail", 5, 3);
	}
	break;
}
}
}


/*for(int i = 1; i <=5; i++){
	String sUserName = ExcelUtils.getCellData(i, 1);
	String sPassword = ExcelUtils.getCellData(i, 2);
	driver.findElement(By.xpath(".//*[@id='account']/a/span[1]")).click();
	driver.findElement(By.id("log")).sendKeys(sUserName);
	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	driver.findElement(By.id("login")).click();
	if(sUserName=="testuser_1" && sPassword=="Test@123"){
		System.out.println("Login Completed!!");
		break;
	}
	else{
		System.out.println("Login Fail, Please try again!!");
		ExcelUtils.setCellData("Fail", i, 3);
		
	}
}
*/


//SignIn_Action.Execute(driver);



//

driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();
//driver.quit();
//driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();
//driver.quit();
//ExcelUtils.setCellData("Pass", 5, 3);


//This is to send the PASS value to the Excel sheet in the result column.



}

}