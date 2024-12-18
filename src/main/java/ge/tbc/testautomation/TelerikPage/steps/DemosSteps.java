package ge.tbc.testautomation.TelerikPage.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.TelerikPage.pages.DemosPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static ge.tbc.testautomation.data.Constants.*;

public class DemosSteps {
    DemosPage demosPage = new DemosPage();

    @Step("accept cookie")
    public DemosSteps acceptCookie() {
        demosPage.acceptCookie.click();

        return this;
    }

    @Step("asserting webcard background colors")
    public DemosSteps webcardsBackgroundColorAssert() {
        demosPage.webCards.shouldHave(allMatch("", webcard -> {
            actions().moveToElement(webcard).perform();
            return webcard.getCssValue(WEBCARD_PROPERT_NAME).equals(HOVER_COLOR);
        }));

        return this;
    }

    @Step("hover on kendoUI element")
    public DemosSteps kendoUIHover() {
        demosPage.kendoUI.hover();

        return this;
    }

    @Step("assert the text when hovered on kendo UI")
    public DemosSteps kendoUIHoverTextAssert() {
        demosPage.kendoUI.shouldHave(text(KENDOUI_HOVER_TEXT));

        return this;
    }

    @Step("filter cards which have microsoft support")
    public DemosSteps filterCards() {
        Assert.assertEquals(demosPage.filteredDesktopCards.size(), 2);

        return this;
    }

    @Step("scroll to desktop elements")
    public DemosSteps scrollToDesktop() {
        demosPage.desktopTitle.scrollTo();

        demosPage.stickyTab.shouldBe(visible);

        return this;
    }

    @Step("assert titles when changing sections")
    public DemosSteps titleAppearingAssertion() {
        for (int i = 0; i < demosPage.sections.size(); i++) {
            demosPage.sections.get(i).click();
            demosPage.titles.get(i).shouldBe(Condition.visible);
        }

        return this;
    }

    @Step("assert background color of titles when on hover")
    public void titleBackgroundOnHover() {
        demosPage.sections.forEach(section -> {
            section.click();
            section.shouldHave(Condition.attribute(TITLE_BACKGROUND_ATTR, SECTION_CLASS_VALUE));
        });

    }
}
