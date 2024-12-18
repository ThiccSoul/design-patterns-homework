package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.DemosSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.TELERIK_DEMOS_PAGE;

@Test(groups = {"Smoke"})
@Epic("Telerik Demos Testing")
@Feature("Web Cards, Hover Effects, and Filters")
@Listeners(ge.tbc.testautomation.listeners.SelenideScreenshotListener.class)
public class DemosTests extends TestConfig {
    DemosSteps demosSteps = new DemosSteps();

    @BeforeMethod
    public void startUp() {
        open(TELERIK_DEMOS_PAGE);
    }

    @Test(description = "Accept cookies, verify web cards background color, hover effects, and filter functionality.")
    @Story("Comprehensive Validation of Cookies, Cards, and Hover Effects")
    @Severity(SeverityLevel.NORMAL)
    public void validateCookiesCardsAndHoverEffects() {
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
