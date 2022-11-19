package com.TestVagrant.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class customUtils {
    private static WebDriver driver=Driver.getDriver();
    private static final Logger LOG = LogManager.getLogger(customUtils.class);

    public static WebElement getDynamicXpath (String xpathValue, String substitutionValue ) {
        return driver.findElement(By.xpath(xpathValue.replace("DYNAMIC_VALUE", substitutionValue)));
    }

    public static void executeJS(String script,WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script,element);
        LOG.info("Successfully executed JS on element : {} [executeJS]", element);
    }

    public static void launchSite(String siteName){
        String url= Data.get(siteName);
        driver.get(url);
        LOG.info("Successfully opened site : {}", url);
    }

    public static void navigateSite(String siteName){
        String url= Data.get(siteName);
        driver.navigate().to(url);
        LOG.info("Successfully navigated to site : {}", url);
    }

    public static String formatImdbDate (String date){
        String newDate=date.replaceAll(",", "").trim();
        String[] arrOfNewDate = newDate.split(" ", -3);
        return ""+arrOfNewDate[1]+" "+arrOfNewDate[0]+" "+arrOfNewDate[2];
    }

    public static String formatWikiDate(String date){
        String newDate=date.trim();
        String[] arrOfNewDate = newDate.split(" ", -3);
        return ""+arrOfNewDate[0]+" "+arrOfNewDate[1]+" "+arrOfNewDate[2];
    }

}
