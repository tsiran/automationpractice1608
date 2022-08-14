package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class APRegPage {
    WebDriver driver;
    BasePage basePage;


    public APRegPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Register(String password) throws Exception {
        basePage = new BasePage(driver);
        basePage.clickOnElement("id", "id_gender2");
        Thread.sleep(1000);
        basePage.filledTextField("id", "customer_firstname", "Olga");
        Thread.sleep(1000);
        basePage.filledTextField("id", "customer_lastname", "Anisimova");
        basePage.filledTextField("id", "passwd", password);
        Select drpDays = new Select(driver.findElement(By.id("days")));
        drpDays.selectByIndex(20);
        Thread.sleep(2000);
        Select drpMonths = new Select(driver.findElement(By.id("months")));
        drpMonths.selectByIndex(4);
        Thread.sleep(2000);
        Select drpYears = new Select(driver.findElement(By.id("years")));
        drpYears.selectByValue("2020");
        Thread.sleep(2000);
        basePage.filledTextField("id", "address1", "High street 15");
        Thread.sleep(1000);
        basePage.filledTextField("id", "city", "Birmingham");
        Thread.sleep(1000);
        Select drpState = new Select(driver.findElement(By.id("id_state")));
        drpState.selectByIndex(1);
        basePage.filledTextField("id", "postcode", "12151");
        Thread.sleep(2000);
        basePage.filledTextField("id", "phone_mobile", "+16992558989");
        Thread.sleep(1000);
        basePage.filledTextField("id", "alias", "My address for APractice");
        basePage.clickOnElement("id", "submitAccount");
        basePage.assertString(driver.getTitle(), "My account - My Store");
    }
}

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

//    }
//    public void assertString(String expectedString, String actualString){
//        Assert.assertEquals(actualString, expectedString);
//    }

