package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(name = "q")
    WebElement query;

    public void isVisibleSearchSign(){
        query.isDisplayed();
    }
    public void searchByKeyword(final String keyword) {
        query.sendKeys(keyword, Keys.ENTER);
    }
    public HomePage(WebDriver driver){
        super(driver);
    }
}
