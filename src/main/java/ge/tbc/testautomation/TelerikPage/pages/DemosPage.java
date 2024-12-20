package ge.tbc.testautomation.TelerikPage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbc.testautomation.data.Constants.MICROSOFT_TITLE;

public class DemosPage {
    public SelenideElement
            acceptCookie = $x("//*[@id='onetrust-accept-btn-handler']"),
            kendoUI = $x(".//h3[text()='Kendo UI']/preceding-sibling::div"),
            desktopCards = $x(".//h2[@id='desktop']/following-sibling::div//img[@title='winui-product-thumb']/ancestor::div[@data-sf-element='Row']/div[.//*]/parent::div"),
            desktopTitle = $x("//*[@id='desktop']"),
            stickyTab = $x("//*[@id='ContentPlaceholder1_T53129E6C012_Col00']/nav");
    public ElementsCollection
            webCards = $$x(".//h2[@id='web']/following-sibling::div//img[@title='Kendo Ui']/ancestor::div[@data-sf-element='Row']/div/div"),
            filteredDesktopCards = desktopCards.$$(byAttribute("title", MICROSOFT_TITLE)),
            sections = $$x(".//div[@data-tlrk-plugin='navspy']/*"),
            titles = $$x(".//h2[@class='u-mb0 h3']");
}
