package ge.tbc.testautomation.TelerikPage.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.TelerikPage.pages.DemosPage;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static ge.tbc.testautomation.data.Constants.*;

public class DemosSteps {
    DemosPage demosPage = new DemosPage();

    public DemosSteps acceptCookie(){
        demosPage.acceptCookie.click();

        return this;
    }
    public DemosSteps webcardsBackgroundColorAssert(){
        demosPage.webCards.shouldHave(allMatch("", webcard -> {
            actions().moveToElement(webcard).perform();
            return webcard.getCssValue(WEBCARD_PROPERT_NAME).equals(HOVER_COLOR);
        }));

        return this;
    }

    public DemosSteps kendoUIHover(){
        demosPage.kendoUI.hover();

        return this;
    }

    public DemosSteps kendoUIHoverTextAssert(){
        demosPage.kendoUI.shouldHave(text(KENDOUI_HOVER_TEXT));

        return this;
    }

    public DemosSteps filterCards(){
        Assert.assertEquals(demosPage.filteredDesktopCards.size(), 2);

        return this;
    }

    public DemosSteps scrollToDesktop(){
        demosPage.desktopTitle.scrollTo();

        demosPage.stickyTab.shouldBe(visible);

        return this;
    }

    public DemosSteps titleAppearingAssertion(){
        for (int i = 0; i < demosPage.sections.size(); i++) {
            demosPage.sections.get(i).click();
            demosPage.titles.get(i).shouldBe(Condition.visible);
        }

        return this;
    }

    public void titleBackgroundOnHover(){
        demosPage.sections.forEach(section -> {
            section.click();
            section.shouldHave(Condition.attribute(TITLE_BACKGROUND_ATTR, SECTION_CLASS_VALUE));
        });

    }
}
