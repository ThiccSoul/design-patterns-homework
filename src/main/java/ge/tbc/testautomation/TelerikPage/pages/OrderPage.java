package ge.tbc.testautomation.TelerikPage.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    public SelenideElement
            devCraftCompleteBuyNow = $x(".//th[@class='Complete']/div/a"),
            loginCloseBtn = $x(".//i[@class='far fa-times label u-cp']"),
            devCraftCompletePriceEl = $x(".//th[@class='Complete']/div/h3/span[text()='1,699']"),
            priceInPayment = $x(".//span[@class='e2e-price-per-license']"),
            yearDropdown = $(byAttribute("textfield", "yearModifier")),
            dropDownOptions = $x(".//kendo-popup[@aria-label='Options list']"),
            option1 = dropDownOptions.$(byTagAndText("span", "-5%")).closest("div"),
            continueAsGuest = $x(".//span[text()='Continue as Guest']/.."),
            subtotal = $x(".//td[@data-label='Subtotal']/div/div[2]"),
            unitPrice = $x(".//td[@data-label='Licenses']//div[text()='Unit Price']/following-sibling::span/span"),
            termPrice = $x(".//td[@data-label='Maintenance & Support']//div[text()='Yearly Price']/following-sibling::div/span/span"),
            priceBeforeSale = $x(".//div[text()='Unit Price']/following-sibling::span/span"),
            quantityDropdown = $("quantity-select.u-db kendo-dropdownlist"),
            dropdwnOptions = $x(".//kendo-popup[@aria-label='Options list']"),
            dropdownOption1 = dropdwnOptions.$$("li").get(1),
            percentDiscount = $(".k-popup div[class*='u-df justify-'] span:last-child"),
            termSaveAmount = $x(".//td[@data-label='Maintenance & Support']//div[text()='Yearly Price']/following-sibling::div/span/div"),
            priceWithSale = $x(".//div[text()='Unit Price']/following-sibling::span/span"),
            unitSaveAmount = $x(".//td[@data-label='Licenses']//div[text()='Unit Price']/following-sibling::span/div"),
            totalDiscountEl = $x(".//div[text()='Total Discounts ']/../following-sibling::span"),
            totalDiscountTitle = $x(".//div[text()='Total Discounts ']"),
            totalDiscountsHoverEL = $x(".//div[text()='Total Discounts ']/following-sibling::div"),
            licensesSaleAmount = $x(".//div[text()='Total Discounts ']/following-sibling::div//span[text()='Licenses']/following-sibling::div"),
            maintenanceAndSupportSale = $x(".//span[text()='Maintenance & Support']/following-sibling::div/span[contains(@class, 'u-pr5')]"),
            licensePriceTotal = $x(".//span[text()='Licenses']/following-sibling::span"),
            maintenanceAndSupPriceTotal = $x(".//span[text()='Maintenance & Support']/following-sibling::span"),
            totalPrice = $x(".//h4[text()='Total']/following-sibling::h4"),
            continueAsGuestBtn = $x(".//span[text()='Continue as Guest']"),
            backBtn = $x(".//div[@class='u-df justify-content-between']/a"),
            firstNameField = $x("//*[@id='biFirstName']"),
            lastNameField = $x("//*[@id='biLastName']");


}
