package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.OrderSteps;
import ge.tbc.testautomation.Util.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;
@Test(groups = {"Smoke"})
public class OrderTests extends TestConfig {
    OrderSteps orderSteps = new OrderSteps();

    @BeforeMethod
    public void startUp() {
        open(TELERIK_ORDER_PAGE);
    }


    public void OrderTest() {
        Double firstPrice = orderSteps.devCraftCompletePrice();
        orderSteps
                .clickOnDevCraftCompleteBuyNow()
                .closeLogin()
                .assertPrice(firstPrice, orderSteps.priceInPayment())
                .clickOnDropdown()
                .choosingOption1()
                .waitForSaleToApply()
                .subtotalAssertion(orderSteps.calculatedSubtotal(orderSteps.unitPriceDouble(), orderSteps.termPriceDouble()))
                .clickOnQuantityDropdown()
                .percentDiscoutVisibilityAssert();
        String percentNumber = orderSteps.percentNumber();
        Double priceBeforeSaleDouble = orderSteps.priceBeforeSaleDouble();
        orderSteps
                .clickQuantityOption1()
                .waitForSaleToApply()
                .unitSaveAmountAssert(orderSteps.unitSaveAmountDouble(), orderSteps.percentDouble(percentNumber), priceBeforeSaleDouble)
                .priceWithSaleAssert(orderSteps.priceWithSaleDouble(), priceBeforeSaleDouble, orderSteps.percentDouble(percentNumber))
                .totalDiscountAssert(orderSteps.totalDiscountDouble(), orderSteps.termSaveAmountDouble(), orderSteps.unitSaveAmountDouble())
                .hoverOnTotalDiscount()
                .waitForHover()
                .totalDiscountsAssert(orderSteps.totalDiscountsDouble(), orderSteps.licenseAmountDouble(), orderSteps.maintenanceAndSupDouble())
                .totalPriceAssert(orderSteps.totalPriceDouble(), orderSteps.licensePriceTotalDouble(), orderSteps.maintenanceAndSupPriceTotalDouble(), orderSteps.totalDiscountsDouble())
                .clickOnContinueAsGuest()
                .fillingFirstName()
                .fillingLastName()
                .clickOnBackBtn()
                .clickOnContinueAsGuest()
                .softAssertName(orderSteps.enteredName())
                .softAssertLastName(orderSteps.enteredLastName());
    }
}
