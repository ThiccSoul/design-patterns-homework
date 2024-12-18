package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.PricingSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.TELERIK_DEMOS_PAGE;

@Test(groups = {"Smoke"})
@Epic("Telerik UI Testing")
@Feature("Pricing Page Validation")
@Listeners(ge.tbc.testautomation.listeners.SelenideScreenshotListener.class)
public class PricingPageTests extends TestConfig {

    PricingSteps pricingSteps = new PricingSteps();

    @BeforeMethod
    public void startUp() {
        open(TELERIK_DEMOS_PAGE);
    }

    @Test(description = "Validate correct calculation of the sales and total prices")
    @Story("Validate Pricing Page Offer Details and Features")
    @Severity(SeverityLevel.CRITICAL)
    public void pricingTest() {
        pricingSteps
                .clickingOnPricingBtn()
                .saveOfferTitles()
                .devCraftUIMockingAssert(pricingSteps.devCraftUIIndex())
                .devCraftUltimateIssueAssert(pricingSteps.devCraftUltimateIndex())
                .devCraftCompleteIssueAssert(pricingSteps.devCraftCompleteIndex())
                .devCraftUIIssueAssert(pricingSteps.devCraftUIIndex())
                .devCraftUltimateEndToEndAssert(pricingSteps.devCraftUltimateIndex())
                .devCraftCompleteEndToEndAssert(pricingSteps.devCraftCompleteIndex())
                .devCraftUIEndToEndAssert(pricingSteps.devCraftUIIndex())
                .telerikTestDevCraftUIAssert(pricingSteps.devCraftUIIndex())
                .telerikTestDevCraftCompleteAssert(pricingSteps.devCraftCompleteIndex())
                .telerikTestDevCraftUltimateAssert(pricingSteps.devCraftUltimateIndex())
                .kendoUIForJqDevCraftUIAssert(pricingSteps.devCraftUIIndex())
                .kendoUIForJqDevCraftCompleteAssert(pricingSteps.devCraftCompleteIndex())
                .kendoUIForJqDevCraftUltimateAssert(pricingSteps.devCraftUltimateIndex())
                .telerikReportServerDevCraftUltimateAssert(pricingSteps.devCraftUltimateIndex())
                .telerikReportingDevCraftUIAssert(pricingSteps.devCraftUIIndex())
                .telerikReportingDevCraftCompleteAssert(pricingSteps.devCraftCompleteIndex())
                .telerikReportingDevCraftUltimateAssert(pricingSteps.devCraftUltimateIndex())
                .accessOnDemandAssert()
                .stickyElementVisibilityAssert();
    }
}
