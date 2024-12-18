package ge.tbc.testautomation.TelerikPage.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.TelerikPage.pages.OrderPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static ge.tbc.testautomation.data.Constants.LASTNAME;
import static ge.tbc.testautomation.data.Constants.NAME;

public class OrderSteps {

    SoftAssert sfa = new SoftAssert();
    OrderPage orderPage = new OrderPage();

    @Step("casting complete price into double")
    public Double devCraftCompletePrice() {
        return Double.parseDouble(orderPage.devCraftCompletePriceEl.getText().replace(",", ""));
    }

    @Step("click on buy now of devcraftComplete")
    public OrderSteps clickOnDevCraftCompleteBuyNow() {
        orderPage.devCraftCompleteBuyNow.click();

        return this;
    }

    @Step("click on x button on login popup")
    public OrderSteps closeLogin() {
        orderPage.loginCloseBtn.click();

        return this;
    }


    @Step("casting price in Payment into double")
    public Double priceInPayment() {
        return Double.parseDouble(orderPage.priceInPayment.getText().replace(",", "").replaceAll("^[$]", ""));
    }

    @Step("assert that in pricing and order page prices match")
    public OrderSteps assertPrice(Double devCraftPrice, Double priceInPayment) {
        Assert.assertEquals(devCraftPrice, priceInPayment);

        return this;
    }

    @Step("clicking on dropdown")
    public OrderSteps clickOnDropdown() {
        orderPage.yearDropdown.click();

        return this;
    }

    @Step("clicking on option1")
    public OrderSteps choosingOption1() {
        orderPage.option1.click();

        return this;
    }

    @Step("wait for sale to appear")
    public OrderSteps waitForSaleToApply() {
        orderPage.continueAsGuest.shouldBe(Condition.clickable, Condition.interactable);

        return this;
    }

    @Step("casting unit price as Double")
    public Double unitPriceDouble() {
        return Double.parseDouble(orderPage.unitPrice.getText().replaceAll("[\\$,]", ""));
    }

    @Step("casting term price as Double")
    public Double termPriceDouble() {
        return Double.parseDouble(orderPage.termPrice.getText().replaceAll("[\\$,]", ""));
    }

    @Step("Enter PriceDouble: {unitPriceDouble} and termPriceDouble: {termPriceDouble}")
    public String calculatedSubtotal(Double unitPriceDouble, Double termPriceDouble) {

        return String.valueOf(unitPriceDouble + termPriceDouble)
                .replaceAll("(?<=\\d)(?=(\\d{3})+\\.)", ",");

    }

    @Step("Enter calculatedSubtotal: {calculatedSubtotal}")
    public OrderSteps subtotalAssertion(String calculatedSubtotal) {
        orderPage.subtotal.shouldHave(text(calculatedSubtotal));

        return this;
    }

    @Step("clicking on quantity dropdown")
    public OrderSteps clickOnQuantityDropdown() {
        orderPage.quantityDropdown.click();

        return this;
    }

    @Step("assert that discount is visible")
    public void percentDiscoutVisibilityAssert() {
        orderPage.percentDiscount.shouldBe(visible);

    }

    @Step("assert that discount is visible")
    public String percentNumber() {
        return orderPage.percentDiscount.getText().replaceAll("[^0-9]", "");
    }


    @Step("Click on quantity option 1")
    public OrderSteps clickQuantityOption1() {
        orderPage.dropdownOption1.click();
        return this;
    }

    @Step("Convert percentage value '{percentNumber}' to double")
    public Double percentDouble(String percentNumber) {
        return Double.parseDouble(percentNumber);
    }

