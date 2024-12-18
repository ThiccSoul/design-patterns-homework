package ge.tbc.testautomation.Util;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {

    public static byte[] captureScreenshotAsBytes() {
        return ((TakesScreenshot) Selenide.webdriver().object()).getScreenshotAs(OutputType.BYTES);
    }
}
