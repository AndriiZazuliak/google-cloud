package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends BasePage{

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendEmail;
    @FindBy(xpath = "//h2[@class='md-title']/b")
    WebElement estimation;

    public String getEstimation(){
        return estimation.getAttribute("outerText");
    }
    public void inputEmail(String mail){
        emailInput.sendKeys(mail);
    }
    public void clickSendEmail(){
        sendEmail.click();
    }
    public EmailPage(WebDriver driver){
        super(driver);
    }
}
