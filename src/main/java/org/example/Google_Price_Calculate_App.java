package org.example;

import java.lang.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google_Price_Calculate_App
{
    WebDriver driver;
    public Google_Price_Calculate_App(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className="devsite-search-form")
    WebElement searchLogo;
    @FindBy(xpath="//input[@class='devsite-search-field devsite-search-query']")
    WebElement googleSearch;
    @FindBy(xpath="//body/section[@class='devsite-wrapper']/section[@id='gc-wrapper']/main[@role='main']/devsite-content/article[@class='devsite-article']/article[@class='devsite-article-inner']/div[@class='devsite-article-body']/devsite-catalog[@body-tag-name='devsite-cse']/div[@class='catalog-container']/div[@class='catalog-main']/div[@class='catalog-results-container']/devsite-cse[@name='results']/devsite-analytics-scope[@category='Site-Wide Custom Events']/div[@class='devsite-cse-results']/div/div[@id='___gcse_0']/div[@class='gsc-control-cse gsc-control-cse-en']/div[@class='gsc-control-wrapper-cse']/div[@class='gsc-results-wrapper-nooverlay gsc-results-wrapper-visible']/div[@class='gsc-wrapper']/div[@class='gsc-resultsbox-visible']/div[@class='gsc-resultsRoot gsc-tabData gsc-tabdActive']/div[@class='gsc-results gsc-webResult']/div[@class='gsc-expansionArea']/div[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement switchToCalculator;
    @FindBy(xpath="//iframe[contains(@name,'goog_')]")
    WebElement newFrame;
    @FindBy(xpath ="/html[1]/body[1]/md-content[1]/md-card[1]/div[1]/md-card-content[1]/div[2]/div[1]/md-card[1]/md-card-content[1]/div[1]/div[1]/form[1]/div[1]/div[1]/md-input-container[1]/input[1]")
    WebElement instanceField;
    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    WebElement cookiesOkBtn;







    @FindBy(xpath="//div[normalize-space()='Provisioning model: Regular']")
    WebElement vmClassData;
    @FindBy(xpath="//div[normalize-space()='Region: Frankfurt']")
    WebElement location;
    @FindBy(xpath="//div[normalize-space()='Commitment term: 1 Year']")
    WebElement commitedTime;
    @FindBy(xpath="//div[contains (text(),'Instance type: n1-standard-8')]")
    WebElement instanceData;
    @FindBy(xpath="//div[contains (text(),'Local SSD: 2x375 GiB')]")
    WebElement ssdData;
    @FindBy(xpath="//b[contains(text(),'Total Estimated Cost:')]")
    WebElement amount;



//    public void openGcpPage(String url){
//        driver.get(url);
//
//    }
    public void goToCloudCalculatorPage(String searchText) {
        searchLogo.click();
        googleSearch.click();
        googleSearch.sendKeys(searchText);
        googleSearch.sendKeys(Keys.ENTER);
        switchToCalculator.click();
    }
    public void NumberOfInstancesField(String NumberOfInstances) {
        driver.switchTo().frame(newFrame);
        //frame inside frame
        driver.switchTo().frame("myFrame");
        instanceField.sendKeys(NumberOfInstances);
    }
    public void ManageCookie() throws InterruptedException {

        if (cookiesOkBtn.isDisplayed()) {
            cookiesOkBtn.click();
            Thread.sleep(1000);
        }
    }

    @FindBy(xpath="//md-select[@name='series']/parent::md-input-container")
    WebElement series;

//    class="md-text ng-binding"
    @FindBy(xpath="//md-option[@id='select_option_212']")
    WebElement seriesType;
    public void selectSeries() throws InterruptedException {
        series.click();
        Thread.sleep(1000);
        seriesType.click();
    }
    //first select series then MachineType

    @FindBy(xpath="//label[text()='Machine type']/parent::md-input-container")
    WebElement machineTypeDropBox;
    @FindBy(xpath="//div[normalize-space()='n1-standard-8 (vCPUs: 8, RAM: 30GB)']")
    WebElement machineType;
    public void selectMachineType() throws InterruptedException {
        machineTypeDropBox.click();
        Thread.sleep(1000);
        machineType.click();
    }
    @FindBy(xpath="//md-checkbox[@aria-label='Add GPUs']")
    WebElement gpusCheckBox;
    @FindBy(xpath="//md-select[@placeholder='GPU type']")
    WebElement gpuTypeDropBox;
    public void AddGpusCheckBox() {
        gpusCheckBox.click();
    }
    @FindBy(xpath="//md-select[@placeholder='Number of GPUs']")
    WebElement numberOfGpusDropBox;
    @FindBy(xpath ="//md-option[@id='select_option_496']")
    WebElement numberOfGpus;
    @FindBy(xpath="//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement gpusType;
    public void selectTypeOfGpus() throws InterruptedException {
        gpuTypeDropBox.click();
        Thread.sleep(1000);
        gpusType.click();
    }
    public void selectNumberOfGpus() throws InterruptedException {
        numberOfGpusDropBox.click();
        Thread.sleep(500);
        numberOfGpus.click();
    }

    @FindBy(xpath="//md-select[@placeholder='Local SSD']")
    WebElement localSsdDropBox;
    @FindBy(xpath="//div[normalize-space()='2x375 GB']")
    WebElement localSsdModel;

    public void selectLocalSsd() throws InterruptedException {
        localSsdDropBox.click();
        Thread.sleep(1000);
        localSsdModel.click();
    }
    @FindBy(xpath="//md-select[@placeholder='Datacenter location']")
    WebElement dataCenterLocationDropBox;
    @FindBy(xpath="//md-option[@id='select_option_252']//div[@class='md-text ng-binding'][normalize-space()='Frankfurt (europe-west3)']")
    WebElement dataCenterLocation;
    public void selectDataCenterLocation() throws InterruptedException {
        dataCenterLocationDropBox.click();
        Thread.sleep(1000);
        dataCenterLocation.click();
    }
    @FindBy(xpath="//md-select[@placeholder='Committed usage']")
    WebElement commitedUageDropBox;
    @FindBy(xpath="//md-option[@id='select_option_133']")
    WebElement commitedUsageOneYear;
    public void selectCommittedUsage() throws InterruptedException {
        commitedUageDropBox.click();
        Thread.sleep(1000);
        commitedUsageOneYear.click();
    }
    @FindBy(xpath="//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']")
    WebElement addToEstimateButton;
    public void pushAddToEstimate() {
        addToEstimateButton.click();
    }
    public WebElement getVmClassData(){
        WebElement vmData=vmClassData;
        return vmData;
    }
    public WebElement getLocation(){
        WebElement loc=location;
        return loc;
    }
    public WebElement getCommitment(){
        WebElement time=commitedTime;
        return time;
    }
    public WebElement getInstanceType(){
        WebElement instance=instanceData;
        return instance;
    }
    public WebElement getSsdData(){
        WebElement ssd=ssdData;
        return ssd;
    }
    public WebElement getCost(){
        WebElement price=amount;
        return price;
    }
}
