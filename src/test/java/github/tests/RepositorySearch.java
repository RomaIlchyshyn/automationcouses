package github.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RepositorySearch {

    @BeforeAll
    static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    void shouldFindSelenideRepoAtTheTop() {

        open("https://github.com");
        $("button[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        sleep(5000);
        $$("div[data-testid='results-list']").first().click();
        sleep(3000);
        $("#repository-container-header").shouldHave(text("selenide"));



    }
}
