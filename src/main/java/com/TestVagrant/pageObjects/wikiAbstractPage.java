package com.TestVagrant.pageObjects;

import com.TestVagrant.utils.Data;
import com.TestVagrant.utils.commandUtils;
import com.TestVagrant.utils.customUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wikiAbstractPage {
    private WebDriver driver;

    private static final Logger LOG = LogManager.getLogger(wikiAbstractPage.class);
    public wikiAbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    String searchValueXpath="(//div[@class='suggestions-results']/a/div/span[contains(.,'DYNAMIC_VALUE')])[1]";
    @FindBy(name="search") WebElement searchField;

    public void search(String value){
        Data.put("movieName",value);
        commandUtils.click(searchField);
        commandUtils.type(searchField,value);
        WebElement searchValue = customUtils.getDynamicXpath(this.searchValueXpath,value);
        commandUtils.click(searchValue);
        LOG.info("WIKI search was successful for : {}", value);
    }
}
