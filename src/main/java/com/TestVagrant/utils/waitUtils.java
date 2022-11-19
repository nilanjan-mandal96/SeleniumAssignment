package com.TestVagrant.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtils {
    private static WebDriver driver=Driver.getDriver();
    private static final long commonWait=15;
    private static final Logger LOG = LogManager.getLogger(waitUtils.class);

    public static void waitUntilElementVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, commonWait);
            wait.until(ExpectedConditions.visibilityOf(element));
            LOG.info("Successfully located element and the element is visible : {}", element);
        }catch (Exception e) {
            LOG.error("The element is not present : {}", element);
            e.printStackTrace();
            throw e;
        }
    }

    public static void waitUntilElementToBeClickable(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, commonWait);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            LOG.info("Successfully located element and element is clickable : {}", element);
        } catch (Exception e) {
            LOG.error("Unable to locate element : {}", element);
            e.printStackTrace();
            throw e;
        }
    }




}
