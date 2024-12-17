package ge.tbc.testautomation.DemoQAPage.steps;

import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.DemoQAPage.pages.DemoQATextBoxPage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static ge.tbc.testautomation.data.Constants.*;

public class DemoQATextBoxSteps {
    DemoQATextBoxPage demoQATextBoxPage = new DemoQATextBoxPage();

    public DemoQATextBoxSteps fullNameFillInfo(){
        demoQATextBoxPage.fullName.sendKeys(FULL_NAME);

        return this;
    }

    public DemoQATextBoxSteps emailFillInfo(){
        demoQATextBoxPage.email.sendKeys(EMAIL);

        return this;
    }

    public DemoQATextBoxSteps currentAddressFillInfo(){
        demoQATextBoxPage.currentAddress.sendKeys(CURRENT_ADDRESS);

        return this;
    }

    public DemoQATextBoxSteps permanentAddressFillInfo(){
        demoQATextBoxPage.permanentAddress.sendKeys(PERMANENT_ADDRESS);

        return this;
    }

    public DemoQATextBoxSteps scrollToSubmitBtn(){
        Selenide.executeJavaScript(
                SCROLL_TO_EL_JS, demoQATextBoxPage.submitBtn
        );

        return this;
    }

    public DemoQATextBoxSteps submitForm(){
        demoQATextBoxPage.submitBtn.click();

        return this;
    }

    public void pharagraphsAssertion(){
        demoQATextBoxPage.paragraph.shouldHave(texts(
                "Name:" + FULL_NAME, "Email:" + EMAIL,"Current Address :" + CURRENT_ADDRESS,"Permananet Address :" + PERMANENT_ADDRESS));

    }
}
