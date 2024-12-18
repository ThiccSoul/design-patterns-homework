package ge.tbc.testautomation.TelerikPageTests;

import ge.tbc.testautomation.TelerikPage.steps.IndividualProductsSteps;
import ge.tbc.testautomation.Util.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.TELERIK_DEMOS_PAGE;
@Test(groups = {"Smoke"})
public class IndividualProductsPageTests extends TestConfig {

    IndividualProductsSteps individualProductsSteps = new IndividualProductsSteps();
    @BeforeMethod
    public void startUp() {
        open(TELERIK_DEMOS_PAGE);
    }


    public void individualProductsTest(){

        individualProductsSteps
                .clickOnPricingBtn()
                .clickOnindividualProducts()
                .kendoUIHoverAssert()
                .kendoReactHoverAssert()
                .selectedByDefaultKendoUIAssert()
                .selectedByDefaultKendoReactAssert()
                .kendoUIPriceVisibilityAssert()
                .kendoReactPriceVisibilityAssert();
    }

}
