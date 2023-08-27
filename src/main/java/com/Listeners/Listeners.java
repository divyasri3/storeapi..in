//package com.Listeners;
//
//
//import com.ExtentReports.ExtendReport;
//import com.ExtentReports.ExtentLogger;
//import org.testng.ISuite;
//import org.testng.ISuiteListener;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class Listeners implements ITestListener, ISuiteListener {
//
//
//    @Override
//    public void onStart(ISuite suite) {
//
//ExtendReport.initReports();
//    }
//
//    @Override
//    public void onFinish(ISuite suite) {
//        ExtendReport.tearDownReports();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtendReport.createTest(result.getName());
//
////        //find the author and category and then i need to call that extent report
////        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class).author();
////        ExtendReport.addAuthor(authors);
////        String[] category = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class).category();
////        ExtendReport.addCategory(category);
//
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//
//
//        ExtentLogger.pass(result.getName() + "is passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ExtentLogger.fail(result.getName() + "is failed");
//    }
//
//
//}