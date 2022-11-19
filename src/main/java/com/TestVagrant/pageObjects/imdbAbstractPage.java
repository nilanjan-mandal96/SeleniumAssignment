package com.TestVagrant.pageObjects;

import com.TestVagrant.utils.commandUtils;
import com.TestVagrant.utils.customUtils;
import com.TestVagrant.utils.Data;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class imdbAbstractPage {
    private static WebDriver driver;
    private static final Logger LOG = LogManager.getLogger(imdbAbstractPage.class);

    public imdbAbstractPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }


    String searchValueXpath="//a[@data-testid='search-result--const']/div[contains(.,'DYNAMIC_VALUE')]";
    @FindBy(id="suggestion-search") WebElement searchField;


    public void search(String value){
        Data.put("movieName",value);
        commandUtils.click(searchField);
        commandUtils.type(searchField,value);
        WebElement searchValue = customUtils.getDynamicXpath(this.searchValueXpath,value);
        commandUtils.click(searchValue);
        LOG.info("IMDB search was successful for : {}", value);
    }
}
