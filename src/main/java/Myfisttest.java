import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Myfisttest {
	private WebDriver driver;
	@Test
	public void verifySearch() {
	driver = new FirefoxDriver();
	driver.get("http://ww.google.com/");
	driver.quit();
}
}