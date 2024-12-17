package ge.tbc.testautomation.Util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestConfig {

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser + ". Please specify 'chrome', 'firefox', or 'edge'."
                );
        }

        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
        Configuration.timeout = 10000;
    }
}
