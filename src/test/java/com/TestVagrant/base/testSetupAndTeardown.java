package com.TestVagrant.base;

import com.TestVagrant.utils.Driver;
import com.TestVagrant.utils.dataSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class testSetupAndTeardown extends Driver{
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openBrowser(){
        dataSetup.setPropertiesData();
        Driver.setDriver();
        this.driver= Driver.getDriver();
    }


    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        this.driver.close();
    }

}
