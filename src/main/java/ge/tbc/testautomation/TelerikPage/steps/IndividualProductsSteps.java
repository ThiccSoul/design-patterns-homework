package ge.tbc.testautomation.TelerikPage.steps;

import ge.tbc.testautomation.TelerikPage.pages.IndividualProductsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static ge.tbc.testautomation.data.Constants.*;

public class IndividualProductsSteps {
    IndividualProductsPage individualProductsPage = new IndividualProductsPage();


    public IndividualProductsSteps clickOnPricingBtn(){
        individualProductsPage.pricingButton.click();

        return this;
    }

    public IndividualProductsSteps clickOnindividualProducts(){
        individualProductsPage.individualProducts.click();

        return this;
    }

    public IndividualProductsSteps kendoUIHoverAssert(){
        individualProductsPage.kendoUI.hover();
        individualProductsPage.kendoUiNinja.shouldBe(visible);

        return this;
    }

    public IndividualProductsSteps kendoReactHoverAssert(){
        individualProductsPage.kendoReact.hover();
        individualProductsPage.kendoReactNinja.shouldBe(visible);

        return this;
    }

    public IndividualProductsSteps selectedByDefaultKendoUIAssert(){
        individualProductsPage.selectedElementKendoUI.shouldHave(text(BY_DEFAULT_SELECTED_TEXT));

        return this;
    }

    public IndividualProductsSteps selectedByDefaultKendoReactAssert(){
        individualProductsPage.selectedElementKendoReact.shouldHave(text(BY_DEFAULT_SELECTED_TEXT));

        return this;
    }

    public IndividualProductsSteps kendoUIPriceVisibilityAssert(){
        individualProductsPage.kendoUiPrice.shouldHave(text(KENDO_UI_EXPECTED_PRICE), visible);

        return this;
    }

    public void kendoReactPriceVisibilityAssert(){
        individualProductsPage.kendoReactPrice.shouldHave(text(KENDO_REACT_EXPECTED_PRICE), visible);

    }




}
