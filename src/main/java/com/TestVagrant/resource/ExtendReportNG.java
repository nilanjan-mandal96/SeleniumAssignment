package com.TestVagrant.resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Date;

public class ExtendReportNG {

    public static ExtentReports getReportObject(){
        String fileName = (new Date()).toString().replace(" ","_").replace(":","_");
        String path = "\\reports\\html";
        String filePath = System.getProperty("user.dir") + path + fileName + ".html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(filePath);
        reporter.config().setReportName("Automation assignment");
        reporter.config().setDocumentTitle("Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Assignment","Nilanjan");

        return extent;

    }
}
