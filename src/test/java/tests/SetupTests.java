package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class SetupTests {
    private WebDriver driver;
    private static final String HOME_URL = "https://cloud.google.com/";
    private static final String YOPMAIL_URL  = "https://yopmail.com/";

    @BeforeTest
    public void profileSetup(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(HOME_URL);
    }
    @AfterMethod
    public void theEndOfTheMetod(){
        driver.close();
    }
    @AfterTest
    public void theEndOfTests(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public GCPCPage getGCPCPage(){
        return new GCPCPage(getDriver());
    }

    public EmailPage getEmailPage(){
        return new EmailPage(getDriver());
    }

    public void openYopMailPage(){
        driver.get(YOPMAIL_URL);
    }

    public YopMailPage getYopMailPage(){
        return new YopMailPage(getDriver());
    }

}
