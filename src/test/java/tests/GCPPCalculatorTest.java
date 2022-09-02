package tests;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class GCPPCalculatorTest extends SetupTests{
    private static final String SEARCH_WORD = "Google Cloud Platform Pricing Calculator";
    private static final long WAIT_TIME = 10;

    @Test
    public void openHomePage() {

        String calkTab = getHomePage().getWindowId();
        getHomePage().switchToNewTab();  //переключаємося на нову вкладку
        // відкриваємо YopMail і генеруємо нову поштову скриньку
        openYopMailPage();
        String yopTab = getYopMailPage().getWindowId();  // запам'ятовуємо ID вкладки YopMail
        getYopMailPage().clickRandomEmailGenerator();
        getYopMailPage().waitForPageLoadComplete(WAIT_TIME);
        String mailName = getYopMailPage().copyMail();    // записуємо назву поштової скриньки
            System.out.println("mailName = " + mailName);
        getYopMailPage().switchToPreviousTab(calkTab);  //переключаємося на попередню вкладку
        // працюємо з основним вікном
        getHomePage().waitForPageLoadComplete(WAIT_TIME);
        getHomePage().isVisibleSearchSign();
        getHomePage().searchByKeyword(SEARCH_WORD);
        getSearchResultPage().waitForVisibility(WAIT_TIME, getSearchResultPage().getCalculator());
        getSearchResultPage().chooseCalculator();
        getGCPCPage().waitForPageLoadComplete(WAIT_TIME);
        getGCPCPage().comeInFrame();
        getGCPCPage().insertAmountOfInstances();
        getGCPCPage().insertOperatingSystemSoftware();
        getGCPCPage().insertProvisioningModel();
        getGCPCPage().insertMachineFamily();
        getGCPCPage().insertSeries();
        getGCPCPage().insertMachineType();
        getGCPCPage().setCheckAddGPU();
        getGCPCPage().insertGpuType();
        getGCPCPage().insertAmountOfGPUs();
        getGCPCPage().insertLocalSSD();
        getGCPCPage().insertDatacenterLocation();
        getGCPCPage().insertCommittedUsage();
        getGCPCPage().clickEstimate();
        getGCPCPage().waitForVisibility(WAIT_TIME, getGCPCPage().getEmailEstimate());
        getGCPCPage().clickEmailEstimate();
        getEmailPage().inputEmail(mailName);
        getEmailPage().clickSendEmail();
        String calcEstimation = getEmailPage().getEstimation(); // записуємо текст з розрахунками
        System.out.println("calcEstimation = " + calcEstimation);
        // переключаємося на сторінку електронної пошти
        getEmailPage().switchToPreviousTab(yopTab);
        getYopMailPage().waitForPageLoadComplete(WAIT_TIME);
        getYopMailPage().clickAndCheckEmail();
        getYopMailPage().waitForPageLoadComplete(WAIT_TIME);
        getYopMailPage().comeInYopFrame();
        String mailEstimation = getYopMailPage().getMonthCost(); // записуємо текст отриманих поштою розрахунків
        System.out.println("mailEstimation = " + mailEstimation);
        Pattern pattern = Pattern.compile(".*" + mailEstimation + ".*");
        Matcher matcher = pattern.matcher(calcEstimation);
        assertTrue(matcher.matches());
    }
}
