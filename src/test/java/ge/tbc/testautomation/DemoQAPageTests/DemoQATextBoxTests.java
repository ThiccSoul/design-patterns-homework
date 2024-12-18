package ge.tbc.testautomation.DemoQAPageTests;

import ge.tbc.testautomation.DemoQAPage.steps.DemoQATextBoxSteps;
import ge.tbc.testautomation.Util.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;
@Test(groups = {"NewFeatureTesting"})
public class DemoQATextBoxTests extends TestConfig {
    DemoQATextBoxSteps demoQATextBoxSteps = new DemoQATextBoxSteps();

    @BeforeMethod
    public void startUp() {
        open(DEMOQA_PAGE);
    }


    public void DemoQAFormsTest(){
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
