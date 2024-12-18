package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.IndividualProductsSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.TELERIK_DEMOS_PAGE;

@Test(groups = {"Smoke"})
@Epic("Telerik Individual Product Testing")
@Feature("Pricing Page and Product Validation")
@Listeners(ge.tbc.testautomation.listeners.SelenideScreenshotListener.class)
public class IndividualProductsPageTests extends TestConfig {

    IndividualProductsSteps individualProductsSteps = new IndividualProductsSteps();

    @BeforeMethod
    public void startUp() {
        open(TELERIK_DEMOS_PAGE);
    }

    @Test(priority = 1, description = "Verify that the Pricing button navigates to the correct page")
    @Story("Verify Pricing Button and Navigation")
    @Severity(SeverityLevel.MINOR)
    public void verifyPricingButtonNavigation() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts();
    }

    @Test(priority = 2, description = "Validate the hover behavior of the Kendo UI product")
    @Story("Validate Kendo UI Product Hover Behavior")
    @Severity(SeverityLevel.MINOR)
    public void validateKendoUIHoverBehavior() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .kendoUIHoverAssert();
    }

    @Test(priority = 3, description = "Validate the hover behavior of the Kendo React product")
    @Story("Validate Kendo React Product Hover Behavior")
    @Severity(SeverityLevel.MINOR)
    public void validateKendoReactHoverBehavior() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .kendoReactHoverAssert();
    }

    @Test(priority = 4, description = "Verify that Kendo UI is selected by default")
    @Story("Verify Default Selection of Kendo UI Product")
    @Severity(SeverityLevel.MINOR)
    public void verifyKendoUISelectedByDefault() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .selectedByDefaultKendoUIAssert();
    }

    @Test(priority = 5, description = "Verify that Kendo React is selected by default")
    @Story("Verify Default Selection of Kendo React Product")
    @Severity(SeverityLevel.MINOR)
    public void verifyKendoReactSelectedByDefault() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .selectedByDefaultKendoReactAssert();
    }

    @Test(priority = 6, description = "Check the visibility of Kendo UI product pricing")
    @Story("Check Kendo UI Product Pricing Visibility")
    @Severity(SeverityLevel.CRITICAL)
    public void checkKendoUIPriceVisibility() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .kendoUIPriceVisibilityAssert();
    }

    @Test(priority = 7, description = "Check the visibility of Kendo React product pricing")
    @Story("Check Kendo React Product Pricing Visibility")
    @Severity(SeverityLevel.CRITICAL)
    public void checkKendoReactPriceVisibility() {
        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .kendoReactPriceVisibilityAssert();
    }
}
