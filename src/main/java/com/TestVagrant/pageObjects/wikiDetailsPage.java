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

public class wikiDetailsPage  extends wikiAbstractPage{
    private static WebDriver driver;

    private static final Logger LOG = LogManager.getLogger(wikiDetailsPage.class);
    public wikiDetailsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    String titleXpath="//h1/i[text()='DYNAMIC_VALUE']";
    @FindBy(xpath="//div[text()='Release date']/../../td/div/ul/li") WebElement releaseDateValue;
    @FindBy(xpath="//th[text()='Country']//following-sibling::td[@class='infobox-data']") WebElement countryValue;

    public boolean verifyPage(){
        String value= Data.get("movieName");
        WebElement title = customUtils.getDynamicXpath(this.titleXpath,value);
        waitUtils.waitUntilElementVisible(title);
        return commandUtils.isElementDisplayed(title);
    }

    public boolean verifyReleaseDate(){
        return commandUtils.isElementDisplayed(releaseDateValue);
    }

    public void setReleaseDate(){
        commandUtils.scrollToElement(releaseDateValue);
        String releaseDate=releaseDateValue.getText();
        String formattedDate= customUtils.formatWikiDate(releaseDate);
        Data.put("wikiReleaseDate",formattedDate);
        LOG.info("WIKI release date captured as : {}",formattedDate);
    }

    public boolean verifyCountry(){
        return commandUtils.isElementDisplayed(countryValue);
    }

    public void setCountry(){
        commandUtils.scrollToElement(countryValue);
        String country=countryValue.getText();
        Data.put("wikiCountry",country);
        LOG.info("WIKI country captured as : {}",country);
    }
}
