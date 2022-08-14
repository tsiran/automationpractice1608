package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Locale;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method returns the Selenium By type.
     *
     * @param locatorType
     * @param locator
     * @return
     */
    public By getByType(String locatorType, String locator) {
        if (locatorType.toLowerCase(Locale.ROOT).equals("css")) {
            return By.cssSelector(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("xpath")) {
            return By.xpath(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("id")) {
            return By.id(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("name")) {
            return By.name(locator);
        } else {
            return By.tagName("");
        }
    }

    public WebElement getElement(String locatorType, String locator) {
        By byType = getByType(locatorType, locator);
        WebElement elem = driver.findElement(byType);
        return elem;
    }

    public void clickOnElement(String locatorType, String locator) {
        getElement(locatorType, locator).click();
    }

    public void filledTextField(String locatorType, String locator, String inputText) {
        WebElement elem = getElement(locatorType, locator);
        elem.clear();
        elem.sendKeys(inputText);
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void assertString(String actualString, String expectedString) {
        Assert.assertEquals(actualString, expectedString);
    }
}