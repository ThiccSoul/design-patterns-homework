package ge.tbc.testautomation.TelerikPage.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbc.testautomation.data.Constants.PRICINT_BTN_TXT;

public class IndividualProductsPage {
    public SelenideElement
            pricingButton = $(byTagAndText("a", PRICINT_BTN_TXT)),
            individualProducts = $x("//span[text()='Individual Products']"),
            kendoUI = $x("//h3[contains(text(),'Kendo UI')]").parent(),
            kendoReact = $x("//h3[contains(text(),'KendoReact')]").parent(),
            kendoUiNinja = $x("//img[@title='Kendo Ui Ninja']"),
            kendoReactNinja = $x("//img[@title='Kendo React Ninja']"),
            selectedElementKendoUI = kendoUiNinja.$x(".//parent::div/parent::div/following-sibling::div/h2/following-sibling::div/child::a"),
            selectedElementKendoReact = kendoReactNinja.$x(".//parent::div/parent::div/following-sibling::div/h2/following-sibling::div/child::a"),
            kendoUiPrice = kendoUiNinja.$x(".//parent::div/parent::div/following-sibling::div/h2/span"),
            kendoReactPrice = kendoReactNinja.$x(".//parent::div/parent::div/following-sibling::div/h2/span");
}
