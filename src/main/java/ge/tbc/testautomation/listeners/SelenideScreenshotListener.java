package ge.tbc.testautomation.listeners;

import ge.tbc.testautomation.Util.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class SelenideScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("Test Failed: " + testName);

        byte[] screenshot = ScreenshotUtil.captureScreenshotAsBytes();

        Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }
}
