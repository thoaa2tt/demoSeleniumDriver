import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class eventregistest {
	private WebDriver driver;
	@Test
	public void verifySearch() {
	driver = new FirefoxDriver();
	driver.get("http://eventregist.com/");
	driver.quit();
}
}
