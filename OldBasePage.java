package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class OldBasePage {

    WebDriver driver;

    public OldBasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method returns the Selenium By type.
     * @param locatorType
     * @param locator
     * @return
     */
    public By getByType(String locatorType, String locator){
        if (locatorType.toLowerCase(Locale.ROOT).equals("css")){
            return By.cssSelector(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("xpath")) {
            return By.xpath(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("id")){
            return By.id(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("name")){
            return By.name(locator);
        } else {
            return By.tagName("");
        }
    }

    public WebElement getElement(String locatorType, String locator){
        By byType = getByType(locatorType, locator);
        WebElement elem = driver.findElement(byType);
        return elem;
    }

    public List<WebElement> getElements(String locatorType, String locator){
        By byType = getByType(locatorType, locator);
        List<WebElement> elems = driver.findElements(byType);
        return elems;
    }

    public void clickOnElement(String locatorType, String locator){
        getElement(locatorType, locator).click();
    }

    public void insertInto(String locatorType, String locator, String text){
        WebElement elem = getElement(locatorType, locator);
        elem.clear();
        elem.sendKeys(text);
    }

    /**
     * Use this method to check the web page title
     *
     * @param expectedTitle
     */
    public void checkPageTitle(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().equals(expectedTitle));
    }


    /**
     * The method to implement customs wait
     *
     * @param locator
     * @return
     */
    public boolean customTry(String locatorType, String locator) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 5) {
            try {
                getElement(locatorType, locator).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempts++;
        }
        return result;
    }

    /**
     * Use this method to go to web page menu item by locator and text
     *
     * @param itemText
     * @param locator
     */
    public void goToMenuItem(String itemText, String locatorType, String locator) {
        if (customTry(locatorType, locator)) {
            List<WebElement> items = getElements(locatorType, locator);
            boolean isItemExist = false;
            for (WebElement item : items) {
                if (item.getText().contains(itemText)) {
                    item.click();
                    isItemExist = true;
                    break;
                }
            }
            Assert.assertTrue(isItemExist);
        }
    }

    public void verifyMenuItemText(String itemText, String locatorType, String locator) {
        if (customTry(locatorType, locator)) {
            List<WebElement> items = getElements(locatorType, locator);
            boolean isItemExist = false;
            for (WebElement item : items) {
                if (item.getText().equals(itemText)) {
                    isItemExist = true;
                    Assert.assertTrue(isItemExist);
                    break;
                }
            }
            Assert.assertTrue(isItemExist);
        }
    }

    /**
     * Use this method to set delay by seconds between steps.
     * @param seconds
     * @throws InterruptedException
     */
    public void delay(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    /**
     * Use this method to set explicitly wait.
     * @param conditions
     */
    public void explicitlyWait(Function conditions){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(conditions);
    }

    public void checkAlertMessage(String message) throws InterruptedException{
        delay(1);
        String actualmessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualmessage, message, "The Registration Alert message not match");
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public void getUrl(String URL){
        driver.get(URL);
    }

    public void checkElemetText(String locatorType, String locator, String expectedText){
        WebElement elem = getElement(locatorType, locator);
        String actualText = elem.getText();
        Assert.assertEquals(actualText, expectedText, "The expected text from element not mutch");
    }
}
