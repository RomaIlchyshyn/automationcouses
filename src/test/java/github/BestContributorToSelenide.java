package github;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BestContributorToSelenide {

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    void solntsevShouldBeHere() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        getWebDriver().manage().window().maximize();
        SelenideElement columnA = $("div#column-a");
        SelenideElement columnB = $("div#column-b");
        Selenide.actions().dragAndDrop(columnA, columnB).perform();

    }
}
