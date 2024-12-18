package ge.tbc.testautomation.Util;

import com.codeborne.selenide.Selenide;

public class ScreenshotUtil {

    public static void captureScreenshot(String testName) {
        String screenshotPath = Selenide.screenshot(testName);
        System.out.println("Screenshot saved: " + screenshotPath);
    }
}
