package ge.tbc.testautomation.DemoQAPageTests;

import ge.tbc.testautomation.DemoQAPage.steps.DemoQABooksSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.DEMO_QA_BOOKS_PAGE;

@Epic("DemoQA Application Testing")
@Feature("Books Page Functionality")
@Test(groups = {"NewFeatureTesting"})
@Listeners(ge.tbc.testautomation.listeners.SelenideScreenshotListener.class)
public class DemoQABooksTests extends TestConfig {
    DemoQABooksSteps demoQABooksSteps = new DemoQABooksSteps();

    @BeforeMethod
    public void startUp() {
        open(DEMO_QA_BOOKS_PAGE);
    }

    @Test(description = "Test to filter books by criteria")
    @Story("Filter books by author and title")
    @Severity(SeverityLevel.MINOR)
    public void filterBooksTest() {
        demoQABooksSteps.filterBooks();
    }

    @Test(description = "Test to filter books with images")
    @Story("Display books with images only")
    @Severity(SeverityLevel.MINOR)
    public void filterBooksWithImageTest() {
        demoQABooksSteps.filterWithImg();
    }
}
