package ge.tbc.testautomation.listeners;
import ge.tbc.testautomation.Util.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SelenideScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("Test Failed: " + testName);
        ScreenshotUtil.captureScreenshot(testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }
}
