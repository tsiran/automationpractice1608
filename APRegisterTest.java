package Test;

import Base.SeleniumBase;
import Page.APRegFirst;
import Page.APRegPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Utils.Helpers;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;


public class APRegisterTest extends SeleniumBase {
    APRegPage apRegPage;
    APRegFirst apRegFirst;
    Helpers helpers;
    String emailField;
    String password;


    @Test
    public void APRegisterTest() throws Exception {
          apRegFirst = new APRegFirst(driver);
          helpers = new Helpers();
          apRegPage = new APRegPage(driver);
          String rndStr = helpers.randomStr(5);
          emailField=rndStr+"@gmail.com";
          apRegFirst.RegFirstPage(emailField);
          Thread.sleep(4000);
          String rndStr2 = helpers.randomStr(6);
          password = rndStr2;
          apRegPage.Register(password);
          Thread.sleep(2000);


//        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
//        driver.manage().window().maximize();

//        driver.get("http://automationpractice.com/index.php");
//        WebElement signInButton = driver.findElement(By.xpath("//*[contains(@title,'Log in to your customer account')]"));
//        signInButton.click();
//        WebElement emailField = driver.findElement(By.cssSelector("#email_create"));
//        emailField.clear();
//        Thread.sleep(1000);
//        emailField.sendKeys("test11408@gmail.com");
//        Thread.sleep(1000);
//        driver.findElement(By.id("SubmitCreate")).click();
//        driver.findElement(By.id("id_gender2")).click();
//        driver.findElement(By.id("customer_firstname")).sendKeys("Olga");
//        driver.findElement(By.id("customer_lastname")).sendKeys("Anisimova");
//        driver.findElement(By.id("passwd")).sendKeys("12345");
//        Thread.sleep(1000);
//        driver.findElement(By.id("days")).sendKeys("1");
//        Thread.sleep(1000);
//        driver.findElement(By.id("months")).sendKeys("January");
//        Thread.sleep(1000);
//        driver.findElement(By.id("years")).sendKeys("2020");
//        driver.findElement(By.id("address1")).sendKeys("High street 15");
//        driver.findElement(By.id("city")).sendKeys("Birmingham");
//        driver.findElement(By.id("id_state")).sendKeys("Alabama");
//        driver.findElement(By.id("postcode")).sendKeys("14142");
//        driver.findElement(By.id("phone_mobile")).sendKeys("+16992558787");
//        driver.findElement(By.id("alias")).sendKeys("My address");
//        driver.findElement(By.id("submitAccount")).click();

//        if(driver.getTitle().equals("My account - My Store")){
//            System.out.println("It's passed");
//        }else {
//            System.out.println("It's failed");
//        }
//        driver.quit();
    }
}