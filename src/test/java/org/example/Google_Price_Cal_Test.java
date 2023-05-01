package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Google_Price_Cal_Test {
    WebDriver driver;
    Google_Price_Calculate_App obj;
    String VM_Of_Class;
    String region;
    String S_S_D;
    String No_of_Instance;
    String Time_Taken;
    String Cost_of_USD;
    @Test
    public void checkInformationInVmClassString() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        obj = new Google_Price_Calculate_App(driver);

        driver.get("https://cloud.google.com/products/calculator");

        driver.manage().window().maximize();
        obj.Number_Of_Instances_Field("4");
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
        //Data Store from Object

        VM_Of_Class = obj.getVmClassData().getText();
        region=obj.getLocation().getText();
        S_S_D = obj.getSsdData().getText();
        No_of_Instance = obj.getInstanceType().getText();
        Time_Taken = obj.getCommitment().getText();
        Cost_of_USD = obj.getCost().getText();
    }
    @Test
    public void check_Data_is_correct()
    {
        Assert.assertEquals(VM_Of_Class,"Provisioning model: Regular");
        Assert.assertEquals(region,"Region: Frankfurt");
        Assert.assertEquals(S_S_D, "Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");
        Assert.assertEquals(No_of_Instance, "Instance type: n1-standard-8\n"+ "Committed Use Discount applied");
        Assert.assertEquals(Time_Taken, "Commitment term: 1 Year");
        Assert.assertEquals(Cost_of_USD, "Total Estimated Cost: USD 1,081.20 per 1 month");
    }

}
