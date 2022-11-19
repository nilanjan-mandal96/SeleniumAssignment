package com.TestVagrant.pageObjects;

import com.TestVagrant.utils.waitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class imdbLandingPage extends imdbAbstractPage{
    private WebDriver driver;

    private static final Logger LOG = LogManager.getLogger(imdbLandingPage.class);
    public imdbLandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="#home_img") WebElement logo;

    public void verifyPage(){
        waitUtils.waitUntilElementVisible(logo);
        LOG.info("IMDB Landing Page Loaded");
    }


}
