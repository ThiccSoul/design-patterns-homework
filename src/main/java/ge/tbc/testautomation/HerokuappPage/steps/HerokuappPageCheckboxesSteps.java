package ge.tbc.testautomation.HerokuappPage.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.HerokuappPage.pages.HerokuappPageCheckboxesPage;

public class HerokuappPageCheckboxesSteps {
    HerokuappPageCheckboxesPage herokuappPageCheckboxesPage = new HerokuappPageCheckboxesPage();

    public HerokuappPageCheckboxesSteps clickOnFirstCheckbox(){
        herokuappPageCheckboxesPage.checkboxes.get(0).click();

        return this;
    }

    public void checkboxesCheckAssertion(){
        herokuappPageCheckboxesPage.checkboxes.forEach(checkbox -> checkbox.shouldBe(Condition.checked));
    }


}
