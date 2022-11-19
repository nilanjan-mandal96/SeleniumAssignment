package com.TestVagrant.testCases;

import com.TestVagrant.base.testSetupAndTeardown;
import com.TestVagrant.pageObjects.imdbDetailsPage;
import com.TestVagrant.pageObjects.imdbLandingPage;
import com.TestVagrant.pageObjects.wikiDetailsPage;
import com.TestVagrant.pageObjects.wikiLandingPage;
import com.TestVagrant.utils.Data;
import com.TestVagrant.utils.assertUtils;
import com.TestVagrant.utils.customUtils;
import com.TestVagrant.utils.dataSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class verifyMovieDetailsTest extends testSetupAndTeardown {

    private static final Logger LOG = LogManager.getLogger(verifyMovieDetailsTest.class);


    @Test(dataProvider = "getData")
    public void verifyMovie(HashMap<String,String> inputData){

        String movieName=inputData.get("movieName");
        LOG.info("Verifying Movie details for : {}", movieName);

        customUtils.launchSite("wikiUrl");

        wikiLandingPage wikiLanding = new wikiLandingPage(driver);
        wikiLanding.verifyPage();
        wikiLanding.search(movieName);

        wikiDetailsPage  wikiDetails = new wikiDetailsPage(driver);
        boolean isDiapalyed = wikiDetails.verifyPage();
        assertUtils.verifyTrue(isDiapalyed);
        isDiapalyed = wikiDetails.verifyReleaseDate();
        assertUtils.verifyTrue(isDiapalyed);
        wikiDetails.setReleaseDate();
        isDiapalyed = wikiDetails.verifyCountry();
        assertUtils.verifyTrue(isDiapalyed);
        wikiDetails.setCountry();

        customUtils.navigateSite("imdbUrl");

        imdbLandingPage imdbLanding = new imdbLandingPage(driver);
        imdbLanding.verifyPage();
        imdbLanding.search(movieName);

        imdbDetailsPage imdbDetails = new imdbDetailsPage(driver);
        isDiapalyed = imdbDetails.verifyPage();
        assertUtils.verifyTrue(isDiapalyed);
        isDiapalyed = imdbDetails.verifyReleaseDate();
        assertUtils.verifyTrue(isDiapalyed);
        imdbDetails.setReleaseDate();
        isDiapalyed = imdbDetails.verifyCountry();
        assertUtils.verifyTrue(isDiapalyed);
        imdbDetails.setCountry();

        String wikiCountry= Data.get("wikiCountry");
        String imdbCountry= Data.get("imdbCountry");
        assertUtils.verifyEquals(wikiCountry,imdbCountry,"Country do not match");

        String wikiReleaseDate= Data.get("wikiReleaseDate");
        String imdbReleaseDate= Data.get("imdbReleaseDate");
        assertUtils.verifyEquals(wikiReleaseDate,imdbReleaseDate,"Release Date do not match");

        LOG.info("Verifying Movie details for {} is successful", movieName);

    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{{dataSetup.setExcelData(1)},{dataSetup.setExcelData(2)}};

    }

}
