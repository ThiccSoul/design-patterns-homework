package ge.tbc.testautomation.TelerikPage.steps;

import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.TelerikPage.pages.PricingPage;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static ge.tbc.testautomation.data.Constants.*;

public class PricingSteps {
    PricingPage pricingPage = new PricingPage();
    List<String> titles;

    public PricingSteps clickingOnPricingBtn(){
        pricingPage.pricingButton.click();

        return this;
    }


    public PricingSteps saveOfferTitles(){
        titles = pricingPage.titles.texts();

        return this;
    }

    public int devCraftUIIndex(){
        return titles.indexOf(DEVCRAFTUI_TITLE);
    };

    public int devCraftCompleteIndex(){
        return titles.indexOf(DEVCRAFT_COMPL_TITLE);
    };

    public int devCraftUltimateIndex(){
        return titles.indexOf(DEVCRAFT_ULTIM_TITLE);
    };

    public PricingSteps devCraftUIMockingAssert(int devCraftUIIndex){
        pricingPage.pricingInfo.get(devCraftUIIndex).shouldNotHave(text(MOCKING_SOLUTION_TXT));

        return this;
    }

    public PricingSteps devCraftUltimateIssueAssert(int devCraftUltimateIndex){
        pricingPage.pricingsSupport.get(devCraftUltimateIndex).shouldHave(text(ISSUE_TXT));

        return this;
    };

    public PricingSteps devCraftCompleteIssueAssert(int devCraftCompleteIndex){
        pricingPage.pricingsSupport.get(devCraftCompleteIndex).shouldNotHave(text(ISSUE_TXT));

        return this;
    };

    public PricingSteps devCraftUIIssueAssert(int devCraftUIIndex){
        pricingPage.pricingsSupport.get(devCraftUIIndex).shouldNotHave(text(ISSUE_TXT));

        return this;
    };

    public PricingSteps devCraftUltimateEndToEndAssert(int devCraftUltimateIndex){
        pricingPage.pricingInfo.get(devCraftUltimateIndex).shouldHave(text(END_TO_END_TXT));

        return this;
    };

    public PricingSteps devCraftCompleteEndToEndAssert(int devCraftCompleteIndex){
        pricingPage.pricingInfo.get(devCraftCompleteIndex).shouldNotHave(text(END_TO_END_TXT));

        return this;
    };

    public PricingSteps devCraftUIEndToEndAssert(int devCraftUIIndex){
        pricingPage.pricingInfo.get(devCraftUIIndex).shouldNotHave(text(END_TO_END_TXT));

        return this;
    };

    public PricingSteps telerikTestDevCraftUIAssert(int devCraftUIIndex){
        Assert.assertNotEquals(pricingPage.telerikTest.texts().get(devCraftUIIndex), DOT);

        return this;
    }

    public PricingSteps telerikTestDevCraftCompleteAssert(int devCraftCompleteIndex){
        Assert.assertNotEquals(pricingPage.telerikTest.texts().get(devCraftCompleteIndex), DOT);

        return this;
    }

    public PricingSteps telerikTestDevCraftUltimateAssert(int devCraftUltimateIndex){
        Assert.assertEquals(pricingPage.telerikTest.texts().get(devCraftUltimateIndex), DOT);

        return this;
    }

    public PricingSteps kendoUIForJqDevCraftUIAssert(int devCraftUIIndex){
        Assert.assertEquals(pricingPage.kendoUiForJq.texts().get(devCraftUIIndex), DOT);

        return this;
    }

    public PricingSteps kendoUIForJqDevCraftCompleteAssert(int devCraftCompleteIndex){
        Assert.assertEquals(pricingPage.kendoUiForJq.texts().get(devCraftCompleteIndex), DOT);

        return this;
    }

    public PricingSteps kendoUIForJqDevCraftUltimateAssert(int devCraftUltimateIndex){
        Assert.assertEquals(pricingPage.kendoUiForJq.texts().get(devCraftUltimateIndex), DOT);

        return this;
    }

    public PricingSteps telerikReportServerDevCraftUltimateAssert(int devCraftUltimateIndex){
        Assert.assertTrue(pricingPage.telerikReportServer.texts().get(devCraftUltimateIndex).contains(INSTANCE_TXT));

        return this;
    }

    public PricingSteps telerikReportingDevCraftUIAssert(int devCraftUIIndex){
        Assert.assertNotEquals(pricingPage.telerikReporting.texts().get(devCraftUIIndex), DOT);

        return this;
    }

    public PricingSteps telerikReportingDevCraftCompleteAssert(int devCraftCompleteIndex){
        Assert.assertEquals(pricingPage.telerikReporting.texts().get(devCraftCompleteIndex), DOT);

        return this;
    }

    public PricingSteps telerikReportingDevCraftUltimateAssert(int devCraftUltimateIndex){
        Assert.assertEquals(pricingPage.telerikReporting.texts().get(devCraftUltimateIndex), DOT);

        return this;
    }

    public PricingSteps accessOnDemandAssert(){
        pricingPage.accessOnDemand.filter(innerText(DOT)).shouldHave(size(pricingPage.titles.size()));

        return this;
    }

    public void stickyElementVisibilityAssert(){
        Selenide.executeJavaScript(
                SCROLL_TO_EL_JS, pricingPage.detailedBtn
        );

        pricingPage.detailedBtn.click();

        Selenide.executeJavaScript(
                SCROLL_TO_EL_JS, pricingPage.productTraining
        );

        pricingPage.stickyEl.shouldBe(visible);

    }


















}
