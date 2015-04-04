package demoSeleniumDriver;
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

public class DangNhap {

private static WebDriver driver = null;

public static void main(String[] args) throws Exception {

//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method

//ExcelUtils.setExcelFile(constant.Path_TestData + constant.File_TestData,"Sheet1");

driver = new FirefoxDriver();
//System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
//driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get(constant.URL1);
driver.findElement(By.xpath(".//*[@id='loginBar']")).click();
//nhap voi lenh switch 
for (int i = 1; i <=5; i++) {

switch(i){
// Log in with email ad pass blank 
case 1:
{
	String sUserName = ExcelUtils.getCellData(1, 1);
	String sPassword = ExcelUtils.getCellData(1, 2);
	driver.findElement(By.name("email")).sendKeys(sUserName);
	driver.findElement(By.name("password")).sendKeys(sPassword);
	driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
	String str = driver.findElement(By.xpath(".//*[@id='email-error']")).getText();
	String str1 = driver.findElement(By.xpath(".//*[@id='password-error']")).getText();
	if(str.equals("Vui lòng nhập Email.") == true && str1.equals("Vui lòng nhập mật khẩu.") == true ){
		System.out.println("Please enter your email and password.");
		ExcelUtils.setCellData("Pass", 1, 3);
	//Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message of testcase email , password display wrong");
		ExcelUtils.setCellData("Fail", 1, 3);
		
	}
	driver.navigate().refresh();
	Thread.sleep(1000);
	break;
	
}
//log in vith email blank 
case 2:
{
	driver.findElement(By.xpath(".//*[@id='loginBar']")).click();
	String sUserName = ExcelUtils.getCellData(2, 1);
	String sPassword = ExcelUtils.getCellData(2, 2);
	driver.findElement(By.name("email")).sendKeys(sUserName);
	driver.findElement(By.name("password")).sendKeys(sPassword);
	driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
	String str = driver.findElement(By.xpath(".//*[@id='email-error']")).getText();
	if(str.equals("Vui lòng nhập Email.") == true ){
		System.out.println("Please enter your email.");
		ExcelUtils.setCellData("Pass", 2, 3);
	//Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message testcase2 display wrong");
		ExcelUtils.setCellData("Fail", 2, 3);
		//Thread.sleep(3000);
	}
	driver.navigate().refresh();
	Thread.sleep(1000);
	break;
	
}
//log in with pwd blank 
case 3:
{
	driver.findElement(By.xpath(".//*[@id='loginBar']")).click();
	String sUserName = ExcelUtils.getCellData(3, 1);
	String sPassword = ExcelUtils.getCellData(3, 2);
	driver.findElement(By.name("email")).sendKeys(sUserName);
	driver.findElement(By.name("password")).sendKeys(sPassword);
	driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
	String str = driver.findElement(By.xpath(".//*[@id='password-error']")).getText();
	if(str.equals("Vui lòng nhập mật khẩu.") == true ){
		System.out.println("Please enter your password.");
		ExcelUtils.setCellData("Pass", 3, 3);
	//Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message of testcase not enter password display wrong");
		ExcelUtils.setCellData("Fail", 3, 3);
		//Thread.sleep(3000);
	}
	driver.navigate().refresh();
	Thread.sleep(1000);
	break;
	
}
//log in with email and pass invalid
case 4:
{
	driver.findElement(By.xpath(".//*[@id='loginBar']")).click();
	String sUserName = ExcelUtils.getCellData(4, 1);
	String sPassword = ExcelUtils.getCellData(4, 2);
	driver.findElement(By.name("email")).sendKeys(sUserName);
	driver.findElement(By.name("password")).sendKeys(sPassword);
	driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
	String str = driver.findElement(By.xpath(".//*[@id='email-error']")).getText();
	if(str.equals("Vui lòng nhập đúng định dạng email. Ví dụ : support@amazon247.vn.") == true){
		System.out.println("Please enter your email and password valid.");
		ExcelUtils.setCellData("Pass", 4, 3);
		//Thread.sleep(3000);
	}
	else
	{
		System.out.println("Message of testcase eneter email and pwd invalid display wrong");
		ExcelUtils.setCellData("Fail", 4, 3);
		//Thread.sleep(3000);
	}
	driver.navigate().refresh();
	Thread.sleep(1000);
	break;
}
//log in with email and pass valid
case 5:
{
	driver.findElement(By.xpath(".//*[@id='loginBar']")).click();
	String sUserName = ExcelUtils.getCellData(5, 1);
	String sPassword = ExcelUtils.getCellData(5, 2);
	driver.findElement(By.name("email")).sendKeys(sUserName);
	driver.findElement(By.name("password")).sendKeys(sPassword);
	driver.findElement(By.xpath(".//*[@id='frmLogin']/button")).click();
	String str = driver.findElement(By.xpath(".//*[@id='loginBar']")).getText();
	if(str.equals("Xin chào Hiến") == true){
		System.out.println("Login success");
		ExcelUtils.setCellData("Pass", 5, 3);
	}
	else
	{
		System.out.println("Message of testcase enter email and pwd valid display wrong");
		ExcelUtils.setCellData("Fail", 5, 3);
	}
	break;
}
default:
	System.out.println("Khong vao cac truong hop tren ");
	break;
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
driver.findElement(By.id("loginBar")).click();
driver.findElement(By.xpath(".//*[@id='userFunction']/a[6]")).click();
driver.quit();
//driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();
//driver.quit();
//ExcelUtils.setCellData("Pass", 5, 3);


//This is to send the PASS value to the Excel sheet in the result column.



}

}