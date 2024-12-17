package ge.tbc.testautomation.DemoQAPage.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DemoQABooksPage {
    public ElementsCollection
            books = $x("//div[contains(@class, 'rt-tbody')]").$$(By.xpath(".//div[contains(@class, 'rt-tr-group')]")),
            bookElements = $("div.rt-tbody").findAll(By.xpath("./div[div[div[div]]]"));
}
