package ge.tbc.testautomation.HerokuappPage.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.HerokuappPage.pages.HerokuappPageCheckboxesPage;
import io.qameta.allure.Step;

public class HerokuappPageCheckboxesSteps {
    HerokuappPageCheckboxesPage herokuappPageCheckboxesPage = new HerokuappPageCheckboxesPage();

    @Step("check first checkbox")
    public HerokuappPageCheckboxesSteps clickOnFirstCheckbox() {
        herokuappPageCheckboxesPage.checkboxes.get(0).click();

        return this;
    }

    @Step("check box assertion")
    public void checkboxesCheckAssertion() {
        herokuappPageCheckboxesPage.checkboxes.forEach(checkbox -> checkbox.shouldBe(Condition.checked));
    }


}
