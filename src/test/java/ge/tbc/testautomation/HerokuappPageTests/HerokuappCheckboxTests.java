package ge.tbc.testautomation.HerokuappPageTests;

import ge.tbc.testautomation.HerokuappPage.steps.HerokuappPageCheckboxesSteps;
import ge.tbc.testautomation.Util.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;
@Test(groups = {"Regression"})
public class HerokuappCheckboxTests extends TestConfig {
    HerokuappPageCheckboxesSteps herokuappPageCheckboxesSteps = new HerokuappPageCheckboxesSteps();

    @BeforeMethod
    public void startUp() {
        open(HEROKUAPP_CHECKBOX_PAGE);
    }


    public void checkboxesTest(){
        herokuappPageCheckboxesSteps
                .clickOnFirstCheckbox()
                .checkboxesCheckAssertion();
    }
}
