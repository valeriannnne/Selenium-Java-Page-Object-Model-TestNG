package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;

// using (implementing) the ITestListener and IAnnotationTransformer interfaces allow it to listen to test events and modify annotations at runtime.
public class SuiteListener implements ITestListener, IAnnotationTransformer {
	
    public void onTestFailure(ITestResult result) {
        String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
        File f1 = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f1, new File(filename + ".png")); // copies the screenshot (stored in f1) to the location specified by filename with a .png extension.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void transform(
    		ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    	annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}




