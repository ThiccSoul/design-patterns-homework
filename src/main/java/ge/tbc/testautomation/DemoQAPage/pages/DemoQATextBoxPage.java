package ge.tbc.testautomation.DemoQAPage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbc.testautomation.data.Constants.*;

public class DemoQATextBoxPage {
    public SelenideElement
            fullName = $(FULL_NAME_CSSSELECTOR),
            email = $x(EMAIL_XPATH),
            currentAddress = $(CURRENT_ADDRESS_CSSSELECTOR),
            permanentAddress = $x(PERMANENT_ADDRESS_XPATH),
            submitBtn = $(SUBMIT_BTN_CSS);

    public ElementsCollection
            paragraph = $(PHARAGRAHP_CSS).$$("p");

}
