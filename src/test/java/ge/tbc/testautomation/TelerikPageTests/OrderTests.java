package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.OrderSteps;
import ge.tbc.testautomation.Util.TestConfig;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.TELERIK_ORDER_PAGE;

@Test(groups = {"Smoke"})
@Epic("Telerik Order Functionality Testing")
@Feature("Order Page Pricing and Discounts")
@Listeners(ge.tbc.testautomation.listeners.SelenideScreenshotListener.class)
public class OrderTests extends TestConfig {
    OrderSteps orderSteps = new OrderSteps();

    @BeforeMethod
    public void startUp() {
        open(TELERIK_ORDER_PAGE);
    }

    @Test(priority = 1, description = "Verify pricing calculations and discounts applied correctly")
    @Story("Verify Pricing and Discount Calculations")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyPricingAndDiscountCalculations() {
        Double initialPrice = orderSteps.devCraftCompletePrice();
        orderSteps
                .clickOnDevCraftCompleteBuyNow()
                .closeLogin()
                .assertPrice(initialPrice, orderSteps.priceInPayment())
                .clickOnDropdown()
                .choosingOption1()
                .waitForSaleToApply()
                .subtotalAssertion(orderSteps.calculatedSubtotal(orderSteps.unitPriceDouble(), orderSteps.termPriceDouble()))
                .clickOnQuantityDropdown()
                .percentDiscoutVisibilityAssert();

        String discountPercentage = orderSteps.percentNumber();
        Double priceBeforeDiscount = orderSteps.priceBeforeSaleDouble();

        orderSteps
                .clickQuantityOption1()
                .waitForSaleToApply()
                .unitSaveAmountAssert(orderSteps.unitSaveAmountDouble(), orderSteps.percentDouble(discountPercentage), priceBeforeDiscount)
                .priceWithSaleAssert(orderSteps.priceWithSaleDouble(), priceBeforeDiscount, orderSteps.percentDouble(discountPercentage))
                .totalDiscountAssert(orderSteps.totalDiscountDouble(), orderSteps.termSaveAmountDouble(), orderSteps.unitSaveAmountDouble());
    }

    @Test(priority = 2, description = "Validate the visibility and correctness of discount tooltip and final price")
    @Story("Validate Discount Tooltip and Final Price")
    @Severity(SeverityLevel.CRITICAL)
    public void validateDiscountTooltipAndFinalPrice() {
        orderSteps
                .hoverOnTotalDiscount()
                .waitForHover()
                .totalDiscountsAssert(orderSteps.totalDiscountsDouble(), orderSteps.licenseAmountDouble(), orderSteps.maintenanceAndSupDouble())
                .totalPriceAssert(orderSteps.totalPriceDouble(), orderSteps.licensePriceTotalDouble(), orderSteps.maintenanceAndSupPriceTotalDouble(), orderSteps.totalDiscountsDouble());
    }

    @Test(priority = 3, description = "Ensure the guest checkout workflow works as expected")
    @Story("Ensure Guest Checkout Workflow Completes")
    @Severity(SeverityLevel.CRITICAL)
    public void ensureGuestCheckoutWorkflow() {
        orderSteps
                .clickOnContinueAsGuest()
                .fillingFirstName()
                .fillingLastName()
                .clickOnBackBtn()
                .clickOnContinueAsGuest()
                .softAssertName(orderSteps.enteredName())
                .softAssertLastName(orderSteps.enteredLastName());
    }
}
