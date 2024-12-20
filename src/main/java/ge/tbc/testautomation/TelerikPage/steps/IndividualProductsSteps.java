package ge.tbc.testautomation.TelerikPage.steps;

import ge.tbc.testautomation.TelerikPage.pages.IndividualProductsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static ge.tbc.testautomation.data.Constants.*;

public class IndividualProductsSteps {
    IndividualProductsPage individualProductsPage = new IndividualProductsPage();


    @Step("clicking on pricing button")
    public IndividualProductsSteps clickOnPricingBtn() {
        individualProductsPage.pricingButton.click();

        return this;
    }

    @Step("clicking on individual product")
    public IndividualProductsSteps clickOnindividualProducts() {
        individualProductsPage.individualProducts.click();

        return this;
    }

    @Step("hover and assert visibility of kendoUI ninja")
    public IndividualProductsSteps kendoUIHoverAssert() {
        individualProductsPage.kendoUI.hover();
        individualProductsPage.kendoUiNinja.shouldBe(visible);

        return this;
    }

    @Step("accept cookie")
    public IndividualProductsSteps kendoReactHoverAssert() {
        individualProductsPage.kendoReact.hover();
        individualProductsPage.kendoReactNinja.shouldBe(visible);

        return this;
    }

    @Step("assert selected value by default on kendo UI element")
    public IndividualProductsSteps selectedByDefaultKendoUIAssert() {
        individualProductsPage.selectedElementKendoUI.shouldHave(text(BY_DEFAULT_SELECTED_TEXT));

        return this;
    }

    @Step("assert selected value by default on kendo react element")
    public IndividualProductsSteps selectedByDefaultKendoReactAssert() {
        individualProductsPage.selectedElementKendoReact.shouldHave(text(BY_DEFAULT_SELECTED_TEXT));

        return this;
    }

    @Step("asserting visibility of price in kendo UI element")
    public IndividualProductsSteps kendoUIPriceVisibilityAssert() {
        individualProductsPage.kendoUiPrice.shouldHave(text(KENDO_UI_EXPECTED_PRICE), visible);

        return this;
    }

    @Step("asserting visibility of price in kendo react element")
    public void kendoReactPriceVisibilityAssert() {
        individualProductsPage.kendoReactPrice.shouldHave(text(KENDO_REACT_EXPECTED_PRICE), visible);
    }
}
