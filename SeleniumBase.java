package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class SeleniumBase {
   public WebDriver driver;
   @BeforeTest
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
    }
    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}