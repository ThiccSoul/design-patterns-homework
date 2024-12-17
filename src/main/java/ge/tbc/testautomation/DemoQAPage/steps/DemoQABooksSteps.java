package ge.tbc.testautomation.DemoQAPage.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.DemoQAPage.pages.DemoQABooksPage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static ge.tbc.testautomation.data.Constants.*;

public class DemoQABooksSteps {
    DemoQABooksPage demoQABooksPage = new DemoQABooksPage();

    public DemoQABooksSteps filterBooks(){
        demoQABooksPage.books
                .filter(Condition.text(FILTER_TXT_1))
                .filter(Condition.text(FILTER_TXT_2));

        System.out.println(demoQABooksPage.books.texts());
        return this;
    }

    public void filterWithImg(){
        List<SelenideElement> nonEmptyImgBooks = new ArrayList<>();
        demoQABooksPage.bookElements.forEach(div -> {
            if (div.find(By.tagName("img")).exists()) {
                nonEmptyImgBooks.add(div);
            }
        });

        System.out.println(nonEmptyImgBooks.size());

    }
}
