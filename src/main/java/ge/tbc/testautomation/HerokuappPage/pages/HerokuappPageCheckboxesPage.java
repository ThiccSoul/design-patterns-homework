package ge.tbc.testautomation.HerokuappPage.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
import static ge.tbc.testautomation.data.Constants.*;

public class HerokuappPageCheckboxesPage {

    public ElementsCollection checkboxes = $$x(CHECKBOXES_XPATH);

}
