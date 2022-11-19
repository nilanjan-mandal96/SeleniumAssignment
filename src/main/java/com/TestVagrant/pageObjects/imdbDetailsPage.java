package com.TestVagrant.pageObjects;

import com.TestVagrant.utils.Data;
import com.TestVagrant.utils.commandUtils;
import com.TestVagrant.utils.customUtils;
import com.TestVagrant.utils.waitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class imdbDetailsPage extends imdbAbstractPage{
    private static WebDriver driver;
    private static final Logger LOG = LogManager.getLogger(imdbDetailsPage.class);

    public imdbDetailsPage(WebDriver driver){
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);

    }

    String titleXpath="//h1[contains(.,'DYNAMIC_VALUE')]";
    @FindBy(xpath="//a[text()='Release date']/../div/ul/li/a") WebElement releaseDateValue;
    @FindBy(xpath="//button[text()='Country of origin']/../div/ul/li/a") WebElement countryValue;

    public boolean verifyPage(){
        String value= Data.get("movieName");
        WebElement title = customUtils.getDynamicXpath(this.titleXpath,value);
        waitUtils.waitUntilElementVisible(title);
        Boolean displayed= commandUtils.isElementDisplayed(title);
        return displayed;
    }

    public boolean verifyReleaseDate(){
        Boolean displayed=commandUtils.isElementDisplayed(releaseDateValue);
        return displayed;
    }

    public void setReleaseDate(){
        commandUtils.scrollToElement(releaseDateValue);
        String releaseDate=releaseDateValue.getText();
        String formattedDate= customUtils.formatImdbDate(releaseDate);
        Data.put("imdbReleaseDate",formattedDate);
        LOG.info("IMDB release date captured as : {}",formattedDate);
    }

    public boolean verifyCountry(){
        Boolean displayed=commandUtils.isElementDisplayed(countryValue);
        return displayed;
    }

    public void setCountry(){
        commandUtils.scrollToElement(countryValue);
        String country=countryValue.getText();
        Data.put("imdbCountry",country);
        LOG.info("IMDB country captured as : {}",country);
    }


}
