package Extent;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public  final class ExtentLogger {

    private  ExtentLogger(){}

    public static  void pass (String  msg)
    {

        ExtentManager.getTest().pass(msg);
    }
    public static  void fail (String  msg)
    {

        ExtentManager.getTest().fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
    }
    public static  void info (String  msg)
    {

        ExtentManager.getTest().info(msg);
    }


    public static  void logResponse(String msg ){


        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(msg, CodeLanguage.JSON));

    }
}
