package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getWindowId(){
        return driver.getWindowHandle();
    }
    public void switchToNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public void switchToPreviousTab(String windowId){
        driver.switchTo().window(windowId);
    }
    public void waitForPageLoadComplete(long timeWait){  // завантаження сторінки
        new WebDriverWait(driver, Duration.ofSeconds(timeWait))
                .until(webDriver ->((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState;"));
    }
    public void waitForVisibility(long timeWait, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(timeWait))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
