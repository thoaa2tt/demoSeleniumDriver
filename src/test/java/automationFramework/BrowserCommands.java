package automationFramework; // Nếu khai báo package này, thì trong file pom project lấy từ thư viện nào => các tra thư viện lấy ra từ file POM
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;//nếu sử dụng Junit cho việc build project with maven thì mới cần khai báo biến Test này 
 
public class BrowserCommands {
    private static WebDriver driver = null;
    @Test
     public static void main(String[] args) throws InterruptedException {
          // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
         //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        // chính là khoảng thời gian đưa ra thông báo hay ngoại lệ nếu bị t
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the markdown syntax
        driver.get("http://daringfireball.net/");
    // Storing Title name in String variable
        String sTitle = driver.getTitle();
        // Storing Title length in Int variable
        int iTitleLength = driver.getTitle().length();
        // Printing Title name on Console
        System.out.println(sTitle);
        // Printing Title length on console
        System.out.println(iTitleLength);
 
        // Storing URL in String variable
        sTitle = driver.getCurrentUrl();
        // Storing URL length in Int variable
        iTitleLength = driver.getCurrentUrl().length();
        // Printing URL on Console
        System.out.println(sTitle);
        // Printing URL length on console
        System.out.println(iTitleLength);
        // Refreshing current page
        driver.get(driver.getCurrentUrl());  
         // Storing Page Source in Strinsg variable
        String sPageSource = driver.getPageSource();
        // Storing Page Source length in Int variable
        int iPageSourceLength = driver.getPageSource().length();
        // Printing Page Source on console
        System.out.println(sPageSource);
        // Printing Page SOurce length on console
        System.out.println(iPageSourceLength);
         //Closing browser
        driver.close();
    }
    // Tạo ra một testcase
}