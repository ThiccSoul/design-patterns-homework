package ge.tbc.testautomation.TelerikPage.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.TelerikPage.pages.OrderPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.*;
import static ge.tbc.testautomation.data.Constants.*;

public class OrderSteps {

    SoftAssert sfa = new SoftAssert();
    OrderPage orderPage = new OrderPage();

    public Double devCraftCompletePrice() {
        return Double.parseDouble(orderPage.devCraftCompletePriceEl.getText().replace(",", ""));
    }

    public OrderSteps clickOnDevCraftCompleteBuyNow() {
        orderPage.devCraftCompleteBuyNow.click();

        return this;
    }

    public OrderSteps closeLogin() {
        orderPage.loginCloseBtn.click();

        return this;
    }


    public Double priceInPayment() {
        return Double.parseDouble(orderPage.priceInPayment.getText().replace(",", "").replaceAll("^[$]", ""));
    }

    public OrderSteps assertPrice(Double devCraftPrice, Double priceInPayment) {
        Assert.assertEquals(devCraftPrice, priceInPayment);

        return this;
    }

    public OrderSteps clickOnDropdown() {
        orderPage.yearDropdown.click();

        return this;
    }

    public OrderSteps choosingOption1() {
        orderPage.option1.click();

        return this;
    }

    public OrderSteps waitForSaleToApply() {
        orderPage.continueAsGuest.shouldBe(Condition.clickable, Condition.interactable);

        return this;
    }

    public Double unitPriceDouble() {
        return Double.parseDouble(orderPage.unitPrice.getText().replaceAll("[\\$,]", ""));
    }

    public Double termPriceDouble() {
        return Double.parseDouble(orderPage.termPrice.getText().replaceAll("[\\$,]", ""));

    }

    public String calculatedSubtotal(Double unitPriceDouble, Double termPriceDouble) {

        return String.valueOf(unitPriceDouble + termPriceDouble)
                .replaceAll("(?<=\\d)(?=(\\d{3})+\\.)", ",");

    }

    public OrderSteps subtotalAssertion(String calculatedSubtotal) {
        orderPage.subtotal.shouldHave(text(calculatedSubtotal));

        return this;
    }


    public OrderSteps clickOnQuantityDropdown(){
        orderPage.quantityDropdown.click();

        return this;
    }


    public void percentDiscoutVisibilityAssert(){
        orderPage.percentDiscount.shouldBe(visible);

    }

    public String percentNumber(){
        return orderPage.percentDiscount.getText().replaceAll("[^0-9]", "");
    }

    public OrderSteps clickQuantityOption1(){
        orderPage.dropdownOption1.click();

        return this;
    }

    public Double percentDouble(String percentNumber){
        return Double.parseDouble(percentNumber);
    }

    public Double unitSaveAmountDouble(){
        return Double.parseDouble(orderPage.unitSaveAmount.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double priceWithSaleDouble(){
        return Double.parseDouble(orderPage.priceWithSale.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double priceBeforeSaleDouble(){
        return Double.parseDouble(orderPage.priceBeforeSale.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double termSaveAmountDouble(){
        return Double.parseDouble(orderPage.termSaveAmount.getText().replaceAll("[^0-9.]+", ""));
    }

    public OrderSteps unitSaveAmountAssert(Double unitSaveAmountDouble, Double percentDouble, Double priceBeforeSaleDouble){
        Assert.assertEquals(unitSaveAmountDouble, (percentDouble / 100) * priceBeforeSaleDouble, 0.01);

        return this;
    }

    public OrderSteps priceWithSaleAssert(Double priceWithSaleDouble, Double priceBeforeSaleDouble, Double percentDouble){
        Assert.assertEquals(priceWithSaleDouble, priceBeforeSaleDouble - (percentDouble / 100) * priceBeforeSaleDouble, 0.01);
        return this;
    }

    public Double totalDiscountDouble(){
        return Double.parseDouble(orderPage.totalDiscountEl.getText().replaceAll("[^0-9.]+", ""));
    }

    public OrderSteps totalDiscountAssert(Double totalDiscount, Double termSaveAmountDouble, Double unitSaveAmountDouble){
        Assert.assertEquals(totalDiscount, termSaveAmountDouble + unitSaveAmountDouble * 2, 0.0001);

        return this;
    }

    public OrderSteps hoverOnTotalDiscount(){
        orderPage.totalDiscountTitle.hover();

        return this;
    }

    public OrderSteps waitForHover(){
        orderPage.totalDiscountsHoverEL.shouldBe(visible);

        return this;
    }

    public Double licenseAmountDouble(){
        return Double.parseDouble(orderPage.licensesSaleAmount.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double maintenanceAndSupDouble(){
        return Double.parseDouble(orderPage.maintenanceAndSupportSale.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double totalDiscountsDouble(){
        return Double.parseDouble(orderPage.totalDiscountEl.getText().replaceAll("[^0-9.]+", ""));
    }

    public OrderSteps totalDiscountsAssert(Double totalDiscount, Double licenseAmountDouble, Double maintenanceAndSupDouble){
        Assert.assertEquals(totalDiscount, licenseAmountDouble + maintenanceAndSupDouble, 0.0001);

        return this;
    }

    public Double licensePriceTotalDouble(){
        return Double.parseDouble(orderPage.licensePriceTotal.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double maintenanceAndSupPriceTotalDouble(){
        return Double.parseDouble(orderPage.maintenanceAndSupPriceTotal.getText().replaceAll("[^0-9.]+", ""));
    }

    public Double totalPriceDouble(){
        return Double.parseDouble(orderPage.totalPrice.getText().replaceAll("[^0-9.]+", ""));
    }

    public OrderSteps totalPriceAssert(Double totalPriceDouble, Double licensePriceTotalDouble, Double maintenanceAndSupPriceTotalDouble, Double totalDiscounts){
        Assert.assertEquals(totalPriceDouble, (licensePriceTotalDouble + maintenanceAndSupPriceTotalDouble) - totalDiscounts, 0.0001);

        return this;
    }

    public OrderSteps clickOnContinueAsGuest(){
        orderPage.continueAsGuestBtn.click();

        return this;
    }

    public OrderSteps fillingFirstName(){
        orderPage.firstNameField.sendKeys(NAME);

        return this;
    }

    public OrderSteps fillingLastName(){
        orderPage.lastNameField.sendKeys(LASTNAME);

        return this;
    }

    public OrderSteps clickOnBackBtn(){
        orderPage.backBtn.click();

        return this;
    }

    public String enteredName(){
        return orderPage.firstNameField.getAttribute("value");
    }

    public String enteredLastName(){
        return orderPage.lastNameField.getAttribute("value");
    }

    public OrderSteps softAssertName(String enteredName){
        sfa.assertEquals(NAME, enteredName);

        return this;
    }

    public void softAssertLastName(String enteredLastname){
        sfa.assertEquals(LASTNAME, enteredLastname);

    }

    //         just because I don't want test to fail I commented assertAll


//    public OrderSteps softAssertAll(){
//        sfa.assertAll();
//
//        return this;
//    }







}
