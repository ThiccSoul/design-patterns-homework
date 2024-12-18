package ge.tbc.testautomation.TelerikPage.steps;

import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.TelerikPage.pages.PricingPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static ge.tbc.testautomation.data.Constants.*;

public class PricingSteps {
    PricingPage pricingPage = new PricingPage();
    List<String> titles;

    @Step("Click on the 'Pricing' button")
    public PricingSteps clickingOnPricingBtn() {
        pricingPage.pricingButton.click();
        return this;
    }

    @Step("Save all offer titles")
    public PricingSteps saveOfferTitles() {
        titles = pricingPage.titles.texts();
        return this;
    }

    @Step("Get the index of 'DevCraft UI' from the titles")
    public int devCraftUIIndex() {
        return titles.indexOf(DEVCRAFTUI_TITLE);
    }

    @Step("Get the index of 'DevCraft Complete' from the titles")
    public int devCraftCompleteIndex() {
        return titles.indexOf(DEVCRAFT_COMPL_TITLE);
    }

    @Step("Get the index of 'DevCraft Ultimate' from the titles")
    public int devCraftUltimateIndex() {
        return titles.indexOf(DEVCRAFT_ULTIM_TITLE);
    }

    @Step("Assert that 'DevCraft UI' offer does not contain mocking solution text at index {devCraftUIIndex}")
    public PricingSteps devCraftUIMockingAssert(int devCraftUIIndex) {
        pricingPage.pricingInfo.get(devCraftUIIndex).shouldNotHave(text(MOCKING_SOLUTION_TXT));
        return this;
    }

    @Step("Assert that 'DevCraft Ultimate' support contains issue text at index {devCraftUltimateIndex}")
    public PricingSteps devCraftUltimateIssueAssert(int devCraftUltimateIndex) {
        pricingPage.pricingsSupport.get(devCraftUltimateIndex).shouldHave(text(ISSUE_TXT));
        return this;
    }

    @Step("Assert that 'DevCraft Complete' support does not contain issue text at index {devCraftCompleteIndex}")
    public PricingSteps devCraftCompleteIssueAssert(int devCraftCompleteIndex) {
        pricingPage.pricingsSupport.get(devCraftCompleteIndex).shouldNotHave(text(ISSUE_TXT));
        return this;
    }

    @Step("Assert that 'DevCraft UI' support does not contain issue text at index {devCraftUIIndex}")
    public PricingSteps devCraftUIIssueAssert(int devCraftUIIndex) {
        pricingPage.pricingsSupport.get(devCraftUIIndex).shouldNotHave(text(ISSUE_TXT));
        return this;
    }

    @Step("Assert that 'DevCraft Ultimate' includes end-to-end text at index {devCraftUltimateIndex}")
    public PricingSteps devCraftUltimateEndToEndAssert(int devCraftUltimateIndex) {
        pricingPage.pricingInfo.get(devCraftUltimateIndex).shouldHave(text(END_TO_END_TXT));
        return this;
    }

    @Step("Assert that 'DevCraft Complete' does not include end-to-end text at index {devCraftCompleteIndex}")
    public PricingSteps devCraftCompleteEndToEndAssert(int devCraftCompleteIndex) {
        pricingPage.pricingInfo.get(devCraftCompleteIndex).shouldNotHave(text(END_TO_END_TXT));
        return this;
    }

    @Step("Assert that 'DevCraft UI' does not include end-to-end text at index {devCraftUIIndex}")
    public PricingSteps devCraftUIEndToEndAssert(int devCraftUIIndex) {
        pricingPage.pricingInfo.get(devCraftUIIndex).shouldNotHave(text(END_TO_END_TXT));
        return this;
    }

    @Step("Assert that Telerik Test for 'DevCraft UI' at index {devCraftUIIndex} does not equal '{DOT}'")
    public PricingSteps telerikTestDevCraftUIAssert(int devCraftUIIndex) {
        Assert.assertNotEquals(pricingPage.telerikTest.texts().get(devCraftUIIndex), DOT);
        return this;
    }

