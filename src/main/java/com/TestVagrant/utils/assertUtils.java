package com.TestVagrant.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class assertUtils {
    private static final long commonWait=15;

    private static final Logger LOG = LogManager.getLogger(assertUtils.class);


    public static void verifyEquals(Object expectedValue, Object actualValue, String failMessage)
    {
        Assert.assertEquals(actualValue,expectedValue,failMessage);
        LOG.info("Successfully verified result: {}", String.valueOf(expectedValue));

    }

    public static void verifyEquals(Object expectedValue, Object actualValue)
    {
        Assert.assertEquals(actualValue,expectedValue);
        LOG.info("Successfully verified result: {}", String.valueOf(expectedValue));

    }

    public static void verifyTrue(Boolean actualValue)
    {
        Assert.assertTrue(actualValue);
        LOG.info("Successfully verified result: {}", true);

    }




}