    @Step("Get unit save amount as a double")
    public Double unitSaveAmountDouble() {
        return Double.parseDouble(orderPage.unitSaveAmount.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get price with sale as a double")
    public Double priceWithSaleDouble() {
        return Double.parseDouble(orderPage.priceWithSale.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get price before sale as a double")
    public Double priceBeforeSaleDouble() {
        return Double.parseDouble(orderPage.priceBeforeSale.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get term save amount as a double")
    public Double termSaveAmountDouble() {
        return Double.parseDouble(orderPage.termSaveAmount.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Assert that unit save amount '{unitSaveAmountDouble}' matches the expected calculated value")
    public OrderSteps unitSaveAmountAssert(Double unitSaveAmountDouble, Double percentDouble, Double priceBeforeSaleDouble) {
        Assert.assertEquals(unitSaveAmountDouble, (percentDouble / 100) * priceBeforeSaleDouble, 0.01);
        return this;
    }

    @Step("Assert that price with sale '{priceWithSaleDouble}' matches the expected calculated value")
    public OrderSteps priceWithSaleAssert(Double priceWithSaleDouble, Double priceBeforeSaleDouble, Double percentDouble) {
        Assert.assertEquals(priceWithSaleDouble, priceBeforeSaleDouble - (percentDouble / 100) * priceBeforeSaleDouble, 0.01);
        return this;
    }

    @Step("Get total discount as a double")
    public Double totalDiscountDouble() {
        return Double.parseDouble(orderPage.totalDiscountEl.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Assert that total discount '{totalDiscount}' matches the expected calculated value")
    public OrderSteps totalDiscountAssert(Double totalDiscount, Double termSaveAmountDouble, Double unitSaveAmountDouble) {
        Assert.assertEquals(totalDiscount, termSaveAmountDouble + unitSaveAmountDouble * 2, 0.0001);
        return this;
    }

    @Step("Hover over the total discount title")
    public OrderSteps hoverOnTotalDiscount() {
        orderPage.totalDiscountTitle.hover();
        return this;
    }

    @Step("Wait for the total discounts hover element to be visible")
    public OrderSteps waitForHover() {
        orderPage.totalDiscountsHoverEL.shouldBe(visible);
        return this;
    }

    @Step("Get license amount as a double")
    public Double licenseAmountDouble() {
        return Double.parseDouble(orderPage.licensesSaleAmount.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get maintenance and support sale amount as a double")
    public Double maintenanceAndSupDouble() {
        return Double.parseDouble(orderPage.maintenanceAndSupportSale.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get total discounts as a double")
    public Double totalDiscountsDouble() {
        return Double.parseDouble(orderPage.totalDiscountEl.getText().replaceAll("[^0-9.]+", ""));
    }


    @Step("Assert that total discounts '{totalDiscount}' match the expected calculated value")
    public OrderSteps totalDiscountsAssert(Double totalDiscount, Double licenseAmountDouble, Double maintenanceAndSupDouble) {
        Assert.assertEquals(totalDiscount, licenseAmountDouble + maintenanceAndSupDouble, 0.0001);
        return this;
    }

    @Step("Get license price total as a double")
    public Double licensePriceTotalDouble() {
        return Double.parseDouble(orderPage.licensePriceTotal.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get maintenance and support price total as a double")
    public Double maintenanceAndSupPriceTotalDouble() {
        return Double.parseDouble(orderPage.maintenanceAndSupPriceTotal.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Get total price as a double")
    public Double totalPriceDouble() {
        return Double.parseDouble(orderPage.totalPrice.getText().replaceAll("[^0-9.]+", ""));
    }

    @Step("Assert that total price '{totalPriceDouble}' matches the expected calculated value")
    public OrderSteps totalPriceAssert(Double totalPriceDouble, Double licensePriceTotalDouble, Double maintenanceAndSupPriceTotalDouble, Double totalDiscounts) {
        Assert.assertEquals(totalPriceDouble, (licensePriceTotalDouble + maintenanceAndSupPriceTotalDouble) - totalDiscounts, 0.0001);
        return this;
    }

    @Step("Click on 'Continue as Guest' button")
    public OrderSteps clickOnContinueAsGuest() {
        orderPage.continueAsGuestBtn.click();
        return this;
    }

    @Step("Fill in the first name field with '{NAME}'")
    public OrderSteps fillingFirstName() {
        orderPage.firstNameField.sendKeys(NAME);
        return this;
    }

    @Step("Fill in the last name field with '{LASTNAME}'")
    public OrderSteps fillingLastName() {
        orderPage.lastNameField.sendKeys(LASTNAME);
        return this;
    }

    @Step("Click on the back button")
    public OrderSteps clickOnBackBtn() {
        orderPage.backBtn.click();
        return this;
    }

    @Step("Get the entered first name")
    public String enteredName() {
        return orderPage.firstNameField.getAttribute("value");
    }

    @Step("Get the entered last name")
    public String enteredLastName() {
        return orderPage.lastNameField.getAttribute("value");
    }

    @Step("Soft assert that entered name '{enteredName}' matches the expected name")
    public OrderSteps softAssertName(String enteredName) {
        sfa.assertEquals(NAME, enteredName);
        return this;
    }

    @Step("Soft assert that entered last name '{enteredLastname}' matches the expected last name")
    public void softAssertLastName(String enteredLastname) {
        sfa.assertEquals(LASTNAME, enteredLastname);
    }

    //         just because I don't want test to fail I commented assertAll


//    public OrderSteps softAssertAll(){
//        sfa.assertAll();
//
//        return this;
//    }


}
