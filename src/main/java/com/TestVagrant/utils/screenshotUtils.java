package com.TestVagrant.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

public class screenshotUtils{
    private static WebDriver driver=Driver.getDriver();
    private static final Logger LOG = LogManager.getLogger(screenshotUtils.class);

    public static String captureScreenshot(String tcName) {
        String fileName = (new Date()).toString().replace(" ","_").replace(":","_");
        String path = "\\reports\\screenshots\\";
        String filePath = System.getProperty("user.dir") + path + fileName +"_"+tcName+ ".png";
        try {
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotFile,new File(filePath));
            LOG.info("Screenshot captured at : {}", fileName );
        }
        catch (Exception e) {
            LOG.info("Unable to capture screenshot" );
            e.printStackTrace();
        }
        return fileName;
    }
}
