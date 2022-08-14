package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class APRegFirst {
    WebDriver driver;
    BasePage basePage;

    public APRegFirst(WebDriver driver) {
        this.driver = driver;
    }
    public void RegFirstPage(String emailField) throws Exception{
        basePage =new BasePage(driver);
        basePage.getUrl("http://automationpractice.com/index.php");
        basePage.clickOnElement("xpath", "//*[contains(@title,'Log in to your customer account')]");
        basePage.filledTextField("css", "#email_create", emailField);
        basePage.clickOnElement("id","SubmitCreate");

//        driver.get("http://automationpractice.com/index.php");
//        WebElement signInButton = driver.findElement(By.xpath("//*[contains(@title,'Log in to your customer account')]"));
//        signInButton.click();
//        WebElement emailFiel = driver.findElement(By.cssSelector("#email_create"));
//        emailFiel.clear();
//        Thread.sleep(1000);
//        emailFiel.sendKeys(emailField);
//        Thread.sleep(1000);
//        driver.findElement(By.id("SubmitCreate")).click();
    }
}
