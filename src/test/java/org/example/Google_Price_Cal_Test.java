package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Google_Price_Cal_Test {
    WebDriver driver;
    Google_Price_Calculate_App obj;
    @Test
    public void checkInformationInVmClassString() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        obj = new Google_Price_Calculate_App(driver);

        driver.get("https://cloud.google.com/products/calculator");

        driver.manage().window().maximize();
//        Thread.sleep(5000);
        obj.NumberOfInstancesField("4");
//        Thread.sleep(5000);
        obj.selectSeries();
        Thread.sleep(5000);
        obj.selectMachineType();
        Thread.sleep(5000);
        obj.AddGpusCheckBox();
        obj.selectTypeOfGpus();
        obj.selectNumberOfGpus();
        obj.selectLocalSsd();
        obj.selectDataCenterLocation();
        obj.selectCommittedUsage();
        obj.pushAddToEstimate();
        String vmClass=obj.getVmClassData().getText();
        Assert.assertEquals(vmClass,"Provisioning model: Regular");
    }
}
