package ge.tbc.testautomation.HerokuappPageTests;

import ge.tbc.testautomation.HerokuappPage.steps.HerokuappPageCheckboxesSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.HEROKUAPP_CHECKBOX_PAGE;

@Epic("Herokuapp Testing")
@Feature("Checkboxes Functionality")
@Test(groups = {"Regression"})
public class HerokuappCheckboxTests extends TestConfig {
    HerokuappPageCheckboxesSteps herokuappPageCheckboxesSteps = new HerokuappPageCheckboxesSteps();

    @BeforeMethod
    public void startUp() {
        open(HEROKUAPP_CHECKBOX_PAGE);
    }

    @Test(description = "Verify checkboxes functionality on Herokuapp")
    @Story("Validate checkbox selection and assertions")
    @Severity(SeverityLevel.MINOR)
    public void checkboxesTest() {
        herokuappPageCheckboxesSteps
                .clickOnFirstCheckbox()
                .checkboxesCheckAssertion();
    }
}
