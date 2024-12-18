package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.DemosSteps;
import ge.tbc.testautomation.Util.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.TELERIK_DEMOS_PAGE;
@Test(groups = {"Smoke"})
public class DemosTests extends TestConfig{
    DemosSteps demosSteps = new DemosSteps();

    @BeforeMethod
    public void startUp() {
        open(TELERIK_DEMOS_PAGE);
    }

    @Test
    public void demosTests(){
        demosSteps
                .acceptCookie()
                .webcardsBackgroundColorAssert()
                .kendoUIHover()
                .kendoUIHoverTextAssert()
                .filterCards()
                .scrollToDesktop()
                .titleAppearingAssertion()
                .titleBackgroundOnHover();
    }
}
