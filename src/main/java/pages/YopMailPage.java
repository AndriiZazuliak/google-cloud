package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopMailPage extends BasePage{

    @FindBy(xpath = "(//a[@href='email-generator'])[1]")
    WebElement randomEmailGenerator;
    @FindBy(xpath = "//div[@id='egen']")
    WebElement copyMail;
    @FindBy(xpath = "//button/i[text()='\uE5CC']")
    WebElement checkEmail;
    @FindBy(xpath = "//td[not(@*)]/h3")
    WebElement monthCost;
    @FindBy(xpath = "//iframe[@name='ifmail']")
    WebElement frame;

    public YopMailPage(WebDriver driver){
        super(driver);
    }
    public void clickRandomEmailGenerator(){
        randomEmailGenerator.click();
    }
    public String copyMail(){
        return copyMail.getAttribute("innerText");
    }
    public void clickAndCheckEmail(){
        checkEmail.click();
    }
    public void comeInYopFrame(){
        driver.switchTo().frame(frame);
    }
    public String getMonthCost(){
        return monthCost.getText();
    }
}
