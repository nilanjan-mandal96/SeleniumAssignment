package com.TestVagrant.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.TestVagrant.utils.waitUtils.waitUntilElementToBeClickable;

public class commandUtils {
    private static WebDriver driver=Driver.getDriver();
    private static final Logger LOG = LogManager.getLogger(commandUtils.class);


    public static void click(WebElement element)
    {
        try {
            waitUntilElementToBeClickable(element);
            element.click();
            LOG.info("Successfully clicked on element : {}", element);
        }catch(ElementClickInterceptedException e){
            try {
                customUtils.executeJS("arguments[0].click();", element);
                LOG.info("Successfully clicked on element : {} [executeJS]", element);
            }catch(Exception e2){
                LOG.error("Unable to click on element : {} [executeJS]", element);
                e2.printStackTrace();
                throw e2;
            }
        }catch(Exception e){
            LOG.error("Unable to click on element : {}", element);
            e.printStackTrace();
            throw e;
        }
    }

    public static void type(WebElement element, String value) {
        try {
            waitUtils.waitUntilElementVisible(element);
            element.sendKeys(value);
            LOG.info("Successfully typed [{}] on element : {}", value, element);
        }catch(Exception e) {
            LOG.error("Unable to type on element : {}", element);
            e.printStackTrace();
            throw e;
        }
    }
    public static void pressKey(WebElement element, Keys key) {
        try {
            waitUtils.waitUntilElementVisible(element);
            element.sendKeys(key);
            LOG.info("Successfully pressed [{}] on element : {}", key.toString(), element);
        }catch(Exception e) {
            LOG.error("Unable to pressed [{}] on element : {}",key.toString(), element);
            e.printStackTrace();
            throw e;
        }
    }
    public static boolean isElementDisplayed(WebElement element) {
        try {
            if (element.isDisplayed()) {
                LOG.info("Locator is present : {}", element);
                return true;
            } else {
                LOG.info("Locator is not present : {}", element);
                return false;
            }
        } catch (NoSuchElementException e) {
            LOG.info("Locator is not present : {}", element);
            return false;
        }
    }

    public static void scrollToElement(WebElement element) {
        try {
            waitUtils.waitUntilElementVisible(element);
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
            LOG.info("Successfully Moved to element : {}", element);
        } catch (Exception e) {
            LOG.error("Unable to move to element : {}", element);
            e.printStackTrace();
            throw e;
        }
    }




}
