package ge.tbc.testautomation.TelerikPage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class PricingPage {
    public SelenideElement
            pricingButton = $(byTagAndText("a", "See Plans & Pricing")),
            stickyEl = $x("//*[@id='js-sticky-head']/th/div/div"),
            detailedBtn = $x("//button[contains(text(), 'detailed')]"),
            productTraining = $x(".//h4/strong[text()='Product Training']");

    public ElementsCollection
            pricingInfo = $$x(".//tr[@class='Pricings-info']/child::th"),
            pricingsSupport = $$x(".//tr[@class='Pricings-support']/child::th"),
            telerikTest = $$x("//p[contains(text(), 'Telerik Test Studio Dev Edition')]/parent::td/following-sibling::td"),
            kendoUiForJq = $$x("//td[contains(text(), 'Kendo UI for jQuery')]/following-sibling::td"),
            telerikReportServer = $$x("//p[contains(text(), 'Telerik Report Server')]/parent::td/following-sibling::td"),
            telerikReporting = $$x("//p[contains(text(), 'Telerik Reporting')]/parent::td/following-sibling::td"),
            accessOnDemand = $$x("//td[contains(text(), 'Access to on-demand videos')]/following-sibling::td"),
            titles = $$(".Pricings-name th[class] h5");
}
