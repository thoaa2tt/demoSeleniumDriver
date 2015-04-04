package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

private static WebElement element = null;

public static WebElement lnk_MyAccount(WebDriver driver){

element = driver.findElement(By.id("account"));
System.out.println(element.isEnabled());
element.sendKeys(Keys.ENTER);

return element;

}

public static WebElement lnk_LogOut(WebDriver driver){

element = driver.findElement(By.id("account_logout"));

return element;

}

}
