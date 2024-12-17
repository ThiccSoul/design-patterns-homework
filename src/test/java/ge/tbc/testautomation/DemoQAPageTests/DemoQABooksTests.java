package ge.tbc.testautomation.DemoQAPageTests;

import ge.tbc.testautomation.DemoQAPage.steps.DemoQABooksSteps;
import ge.tbc.testautomation.Util.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;
@Test(groups = {"NewFeatureTesting"})
public class DemoQABooksTests extends TestConfig {
    DemoQABooksSteps demoQABooksSteps = new DemoQABooksSteps();
    @BeforeMethod
    public void startUp() {
        open(DEMO_QA_BOOKS_PAGE);
    }

    public void DemoQAFormsTest(){
        demoQABooksSteps
                .filterBooks()
                .filterWithImg();
    }
}
