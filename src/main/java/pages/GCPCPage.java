package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class GCPCPage extends BasePage{
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String OPERATING_SYSTEM_SOFTWARE = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    private static final String PROVISIONING_MODEL = "Regular";
    private static final String MACHINE_FAMILY = "General purpose";
    private static final String SERIES = "N1";
    private static final String MACHINE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String AMOUNT_OF_GPUS = "1";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    private static final String COMMITTED_USAGE = "1 Year";

    @FindBy(xpath = "//iframe[@allow]")
    WebElement firstFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    WebElement secondFrame;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement instances;
    @FindBy(xpath = "//md-select[@id='select_102']//div[@class='md-text']")
    WebElement operatingSystemSoftwareMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text' and contains(text(),'" + OPERATING_SYSTEM_SOFTWARE + "')]")
    WebElement operatingSystemSoftwareSelecting;
    @FindBy(xpath = "//md-select[@id='select_106']//div[@class='md-text']")
    WebElement provisioningModelMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text' and contains(text(),'" + PROVISIONING_MODEL + "')]")
    WebElement provisioningModelSelection;
    @FindBy(xpath = "//md-select[@id='select_112']//div[@class='md-text']")
    WebElement machineFamilyMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text' and contains(text(),'" + MACHINE_FAMILY + "')]")
    WebElement machineFamilySelection;
    @FindBy(xpath = "//md-select[@id='select_114']//div[@class='md-text ng-binding']")
    WebElement seriesNameMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text ng-binding' and contains(text(),'" + SERIES + "')]")
    WebElement seriesNameSelection;
    @FindBy(xpath = "//md-select[@id='select_116']//div[@class='md-text ng-binding']")
    WebElement machineTypeMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text ng-binding' and contains(text(),'" + MACHINE_TYPE + "')]")
    WebElement machineTypeSelection;
    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs' and contains(@ng-model, 'computeServer')]")
    WebElement checkAddGPU;
    @FindBy(xpath = "//md-select[@id='select_461']")
    WebElement gpuTypeMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text ng-binding' and contains(text(),'" + GPU_TYPE + "')]")
    WebElement gpuTypeSelection;
    @FindBy(xpath = "//md-select[@id='select_463']")
    WebElement amountOfGPUs;
    @FindBy(xpath = "//md-select[@id='select_418']")
    WebElement localSSDMenu;
    @FindBy(xpath = "//md-option/div[@class='md-text ng-binding' and contains(text(),'" + LOCAL_SSD + "')]")
    WebElement localSSDSelection;
    @FindBy(xpath = "//md-select[@id='select_122']")
    WebElement datacenterLocationMenu;
    @FindBy(xpath = "(//md-option/div[@class='md-text ng-binding' and contains(text(),'" + DATACENTER_LOCATION + "')])[3]")
    WebElement datacenterLocationSelection;
    @FindBy(xpath = "//md-select[@id='select_129']")
    WebElement committedUsageMenu;
    @FindBy(xpath = "(//md-option/div[@class='md-text' and contains(text(),'" + COMMITTED_USAGE + "')])[2]")
    WebElement committedUsageSelection;
    @FindBy(xpath = "//button[contains(text(),'Add to Estimate') and contains(@ng-disabled,'ComputeEngine')]")
    WebElement estimateButton;
    @FindBy(xpath = "//button[@id='email_quote']")
    WebElement emailEstimate;

    public void comeInFrame(){
        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(secondFrame);
    }
    public GCPCPage(WebDriver driver){
        super(driver);
    }
    public void insertAmountOfInstances(){
        instances.sendKeys(NUMBER_OF_INSTANCES);
    }
    public void insertOperatingSystemSoftware(){
        operatingSystemSoftwareMenu.click();
        operatingSystemSoftwareSelecting.click();
    }
    public void insertProvisioningModel(){
        provisioningModelMenu.click();
        provisioningModelSelection.click();
    }
    public void insertMachineFamily(){
        machineFamilyMenu.click();
        machineFamilySelection.click();
    }
    public void insertSeries(){
        seriesNameMenu.click();
        seriesNameSelection.click();
    }
    public void insertMachineType(){
        machineTypeMenu.click();
        machineTypeSelection.click();
    }
    public void setCheckAddGPU(){
        checkAddGPU.click();
    }
    public void insertGpuType(){
        gpuTypeMenu.click();
        gpuTypeSelection.click();
    }
    public void insertAmountOfGPUs(){
        amountOfGPUs.sendKeys(AMOUNT_OF_GPUS);
    }
    public void insertLocalSSD(){
        localSSDMenu.click();
        localSSDSelection.click();
    }
    public void insertDatacenterLocation(){
        datacenterLocationMenu.click();
        datacenterLocationSelection.click();
    }
    public void insertCommittedUsage(){
        committedUsageMenu.click();
        committedUsageSelection.click();
    }
    public void clickEstimate(){
        estimateButton.click();
    }
    public WebElement getEmailEstimate(){
        return emailEstimate;
    }
    public void clickEmailEstimate(){
        emailEstimate.click();
    }
}
