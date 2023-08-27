package Extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportsDemo {

    @Test
    public void extentTest(){

        ExtentReports extent =new ExtentReports();
        ExtentSparkReporter spark= new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);


        ExtentTest test = extent.createTest("divya");
        test.log(Status.PASS,"this is passed");
        ExtentTest test1 = extent.createTest("divya123");
        test.log(Status.PASS,"this is passed");

        extent.flush();

    }


}
