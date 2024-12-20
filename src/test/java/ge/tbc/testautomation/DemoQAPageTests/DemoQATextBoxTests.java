package ge.tbc.testautomation.DemoQAPageTests;

import ge.tbc.testautomation.DemoQAPage.steps.DemoQATextBoxSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.DEMOQA_PAGE;

@Epic("DemoQA Application Testing")
@Feature("Text Box Functionality")
@Test(groups = {"NewFeatureTesting"})
@Listeners(ge.tbc.testautomation.listeners.SelenideScreenshotListener.class)
public class DemoQATextBoxTests extends TestConfig {
    DemoQATextBoxSteps demoQATextBoxSteps = new DemoQATextBoxSteps();
    @BeforeMethod
    public void startUp() {
        open(DEMOQA_PAGE);
    }

    @Test(description = "Verify form data persistence after submission")
    @Story("Catching entered data in fields and asserting them")
    @Severity(SeverityLevel.MINOR)
    public void demoQAFormsTest() {
        demoQATextBoxSteps
                .fullNameFillInfo()
                .emailFillInfo()
                .currentAddressFillInfo()
                .permanentAddressFillInfo()
                .scrollToSubmitBtn()
                .submitForm()
                .pharagraphsAssertion();
    }
}
