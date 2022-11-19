package com.TestVagrant.pageObjects;

import com.TestVagrant.utils.waitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wikiLandingPage extends wikiAbstractPage{
    private static WebDriver driver;

    private static final Logger LOG = LogManager.getLogger(wikiLandingPage.class);
    public wikiLandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="Welcome_to_Wikipedia") WebElement welcomeTiTle;


    public void verifyPage(){
        waitUtils.waitUntilElementVisible(welcomeTiTle);
        LOG.info("WIKI Landing Page Loaded");
    }
}