    @Step("Assert that Telerik Test for 'DevCraft Complete' at index {devCraftCompleteIndex} does not equal '{DOT}'")
    public PricingSteps telerikTestDevCraftCompleteAssert(int devCraftCompleteIndex) {
        Assert.assertNotEquals(pricingPage.telerikTest.texts().get(devCraftCompleteIndex), DOT);
        return this;
    }

    @Step("Assert that Telerik Test for 'DevCraft Ultimate' at index {devCraftUltimateIndex} equals '{DOT}'")
    public PricingSteps telerikTestDevCraftUltimateAssert(int devCraftUltimateIndex) {
        Assert.assertEquals(pricingPage.telerikTest.texts().get(devCraftUltimateIndex), DOT);
        return this;
    }

    @Step("Assert that Kendo UI for JQuery for 'DevCraft UI' at index {devCraftUIIndex} equals '{DOT}'")
    public PricingSteps kendoUIForJqDevCraftUIAssert(int devCraftUIIndex) {
        Assert.assertEquals(pricingPage.kendoUiForJq.texts().get(devCraftUIIndex), DOT);
        return this;
    }

    @Step("Assert that Kendo UI for JQuery for 'DevCraft Complete' at index {devCraftCompleteIndex} equals '{DOT}'")
    public PricingSteps kendoUIForJqDevCraftCompleteAssert(int devCraftCompleteIndex) {
        Assert.assertEquals(pricingPage.kendoUiForJq.texts().get(devCraftCompleteIndex), DOT);
        return this;
    }

    @Step("Assert that Kendo UI for JQuery for 'DevCraft Ultimate' at index {devCraftUltimateIndex} equals '{DOT}'")
    public PricingSteps kendoUIForJqDevCraftUltimateAssert(int devCraftUltimateIndex) {
        Assert.assertEquals(pricingPage.kendoUiForJq.texts().get(devCraftUltimateIndex), DOT);
        return this;
    }

    @Step("Assert that Telerik Report Server for 'DevCraft Ultimate' at index {devCraftUltimateIndex} contains '{INSTANCE_TXT}'")
    public PricingSteps telerikReportServerDevCraftUltimateAssert(int devCraftUltimateIndex) {
        Assert.assertTrue(pricingPage.telerikReportServer.texts().get(devCraftUltimateIndex).contains(INSTANCE_TXT));
        return this;
    }

    @Step("Assert that Telerik Reporting for 'DevCraft UI' at index {devCraftUIIndex} does not equal '{DOT}'")
    public PricingSteps telerikReportingDevCraftUIAssert(int devCraftUIIndex) {
        Assert.assertNotEquals(pricingPage.telerikReporting.texts().get(devCraftUIIndex), DOT);
        return this;
    }

    @Step("Assert that Telerik Reporting for 'DevCraft Complete' at index {devCraftCompleteIndex} equals '{DOT}'")
    public PricingSteps telerikReportingDevCraftCompleteAssert(int devCraftCompleteIndex) {
        Assert.assertEquals(pricingPage.telerikReporting.texts().get(devCraftCompleteIndex), DOT);
        return this;
    }

    @Step("Assert that Telerik Reporting for 'DevCraft Ultimate' at index {devCraftUltimateIndex} equals '{DOT}'")
    public PricingSteps telerikReportingDevCraftUltimateAssert(int devCraftUltimateIndex) {
        Assert.assertEquals(pricingPage.telerikReporting.texts().get(devCraftUltimateIndex), DOT);
        return this;
    }

    @Step("Assert that all 'Access on Demand' elements contain '{DOT}' and have size equal to the number of titles")
    public PricingSteps accessOnDemandAssert() {
        pricingPage.accessOnDemand.filter(innerText(DOT)).shouldHave(size(pricingPage.titles.size()));
        return this;
    }

    @Step("Assert the visibility of the sticky element after interactions")
    public void stickyElementVisibilityAssert() {
        Selenide.executeJavaScript(SCROLL_TO_EL_JS, pricingPage.detailedBtn);
        pricingPage.detailedBtn.click();
        Selenide.executeJavaScript(SCROLL_TO_EL_JS, pricingPage.productTraining);
        pricingPage.stickyEl.shouldBe(visible);
    }
}
