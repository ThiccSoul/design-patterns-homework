package ge.tbc.testautomation.DemoQAPage.steps;

import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.DemoQAPage.pages.DemoQATextBoxPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static ge.tbc.testautomation.data.Constants.*;

public class DemoQATextBoxSteps {
    DemoQATextBoxPage demoQATextBoxPage = new DemoQATextBoxPage();

    @Step("filling fullname field")
    public DemoQATextBoxSteps fullNameFillInfo() {
        demoQATextBoxPage.fullName.sendKeys(FULL_NAME);

        return this;
    }

    @Step("filtering email field")
    public DemoQATextBoxSteps emailFillInfo() {
        demoQATextBoxPage.email.sendKeys(EMAIL);

        return this;
    }

    @Step("filling current address field")
    public DemoQATextBoxSteps currentAddressFillInfo() {
        demoQATextBoxPage.currentAddress.sendKeys(CURRENT_ADDRESS);

        return this;
    }

    @Step("filling permanent address field")
    public DemoQATextBoxSteps permanentAddressFillInfo() {
        demoQATextBoxPage.permanentAddress.sendKeys(PERMANENT_ADDRESS);

        return this;
    }

    @Step("scroll to submit button")
    public DemoQATextBoxSteps scrollToSubmitBtn() {
        Selenide.executeJavaScript(
                SCROLL_TO_EL_JS, demoQATextBoxPage.submitBtn
        );

        return this;
    }

    @Step("click on submit button")
    public DemoQATextBoxSteps submitForm() {
        demoQATextBoxPage.submitBtn.click();

        return this;
    }

    @Step("assert fields")
    public void pharagraphsAssertion() {
        demoQATextBoxPage.paragraph.shouldHave(texts(
                "Name:" + FULL_NAME, "Email:" + EMAIL, "Current Address :" + CURRENT_ADDRESS, "Permananet Address :" + PERMANENT_ADDRESS));

    }
}
